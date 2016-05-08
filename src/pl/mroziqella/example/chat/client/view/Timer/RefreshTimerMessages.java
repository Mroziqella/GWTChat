package pl.mroziqella.example.chat.client.view.Timer;


import com.google.gwt.user.cellview.client.*;
import com.google.gwt.user.client.*;
import com.google.gwt.user.client.rpc.*;
import com.google.gwt.user.client.ui.*;
import pl.mroziqella.example.chat.client.*;
import pl.mroziqella.example.chat.client.model.*;


/**
 * Created by Kamil on 04/05/2016.
 */
public class RefreshTimerMessages extends Timer {
    private TextArea allMessages;
    private CellList<String>  allUsersList;

    public RefreshTimerMessages(TextArea allMessages, CellList<String> allUsersList) {
        super();
        this.allMessages = allMessages;
        this.allUsersList = allUsersList;
    }


    @Override
    public void run() {
        ChatService.App.getInstance().getMessages(new MyAsyncCallback(allMessages,allUsersList));

    }

    private static class MyAsyncCallback implements AsyncCallback<Messages> {
        private TextArea textArea;
        private CellList<String> cellList;

        public MyAsyncCallback(TextArea textArea, CellList<String> cellList) {
            this.textArea = textArea;

            this.cellList = cellList;
        }


        public void onFailure(Throwable throwable) {
            textArea.setText("Brak połączenia z serwerem");
        }

        @Override
        public void onSuccess(Messages result) {
                String tmp = "";
                for (String x : result.getMessages()) {
                    tmp += x + "\n";
                }
                textArea.setText(tmp);
                scrollToBottom(textArea.getElement());

            cellList.setRowCount(result.getUsers().size(), true);
            cellList.setRowData(0, result.getUsers());

        }
        public static void scrollToBottom(com.google.gwt.dom.client.Element element) {
            element.setScrollTop(element.getScrollHeight());
        }

    }
}

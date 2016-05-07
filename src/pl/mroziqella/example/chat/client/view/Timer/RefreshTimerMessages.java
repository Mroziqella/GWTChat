package pl.mroziqella.example.chat.client.view.Timer;


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
    private ListBox allUsersList;

    public RefreshTimerMessages(TextArea allMessages, ListBox allUsersList) {
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
        private ListBox listBox;

        public MyAsyncCallback(TextArea textArea, ListBox listBox) {
            this.textArea = textArea;

            this.listBox = listBox;
        }


        public void onFailure(Throwable throwable) {
            textArea.setText("Failed to receive answer from server!");
        }

        @Override
        public void onSuccess(Messages result) {
                String tmp = "";
                for (String x : result.getMessages()) {
                    tmp += x + "\n";
                }
                textArea.setText(tmp);
                scrollToBottom(textArea.getElement());
                listBox.clear();
                for (String x:result.getUsers()){
                    listBox.addItem(x);
                }


        }
        public static void scrollToBottom(com.google.gwt.dom.client.Element element) {
            element.setScrollTop(element.getScrollHeight());
        }

    }
}

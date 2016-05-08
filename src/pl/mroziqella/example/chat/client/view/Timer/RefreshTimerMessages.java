package pl.mroziqella.example.chat.client.view.Timer;


import com.google.gwt.user.cellview.client.*;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.rpc.*;
import com.google.gwt.user.client.ui.*;
import pl.mroziqella.example.chat.client.*;
import pl.mroziqella.example.chat.client.model.*;
import pl.mroziqella.example.chat.client.view.*;

import java.util.*;


/**
 * Created by Kamil on 04/05/2016.
 */
public class RefreshTimerMessages extends Timer {
    private TextArea allMessages;
    private CellList<String> allUsersList;

    public RefreshTimerMessages(TextArea allMessages, CellList<String> allUsersList) {
        super();
        this.allMessages = allMessages;
        this.allUsersList = allUsersList;
    }


    @Override
    public void run() {
        ChatService.App.getInstance().getMessages(new MyAsyncCallback(allMessages, allUsersList));

    }

    private static class MyAsyncCallback implements AsyncCallback<Messages> {
        private TextArea textArea;
        private CellList<String> cellList;

        public MyAsyncCallback(TextArea textArea, CellList<String> cellList) {
            this.textArea = textArea;

            this.cellList = cellList;
        }

        public static void scrollToBottom(com.google.gwt.dom.client.Element element) {
            element.setScrollTop(element.getScrollHeight());
        }

        public void onFailure(Throwable throwable) {
            textArea.setText("Brak połączenia z serwerem");
        }

        @Override
        public void onSuccess(Messages result) {
            String tmp = "";
            for (String x : result.getMessages(Chat.getRoomName())) {
                tmp += x + "\n";

            }
            textArea.setText(tmp);
            scrollToBottom(textArea.getElement());
            cellList.setRowCount(result.getUsers(Chat.getRoomName()).size(), true);
            cellList.setRowData(0, new LinkedList<>(result.getUsers(Chat.getRoomName())));

            ChatService.App.getInstance().isInfo(Chat.getLoginSession(),new MyAsyncCallbackInfo());



        }


        private static class MyAsyncCallbackInfo implements AsyncCallback<String> {
            public void onFailure(Throwable throwable){}
            @Override
            public void onSuccess(String result) {

                if(result!=null) {
//                    DialogBox dialogBox = new DialogBox();
//                    InviteWidget inviteWidget =new InviteWidget(result);
//                    dialogBox.add(inviteWidget);
//                    dialogBox.center();
//                    Chat.setRoomName(result);
                    RootPanel.get("slot1").clear();
                    RootPanel.get("slot2").clear();
                    RootPanel.get("slot1").add(new ChatWidget());

                }
            }
        }


    }
}

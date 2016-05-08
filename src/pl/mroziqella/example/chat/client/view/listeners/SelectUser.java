package pl.mroziqella.example.chat.client.view.listeners;

import com.google.gwt.user.client.*;
import com.google.gwt.user.client.rpc.*;
import com.google.gwt.user.client.ui.*;
import com.google.gwt.view.client.*;
import pl.mroziqella.example.chat.client.*;
import pl.mroziqella.example.chat.client.view.*;

/**
 * Created by Kamil on 08/05/2016.
 */
public class SelectUser implements SelectionChangeEvent.Handler {
    private SingleSelectionModel<String> selectionModel;

    public SelectUser(SingleSelectionModel<String> selectionUser) {
        selectionModel = selectionUser;
    }

    @Override
    public void onSelectionChange(SelectionChangeEvent event) {
        String selected = selectionModel.getSelectedObject();
        if (selected != null) {
            Chat.setRoomName(Chat.getLoginSession() + "," + selected);
            Window.alert("You selected: " + selected);
            ChatService.App.getInstance().userAccountExists(Chat.getLoginSession() + "," + selected, Chat.getLoginSession(), Chat.getPassword(), new MyAsyncCallback(selected));

        }
    }


    private static class MyAsyncCallbackRemoveUser implements AsyncCallback<Void> {


        public void onFailure(Throwable throwable) {

        }

        @Override
        public void onSuccess(Void result) {


        }


    }

    private static class MyAsyncCallback implements AsyncCallback<Boolean> {
        private String selected;

        public MyAsyncCallback(String selected) {
            this.selected = selected;
        }

        public void onFailure(Throwable throwable) {
        }

        @Override
        public void onSuccess(Boolean result) {
            Chat.setRoomName(Chat.getLoginSession() + "," + selected);
            RootPanel.get("slot1").clear();
            RootPanel.get("slot2").clear();
            RootPanel.get("slot1").add(new ChatWidget());

        }
    }
}

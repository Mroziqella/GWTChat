package pl.mroziqella.example.chat.client.view.Timer;


import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.rpc.*;
import com.google.gwt.user.client.ui.*;
import pl.mroziqella.example.chat.client.*;

import java.util.*;


/**
 * Created by Kamil on 04/05/2016.
 */
public class RefreshTimerMessages extends Timer {
    private TextArea allMessages;

    public RefreshTimerMessages(TextArea allMessages) {
        super();
        this.allMessages = allMessages;
    }



    @Override
    public void run() {
        ChatService.App.getInstance().getMessages(new MyAsyncCallback(allMessages));

    }

    private static class MyAsyncCallback implements AsyncCallback<ArrayList<String>> {
        private TextArea textArea;

        public MyAsyncCallback(TextArea textArea) {
            this.textArea = textArea;
        }


        public void onFailure(Throwable throwable) {
            textArea.setText("Failed to receive answer from server!");
        }

        @Override
        public void onSuccess(ArrayList<String> result) {
            String tmp = "";
            for (String x : result) {
                tmp += x + "\n";
            }
            textArea.setText(tmp);

        }

    }
}

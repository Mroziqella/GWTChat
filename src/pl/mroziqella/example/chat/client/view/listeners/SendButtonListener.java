package pl.mroziqella.example.chat.client.view.listeners;

import com.google.gwt.dom.client.*;
import com.google.gwt.event.dom.client.*;
import com.google.gwt.user.client.rpc.*;
import com.google.gwt.user.client.ui.*;
import pl.mroziqella.example.chat.client.*;
import pl.mroziqella.example.chat.client.model.*;

/**
 * Created by Kamil on 04/05/2016.
 */
public class SendButtonListener implements ClickHandler{
    private final TextArea allMessages;
    private final TextBox message;


    public SendButtonListener(TextArea allMessages, TextBox message) {
        this.allMessages = allMessages;
        this.message=message;
    }

    @Override
    public void onClick(ClickEvent event) {
        allMessages.setText(allMessages.getText()+Chat.getLoginSession()+": "+message.getText()+"\n");
        scrollToBottom(allMessages.getElement());
        ChatService.App.getInstance().setMessage(Chat.getLoginSession()+": "+message.getText(),new MyAsyncCallback(allMessages));
        message.setText("");

    }
    public static void scrollToBottom(com.google.gwt.dom.client.Element element) {
        element.setScrollTop(element.getScrollHeight());
    }

    private static class MyAsyncCallback implements AsyncCallback<Void> {
        private TextArea textArea;

        public MyAsyncCallback(TextArea textArea) {
            this.textArea = textArea;
        }


        public void onFailure(Throwable throwable) {
            textArea.setText("Brak połączenia z serwerem");
        }

        @Override
        public void onSuccess(Void result) {


        }



    }
}

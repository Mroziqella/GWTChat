package pl.mroziqella.example.chat.client.view.listeners;

import com.google.gwt.dom.client.*;
import com.google.gwt.event.dom.client.*;
import com.google.gwt.user.client.rpc.*;
import com.google.gwt.user.client.ui.*;
import pl.mroziqella.example.chat.client.*;

/**
 * Created by Kamil on 04/05/2016.
 */
public class SendButtonListener implements ClickHandler{
    private final TextArea allMessages;
    private final TextBox message;
    private final TextBox login;

    public SendButtonListener(TextArea allMessages, TextBox message, TextBox login) {
        this.allMessages = allMessages;
        this.message=message;
        this.login = login;
    }

    @Override
    public void onClick(ClickEvent event) {
        ChatService.App.getInstance().setMessage(login.getText()+": "+message.getText(),new MyAsyncCallback(allMessages));

    }


    private static class MyAsyncCallback implements AsyncCallback<Void> {
        private TextArea textArea;

        public MyAsyncCallback(TextArea textArea) {
            this.textArea = textArea;
        }


        public void onFailure(Throwable throwable) {
            textArea.setText("Failed to receive answer from server!");
        }

        @Override
        public void onSuccess(Void result) {
            scrollToBottom(textArea.getElement());

        }
        public static void scrollToBottom(Element element) {
            element.setScrollTop(element.getScrollHeight());
        }


    }
}

package pl.mroziqella.example.chat.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.impl.*;
import com.google.gwt.event.logical.shared.*;
import com.google.gwt.user.client.*;
import com.google.gwt.user.client.rpc.*;
import com.google.gwt.user.client.ui.*;
import pl.mroziqella.example.chat.client.model.*;
import pl.mroziqella.example.chat.client.view.*;

import java.util.logging.*;

/**
 * Entry point classes define <code>onModuleLoad()</code>
 */
public class Chat implements EntryPoint {

    private static String loginSession;

    public static String getLoginSession() {
        return loginSession;
    }

    public static void serLoginSession(String login) {
        Chat.loginSession = login;
    }

    /**
     * This is the entry point method.
     */
    public void onModuleLoad() {


        // Assume that the host HTML has elements defined whose
        // IDs are "slot1", "slot2".  In a real app, you probably would not want
        // to hard-code IDs.  Instead, you could, for example, search for all
        // elements with a particular CSS class and replace them with widgets.
        //
        RootPanel.get("slot2").add(new LoginWidget());
        Window.addWindowClosingHandler(new Window.ClosingHandler() {
            @Override
            public void onWindowClosing(Window.ClosingEvent event) {
                event.setMessage("Zamknąć?");

            }
        });

        Window.addCloseHandler(new CloseHandler<Window>() {
            @Override
            public void onClose(CloseEvent<Window> event) {
                ChatService.App.getInstance().removeUserfromTheList(getLoginSession(),new MyAsyncCallback());

            }
        });


    }

    private static class MyAsyncCallback implements AsyncCallback<Void> {



        public void onFailure(Throwable throwable) {

        }

        @Override
        public void onSuccess(Void result) {


        }



    }
}

package pl.mroziqella.example.chat.client.view;

import com.google.gwt.event.dom.client.*;
import com.google.gwt.user.client.ui.*;
import pl.mroziqella.example.chat.client.view.listeners.*;

/**
 * Created by Kamil on 08/05/2016.
 */
public class InviteWidget extends HorizontalPanel {
    private static Boolean acceptInvite =null;
    public InviteWidget(String login) {
        super();
        Button confirm = new Button("Powterdź");
        Button reject = new Button("Anuluj");
        confirm.addClickHandler(new ClickConfirm(true));
        reject.addClickHandler(new ClickConfirm(false));
        this.add(new Label("Zaprasza Cię: "+login));
        this.add(confirm);
        this.add(reject);

    }

    public static boolean isAcceptInvite() {
        return acceptInvite;
    }

    public static void setAcceptInvite(Boolean acceptInvite) {
        InviteWidget.acceptInvite = acceptInvite;
    }
}

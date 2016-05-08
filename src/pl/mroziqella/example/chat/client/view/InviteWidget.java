package pl.mroziqella.example.chat.client.view;

import com.google.gwt.event.dom.client.*;
import com.google.gwt.user.client.ui.*;

/**
 * Created by Kamil on 08/05/2016.
 */
public class InviteWidget extends HorizontalPanel {
    private boolean acceptInvite;
    public InviteWidget(String login) {
        super();
        Button confirm = new Button("Powterdź");
        Button reject = new Button("Anuluj");
        this.add(new Label("Zaprasza Cię: "+login));

        this.add(confirm);
        this.add(reject);

    }

    public boolean isAcceptInvite() {
        return acceptInvite;
    }

    public void setAcceptInvite(boolean acceptInvite) {
        this.acceptInvite = acceptInvite;
    }


}

package pl.mroziqella.example.chat.client.view.listeners;

import com.google.gwt.user.client.*;
import com.google.gwt.view.client.*;

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
            Window.alert("You selected: " + selected);
        }
    }
}

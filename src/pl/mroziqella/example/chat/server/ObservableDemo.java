package pl.mroziqella.example.chat.server;

import java.util.*;

public class ObservableDemo implements Observer {
    public static void main(String[] args) {
        // create watched and watcher objects
        ObservedObject watched = new ObservedObject("Original Value");
        // watcher object listens to object change
        ObservableDemo watcher = new ObservableDemo();
        ObservableDemo watcher1 = new ObservableDemo();

        // add observer to the watched object
        watched.addObserver(watcher);
        watched.addObserver(watcher1);

        // trigger value change
        watched.setValue("hahha");
        watched.setValue("hh");

    }

    public void update(Observable obj, Object arg) {
        System.out.println("Update called with Arguments: " + arg);
    }
}
package com.mycompany.zoo2aplication;

import com.mycompany.zoo2aplication.ui.AnimalManager;
import javafx.application.Platform;

public class Main {
    public static void main(String[] args) {
        Platform.startup(() ->
        {
            AnimalManager manager = new AnimalManager();
            manager.openMainWindow();
        });
    }
}

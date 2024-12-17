package com.mycompany.zoo2aplication.ui;

import com.mycompany.zoo2aplication.zoo.*;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;

public class AnimalManager {
    private final ArrayList<Animal> animals = new ArrayList<>();

    public void openMainWindow() {
        Stage window = new Stage();
        window.setTitle("Zoo Animal Manager");

        VBox layout = new VBox();
        layout.setSpacing(10);

        ListView<String> animalListView = new ListView<>();
        Button addButton = new Button("Add New Animal");
        Button refreshButton = new Button("Refresh List");

        // Logika dodawania nowego zwierzęcia
        addButton.setOnAction(e -> {
            AddAnimalForm form = new AddAnimalForm(this);
            form.show();
        });

        // Logika odświeżania listy zwierząt
        refreshButton.setOnAction(e -> refreshAnimalList(animalListView));

        layout.getChildren().addAll(animalListView, addButton, refreshButton);

        Scene scene = new Scene(layout, 400, 300);
        window.setScene(scene);
        window.show();

        refreshAnimalList(animalListView);
    }

    public void addAnimal(Animal animal) {
        animals.add(animal);
    }

    public void refreshAnimalList(ListView<String> listView) {
        listView.getItems().clear();
        for (Animal animal : animals) {
            listView.getItems().add(animal.toString());
        }
    }
}

package com.mycompany.zoo2aplication.ui;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import com.mycompany.zoo2aplication.zoo.*;

public class AddAnimalForm {
    private final AnimalManager manager; // Odwołanie do managera zwierząt

    public AddAnimalForm(AnimalManager manager) {
        this.manager = manager;
    }

    public void show() {
        Stage window = new Stage();
        window.setTitle("Add New Animal");

        // Utworzenie layoutu formularza
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10));
        grid.setVgap(8);
        grid.setHgap(10);

        // Tworzenie etykiet i pól formularza
        Label nameLabel = new Label("Name:");
        TextField nameInput = new TextField();
        Label ageLabel = new Label("Age:");
        TextField ageInput = new TextField();
        Label typeLabel = new Label("Type:");
        ComboBox<String> typeInput = new ComboBox<>();
        typeInput.getItems().addAll("REPTILE", "BIRD", "MAMMAL", "FISH");

        Button submitButton = new Button("Add Animal");

        // Dodanie elementów do layoutu
        grid.add(nameLabel, 0, 0);
        grid.add(nameInput, 1, 0);
        grid.add(ageLabel, 0, 1);
        grid.add(ageInput, 1, 1);
        grid.add(typeLabel, 0, 2);
        grid.add(typeInput, 1, 2);
        grid.add(submitButton, 1, 3);

        // Logika po kliknięciu przycisku Submit
        submitButton.setOnAction(e -> {
            String name = nameInput.getText();
            String ageText = ageInput.getText();
            String typeStr = typeInput.getValue();

            if (name.isEmpty() || ageText.isEmpty() || typeStr == null) {
                showAlert("Error", "Please fill all fields.");
                return;
            }

            try {
                int age = Integer.parseInt(ageText);
                AnimalType type = AnimalType.valueOf(typeStr);

                Animal animal;
                if (type == AnimalType.REPTILE) {
                    animal = new Crocodile(0, name, age, "rough", true);
                } else if (type == AnimalType.BIRD) {
                    animal = new Eagle(0, name, age, true, 1.5);
                } else {
                    animal = new Animal(0, name, age, type) {
                        @Override
                        public void eat() {
                            System.out.println(getName() + " is eating food.");
                        }
                    };
                }

                manager.addAnimal(animal);
                window.close();
            } catch (NumberFormatException ex) {
                showAlert("Error", "Invalid age entered.");
            }
        });

        Scene scene = new Scene(grid, 400, 250);
        window.setScene(scene);
        window.show();
    }

    private void showAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }
}

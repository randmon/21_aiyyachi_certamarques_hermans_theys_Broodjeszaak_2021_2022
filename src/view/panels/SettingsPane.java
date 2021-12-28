package view.panels;

import controller.AdminViewController;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.HashMap;

public class SettingsPane extends VBox {
    private AdminViewController controller;
    private ComboBox<String> fileChoice,kortingChoice;

    public SettingsPane (AdminViewController controller){
        super(15);
        this.controller = controller;
        this.setPadding(new Insets(5, 5, 5, 5));
        HBox saveStrategyBox = new HBox();
        saveStrategyBox.setAlignment(Pos.CENTER_LEFT);
        Label strategyLabel = new Label("Opslaan bestanden als: ");
        saveStrategyBox.getChildren().add(strategyLabel);
        fileChoice = new ComboBox<>();
        fileChoice.getItems().addAll(controller.getFileStrategies());
        fileChoice.getSelectionModel().select(controller.getSaveStrategy());
        saveStrategyBox.getChildren().add(fileChoice);
        this.getChildren().add(saveStrategyBox);

        HBox kortingStrategyBox = new HBox();
        kortingStrategyBox.setAlignment(Pos.CENTER_LEFT);
        Label kortingLabel = new Label("Voorkeur kortingsstrategy: ");
        kortingStrategyBox.getChildren().add(kortingLabel);
        kortingChoice = new ComboBox<>();
        kortingChoice.getItems().addAll(controller.getKortingStrategies());
        kortingChoice.getSelectionModel().select(controller.getKortingStrategy());
        kortingStrategyBox.getChildren().add(kortingChoice);
        this.getChildren().add(kortingStrategyBox);

        Button saveButton = new Button("Save");
        this.getChildren().add(saveButton);
        saveButton.setOnAction(event -> {
            HashMap<String, String> properties = new HashMap<>();
            properties.put("saveStrategy", getSaveStrategySelected());
            properties.put("kortingStrategy", getKortingSelected());
            controller.setProperties(properties);
        });
    }

    private String getSaveStrategySelected() {
        return fileChoice.getSelectionModel().getSelectedItem();
    }

    private String getKortingSelected() {
        return kortingChoice.getSelectionModel().getSelectedItem();
    }

}

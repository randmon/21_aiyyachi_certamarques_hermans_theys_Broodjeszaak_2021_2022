package view.panels;

import controller.AdminViewController;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class SettingsPane extends VBox {
    private AdminViewController controller;

    public SettingsPane (AdminViewController controller){
        super(5);
        this.controller = controller;
        this.setPadding(new Insets(5, 5, 5, 5));
            HBox saveStrategyBox = new HBox();
            saveStrategyBox.setAlignment(Pos.CENTER_LEFT);
            Label strategyLabel = new Label("Opslaan bestanden als: ");
            saveStrategyBox.getChildren().add(strategyLabel);
            ComboBox<String> strategyChoice = new ComboBox<>();
            strategyChoice.getItems().addAll(controller.getFileStrategies());
            strategyChoice.getSelectionModel().selectFirst();

            saveStrategyBox.getChildren().add(strategyChoice);
            this.getChildren().add(saveStrategyBox);
    }

}

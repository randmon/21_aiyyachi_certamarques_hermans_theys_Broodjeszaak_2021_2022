package view.panels;

import controller.AdminViewController;
import javafx.geometry.Insets;
import javafx.scene.layout.VBox;

public class SettingsPane extends VBox {
    private AdminViewController controller;

    public SettingsPane (AdminViewController controller){
        super(5);
        this.controller = controller;
        this.setPadding(new Insets(5, 5, 5, 5));

    }

}

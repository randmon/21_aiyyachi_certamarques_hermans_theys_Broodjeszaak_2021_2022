package view.panels;

import controller.AdminViewController;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;

public class AdminMainPane extends BorderPane {
	public AdminMainPane(AdminViewController controller){
	    TabPane tabPane = new TabPane();
        SandwichOverviewPane sandwichOverviewPane = new SandwichOverviewPane(controller);
        Tab broodjesTab = new Tab("Broodjes/Beleg",sandwichOverviewPane);
        Tab instellingTab = new Tab("Instellingen");
        Tab statistiekTab = new Tab("Statistieken");
        tabPane.getTabs().add(broodjesTab);
        tabPane.getTabs().add(statistiekTab);
        tabPane.getTabs().add(instellingTab);
        this.setCenter(tabPane);
	}
}

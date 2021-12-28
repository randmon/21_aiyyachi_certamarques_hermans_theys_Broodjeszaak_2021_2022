package view.panels;

import controller.AdminViewController;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;

public class AdminMainPane extends BorderPane {
    private SandwichOverviewPane sandwichOverviewPane;
    private StatisticsPane statisticsPane;
    private SettingsPane settingsPane;

    public AdminMainPane(AdminViewController controller){
	    TabPane tabPane = new TabPane();
        sandwichOverviewPane = new SandwichOverviewPane(controller);
        Tab broodjesTab = new Tab("Broodjes/Beleg", sandwichOverviewPane);

        statisticsPane = new StatisticsPane(controller);
        Tab statistiekTab = new Tab("Statistieken", statisticsPane);

        settingsPane = new SettingsPane(controller);
        Tab instellingTab = new Tab("Instellingen");

        tabPane.getTabs().add(broodjesTab);
        tabPane.getTabs().add(statistiekTab);
        tabPane.getTabs().add(instellingTab);
        this.setCenter(tabPane);
	}

    public void refresh() {
        sandwichOverviewPane.refreshBroodjes();
        sandwichOverviewPane.refreshBeleg();
        statisticsPane.refreshData();
    }
}

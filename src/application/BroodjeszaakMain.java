package application;

import controller.Broodjes_BelegViewController;
import javafx.application.Application;
import javafx.stage.Stage;
import view.AdminView;
import view.KitchenView;
import view.OrderView;

public class BroodjeszaakMain extends Application {
	//String chooseFile = "TXT";
	String chooseFile = "EXCEL";

	Broodjes_BelegViewController bCtrl = new Broodjes_BelegViewController(chooseFile);

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) {
		new AdminView(bCtrl);
		new OrderView();
		new KitchenView();
	}

	@Override
	public void stop() throws Exception {
		super.stop();
		bCtrl.saveVoorraad();
	}
}
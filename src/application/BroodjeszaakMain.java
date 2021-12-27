package application;

import controller.AdminViewController;
import controller.KitchenViewController;
import controller.OrderViewController;
import javafx.application.Application;
import javafx.stage.Stage;
import model.BestelFacade;
import view.AdminView;
import view.KitchenView;
import view.OrderView;

public class BroodjeszaakMain extends Application {
	String chooseFile = "TXT";
	//String chooseFile = "EXCEL";

	BestelFacade model = new BestelFacade(chooseFile);

	AdminViewController bCtrl = new AdminViewController(model);
	OrderViewController oCtrl = new OrderViewController(model);
	KitchenViewController kCtrl = new KitchenViewController(model);

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) {
		new AdminView(bCtrl);
		new OrderView(oCtrl);
		new KitchenView(kCtrl);
	}

	@Override
	public void stop() throws Exception {
		super.stop();
		bCtrl.saveVoorraad();
	}
}
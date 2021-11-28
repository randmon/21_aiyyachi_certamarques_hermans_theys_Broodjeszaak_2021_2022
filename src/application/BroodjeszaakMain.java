package application;
	
import controller.Broodjes_BelegViewController;
import facade.BestelFacade;
import javafx.application.Application;
import javafx.stage.Stage;
import view.AdminView;
import view.KitchenView;
import view.OrderView;

public class BroodjeszaakMain extends Application {

	@Override
	public void start(Stage primaryStage) {
		BestelFacade model = new BestelFacade();
		Broodjes_BelegViewController bCtrl = new Broodjes_BelegViewController(model);
		new AdminView(bCtrl);
		new OrderView();
		new KitchenView();
	}

	public static void main(String[] args) {
		launch(args);
	}
}

package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import view.AdminView;
import view.KitchenView;
import view.OrderView;

public class BroodjeszaakMain extends Application {

	@Override
	public void start(Stage primaryStage) {
		new AdminView();
		new OrderView();
		new KitchenView();
	}

	public static void main(String[] args) {
		launch(args);
	}
}

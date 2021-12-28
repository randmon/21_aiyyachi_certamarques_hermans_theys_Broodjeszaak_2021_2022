package view;

import controller.AdminViewController;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import view.panels.AdminMainPane;

public class AdminView {
	private Stage stage = new Stage();
	private AdminViewController controller;
	private AdminMainPane adminPane;

	public AdminView(AdminViewController controller) {
		this.controller = controller;
		controller.setView(this);

		stage.setTitle("ADMIN VIEW");
		stage.initStyle(StageStyle.UTILITY);
		stage.setX(680);
		stage.setY(20);
		Group root = new Group();
		Scene scene = new Scene(root, 650, 400);

		adminPane = new AdminMainPane(controller);
		adminPane.prefHeightProperty().bind(scene.heightProperty());
		adminPane.prefWidthProperty().bind(scene.widthProperty());
		root.getChildren().add(adminPane);

		stage.setScene(scene);
		stage.sizeToScene();			
		stage.show();		
	}

	public void refresh() {
		adminPane.refresh();
	}
}

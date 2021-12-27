package view;

import controller.KitchenViewController;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class KitchenView {
	private Stage stage = new Stage();
	private KitchenViewController controller;
	private final BorderPane main = new BorderPane();
	
	public KitchenView(KitchenViewController controller) {
		this.controller = controller;
		stage.setTitle("KITCHEN VIEW");
		stage.initStyle(StageStyle.UTILITY);
		stage.setX(680);
		stage.setY(470);
		Group root = new Group();
		Scene scene = new Scene(root, 650, 200);
		root.getChildren().add(main);
		//main.setBackground(new Background(new BackgroundFill(Paint.valueOf("lightblue"), CornerRadii.EMPTY, Insets.EMPTY) ));
		main.setPadding(new Insets(5, 5, 5, 10));
		main.setPrefWidth(650);
		main.setPrefHeight(200);

		//WACHTRIJ
		HBox queuePane = new HBox(10);
		queuePane.setAlignment(Pos.CENTER);
		main.setTop(queuePane);
		Label label = new Label("In wachtrij: 2");
		queuePane.getChildren().add(label);
		Button volgendeButton = new Button("Volgende bestelling");
		queuePane.getChildren().add(volgendeButton);


		//BESTELLING
		VBox bestellingPane = new VBox(5);
		main.setCenter(bestellingPane);
		//VOLGNR
		HBox volgnrHBox = new HBox();
		volgnrHBox.setAlignment(Pos.CENTER);
		Label volgnrLabel = new Label("\nVolgnummer bestelling: 12 - Aantal broodjes: 3\n");
		bestellingPane.getChildren().add(volgnrHBox);
		volgnrHBox.getChildren().add(volgnrLabel);
		//ITEMS
		VBox itemsVBox = new VBox(5);
		bestellingPane.getChildren().add(itemsVBox);
		itemsVBox.setPadding(new Insets(10, 10, 10, 10));
		itemsVBox.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, new CornerRadii(5), BorderStroke.THIN)));

		Label exampleItem1 = new Label("2 x Wit: hesp, feta");
		exampleItem1.setFont(new Font("Arial", 15));
		itemsVBox.getChildren().add(exampleItem1);

		Label exampleItem2 = new Label("1 x Volkoren: kaas, 2 x tomaat");
		exampleItem2.setFont(new Font("Arial", 15));
		itemsVBox.getChildren().add(exampleItem2);


		//AFWERKEN KNOP
		HBox afwerkenHBox = new HBox();
		Button afwerkenButton = new Button("Bestelling afgewerkt");
		afwerkenHBox.getChildren().add(afwerkenButton);
		afwerkenHBox.setAlignment(Pos.CENTER);
		afwerkenButton.setCursor(Cursor.HAND);
		afwerkenButton.setFont(new Font("Arial", 15));
		main.setBottom(afwerkenHBox);

		stage.setScene(scene);
		stage.sizeToScene();
		stage.show();
	}
}

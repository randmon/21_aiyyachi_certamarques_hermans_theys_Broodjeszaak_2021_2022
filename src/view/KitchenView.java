package view;

import controller.KitchenViewController;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.domain.DomainException;
import model.domain.bestelling.Bestelling;

import java.util.List;

public class KitchenView {
	private Stage stage = new Stage();
	private KitchenViewController controller;
	private final BorderPane main = new BorderPane();
	private Label wachtrijLabel, volgnrLabel;
	private Button nextOrderButton, afwerkenButton;
	private VBox bestellingPane, itemsVBox;

	public KitchenView(KitchenViewController controller) {
		this.controller = controller;
		controller.setView(this);
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
		wachtrijLabel = new Label("In wachtrij: -");
		queuePane.getChildren().add(wachtrijLabel);
		nextOrderButton = new Button("Volgende bestelling");
		nextOrderButton.setOnAction(event -> showBestelling());
		queuePane.getChildren().add(nextOrderButton);


		//BESTELLING
		bestellingPane = new VBox(15);
		main.setCenter(bestellingPane);
		//VOLGNR
		HBox volgnrHBox = new HBox();
		volgnrHBox.setAlignment(Pos.CENTER);
		volgnrLabel = new Label();
		bestellingPane.getChildren().add(volgnrHBox);
		volgnrHBox.getChildren().add(volgnrLabel);

		//ITEMS
		ScrollPane scrollPane = new ScrollPane();
		scrollPane.setPrefWidth(250);
		scrollPane.setMaxHeight(90);
		itemsVBox = new VBox(5);
		itemsVBox.setMinWidth(250);
		scrollPane.setContent(itemsVBox);
		bestellingPane.getChildren().add(scrollPane);
		itemsVBox.setPadding(new Insets(5, 5, 5, 5));

		bestellingPane.setVisible(false);

		//AFWERKEN KNOP
		HBox afwerkenHBox = new HBox();
		afwerkenButton = new Button("Bestelling afgewerkt");
		afwerkenHBox.getChildren().add(afwerkenButton);
		afwerkenHBox.setAlignment(Pos.CENTER);
		afwerkenButton.setCursor(Cursor.HAND);
		afwerkenButton.setFont(new Font("Arial", 15));
		afwerkenButton.setDisable(true);
		afwerkenButton.setOnAction(event -> {
			try {
				//hide bestellingpane
				bestellingPane.setVisible(false);

				//enable nextbutton and disable afwerkenbutton
				afwerkenButton.setDisable(true);

				controller.afwerken();

			} catch (DomainException e) {
				showAlert(e.getMessage());
			}
		});
		main.setBottom(afwerkenHBox);

		refreshWachtrij();

		stage.setScene(scene);
		stage.sizeToScene();
		stage.show();
	}

	public void showBestelling() {
		try {
			Bestelling bestelling = controller.getNextInRij();
			bestellingPane.setVisible(true);
			volgnrLabel.setText(
					"\nVolgnummer bestelling: " + bestelling.getId()
							+ " - Aantal broodjes: " + bestelling.getItems().size() + "\n");

			//show items
			itemsVBox.getChildren().clear();
			List<String> itemsForKitchen = controller.getItemsForKitchen();
			for (String s : itemsForKitchen) {
				Label item = new Label(s);
				item.setFont(new Font("Arial", 15));
				itemsVBox.getChildren().add(item);
			}

			//disable nextbutton and enable afwerkenbutton
			nextOrderButton.setDisable(true);
			afwerkenButton.setDisable(false);

		} catch (DomainException e) {
			showAlert(e.getMessage());
		}
	}

	public void refreshWachtrij() {
		int inWachtrij = controller.getInWachtrij();
		wachtrijLabel.setText("In wachtrij: " + inWachtrij);
		if (inWachtrij == 0) {
			//Disable button
			nextOrderButton.setDisable(true);
		} else if (!bestellingPane.visibleProperty().getValue()) {
			nextOrderButton.setDisable(false);
		}
	}

	private void showAlert(String s) {
		Alert alert = new Alert(Alert.AlertType.ERROR);
		alert.setHeaderText(s);
		alert.setTitle("Error!");
		alert.showAndWait();
	}
}

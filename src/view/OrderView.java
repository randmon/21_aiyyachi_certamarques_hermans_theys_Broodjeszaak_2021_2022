package view;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;	

public class OrderView {
	private Stage stage = new Stage();
	private final GridPane grid = new GridPane();
		
	public OrderView(){			
		stage.setTitle("ORDER VIEW");
		stage.initStyle(StageStyle.UTILITY);
		stage.setX(20);
		stage.setY(20);
		Group root = new Group();
		Scene scene = new Scene(root, 650, 650);

		TableView<String> table = getTable();
		root.getChildren().add(table);

		stage.setScene(scene);
		stage.sizeToScene();			
		stage.show();
	}

	public TableView<String> getTable() {
		TableView<String> table = new TableView<>();
		table.setEditable(false);

		TableColumn<String, String> column1 = new TableColumn<>("Naam");
		TableColumn<String, Double> column2 = new TableColumn<>("Prijs");
		TableColumn<String, Integer> column3 = new TableColumn<>("Voorraad");

		table.getColumns().add(column1);
		table.getColumns().add(column2);
		table.getColumns().add(column3);
		return table;
	}

	public void addBroodjesToTable() {
		//TODO implement
	}
}

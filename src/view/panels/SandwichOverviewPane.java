package view.panels;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import model.database.BroodjesDB;
import model.domain.Broodje;
import model.domain.Product;

import java.util.ArrayList;

public class SandwichOverviewPane extends GridPane{
	private final BroodjesDB broodjesDB = BroodjesDB.getInstance();
	//private final BelegDB belegDB = BelegDB.getInstance();
	private final TableView<Broodje> broodjesTable = new TableView<>();
	//private final TableView<Beleg> belegTable = new TableView<>();;
	private ObservableList<Broodje> broodjesList;
	//private ObservableList<Beleg> belegList;

	public SandwichOverviewPane() {
		this.setPadding(new Insets(5, 5, 5, 5));
        this.setVgap(5);
        this.setHgap(5);
		Label lblBroodjes = new Label("Broodjes:");
		lblBroodjes.setFont(new Font("Arial", 20));
		this.add(lblBroodjes, 0, 0, 1, 1);
		Label lblBeleg = new Label("Beleg:");
		lblBeleg.setFont(new Font("Arial", 20));
		this.add(lblBeleg, 1, 0, 1, 1);

		refreshBroodjes();
		//refreshBeleg();

		addCollumnsBroodje(broodjesTable);

		this.add(broodjesTable, 0, 1, 1, 1);
		//this.add(belegTable, 1, 1, 1, 1);
	}

	private void addCollumnsBroodje(TableView<Broodje> table) {
		TableColumn<Broodje, String> naam = new TableColumn<>("Naam");
		naam.setPrefWidth(150);
		naam.setCellValueFactory(new PropertyValueFactory<>("naam"));

		TableColumn<Broodje, Double> prijs = new TableColumn<>("Prijs");
		prijs.setPrefWidth(80);
		prijs.setCellValueFactory(new PropertyValueFactory<>("prijs"));

		TableColumn<Broodje, Integer> voorraad = new TableColumn<>("Voorraad");
		voorraad.setPrefWidth(80);
		voorraad.setCellValueFactory(new PropertyValueFactory<>("voorraad"));

		table.getColumns().addAll(naam, prijs, voorraad);
	}

	public void refreshBroodjes() {
		broodjesList = FXCollections.observableList(new ArrayList<>(broodjesDB.getAll()));
		broodjesTable.setItems(broodjesList);
		broodjesTable.refresh();
	}

	/*public void refreshBeleg() {
		belegList = FXCollections.observableList(new ArrayList<>(belegDB.getAll()));
		belegTable.setItems(belegList);
		belegTable.refresh();
	}*/
}

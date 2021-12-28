package view.panels;

import controller.AdminViewController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import model.domain.Beleg;
import model.domain.Broodje;
import java.util.ArrayList;

public class SandwichOverviewPane extends GridPane{
	private final TableView<Broodje> broodjesTable = new TableView<>();
	private final TableView<Beleg> belegTable = new TableView<>();
	private final AdminViewController controller;

	public SandwichOverviewPane(AdminViewController controller) {
		this.controller = controller;

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
		refreshBeleg();

		addCollumnsBroodje(broodjesTable);
		addCollumnsBeleg(belegTable);

		this.add(broodjesTable, 0, 1, 1, 1);
		this.add(belegTable, 1, 1, 1, 1);
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

	private void addCollumnsBeleg(TableView<Beleg> table) {
		TableColumn<Beleg, String> naam = new TableColumn<>("Naam");
		naam.setPrefWidth(150);
		naam.setCellValueFactory(new PropertyValueFactory<>("naam"));

		TableColumn<Beleg, Double> prijs = new TableColumn<>("Prijs");
		prijs.setPrefWidth(80);
		prijs.setCellValueFactory(new PropertyValueFactory<>("prijs"));

		TableColumn<Beleg, Integer> voorraad = new TableColumn<>("Voorraad");
		voorraad.setPrefWidth(80);
		voorraad.setCellValueFactory(new PropertyValueFactory<>("voorraad"));

		table.getColumns().addAll(naam, prijs, voorraad);
	}

	public void refreshBroodjes() {
		ObservableList<Broodje> broodjesList = FXCollections.observableList(new ArrayList<>(controller.getBroodjes().values()));
		broodjesTable.setItems(broodjesList);
		broodjesTable.refresh();
	}

	public void refreshBeleg() {
		ObservableList<Beleg> belegList = FXCollections.observableList(new ArrayList<>(controller.getBeleg().values()));
		belegTable.setItems(belegList);
		belegTable.refresh();
	}
}

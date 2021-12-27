package view.panels;

import controller.OrderViewController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import model.domain.Beleg;
import model.domain.Bestelling;
import model.domain.Broodje;
import model.domain.Item;

import java.util.ArrayList;
import java.util.List;

public class BestellingTablePane extends VBox {
    private final OrderViewController controller;
    private final TableView<Item> table = new TableView<>();
    private Label aantalBroodjes, optionsErrorLabel;
    private Button addSameItem, deleteItem, cancelOrder;

    public BestellingTablePane(OrderViewController controller) {
        super(10);
        this.controller = controller;

        //Label
        aantalBroodjes = new Label("Aantal broodjes: 0");
        aantalBroodjes.setFont(new Font("Arial", 15));
        getChildren().add(aantalBroodjes);

        //Table
        HBox tableHBox = new HBox(10);
        tableHBox.getChildren().add(table);
        getChildren().add(tableHBox);
        addCollumnsToTable();
        refreshTable();

        //Side options
        BorderPane sideOptions = new BorderPane();
        tableHBox.getChildren().add(sideOptions);

        //Top box
        VBox topVBox = new VBox(10);
        topVBox.setAlignment(Pos.CENTER);
        topVBox.setPadding(new Insets(20, 20, 20, 20));
        sideOptions.setTop(topVBox);

        optionsErrorLabel = new Label("Selecteer lijn in lijst");
        topVBox.getChildren().add(optionsErrorLabel);
        topVBox.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, new CornerRadii(5), BorderStroke.THIN)));


        addSameItem = new Button("Voeg zelfde broodje toe");
        addSameItem.setCursor(Cursor.HAND);
        topVBox.getChildren().add(addSameItem);

        deleteItem = new Button("Verwijder broodje");
        deleteItem.setCursor(Cursor.HAND);
        topVBox.getChildren().add(deleteItem);

        cancelOrder = new Button("Annuleer bestelling");
        cancelOrder.setCursor(Cursor.HAND);
        sideOptions.setBottom(cancelOrder);

        disableButtons(true);
    }

    public void addCollumnsToTable() {
        TableColumn<Item, Broodje> broodje = new TableColumn<>("Broodje");
        broodje.setPrefWidth(100);
        broodje.setCellValueFactory(new PropertyValueFactory<>("broodje"));
        table.getColumns().add(broodje);

        TableColumn<Item, List<Beleg>> beleg = new TableColumn<>("Beleg");
        beleg.setPrefWidth(300);
        beleg.setCellValueFactory(new PropertyValueFactory<>("beleg"));
        table.getColumns().add(beleg);
    }

    public void refreshTable() {
        if (controller.getBestelling() == null) {
            table.setItems(FXCollections.observableList(new ArrayList<>()));
            aantalBroodjes.setText("Aantal broodjes: 0");
        } else {
            ObservableList<Item> items = FXCollections.observableList(new ArrayList<>(controller.getBestelling().getItems().values()));
            table.setItems(items);
            aantalBroodjes.setText("Aantal broodjes: " + controller.getBestelling().getItems().size());
        }
        table.refresh();
    }

    public void disableButtons(boolean disabled) {
        addSameItem.setDisable(disabled);
        deleteItem.setDisable(disabled);
        cancelOrder.setDisable(disabled);
    }

    public Item getSelectedItem() {
        return table.getSelectionModel().getSelectedItem();
    }

    public void selectLast() {
        table.getSelectionModel().selectLast();
    }
}

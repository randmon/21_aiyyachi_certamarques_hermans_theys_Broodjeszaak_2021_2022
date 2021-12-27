package view.panels;

import controller.OrderViewController;
import javafx.geometry.Insets;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import model.domain.Beleg;
import model.domain.Broodje;
import model.domain.Item;

import java.util.List;

public class OrderButtonsPane extends VBox {
    private final FlowPane broodjesButtons = new FlowPane();
    private final FlowPane belegButtons = new FlowPane();
    private final OrderViewController controller;
    private BestellingTablePane bestellingTablePane;

    public OrderButtonsPane(OrderViewController controller) {
        super(20);
        this.controller = controller;
        setPrefWidth(650);
        setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, new CornerRadii(5), BorderStroke.THIN)));
        getChildren().add(broodjesButtons);
        getChildren().add(belegButtons);

        broodjesButtons.setHgap(10);
        broodjesButtons.setVgap(4);
        belegButtons.setHgap(10);
        belegButtons.setVgap(4);

        setPadding(new Insets(5,5,5,5));
    }

    public void refreshButtons() {
        broodjesButtons.getChildren().clear();
        belegButtons.getChildren().clear();

        List<Broodje> broodjesList = controller.getBroodjes();
        List<Beleg> belegList = controller.getBeleg();

        for(Broodje broodje : broodjesList){
               Button button = new Button(broodje.getNaam());

               button.setOnAction(event -> {
                   controller.addNewItem(broodje);
                   bestellingTablePane.selectLast();
               });

               button.setCursor(Cursor.HAND);
            button.setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE,
                    new CornerRadii(5),
                    Insets.EMPTY)));
            broodjesButtons.getChildren().add(button);
            button.setDisable(broodje.getVoorraad() == 0);
        }

        for(Beleg beleg : belegList){
            Button button = new Button(beleg.getNaam());

            //Get selected item in the table
            Item selectedItem = bestellingTablePane.getSelectedItem();

            //Add to the Item object in that line the beleg that we clicked on
            button.setOnAction(event -> controller.addBelegToItem(selectedItem, beleg));

            button.setCursor(Cursor.HAND);
            button.setBackground(new Background(new BackgroundFill(Color.YELLOW,
                    new CornerRadii(5),
                    Insets.EMPTY)));
            belegButtons.getChildren().add(button);
            button.setDisable(beleg.getVoorraad() == 0);
        }
    }

    public void setBestellingTablePane(BestellingTablePane bestellingTablePane) {
        this.bestellingTablePane = bestellingTablePane;
    }

    public void disableButtons(boolean disabled) {
        for (Node button : broodjesButtons.getChildren()) {
            button.setDisable(disabled);
        }

        for (Node button : belegButtons.getChildren()) {
            button.setDisable(disabled);
        }
    }


}

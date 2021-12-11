package view.panels;

import controller.OrderViewController;
import javafx.geometry.Insets;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

import java.util.List;

public class OrderButtonsPane extends VBox {
    private final HBox broodjesButtons = new HBox();
    private final HBox belegButtons = new HBox();
    private OrderViewController controller;

    public OrderButtonsPane(OrderViewController controller) {
        super(20);
        this.controller = controller;
        setPrefWidth(650);
        setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, new CornerRadii(5), BorderStroke.THIN)));
        getChildren().add(broodjesButtons);
        getChildren().add(belegButtons);

        broodjesButtons.setSpacing(10);
        belegButtons.setSpacing(10);

        refreshButtons(broodjesButtons, belegButtons);

        setPadding(new Insets(5,5,5,5));

    }

    public void refreshButtons(HBox broodjesButtons, HBox belegButtons) {
        broodjesButtons.getChildren().clear();
        belegButtons.getChildren().clear();

        List<String> broodjes = controller.getBroodjeButtons();
        List<String> beleg = controller.getBelegButtons();

        for(String s : broodjes){
               Button button = new Button(s);
               button.setCursor(Cursor.HAND);
            button.setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE,
                    new CornerRadii(5),
                    Insets.EMPTY)));
               broodjesButtons.getChildren().add(button);
        }

        for(String s : beleg){
            Button button = new Button(s);
            button.setCursor(Cursor.HAND);
            button.setBackground(new Background(new BackgroundFill(Color.YELLOW,
                    new CornerRadii(5),
                    Insets.EMPTY)));
            belegButtons.getChildren().add(button);
        }
    }
}

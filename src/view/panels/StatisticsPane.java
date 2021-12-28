package view.panels;

import controller.AdminViewController;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.GridPane;
import model.domain.Beleg;
import model.domain.Broodje;

import java.util.ArrayList;
import java.util.List;

public class StatisticsPane extends GridPane {
    private AdminViewController controller;
    private BarChart<Number,String> broodjesChart, belegChart;

    public StatisticsPane(AdminViewController controller) {
        this.controller = controller;
        this.setPadding(new Insets(5, 5, 5, 5));
        this.setVgap(5);
        this.setHgap(5);

        //----BROODJES----
        NumberAxis broodjesXAxis = new NumberAxis();
        CategoryAxis broodjesYAxis = new CategoryAxis();
        broodjesChart = new BarChart<>(broodjesXAxis, broodjesYAxis);
        broodjesChart.setTitle("Omzetstatistiek broodjes (in aantal stuks)");
        broodjesChart.setLegendVisible(false);
        this.add(broodjesChart, 0, 0, 1, 1);

        //----BELEG----
        NumberAxis belegXAxis = new NumberAxis();
        CategoryAxis belegYAxis = new CategoryAxis();
        belegChart = new BarChart<>(belegXAxis, belegYAxis);
        belegChart.setTitle("Omzetstatistiek beleg (in aantal porties)");
        belegChart.setLegendVisible(false);

        this.add(belegChart, 1, 0, 1, 1);

        refreshData();
    }

    public void refreshData() {
        //BROODJES
        List<Broodje> broodjes = new ArrayList<>(controller.getBroodjes().values());
        for (Broodje b : broodjes) {
            int value = b.getBesteld();
            String name = b.getNaam();
            XYChart.Series<Number, String> broodjesData = new XYChart.Series<>();
            broodjesData.getData().add(new XYChart.Data<>(value, name));
            broodjesChart.getData().add(broodjesData);
        }
        for(Node n:broodjesChart.lookupAll(".default-color0.chart-bar")) {
            n.setStyle("-fx-bar-fill: LIGHTBLUE;");
        }

        //BELEG
        List<Beleg> belegList = new ArrayList<>(controller.getBeleg().values());
        for (Beleg b : belegList){
            int value = b.getBesteld();
            String name = b.getNaam();
            XYChart.Series<Number, String> belegData = new XYChart.Series<>();
            belegData.getData().add(new XYChart.Data<>(value, name));
            belegChart.getData().add(belegData);
        }
        for(Node n:belegChart.lookupAll(".default-color0.chart-bar")) {
            n.setStyle("-fx-bar-fill: ORANGE;");
        }

    }
}

package view.panels;

import controller.AdminViewController;
import javafx.geometry.Insets;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.GridPane;

public class StatisticsPane extends GridPane {
    private AdminViewController controller;
    private BarChart<Number,String> broodjesChart, belegChart;

    public StatisticsPane(AdminViewController controller) {
        this.controller = controller;
        this.setPadding(new Insets(5, 5, 5, 5));
        this.setVgap(5);
        this.setHgap(5);

        //BROODJES
        NumberAxis broodjesXAxis = new NumberAxis();
        CategoryAxis broodjesYAxis = new CategoryAxis();
        broodjesChart = new BarChart<>(broodjesXAxis, broodjesYAxis);
        broodjesChart.setTitle("Omzetstatistiek broodjes (in aantal stuks)");

        XYChart.Series<Number, String> broodjesData = new XYChart.Series<>();
        broodjesData.getData().add(new XYChart.Data<>(12, "brood1"));
        broodjesData.getData().add(new XYChart.Data<>(5, "brood2"));
        broodjesData.getData().add(new XYChart.Data<>(13, "brood3"));
        broodjesChart.getData().add(broodjesData);
        broodjesChart.setLegendVisible(false);
        this.add(broodjesChart, 0, 0, 1, 1);

        //BELEG
        NumberAxis belegXAxis = new NumberAxis();
        CategoryAxis belegYAxis = new CategoryAxis();
        belegChart = new BarChart<>(belegXAxis, belegYAxis);
        belegChart.setTitle("Omzetstatistiek beleg (in aantal porties)");

        XYChart.Series<Number, String> belegData = new XYChart.Series<>();
        belegData.getData().add(new XYChart.Data<>(22, "beleg1"));
        belegData.getData().add(new XYChart.Data<>(15, "beleg2"));
        belegData.getData().add(new XYChart.Data<>(13, "beleg3"));
        belegData.getData().add(new XYChart.Data<>(20, "beleg4"));
        belegData.getData().add(new XYChart.Data<>(5, "beleg5"));
        belegData.getData().add(new XYChart.Data<>(10, "beleg6"));
        belegData.getData().add(new XYChart.Data<>(16, "beleg7"));
        belegChart.getData().add(belegData);
        belegChart.setLegendVisible(false);
        this.add(belegChart, 1, 0, 1, 1);
    }

    public void refreshData() {
        //TODO get broodje statistics from controller

        //TODO get beleg statistics from controller
    }
}

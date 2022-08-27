package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.chart.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.VBox;
import javafx.geometry.Insets;

public class SavingsCalculatorApplication extends Application {

    public void start(Stage window) {
        VBox sliders = new VBox();

        //Monthly Savings Setup
        BorderPane savingsUI = new BorderPane();
        Label savingsLabel = new Label("Monthly savings");
        Label monthlyAmount = new Label("25.0");
        Slider savingsSlider = new Slider();

        savingsSlider.setMin(25);
        savingsSlider.setMax(250);
        savingsSlider.setMajorTickUnit(25);
        savingsSlider.setShowTickLabels(true);
        savingsSlider.setShowTickMarks(true);

        savingsUI.setLeft(savingsLabel);
        savingsUI.setCenter(savingsSlider);
        savingsUI.setRight(monthlyAmount);

        //Interest Rate Setup
        BorderPane interestRateUI = new BorderPane();
        Label interestRateLabel = new Label("Yearly interest rate");
        Label rate = new Label("0");
        Slider interestSlider = new Slider(0, 10, 0);
        interestSlider.setShowTickMarks(true);
        interestSlider.setShowTickLabels(true);
        interestSlider.setMinorTickCount(10);

        interestRateUI.setLeft(interestRateLabel);
        interestRateUI.setCenter(interestSlider);
        interestRateUI.setRight(rate);

        //Add savings and interest sliders to slider component
        sliders.getChildren().addAll(savingsUI, interestRateUI);

        //Graph Setup
        NumberAxis xAxis = new NumberAxis(0, 30, 1);
        NumberAxis yAxis = new NumberAxis();
        yAxis.setUpperBound(100);
        yAxis.setLowerBound(0);

        LineChart<Number, Number> lineChart = new LineChart(xAxis, yAxis);
        lineChart.setTitle("Savings");
        lineChart.setLegendVisible(false);

        XYChart.Series savings = new XYChart.Series();
        XYChart.Series interest = new XYChart.Series();

        savingsSlider.valueProperty().addListener((event) -> {
            monthlyAmount.setText(String.valueOf(savingsSlider.getValue()));
            getChartData(savings, yAxis, savingsSlider.getValue(), interestSlider.getValue(), "savings");
            getChartData(interest, yAxis, savingsSlider.getValue(), interestSlider.getValue(), "interest");
        });

        interestSlider.valueProperty().addListener((event) -> {
            rate.setText(String.valueOf(interestSlider.getValue()));
            getChartData(interest, yAxis, savingsSlider.getValue(), interestSlider.getValue(), "interest");
        });

        //init graph
        for (int year = 0; year < 31; year++) {
            double sum = savingsSlider.getValue() * 12 * year;
            savings.getData().add(new XYChart.Data(year, sum));
            interest.getData().add(new XYChart.Data(year, sum));
        }

        lineChart.getData().add(savings);
        lineChart.getData().add(interest);

        //Window Setup
        BorderPane mainScene = new BorderPane();
        mainScene.setTop(sliders);
        mainScene.setCenter(lineChart);

        Scene scene = new Scene(mainScene, 640, 640);

        window.setScene(scene);
        window.show();
    }

    public static void main(String[] args) {
        launch(SavingsCalculatorApplication.class);
    }

    public static void getChartData(XYChart.Series data, NumberAxis yAxis, Double monthlySavings, Double interestRate, String type) {
        data.getData().clear();

        double rate = 0;
        double max = 0;
        double principal = 0;
        double finalAmount = 0;

        if (type.equals("savings")) {
            rate = 0;
        } else if (type.equals("interest")) {
            rate = interestRate / 100;
        }

        for (int year = 0; year < 31; year++) {

            if (year == 0) {
                finalAmount = 0;
            } else {
                finalAmount = (principal + (monthlySavings * 12)) * (1 + rate);
            }
            principal = finalAmount;

            if (finalAmount > max) {
                max = finalAmount;
            }
            data.getData().add(new XYChart.Data(year, finalAmount));
        }
        yAxis.setUpperBound(max);
    }
}
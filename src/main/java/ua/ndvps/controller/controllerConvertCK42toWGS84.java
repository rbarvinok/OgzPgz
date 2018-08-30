package ua.ndvps.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import ua.ndvps.javaClass.*;

import java.io.IOException;

import static ua.ndvps.javaClass.Clear.clear;

public class ControllerConvertCK42toWGS84 {

    @FXML
    public TextField Tx, Ty, ThCK42;
    @FXML
    public TextField Tx2d, Tx2m, Tx2s;
    @FXML
    public TextField Ty2d, Ty2m, Ty2s;
    @FXML
    public TextField ThWGS84;
    @FXML
    public Button btnok, btnx1, back, dov;

    PushButton pb = new PushButton();

    public void onClick_btnx1(ActionEvent actionEvent) {
        Clear.clear(Tx, Ty);
    }

    public void onClick_btnOk(ActionEvent actionEvent) {

        try {
            Double x1 = Double.parseDouble(Tx.getText().replace(",", "."));
            Double y1 = Double.parseDouble(Ty.getText().replace(",", "."));
            Double h1 = Double.parseDouble(ThCK42.getText().replace(",", "."));

            ConverterCoordinateSystem coordinateSystem = new ConverterCoordinateSystem();
            coordinateSystem.GKtoBLh(x1, y1, h1);
            ConverterCoordinates ck42towgs84 = new ConverterCoordinates();
            ck42towgs84.Ck42ToWgs84Converter(coordinateSystem.getLatitude42(), coordinateSystem.getLongitude42(), coordinateSystem.getAltitude42());
            RadToDMS radToDMSLat =new RadToDMS(ck42towgs84.getLatitude84());
            RadToDMS radToDMSLon =new RadToDMS(ck42towgs84.getLongitude84());

            Tx2d.setText(String.valueOf((int) (radToDMSLat.getDegrees())));
            Tx2m.setText(String.valueOf((int) (radToDMSLat.getMinut())));
            Tx2s.setText(Double.toString(radToDMSLat.getSecond()).replace(".", ","));
            Ty2d.setText(String.valueOf((int) (radToDMSLon.getDegrees())));
            Ty2m.setText(String.valueOf((int) (radToDMSLon.getMinut())));
            Ty2s.setText(Double.toString(radToDMSLon.getSecond()).replace(".", ","));
            ThWGS84.setText(Double.toString(ck42towgs84.getAltitude84()));

        } catch (NumberFormatException e) {
            //e.printStackTrace();
            pb.alert();
        }





    }

    public void onClick_dov(ActionEvent actionEvent) {
        pb.hd = "Перетворення координат СК-42 в WGS-84";
        pb.ct = "Координати СК-42 (проєкція Гауса-Крюгера) записуються в форматі в форматі X Y H. \n" +
                "Геодезичні координати WGS-8 виводяться в форматі - B L H.";
        pb.dov = dov;
        pb.dovButton();
    }

    public void onClick_back(ActionEvent actionEvent) throws IOException {
        pb.back = back;
        pb.backButton();
    }
}

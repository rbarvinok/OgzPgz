package ua.ndvps.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import ua.ndvps.javaClass.PushButton;
import ua.ndvps.javaClass.PgzWGS84;
import ua.ndvps.javaClass.Clear;
import static ua.ndvps.javaClass.Clear.clear;
import java.io.IOException;

public class ControllerPgzWGS84 {
    @FXML
    public TextField Tx1d, Tx1m, Tx1s;
    @FXML
    public TextField Ty1d, Ty1m, Ty1s;
    @FXML
    public TextField Tx2d, Tx2m, Tx2s;
    @FXML
    public TextField Ty2d, Ty2m, Ty2s;
    @FXML
    public TextField a, d;
    @FXML
    public Button btnok, btnx1, btnx2, back, dov;

    PushButton pb = new PushButton();


    public void onClick_btnx1(ActionEvent actionEvent) {
        Clear.clear(Tx1d, Tx1m, Tx1s, Ty1d, Ty1m, Ty1s);
    }

    public void onClick_btnx2(ActionEvent actionEvent) {
        Clear.clear(a, d);

    }

    public void onClick_btnOk(ActionEvent actionEvent) {

        try {
            Double b1d = Double.parseDouble(Tx1d.getText().replace(",", "."));
            Double b1m = Double.parseDouble(Tx1m.getText().replace(",", "."));
            Double b1s = Double.parseDouble(Tx1s.getText().replace(",", "."));

            Double l1d = Double.parseDouble(Ty1d.getText().replace(",", "."));
            Double l1m = Double.parseDouble(Ty1m.getText().replace(",", "."));
            Double l1s = Double.parseDouble(Ty1s.getText().replace(",", "."));

            Double latitude1 = b1d + b1m / 60 + b1s / 3600;
            Double longitude1 = l1d + l1m / 60 + l1s / 3600;

            Double s = Double.parseDouble(d.getText().replace(",", "."));
            Double angle = Double.parseDouble(a.getText().replace(",", "."));


            PgzWGS84 pgzWgs84 = new PgzWGS84(latitude1, longitude1, s, angle);

            Tx2d.setText(String.valueOf((int) (pgzWgs84.getLatitude2d())));
            Tx2m.setText(String.valueOf((int) (pgzWgs84.getLatitude2m())));
            Tx2s.setText(Double.toString(pgzWgs84.getLatitude2s()).replace(".", ","));

            Ty2d.setText(String.valueOf((int) (pgzWgs84.getLongitude2d())));
            Ty2m.setText(String.valueOf((int) (pgzWgs84.getLongitude2m())));
            Ty2s.setText(Double.toString(pgzWgs84.getLongitude2s()).replace(".", ","));


        } catch (NumberFormatException e) {
            e.printStackTrace();
            pb.alert();
        }

    }

    public void onClick_back(ActionEvent actionEvent) throws IOException {
        pb.back = back;
        pb.backButton();
    }

    public void onClick_dov(ActionEvent actionEvent) {
        pb.hd = "Пряма геодезична задача";
        pb.ct = "По відомим координатам однієї точки розраховується координати другої точки, для чого необхідно знати довжину лінії між цими точками та дирекційний кут цієї лінії";
        pb.dov = dov;
        pb.dovButton();
    }
}
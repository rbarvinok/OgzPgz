package ua.ndvps.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import ua.ndvps.javaClass.PushButton;
import ua.ndvps.javaClass.PgzCK42;

import java.io.IOException;

public class ControllerPgzCK42 {
    @FXML
    public TextField Tx1,Ty1,Tx2,Ty2, a, d;
    @FXML
    public Button btnok, btnx1,btnx2,back,dov;


    PushButton pb = new PushButton();

    public void onClick_btnx1(ActionEvent actionEvent) {
        Tx1.setText("");
        Ty1.setText("");
    }
    public void onClick_btnx2(ActionEvent actionEvent) {
        a.setText("");
        d.setText("");
    }

    public void onClick_btnOk(ActionEvent actionEvent) {
               
       try {
           if (Double.parseDouble(a.getText().replace(",", "."))<=60) {
               Double x1 = Double.parseDouble(Tx1.getText().replace(",", "."));
               Double y1 = Double.parseDouble(Ty1.getText().replace(",", "."));
               Double ang = Double.parseDouble(a.getText().replace(",", "."));
               Double dist = Double.parseDouble(d.getText().replace(",", "."));


               PgzCK42 pgz = new PgzCK42(x1, y1, dist, ang);
               Tx2.setText(Double.toString(pgz.getX2()).replace(".", ","));
               Ty2.setText(Double.toString(pgz.getY2()).replace(".", ","));
           } else
               pb.alert();
       }
       catch (NumberFormatException e){
           e.printStackTrace();
           pb.alert();
       }

           }


    public void onClick_back(ActionEvent actionEvent) throws IOException {
       pb.back=back;
       pb.backButton();
    }

    public void onClick_dov(ActionEvent actionEvent) {
        pb.hd="Пряма геодезична задача";
        pb.ct="По відомим координатам однієї точки розраховується координати другої точки, для чого необхідно знати довжину лінії між цими точками та дирекційний кут цієї лінії";
        pb.dov=dov;
        pb.dovButton();
    }
}
package ua.ndvps.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import ua.ndvps.javaClass.PushButton;

import java.io.IOException;

public class Controller {
    PushButton pb = new PushButton();

    @FXML
    public TextArea ta;
    @FXML
    public Button btno, btnp, btno84, btnp84, btnCKtoWGS, btnWGStoCK;
    @FXML
    public RadioMenuItem MenuSvitlaTema, MenuTemnaTema;

    public void onClick_btnp(ActionEvent actionEvent) throws IOException {
        //Закрытие окна
        Stage stage = (Stage) btnp.getScene().getWindow();
        stage.hide();
        //  Открытие нового окна
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/samplePgzCK42.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        stage = new Stage();
        stage.setTitle("Пряма геодезична задача");
        stage.getIcons().add(new Image(getClass().getResourceAsStream("/images/america_ico.png")));
        stage.setScene(new Scene(root1));
        root1.getStylesheets().add(getClass().getResource(pb.change_css()).toExternalForm());
        stage.show();
    }

    public void onClick_btno(ActionEvent actionEvent) throws IOException {
        //Закрытие окна
        Stage stage = (Stage) btno.getScene().getWindow();
        stage.hide();
        //  Открытие нового окна
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/sampleOgzCK42.fxml"));
        Parent root2 = (Parent) fxmlLoader.load();
        stage = new Stage();
        stage.setTitle("Оберена геодезична задача");
        stage.getIcons().add(new Image(getClass().getResource("/images/america_ico.png").toExternalForm()));
        stage.setScene(new Scene(root2));
        root2.getStylesheets().add(getClass().getResource(pb.change_css()).toExternalForm());
        stage.show();
    }

    public void onClick_btno84(ActionEvent actionEvent) throws IOException {
        //Закрытие окна
        Stage stage = (Stage) btno84.getScene().getWindow();
        stage.hide();
        //  Открытие нового окна
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/sampleOgzWGS84.fxml"));
        Parent root3 = (Parent) fxmlLoader.load();
        stage = new Stage();
        stage.setTitle("Оберена геодезична задача");
        stage.getIcons().add(new Image(getClass().getResource("/images/america_ico.png").toExternalForm()));
        stage.setScene(new Scene(root3));
        root3.getStylesheets().add(getClass().getResource(pb.change_css()).toExternalForm());
        stage.show();
    }

    public void onClick_btnp84(ActionEvent actionEvent) throws IOException {
        //Закрытие окна
        Stage stage = (Stage) btnp84.getScene().getWindow();
        stage.hide();
        //  Открытие нового окна
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/samplePgzWGS84.fxml"));
        Parent root3 = (Parent) fxmlLoader.load();
        stage = new Stage();
        stage.setTitle("Пряма геодезична задача");
        stage.getIcons().add(new Image(getClass().getResource("/images/america_ico.png").toExternalForm()));
        stage.setScene(new Scene(root3));
        root3.getStylesheets().add(getClass().getResource(pb.change_css()).toExternalForm());
        stage.show();
    }

    public void onClick_btnCKtoWGS(ActionEvent actionEvent) throws IOException {
        //Закрытие окна
        Stage stage = (Stage) btnCKtoWGS.getScene().getWindow();
        stage.hide();
        //  Открытие нового окна
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/sampleConvertCK42toWGS84.fxml"));
        Parent root = (Parent) fxmlLoader.load();
        stage = new Stage();
        stage.setTitle("Перетворення координат СК-42 в WGS-84");
        stage.getIcons().add(new Image(getClass().getResource("/images/america_ico.png").toExternalForm()));
        stage.setScene(new Scene(root));
        root.getStylesheets().add(getClass().getResource(pb.change_css()).toExternalForm());
        stage.show();
    }

    public void onClick_WGStoCK(ActionEvent actionEvent) throws IOException {
//Закрытие окна
        Stage stage = (Stage) btnWGStoCK.getScene().getWindow();
        stage.hide();
        //  Открытие нового окна
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/sampleConvertWGS84toCK42.fxml"));
        Parent root = (Parent) fxmlLoader.load();
        stage = new Stage();
        stage.setTitle("Перетворення координат WGS-84 в СК-42");
        stage.getIcons().add(new Image(getClass().getResource("/images/america_ico.png").toExternalForm()));
        stage.setScene(new Scene(root));
        root.getStylesheets().add(getClass().getResource(pb.change_css()).toExternalForm());
        stage.show();
    }

    public void onClick_menuExit(ActionEvent actionEvent) {

        System.exit(0);
    }

    public void onClick_menuDovidka(ActionEvent actionEvent) {
        pb.ct = "ПРЯМА ГЕОДЕЗИЧНА ЗАДАЧА \n" +
                "заключається в тому, що по відомим координатам однієї точки розраховується координати другої точки, для чого необхідно знати довжину лінії між цими точками та дирекційний кут цієї лінії\n" +
                "\n" +
                "ОБЕРНЕНА ГЕОДЕЗИЧНА ЗАДАЧА \n" +
                "заключається в тому, що по відомим координатам двох точок розраховується довжина лінії між цими точками та дирекційний кут цієї лінії";
        pb.dovButton();
    }

    public void onClick_menuAbaout(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/sampleAbout.fxml"));
        Parent root = (Parent) fxmlLoader.load();
        Stage stage = new Stage(StageStyle.UNDECORATED);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setScene(new Scene(root));
        stage.show();
    }


    public void Tema() {

        if (MenuSvitlaTema.isSelected()) {
            MenuTemnaTema.setSelected(true);
            pb.tema = 0;
        } else if (MenuTemnaTema.isSelected()) {
            MenuTemnaTema.setSelected(true);
            pb.tema = 1;
        }
    }


}
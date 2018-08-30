package ua.ndvps;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import ua.ndvps.javaClass.PushButton;

public class Main extends Application {
    private PushButton pb = new PushButton();

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.getIcons().add(new Image(getClass().getResource("/images/america_ico.png").toExternalForm()));
        Parent root = FXMLLoader.load(getClass().getResource("/view/sample.fxml"));
        primaryStage.setTitle("ПГЗ - ОГЗ");
        Scene scene = new Scene(root);
        //scene.getStylesheets().add(getClass().getResource(pb.change_css()).toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.show();


    }

    public static void main(String[] args) {
//        ConverterCoordinates ck42ToWgs84Converter = new ConverterCoordinates(51.21, 23.43, 1987);
//        ck42ToWgs84Converter.getLatitude();
//        ck42ToWgs84Converter.getLongitude();
//        ck42ToWgs84Converter.getAltitude();

        launch(args);
    }


}

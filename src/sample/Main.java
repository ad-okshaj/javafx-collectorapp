package sample;

//comment - import javafx.stage.Modality;
//comment - import javafx.scene.layout.BorderPane;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.*;
import javafx.fxml.FXMLLoader;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("projectzero.fxml"));
            Scene scene = new Scene(root,430,600);
           // scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
            primaryStage.setScene(scene);
            primaryStage.setTitle("Multi-Purpose Information Collector Tool");
            primaryStage.setResizable(false);
            primaryStage.show();

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
//prefHeight="369.0" prefWidth="343.0"
    public static void main(String[] args) {
        launch(args);
    }
}

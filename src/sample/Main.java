package sample;

//comment - import javafx.stage.Modality;
//comment - import javafx.scene.layout.BorderPane;
import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.scene.*;
import javafx.fxml.FXMLLoader;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("projectzero.fxml"));
            Scene scene = new Scene(root,430,600);
            primaryStage.setScene(scene);
            primaryStage.setTitle("Multi-Purpose Information Collector Tool");
            primaryStage.getIcons().add(new Image(this.getClass().getResource("logo.png").toString()));
            primaryStage.setResizable(false);
            primaryStage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        launch(args);
    }
}

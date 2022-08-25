package sample;

import java.sql.*;
import java.util.ResourceBundle;
import java.net.URL;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import java.io.Writer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import javafx.scene.image.Image;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.SQLException;
//import javafx.scene.control.TextInputControl;
//import javafx.scene.layout.AnchorPane;
//import javafx.stage.Modality;
//import javafx.scene.*;
//import javafx.scene.layout.BorderPane;
//import javafx.fxml.FXMLLoader;
//import javafx.fxml.FXMLLoader;
//import javafx.application.Platform;


public class function implements Initializable {
    @FXML
    public TextField t1;
    @FXML
    public TextField t2;
    @FXML
    public TextField t3;
    @FXML
    public TextField t4;
    @FXML
    public TextField t5;
    Scene scene2;

    public void add(ActionEvent event) {
        if (t1.getText().isEmpty() || t2.getText().isEmpty() || t3.getText().isEmpty() || t4.getText().isEmpty() || t5.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Please Try Again!");
            Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
            stage.getIcons().add(new Image(this.getClass().getResource("logo.png").toString()));
            alert.getDialogPane().setMinWidth(600);
            alert.setHeaderText("Empty fields not allowed!");
            alert.setContentText("All fields are mandatory for using this application. Please make sure that all the information is entered. For further queries, please contact Adokshaj Bhandarkar.");
            alert.showAndWait();
        } else {
            Parent root;
            String lname, fname, dob, email, mobile;
            lname = t1.getText();
            fname = t2.getText();
            dob = t3.getText();
            email = t4.getText();
            mobile = t5.getText();
            handleCSV(lname, fname, dob, email, mobile);
            try {//add to mysql
                pst = con.prepareStatement("insert into tooldb(lname,fname,dob,email,mobile)values(?,?,?,?,?)");
                pst.setString(1, lname);
                pst.setString(2, fname);
                pst.setString(3, dob);
                pst.setString(4, email);
                pst.setString(5, mobile);
                pst.executeUpdate();
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Success!");
                Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
                stage.getIcons().add(new Image(this.getClass().getResource("logo.png").toString()));
                alert.getDialogPane().setMinWidth(400);
                alert.setHeaderText("User added to MySQL database.");
                alert.setContentText("Record has been added to MySQL database successfully!");
                alert.showAndWait();
                //table();
                t1.setText("");
                t2.setText("");
                t3.setText("");
                t4.setText("");
                t5.setText("");
                t1.requestFocus();
                //add to mysql

                //thank you popup
//                    FXMLLoader fxmlLoader = new FXMLLoader();
//                    fxmlLoader.setLocation(getClass().getResource("popup.fxml"));
//                    Scene scene = new Scene(fxmlLoader.load(), 450, 250);
//                    Stage stage = new Stage();
//                    stage.setTitle("Thank You!");
//                    stage.setScene(scene);
//                    stage.setResizable(false);
//                    stage.show();
                //thank you popup
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
    //database code
    static Connection con;
    PreparedStatement pst;
    int myIndex;
    int id;
    public void Connect()
    {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/javafx","root","");
        } catch (ClassNotFoundException ex) {
        } catch (SQLException ex) {
            displayError();
            ex.printStackTrace();
        }
    }
    public void connectFunc(ActionEvent event)
    {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/javafx","root","");
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Connected!");
            Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
            stage.getIcons().add(new Image(this.getClass().getResource("logo.png").toString()));
            alert.getDialogPane().setMinWidth(400);
            alert.setHeaderText("Connected to Database!");
            alert.setContentText("You can use the application in online mode now!");
            alert.showAndWait();
        } catch (ClassNotFoundException ex) {
        } catch (SQLException ex) {
            displayError();
            ex.printStackTrace();
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Connect();
        //table();
    }
    //database code
    public void handleCSV(String lname, String fname, String dob, String email, String mobile){
        //file handling here
        try { Writer my1;
        my1 = new BufferedWriter(new FileWriter("Users.csv", true));
        my1.append(lname + "," + fname + "," + dob + "," + email + "," + mobile + "\n");
        my1.close();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Success!");
            Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
            stage.getIcons().add(new Image(this.getClass().getResource("logo.png").toString()));
            alert.getDialogPane().setMinWidth(400);
            alert.setHeaderText("User added to CSV file.");
            alert.setContentText("Record has been added to the CSV file successfully!");
            alert.showAndWait();
            //table();
            t1.setText("");
            t2.setText("");
            t3.setText("");
            t4.setText("");
            t5.setText("");
            t1.requestFocus();
        }
        // file handling here
        catch (IOException exec) {
            exec.printStackTrace();
            Logger logger = Logger.getLogger(getClass().getName());
            logger.log(Level.SEVERE, "Failed to create new Window.", mobile);
        }
    }
    public void displayError() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Failed to connect!");
        Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
        stage.getIcons().add(new Image(this.getClass().getResource("logo.png").toString()));
        alert.getDialogPane().setMinWidth(600);
        alert.setHeaderText("Failed to establish connection with MySQL database.");
        alert.setContentText("Use offline using CSV file or Please check if your database server is running then relaunch this application. Thank you!");
        alert.showAndWait();
//        Platform.exit();
//        System.exit(0);
    }
}

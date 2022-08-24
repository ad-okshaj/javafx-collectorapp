package sample;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputControl;
import javafx.scene.layout.AnchorPane;
import java.io.Writer;
//import java.util.logging.Level;
//import java.util.logging.Logger;

import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.*;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;



public class function {
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

    public void addition(ActionEvent event) {
        Parent root;
        String a, b, c, d, e, a1;
        a = t1.getText();
        b = t2.getText();
        c = t3.getText();
        d = t4.getText();
        e = t5.getText();
        /*String a1 = Integer.toString(a);
        String b1 = Integer.toString(b);
        String c1 = Integer.toString(c);*/
        try {
           Writer my1;
           my1 = new BufferedWriter(new FileWriter("INFO.csv", true));
           my1.append(a+","+b+","+c+","+d+","+e+"\n");
           my1.close();
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("popup.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 450, 250);
            Stage stage = new Stage();
            stage.setTitle("Thank You!");
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();

        }
        catch (IOException exec) {
            exec.printStackTrace();
//            Logger logger = Logger.getLogger(getClass().getName());
//            logger.log(Level.SEVERE, "Failed to create new Window.", e);
        }

    }
}

/*
try{FileWriter my1 = new FileWriter("PAN.csv");
            my1.write(a1+","+b1+","+c1);
            my1.close();} */

/*package sample;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import java.io.Writer;

public class function {
    @FXML
    public TextField t1;
    @FXML
    public TextField t2;
    @FXML
    public TextField t3;


    public void addition(ActionEvent event) {
        int a, b, c;
        a = Integer.parseInt(t1.getText());
        b = Integer.parseInt(t2.getText());
        c = a + b;
        t3.setText(Integer.toString(c));
        System.out.println(a);
        String a1 = Integer.toString(a);
        String b1 = Integer.toString(b);
        String c1 = Integer.toString(c);
        try {
           Writer my1;
           my1 = new BufferedWriter(new FileWriter("PAN.csv", true));
           my1.append(a1+","+b1+","+c1+"\n");
           my1.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}*/
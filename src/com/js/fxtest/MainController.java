package com.js.fxtest;

import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController  implements Initializable {

    @FXML
    AlertController alertController;

    Stage alertStage;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("init...");
    }

    @FXML
    private void handleOpenDialogButton(ActionEvent event){
        System.out.println("open dialog button..");
        try {
            alertStage= new Stage();

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("alertdialog.fxml"));
            //如果这个地方已经定义了，那么在fxml里面就不需要再定义，这样就对了
            alertController = new AlertController();
            alertController.setTablename("haha");
            fxmlLoader.setController(alertController);
            AlertController alertController1 = fxmlLoader.getController();
            alertController.init();
            alertController1.setMainController(this);
            Parent root = fxmlLoader.load();

            //TextField tablenameTextField = (TextField)root.lookup("#tablenameTextField");
            //tablenameTextField.setText("js_action1");

            alertStage.setTitle("Hello World");
            alertStage.setScene(new Scene(root, 300, 275));
            alertStage.show();
        }catch (Exception e){
            e.printStackTrace();
        }
    }


}

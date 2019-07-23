package com.js.fxtest;

import com.js.code.Controller;
import com.js.common.validator.Validate;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang.math.RandomUtils;


import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;

public class ValidateController implements Initializable {

    Controller controller;

    @FXML
    TextField textField;
    @FXML
    TextArea textArea;

    @FXML
    TextField minLen;
    @FXML
    TextField maxLen;

    @FXML
    TextField len;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("init...");
        len.setText(Integer.toString(6));
        minLen.setText(Integer.toString(6));
        maxLen.setText(Integer.toString(20));
    }


    @FXML
    private void validateEmail(){
        String email = textField.getText().trim();
        boolean result =Validate.isEmail(email);
        textArea.setText(Boolean.toString(result));
        controller.sqlTextArea.setText("haha");
    }

    @FXML
    private void validateLen(){
        String str = textField.getText().trim();
        int l = Integer.parseInt(len.getText().trim());
        boolean result =Validate.isLen(str,l);
        textArea.setText(Boolean.toString(result));
        controller.sqlTextArea.setText("haha");

    }

    @FXML
    private void validatePhone(){
        String email = textField.getText().trim();
        boolean result =Validate.isEmail(email);
        textArea.setText(Boolean.toString(result));
        controller.sqlTextArea.setText("haha");
    }

    @FXML
    private void validateInteger(){
        String email = textField.getText().trim();
        boolean result =Validate.isEmail(email);
        textArea.setText(Boolean.toString(result));
        controller.sqlTextArea.setText("haha");
    }

    @FXML
    private void validateDecimal(){
        String email = textField.getText().trim();
        boolean result =Validate.isEmail(email);
        textArea.setText(Boolean.toString(result));
        controller.sqlTextArea.setText("haha");
    }


    @FXML
    private void validateName(){
        String email = textField.getText().trim();
        boolean result =Validate.isEmail(email);
        textArea.setText(Boolean.toString(result));
        controller.sqlTextArea.setText("haha");
    }

    @FXML
    private void validateNotNull(){
        String email = textField.getText().trim();
        boolean result =Validate.isEmail(email);
        textArea.setText(Boolean.toString(result));
        controller.sqlTextArea.setText("haha");
    }

    @FXML
    private void createRandom(){
        int l = Integer.parseInt(len.getText().trim());
        String random = RandomStringUtils.randomAlphanumeric(l);
        textField.setText(random);
    }

    public Controller getController() {
        return controller;
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }
}

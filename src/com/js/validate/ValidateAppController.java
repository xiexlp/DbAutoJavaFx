package com.js.validate;

import com.js.code.Controller;
import com.js.common.validator.Validate;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import org.apache.commons.lang.RandomStringUtils;

import java.net.URL;
import java.util.ResourceBundle;

public class ValidateAppController implements Initializable {

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
        //controller.sqlTextArea.setText("haha");
    }

    @FXML
    private void validatePhone(){
        String email = textField.getText().trim();
        boolean result =Validate.isEmail(email);
        textArea.setText(Boolean.toString(result));
        //controller.sqlTextArea.setText("haha");
    }

    @FXML
    private void validateInteger(){
        String email = textField.getText().trim();
        boolean result =Validate.isNumber(email);
        showResult(result);
    }

    @FXML
    private void validateDecimal(){
        String email = textField.getText().trim();
        boolean result =Validate.isFloat(email);
        showResult(result);
    }


    @FXML
    private void validateName(){
        String str = textField.getText().trim();
        boolean result =Validate.isName(str);
        textArea.setText(Boolean.toString(result));
    }

    @FXML
    private void validateMinLen(){
        String str = textField.getText().trim();
        int min= Integer.parseInt(minLen.getText().trim());
        boolean result =Validate.isMinLen(str,min);
        showResult(result);
    }

    @FXML
    private void validateMaxLen(){
        String str = textField.getText().trim();
        int max = Integer.parseInt(maxLen.getText().trim());
        boolean result = Validate.isMaxLen(str,max);
        showResult(result);
    }

    @FXML
    private void validateLen(){
        String str = textField.getText().trim();
        int l = Integer.parseInt(len.getText().trim());
        boolean result =Validate.isLen(str,l);
        showResult(result);
    }


    @FXML
    private void validateNotNull(){
        String str = textField.getText().trim();
        boolean r = Validate.isNotNull(str);
        showResult(r);
    }

    private void showResult(boolean r){
        textArea.setText(Boolean.toString(r));
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

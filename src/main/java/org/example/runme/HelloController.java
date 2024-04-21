package org.example.runme;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class HelloController {
    @FXML
    private Label display;

    private String currentInput = "";
    private double result = 0;
    private char lastOperator = '=';

    @FXML
    protected void appendNumber(javafx.event.ActionEvent event) {
        Button btn = (Button) event.getSource();
        currentInput += btn.getText(); // Use getText() instead of getUserData()
        display.setText(currentInput);
    }

    @FXML
    protected void appendOperator(javafx.event.ActionEvent event) {
        Button btn = (Button) event.getSource();
        char operator = btn.getText().charAt(0); // Use getText() instead of getUserData()
        calculate();
        lastOperator = operator;
    }

    @FXML
    protected void calculate() {
        if (!currentInput.isEmpty()) {
            double number = Double.parseDouble(currentInput);
            switch (lastOperator) {
                case '+':
                    result += number;
                    break;
                case '-':
                    result -= number;
                    break;
                case '*':
                    result *= number;
                    break;
                case '/':
                    result /= number;
                    break;
                case '=':
                    result = number;
                    break;
            }
            display.setText(String.valueOf(result));
            currentInput = "";
        }
    }

    @FXML
    protected void clear() {
        display.setText("");
        currentInput = "";
        result = 0;
        lastOperator = '=';
    }
}
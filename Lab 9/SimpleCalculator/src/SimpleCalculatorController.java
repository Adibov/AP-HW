import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import javax.script.ScriptException;

/**
 * Controller class, handles calculator interactions
 * @author Adibov with special thanks to scene builder
 * @version 1.0
 */
public class SimpleCalculatorController {
    @FXML
    private Button button1, button2, button3, button4, button5, button6, button7, button8, button9, button0;
    @FXML
    private Button buttonAC, buttonC;
    @FXML
    private Button plusButton, minusButton, divideButton, multiplicationButton, sinButton, cosButton, equalButton;
    @FXML
    private TextField resultBox;
    @FXML
    private Label wrongLabel;

    /**
     * append 0 at the end of the current expression
     * @param event
     */
    @FXML
    void press0(ActionEvent event) {
        resultBox.appendText("0");
    }

    /**
     * append 1 at the end of the current expression
     * @param event
     */
    @FXML
    void press1(ActionEvent event) {
        resultBox.appendText("1");
    }

    /**
     * append 2 at the end of the current expression
     * @param event
     */
    @FXML
    void press2(ActionEvent event) {
        resultBox.appendText("2");
    }

    /**
     * append 3 at the end of the current expression
     * @param event
     */
    @FXML
    void press3(ActionEvent event) {
        resultBox.appendText("3");
    }

    /**
     * append 4 at the end of the current expression
     * @param event
     */
    @FXML
    void press4(ActionEvent event) {
        resultBox.appendText("4");
    }

    /**
     * append 5 at the end of the current expression
     * @param event
     */
    @FXML
    void press5(ActionEvent event) {
        resultBox.appendText("5");
    }

    /**
     * append 6 at the end of the current expression
     * @param event
     */
    @FXML
    void press6(ActionEvent event) {
        resultBox.appendText("6");
    }

    /**
     * append 7 at the end of the current expression
     * @param event
     */
    @FXML
    void press7(ActionEvent event) {
        resultBox.appendText("7");
    }

    /**
     * append 8 at the end of the current expression
     * @param event
     */
    @FXML
    void press8(ActionEvent event) {
        resultBox.appendText("8");
    }

    /**
     * append 9 at the end of the current expression
     * @param event
     */
    @FXML
    void press9(ActionEvent event) {
        resultBox.appendText("9");
    }

    /**
     * clear current expression
     * @param event
     */
    @FXML
    void pressAC(ActionEvent event) {
        resultBox.clear();
    }

    /**
     * delete the last character of the current expression if possible
     * @param event
     */
    @FXML
    void pressC(ActionEvent event) {
        String text = resultBox.getText();
        if (text.length() == 0)
            return;
        if (text.charAt(text.length() - 1) == ' ')
            text = text.substring(0, text.length() - 3);
        else
            text = text.substring(0, text.length() - 1);
        resultBox.setText(text);
    }

    /**
     * append '+' operation at the end of the current expression
     * @param event
     */
    @FXML
    void pressAddButton(ActionEvent event) {
//        String text = resultBox.getText();
//        if (text == null || text.length() == 0 || !TokenHandler.isOperator(text.charAt(text.length() - 1)))
//            return;
        resultBox.appendText(" + ");
    }

    /**
     * append '÷' operation at the end of the current expression
     * @param event
     */
    @FXML
    void pressDivideButton(ActionEvent event) {
        resultBox.appendText(" ÷ ");
    }

    /**
     * append '-' operation at the end of the current expression
     * @param event
     */
    @FXML
    void pressMinusButton(ActionEvent event) {
        resultBox.appendText(" - ");
    }

    /**
     * append 'x' operation at the end of the current expression
     * @param event
     */
    @FXML
    void pressMultiplicationButton(ActionEvent event) {
        resultBox.appendText(" x ");
    }

    /**
     * calculate cosine of the current expression
     * @param event
     */
    @FXML
    void calculateCos(ActionEvent event) {
        wrongLabel.setVisible(false);
        String expression = resultBox.getText();
        try {
            double result = TokenHandler.calculateExpression(expression);
            result *= Math.PI / 180.0;
            result = Math.cos(result);
            resultBox.setText(Double.toString(result));
        }
        catch (ScriptException e) {
            wrongLabel.setVisible(true);
        }
    }

    /**
     * calculate sine of the current expression
     * @param event
     */
    @FXML
    void calculateSin(ActionEvent event) {
        wrongLabel.setVisible(false);
        String expression = resultBox.getText();
        try {
            double result = TokenHandler.calculateExpression(expression);
            result *= Math.PI / 180.0;
            result = Math.sin(result);
            resultBox.setText(Double.toString(result));
        }
        catch (ScriptException e) {
            wrongLabel.setVisible(true);
        }
    }

    /**
     * calculate current expression and show result
     * @param event
     */
    @FXML
    void calculateResult(ActionEvent event) {
        wrongLabel.setVisible(false);
        String expression = resultBox.getText();
        try {
            int result = TokenHandler.calculateExpression(expression);
            resultBox.setText(Integer.toString(result));
        }
        catch (ScriptException e) {
            wrongLabel.setVisible(true);
        }
    }

    /**
     * initial controller before starting
     */
    public void initialize() {

    }
}

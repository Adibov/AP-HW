import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.util.ArrayList;

/**
 * TokenHandler class, handles token parsing
 * @author Adibov
 * @version 1.0
 */
public class TokenHandler {
    /**
     * check if the given character is an operator or not
     * @param c give character
     * @return true, if the given character is an operator
     */
    public static boolean isOperator(char c) {
        return c == '-' || c == '+' || c == '*' || c == '/';
    }

    /**
     * check if the given expression is valid
     * @param expression given expression
     * @return boolean result
     */
    public static boolean isExpression(String expression) {
        if (expression.length() == 0 || isOperator(expression.charAt(0)) || isOperator(expression.charAt(expression.length() - 1)))
            return false;
        for (int i = 1; i < expression.length(); i++)
            if (isOperator(expression.charAt(i)) && isOperator(expression.charAt(i - 1)))
                return false;
        return true;
    }

    /**
     * calculate the given expression's result
     * @param expression given expression
     * @return result value
     */
    public static int calculateExpression(String expression) throws ScriptException {
        expression = expression.replace("÷", "/");
        expression = expression.replace("x", "*");
        expression = expression.replace(" ", "");
        StringBuilder tmp = new StringBuilder();
        for (int i = 0; i < expression.length(); i++) // delete decimal points
            if (expression.charAt(i) == '.') {
                while (i < expression.length() && !isOperator(expression.charAt(i)))
                    i++;
                i--;
            }
            else
                tmp.append(expression.charAt(i));
        expression = tmp.substring(0, tmp.length());
        if (!isExpression(expression))
            throw new ScriptException("Invalid expression");

        double result = 0;
        char lastOuterOperator = 'n';
        int index = 0;
        while (index < expression.length()) {
            double number = 0;
            char lastInnerOperator = 'n';
            while (index < expression.length()) {
                int lastNumber = 0;
                while (index < expression.length() && !isOperator(expression.charAt(index))) {
                    String tmpString = "" + expression.charAt(index);
                    lastNumber = 10 * lastNumber + Integer.parseInt(tmpString);
                    index++;
                }
                if (lastInnerOperator == '*')
                    number *= lastNumber;
                else if (lastInnerOperator == '/')
                    number /= lastNumber;
                else
                    number = lastNumber;

                if (index < expression.length()) {
                    lastInnerOperator = expression.charAt(index);
                    if (lastInnerOperator == '+' || lastInnerOperator == '-')
                        break;
                    index++;
                }
            }

            if (lastOuterOperator == '+')
                result += number;
            else if (lastOuterOperator == '-')
                result -= number;
            else
                result = number;

            if (index < expression.length()) {
                lastOuterOperator = expression.charAt(index);
                index++;
            }
        }
        return (int) result;
    }
}

package by.bsu.calculator.exception;

/**
 * Created by Nastassia_Dubovik on 08-Sep-16.
 */
public class CalculatorException extends Exception {

    public CalculatorException(){}
    public CalculatorException(String message, Throwable exception) {
        super(message, exception);
    }
    public CalculatorException(String message) {
        super(message);
    }
    public CalculatorException(Throwable exception) {
        super(exception);
    }
}

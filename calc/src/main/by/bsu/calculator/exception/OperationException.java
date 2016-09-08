package by.bsu.calculator.exception;

/**
 * Created by Nastassia_Dubovik on 08-Sep-16.
 */
public class OperationException extends Exception {

    public OperationException(){}
    public OperationException(String message, Throwable exception) {
        super(message, exception);
    }
    public OperationException(String message) {
        super(message);
    }
    public OperationException(Throwable exception) {
        super(exception);
    }
}

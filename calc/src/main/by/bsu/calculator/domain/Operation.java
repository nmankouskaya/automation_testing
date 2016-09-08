package by.bsu.calculator.domain;

import by.bsu.calculator.exception.OperationException;

/**
 * Created by Nastassia_Dubovik on 08-Sep-16.
 */
public enum Operation {
    PLUS("+"), MINUS("-"), MULTIPLICATION("*"), DIVISION("/");

    private String representation;

    Operation(String representation){
        this.representation = representation;
    }

    public String getRepresentation() {
        return representation;
    }

    /**
     * Method returns Operation object depends on its representation
     * @param representation
     * @return operation object
     * @throws OperationException
     */
    public static Operation getOperation(String representation) throws OperationException{
        switch(representation){
            case "+":
                return PLUS;
            case "-":
                return MINUS;
            case "*":
                return MULTIPLICATION;
            case "/":
                return DIVISION;
            default:
                throw new OperationException("No such operation");
        }
    };
}

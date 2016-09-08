package by.bsu.calculator.logic;

import by.bsu.calculator.domain.Operation;
import by.bsu.calculator.exception.OperationException;

/**
 * Created by Nastassia_Dubovik on 08-Sep-16.
 */
public class OperationUtil {

    /**
     * Method gets string with sign and white spaces , trims it and creates Operation object
     * @param operation_sign
     * @return Operation object
     * @throws OperationException
     * @see by.bsu.calculator.domain.Operation
     */
    public static Operation createOperation(String operation_sign) throws OperationException {
        String operation_sign_trim = operation_sign.trim();
        Operation operation = Operation.getOperation(operation_sign_trim);
        return operation;
    }
}

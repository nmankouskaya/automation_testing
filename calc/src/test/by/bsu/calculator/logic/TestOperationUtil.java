package by.bsu.calculator.logic;

import by.bsu.calculator.domain.Operation;
import by.bsu.calculator.exception.OperationException;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by Nastassia_Dubovik on 08-Sep-16.
 */
public class TestOperationUtil {

    @Test
    public void testOperationCreation() throws Exception {
        String representation = "   *\n";
        Operation operation = OperationUtil.createOperation(representation);
        Operation operation_expect =  Operation.MULTIPLICATION;
        boolean equals = operation.equals(operation_expect);
        assertTrue(equals);
    }

    @Test(expected = OperationException.class)
    public void testWrongOperationCreation() throws Exception {
        String representation = "   *o";
        Operation operation = OperationUtil.createOperation(representation);
        Operation operation_expect =  Operation.MULTIPLICATION;
        boolean equals = operation.equals(operation_expect);
        assertTrue(equals);
    }

}

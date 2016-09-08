package by.bsu.calculator.logic;

import by.bsu.calculator.domain.Operation;
import by.bsu.calculator.exception.CalculatorException;
import by.bsu.calculator.logic.impl.Calculator;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by Nastassia_Dubovik on 08-Sep-16.
 */
public class TestCalculator {

    private ICalculator calculator = new Calculator();

    @Test
    public void testSumWithValidArgs() throws Exception {
        double first_arg = 12 , second_arg = 6, result_expect = 18;
        double result = calculator.execute(first_arg, second_arg, Operation.PLUS);
        boolean equals = ( result == result_expect ) ? true : false;
        assertTrue(equals);
    }

    @Test
    public void testSubtractionWithValidArgs() throws Exception {
        double first_arg = 12 , second_arg = 6, result_expect = 6;
        double result = calculator.execute(first_arg, second_arg, Operation.MINUS);
        boolean equals = ( result == result_expect ) ? true : false;
        assertTrue(equals);
    }

    @Test
    public void testMultiplicationWithValidArgs() throws Exception {
        double first_arg = 12 , second_arg = 6, result_expect = 72;
        double result = calculator.execute(first_arg, second_arg, Operation.MULTIPLICATION);
        boolean equals = ( result == result_expect ) ? true : false;
        assertTrue(equals);
    }

    @Test
    public void testDivisionWithValidArgs() throws Exception {
        double first_arg = 12 , second_arg = 6, result_expect = 2;
        double result = calculator.execute(first_arg, second_arg, Operation.DIVISION);
        boolean equals = ( result == result_expect ) ? true : false;
        assertTrue(equals);
    }

    @Test(expected = CalculatorException.class)
    public void testDivisionByZero() throws Exception {
        double first_arg = 12 , second_arg = 0;
        calculator.execute(first_arg, second_arg, Operation.DIVISION);
    }

}

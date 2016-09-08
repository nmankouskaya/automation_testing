package by.bsu.calculator.domain;

import by.bsu.calculator.exception.CalculatorException;

/**
 * Created by Nastassia_Dubovik on 08-Sep-16.
 */
public interface ICalculator {
    double execute(double first_arg, double second_arg, Operation operation) throws CalculatorException;
}

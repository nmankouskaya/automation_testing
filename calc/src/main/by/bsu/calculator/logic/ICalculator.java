package by.bsu.calculator.logic;

import by.bsu.calculator.domain.Operation;
import by.bsu.calculator.exception.CalculatorException;

/**
 * Interface for calculator that works with 2 arguments
 * Created by Nastassia_Dubovik on 08-Sep-16.
 * @see by.bsu.calculator.logic.impl.Calculator realization
 */

public interface ICalculator {
    double execute(double first_arg, double second_arg, Operation operation) throws CalculatorException;
}

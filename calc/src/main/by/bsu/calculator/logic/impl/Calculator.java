package by.bsu.calculator.logic.impl;

import by.bsu.calculator.logic.ICalculator;
import by.bsu.calculator.domain.Operation;
import by.bsu.calculator.exception.CalculatorException;

/**
 * Created by Nastassia_Dubovik on 08-Sep-16.
 */
public class Calculator implements ICalculator {

    /**
     * Method gets 2 args and operation. Depends on operation it call method that returns result of operation.
     * @param first_arg
     * @param second_arg
     * @param operation
     * @return result of operation
     * @throws CalculatorException
     */
    @Override
    public double execute(double first_arg, double second_arg, Operation operation) throws CalculatorException {
        double result;
        switch(operation){
            case PLUS:
                result = sum(first_arg, second_arg);
                break;
            case MINUS:
                result = subtraction(first_arg, second_arg);
                break;
            case MULTIPLICATION:
                result = multiplication(first_arg, second_arg);
                break;
            case DIVISION:
                result = division(first_arg, second_arg);
                break;
            default:
                throw new CalculatorException("I don't know how to do it");
        }
        return result;
    }

    /**
     *
     * @param first_arg
     * @param second_arg
     * @return sum of this 2 args
     */
    private double sum(double first_arg, double second_arg){
        return first_arg + second_arg;
    }

    /**
     *
     * @param first_arg
     * @param second_arg
     * @return difference of this 2 args
     */
    private double subtraction(double first_arg, double second_arg){
        return first_arg - second_arg;
    }

    /**
     *
     * @param first_arg
     * @param second_arg
     * @return quotient of this 2 args
     * @throws CalculatorException
     */
    private double division(double first_arg, double second_arg) throws CalculatorException {
        if(second_arg != 0){
            return first_arg / second_arg;
        } else {
            throw new CalculatorException("Division by 0");
        }

    }

    /**
     *
     * @param first_arg
     * @param second_arg
     * @return product of this 2 args
     */
    private double multiplication(double first_arg, double second_arg){
        return first_arg * second_arg;
    }


}

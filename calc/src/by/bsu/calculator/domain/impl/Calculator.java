package by.bsu.calculator.domain.impl;

import by.bsu.calculator.domain.ICalculator;
import by.bsu.calculator.domain.Operation;
import by.bsu.calculator.exception.CalculatorException;

/**
 * Created by Nastassia_Dubovik on 08-Sep-16.
 */
public class Calculator implements ICalculator {
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


    private double sum(double first_arg, double second_arg){
        return first_arg + second_arg;
    }


    private double subtraction(double first_arg, double second_arg){
        return first_arg - second_arg;
    }


    private double division(double first_arg, double second_arg) throws CalculatorException {
        if(second_arg != 0){
            return first_arg / second_arg;
        } else {
            throw new CalculatorException("Division by 0");
        }

    }


    private double multiplication(double first_arg, double second_arg){
        return first_arg * second_arg;
    }


}

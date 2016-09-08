package by.bsu.calculator;

import by.bsu.calculator.logic.ICalculator;
import by.bsu.calculator.domain.Operation;
import by.bsu.calculator.logic.OperationUtil;
import by.bsu.calculator.logic.impl.Calculator;
import by.bsu.calculator.exception.CalculatorException;
import by.bsu.calculator.exception.OperationException;

import java.util.Scanner;

/**
 * Created by Nastassia_Dubovik on 08-Sep-16.
 */
public class Main {

    public static void main(String[] args) {

        ICalculator calculator = new Calculator();

        double first_arg, second_arg;

        String operation_sign;

        Scanner in = new Scanner(System.in);

        try {
            System.out.println("Enter first argument: ");
            first_arg = in.nextDouble();
            System.out.println("Enter operation: ");
            operation_sign = in.next();
            System.out.println("Enter second argument: ");
            second_arg = in.nextDouble();

            Operation operation = OperationUtil.createOperation(operation_sign);
            System.out.println(calculator.execute(first_arg, second_arg, operation));

        } catch (OperationException e) {
            e.printStackTrace();
        } catch (CalculatorException e) {
            e.printStackTrace();
        }
    }
}

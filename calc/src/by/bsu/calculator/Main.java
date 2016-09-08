package by.bsu.calculator;

import by.bsu.calculator.domain.ICalculator;
import by.bsu.calculator.domain.Operation;
import by.bsu.calculator.domain.impl.Calculator;
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
            System.out.println("Enter sign: ");
            operation_sign = in.next();
            System.out.println("Enter second argument: ");
            second_arg = in.nextDouble();

            Operation operation = createOperation(operation_sign);
            System.out.println(calculator.execute(first_arg, second_arg, operation));

        } catch (OperationException e) {
            e.printStackTrace();
        } catch (CalculatorException e) {
            e.printStackTrace();
        }
    }

    public static Operation createOperation(String operation_sign) throws OperationException {
        operation_sign.trim();
        Operation operation = Operation.getOperation(operation_sign);
        return operation;
    }
}

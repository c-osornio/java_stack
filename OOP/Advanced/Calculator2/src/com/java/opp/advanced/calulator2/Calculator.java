package com.java.opp.advanced.calulator2;
import java.util.ArrayList;

public class Calculator {
    // ensure the entered string is a number
    boolean numCheck(String num){
        try{
            Double.parseDouble(num);
            return true;
        }catch(NumberFormatException e){
            System.out.println("Invalid number");
            return false;
        }
    }

    // verify the operator
    boolean operatorCheck(Character op){
        return op == '+' || op == '-' || op == '*' || op == '/';
    }

    // perform the calculation
    Double calculate(Double num1, char operator, Double num2){
        switch (operator){
            case '+':
                return num1 + num2;
            case '-':
                return num1 - num2;
            case '*':
                return num1 * num2;
            default:
                return num1 / num2;
        }
    }

    // handle multiplication and division before addition and subtraction
    Double orderOperations(ArrayList<Double> numbers, ArrayList<Character> operators){
        Double output = 0.0;
        // the first while loop will take care of all multiplication and division
        while(operators.contains('*')||operators.contains('/')){
            for(int i=0; i<operators.size(); i++){
                if(operators.get(i)=='*'||operators.get(i)=='/'){
                    numbers.set(i, calculate(numbers.get(i), operators.get(i), numbers.get(i+1)));
                    numbers.remove(i+1);
                    operators.remove(i);
                }
            }
        }
        // the second while loop adds/subtracts all remaining numbers in order
        while(operators.contains('+')||operators.contains('-')){
            numbers.set(0, calculate(numbers.get(0), operators.get(0), numbers.get(1)));
            numbers.remove(1);
            operators.remove(0);
        }
        // we use output for clarity, you can also return 'numbers.get(0)'
        output = numbers.get(0);
        return output;
    }
}
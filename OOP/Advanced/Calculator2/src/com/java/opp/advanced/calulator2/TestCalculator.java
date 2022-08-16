package com.java.opp.advanced.calulator2;
import java.util.Scanner;
import java.util.ArrayList;

public class TestCalculator {
    
    public static void main(String[] args){
        // instantiate our calculator
        Calculator calculator = new Calculator();
        Scanner reader = new Scanner(System.in);
        // all valid numbers will be saved to the numbers ArrayList
        ArrayList<Double> numbers = new ArrayList<>();
        // all valid operators will be saved to the operators ArrayList (including the equals sign)
        ArrayList<Character> operators = new ArrayList<>();
        // we use this flag to control our application flow
        boolean isNumber = true;

        // this while loop will run until there is an equals sign
        while (true){
            // if 'isNumber' is true, we get a number from the user
            if(isNumber){
                System.out.println("Enter a number: ");
                String num = reader.nextLine();
                // the number is added to our ArrayList if it passes the number check
                if(calculator.numCheck(num)){
                    numbers.add(Double.parseDouble(num));
                    isNumber = false;
                }else{
                    System.out.println("Invalid Number");
                }
            // if 'isNumber' is false, we get an operator from the user
            }else{
                System.out.println("Enter an operator: ");
                String op = reader.nextLine();
                if(op.length()==0){op=" ";} // ensure the first character in op exists
                // if the operator is valid, we add it to our operators ArrayList
                if(op.charAt(0)=='+'||op.charAt(0)=='-'||op.charAt(0)=='*'||op.charAt(0)=='/'||op.charAt(0)=='='){
                    operators.add(op.charAt(0));
                    if(op.charAt(0)=='='){
                        System.out.println(calculator.orderOperations(numbers, operators));
                        break;
                    }
                    isNumber = true;
                }else{
                    System.out.println("Invalid Operator");
                }
            }
        }
        // we close our Scanner to prevent memory leaks
        reader.close();
    }

}
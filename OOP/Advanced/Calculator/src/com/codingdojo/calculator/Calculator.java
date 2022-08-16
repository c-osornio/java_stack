package com.codingdojo.calculator;

public class Calculator {
	private double operandOne;
	private double operandTwo;
	private char operation;
	private double results;
	
	public Calculator() {}
	
	public void performOperation() {
		if(this.operation == ("+").charAt(0)) {
			setResults(operandOne + operandTwo);
		}
		if (this.operation == ("-").charAt(0)) {
			setResults(operandOne - operandTwo);
		}
	}

	public double getOperandOne() {
		return operandOne;
	}

	public void setOperandOne(double operandOne) {
		this.operandOne = operandOne;
	}

	public double getOperandTwo() {
		return operandTwo;
	}

	public void setOperandTwo(double operandTwo) {
		this.operandTwo = operandTwo;
	}

	public char getOperation() {
		return operation;
	}

	public void setOperation(char operator) {
		this.operation = operator;
	}

	public double getResults() {
		System.out.println(results);
		return results;
	}

	public void setResults(double results) {
		this.results = results;
	}
}

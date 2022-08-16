package com.codingdojo.calculator;

public class TestCalculator {

	public static void main(String[] args) {
		Calculator c = new Calculator();
		c.setOperandOne(10.5);
		c.setOperation(("+").charAt(0));
		c.setOperandTwo(5.2);
		c.performOperation();
		c.getResults();
	}
}

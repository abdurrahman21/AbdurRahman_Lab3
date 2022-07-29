package com.greatLearning.balancingBrackets;

import java.util.Stack;

public class BalancingBracket {

	static boolean isBracketsBalanced(String expr) {

		Stack<Character> stack = new Stack<Character>();

		for (int i = 0; i < expr.length(); i++) {
			char x = expr.charAt(i);

			if (x == '(' || x == '[' || x == '{') {
				stack.push(x);
				continue;
			}
			System.out.println("Stack ::" + stack);
			if (stack.isEmpty()) {
				return false;
			}
			char check;
			switch (x) {
			case ')':
				check = stack.pop();
				System.out.println("check :: )" + check);
				if (check == '{' || check == '[') {
					return false;
				}
				break;

			case '}':
				check = stack.pop();
				System.out.println("check :: }" + check);
				if (check == '(' || check == '[') {
					return false;
				}
				break;

			case ']':
				check = stack.pop();
				System.out.println("check :: ]" + check);
				if (check == '(' || check == '{') {
					return false;
				}
				break;
			}
		}

		return (stack.isEmpty());
	}

	public static void main(String[] args) {
		String expr = "([[{}]])";

		if (isBracketsBalanced(expr)) {
			System.out.println("The entered String has Balanced Brackets");
		} else {
			System.out.println("The entered String do not contain Balanced Brackets");
		}
	}

}

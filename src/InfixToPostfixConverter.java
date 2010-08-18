import java.util.Stack;

public class InfixToPostfixConverter {

	Stack<String> pilha = new Stack<String>();
	int pointer = 1;

	public String converterToPostFix(String infix) {
		infix += ")";
		String[] ex = infix.split("");
		pilha.push("(");
		String postfix = "";
		while (!pilha.empty()) {
			if ((isADigit(ex[pointer])) && (!ex[pointer].equals(")"))
					&& (!ex[pointer].equals("(")))
				postfix += ex[pointer];
			if (ex[pointer].equals("("))
				pilha.push(ex[pointer]);
			if (isOperator(ex[pointer])) {
				if (isOperator(pilha.peek())) {
					while (precedence(pilha.peek(), ex[pointer])) {
						postfix += pilha.pop();
					}
				}
				pilha.push(ex[pointer]);
			}
			if (ex[pointer].equals(")")) {
				postfix = removeFromStackUntilFindRightParenthesis(postfix);
			}
			pointer++;
		}
		return postfix;
	}

	private String removeFromStackUntilFindRightParenthesis(String postfix) {
		while (!pilha.peek().equals("(")) {
			postfix += pilha.pop();
		}
		pilha.pop();
		return postfix;
	}

	public static boolean isADigit(String digit) {
		String[] symbols = { "+", "-", "*", "/", "^" };
		boolean isSymbol = true;
		for (String symbol : symbols) {
			if (digit.equals(symbol))
				isSymbol = false;
		}
		return isSymbol;
	}

	private boolean isOperator(String ch) {
		if ((ch.equals("+")) || (ch.equals("-")) || (ch.equals("*"))
				|| (ch.equals("/")) || (ch.equals("^"))) {
			return true;
		} else
			return false;
	}

	public static boolean precedence(String top, String ex) {
		if (top.equals(ex))
			return true;
		else if (((top.equals("*")) || (top.equals("/"))) && (ex.equals("+"))
				|| (ex.equals("-"))) {
			return true;
		} else {
			return false;
		}
	}

}

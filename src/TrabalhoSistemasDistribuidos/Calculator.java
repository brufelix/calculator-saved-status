package Questao03;

public class Calculator {
	public String calculator(String operator, double fastValue, double lastValue) {
		if (operator.equals("+")) {
			double result = fastValue + lastValue;
			return String.valueOf(result);
		} else if (operator.equals("*")) {
			double result = fastValue * lastValue;
			return String.valueOf(result);
		} else if (operator.equals("-")) {
			double result = fastValue - fastValue;
			return String.valueOf(result);
		} else if (operator.equals("/")) {
			if (lastValue != 0) {
				double result = fastValue / lastValue;
				return String.valueOf(result);
			}else {
				return "Não é possivel dividir por zero!";
			}
		}
		return "Erro";
	}
}

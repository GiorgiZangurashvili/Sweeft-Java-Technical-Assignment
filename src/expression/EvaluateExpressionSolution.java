package expression;

public class EvaluateExpressionSolution {

    public static void main(String[] args) {
        var solution = new EvaluateExpressionSolution();
        System.out.println(solution.evaluateExpression("5+20-8+5") == 22);
        System.out.println(solution.evaluateExpression("") == 0);
        System.out.println(solution.evaluateExpression("-12 + 3 + 27-4") == 14);
    }

    private int evaluateExpression(String expression) {
        int result = 0;
        int currentNumber = 0;
        int sign = 1;

        for (char ch : expression.toCharArray()) {
            if (Character.isDigit(ch)) {
                currentNumber *= 10;
                currentNumber += (ch - '0');
            } else {
                result += sign * currentNumber;
                currentNumber = 0;

                if (ch == '+') {
                    sign = 1;
                } else if (ch == '-') {
                    sign = -1;
                }
            }
        }

        result += sign * currentNumber;

        return result;
    }

}

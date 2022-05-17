package klarna;

import java.math.BigDecimal;
import java.util.Stack;

public class Calc {

    private static final String ZERO = "0.0";
    private static final String Add_OPERATOR = "+";
    private static final String SUBSTRACT_OPERATOR = "-";
    private static final String MULTIPLY_OPERATOR = "*";
    private static final String DIVIDE_OPERATOR = "/";

    public double evaluate(String expr) {

        // Empty expression
        if(expr.isEmpty()) return 0.0;

        String[] inputArr = expr.split(" ");
        Stack<BigDecimal> stack = new Stack<>();

        for(String str : inputArr) {
            if (isNumbric(str)) {
                stack.push(new BigDecimal(str));
                continue;
            }

            if (stack.isEmpty())
                throw new IllegalArgumentException("Invalid input expression : "+ expr);
            BigDecimal secondOperand = stack.pop();

            if (stack.isEmpty())
                throw new IllegalArgumentException("Invalid input expression : "+ expr);
            BigDecimal firstOperand = stack.pop();

            BigDecimal evaluatedValue = evaluate(firstOperand, secondOperand, str);
            stack.push(evaluatedValue);
        }

        return stack.pop().doubleValue();
    }

    private BigDecimal evaluate(BigDecimal firstOperand, BigDecimal secondOperand, String str) {

        BigDecimal result = null;
        switch(str){
            case Add_OPERATOR :
                result =  firstOperand.add(secondOperand);
                break;
            case SUBSTRACT_OPERATOR :
                result =  firstOperand.subtract(secondOperand);
                break;
            case MULTIPLY_OPERATOR :
                result =  firstOperand.multiply(secondOperand);
                break;
            case DIVIDE_OPERATOR :
                result =  firstOperand.divide(secondOperand);
                break;
            default :
                result = new BigDecimal(ZERO);
        }

        // Rounding till 5 decimal places
        return result.setScale(5, BigDecimal.ROUND_HALF_UP);
    }

    private boolean isNumbric(String str) {
        try{
            Double.parseDouble(str);
            return true;
        } catch(NumberFormatException e) {
            return false;
        }
    }
}

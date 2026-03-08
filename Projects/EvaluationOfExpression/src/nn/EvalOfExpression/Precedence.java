package nn.EvalOfExpression;

public class Precedence {

    static int inStack(Token token) {
        return switch(token.symb)
        {
            case '(' -> 0;
            case '+' -> 1;
            case '-' -> 1;
            case '*' -> 2;
            case '/' -> 2;
            case '%' -> 2;
            case '^' -> 3;
            default -> -1;
        };
    }

    static int outStack(Token token) {
        return switch(token.symb)
        {
            case '(' -> 5;
            case '+' -> 1;
            case '-' -> 1;
            case '*' -> 2;
            case '/' -> 2;
            case '%' -> 2;
            case '^' -> 4;
            default -> -1;
        };
    }

   
}

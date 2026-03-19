package nn.EvalOfExpression;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class EvaluationOfPostFix {

    public static int evalPost(List<Token> postfix) {
        Deque<Token> s = new ArrayDeque<>();

        for (Token e : postfix) {
            if (e.type == TokenType.Operand)
                s.push(e);
            else {
                int y = s.pop().value;
                int x = s.pop().value;

                char p = e.symb;

                int r = switch (p) {
                    case '+' -> x + y;
                    case '-' -> x - y;
                    case '*' -> x * y;
                    case '/' -> x / y;
                    case '%' -> x % y;
                    case '^' -> Math.powExact(x, y);
                    default -> 0;
                };

                s.push(new Token(r));
            }
        }

        return s.pop().value;
    }

    public EvaluationOfPostFix() {

        // (15+30) * (10-4) => 45 * 6 => 270
        // 15 30 + 10 4 - *
        List<Token> postfix = List.of(
                new Token(15),
                new Token(30),
                new Token('+'),
                new Token(10),
                new Token(4),
                new Token('-'),
                new Token('*'));
        System.out.println(postfix);
        System.out.println(evalPost(postfix));
    }

    public static void main(String[] args) {
        new EvaluationOfPostFix();
    }
}

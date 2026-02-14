package nn.EvalOfExpression;

import java.util.Stack;

public class EvaluationOfPostFix<T> {

    public T evalPost(String postfixExpression)
    {
        Stack<Character> s = new Stack<>();

        for(char e : postfixExpression.toCharArray())
        {
            if(Character.isDigit(e))
                s.add(e);
            else
            {


            }
        }
    }

    public static void main(String[] args) {
        
    }
}

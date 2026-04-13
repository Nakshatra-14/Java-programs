package nn.EvalOfExpression;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import static nn.EvalOfExpression.Precedence.inStack;

public class InfixToPostfix {
    
    public static List<Token> inToPost(List<Token> infix)
    {
        ArrayList<Token> postfix = new ArrayList<>();
        MyStackI<Token> stack = new MyStackWithLinkedList<>(); 

        for(Token token : infix)
        {
            if(token.type == TokenType.Operand)
            {
                postfix.add(token);
            }
            else if(token.type == TokenType.Cparen)
            {
                while(!stack.isEmpty())
                {
                    Token anotherToken = stack.pop();
                    if(anotherToken.symb == '(')
                        break;
                    else
                        postfix.add(anotherToken);
                }
            }
            else    //operator
            {
                while(!stack.isEmpty() && inStack(stack.peek()) >= Precedence.outStack(token))
                    postfix.add(stack.pop());
                stack.push(token);
            }
        }
        while(!stack.isEmpty())
            postfix.add(stack.pop());
        return postfix;
    }

    public static List<Token> stringToTokens(String str)
    {
        //Infix:    ( 5 + 7 ) * ( 12 - 10 ) 
        ArrayList<Token> al = new ArrayList<>();
        StringTokenizer stk = new StringTokenizer(str, " ", true);
        while(stk.hasMoreTokens())
        {
            String t = stk.nextToken();
            char ch = t.charAt(0);
            if(ch != ' ')
            {
                if(Character.isDigit(ch))
                    al.add(new Token(Integer.parseInt(t)));
                else
                    al.add(new Token(ch));
            }
        }
        return al;
    }

    public static void main(String[] args)
    {
        //Infix:    ( 5 + 7) * (12 - 10) 
        //Postfix:  5 7 + 12 10 - *
        // String strInfix = "( 5 + 7 ) * ( 12 - 10 )";
        String strInfix = "( 1 + 2 ) * ( 3 ^ ( 6 - 3 ) + 6 ) - 180 / 10 / ( 5 + 4 )";
                            // 1.2+ * (3 ^ 6.3- + 6) - 180 / 10 / 5.4+
                            // 1.2+ * (3.6.3-^ + 6) - 180.10/ / 5.4+
                            // 1.2+ * 3.6.3-^6+ - 180.10/.5.4+/
                            // 1.2+.3.6.3-^6+* - 180.10/.5.4+/
                            // 1.2+.3.6.3-^6+*.180.10/.5.4+/-

        // String strInfix = "( 5 + 7 ) * ( 12 - 10 )";
        // ArrayList<Token> infix = new ArrayList<>();
        List<Token> infix = stringToTokens(strInfix);
        // infix.add(new Token('('));
        // infix.add(new Token(5));
        // infix.add(new Token('+'));
        // infix.add(new Token(7));
        // infix.add(new Token(')'));
        // infix.add(new Token('*'));
        // infix.add(new Token('('));
        // infix.add(new Token(12));
        // infix.add(new Token('-'));
        // infix.add(new Token(10));
        // infix.add(new Token(')'));
        
        List<Token> postfix = inToPost(infix);

        System.out.println("Infix:   " + infix);
        System.out.println("Postfix: " + postfix);
        System.out.println("Evaluated:   " + EvaluationOfPostFix.evalPost(postfix));


    }
}

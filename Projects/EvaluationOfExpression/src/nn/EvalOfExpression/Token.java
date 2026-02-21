package nn.EvalOfExpression;

public class Token {
    int value;  //value of operend
    char symb;  //symbol of operator
    TokenType type;

    public Token(char symb) {
        this.symb = symb;
        type = TokenType.Operator;
    }

    public Token(int value) {
        this.value = value;
        type = TokenType.Operand;
    }

    @Override
    public String toString() {
        return type == TokenType.Operand ? String.valueOf(value) : String.valueOf(symb);
    }

}

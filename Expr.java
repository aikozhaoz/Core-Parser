public class Expr {

    public int option = 0;

    public Term term = new Term();
    public Expr expr = new Expr();

    public void parse(Scanner S) {
        // <expr> ::= <term> | <term> + <expr> | <term> – <expr>
        // Regardless of which option we are on.
        // The first tokens is <term>

        // Option 1: <expr> ::= <term>
        option = 1;
        term.parse(S);
        // Option 2: <expr> ::= <term> + <expr>
        if (S.currentToken() == Core.ADD) {
            option = 2;
            S.expectedToken(Core.ADD);
            expr.parse(S);
        }
        // Option 3: <expr> ::= <term> – <expr>
        else if (S.currentToken() == Core.SUB) {
            option = 3;
            S.expectedToken(Core.SUB);
            expr.parse(S);
        }
    }

    public void print(int indent) {
        term.print(indent);
        if (option == 2) {
            System.out.print("+");
            expr.print(indent);
        } else if (option == 3) {
            System.out.print("-");
            expr.print(indent);
        }
    }
}

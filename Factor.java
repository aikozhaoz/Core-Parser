public class Factor {

    public int option = 0;
    public Expr expr = new Expr();

    public void parse(Scanner S) {
        if (S.currentToken() == Core.ID) {
            option = 1;
            S.expectedToken(Core.ID);
        } else if (S.currentToken() == Core.CONST) {
            option = 2;
            S.expectedToken(Core.CONST);
        } else if (S.currentToken() == Core.LPAREN) {
            option = 3;
            S.expectedToken(Core.LPAREN);
            expr.parse(S);
            S.expectedToken(Core.RPAREN);
        }

    }

    public void print() {

    }
}

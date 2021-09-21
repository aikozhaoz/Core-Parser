public class Expr {

    public int option = 0;
    public Term term = new Term();
    public Expr expr = new Expr();

    public void parse(Scanner S) {
        option = 1;
        term.parse(S);
        if (S.currentToken() == Core.ADD) {
            option = 2;
            S.expectedToken(Core.ADD);
            expr.parse(S);
        } else if (S.currentToken() == Core.SUB) {
            option = 3;
            S.expectedToken(Core.SUB);
            expr.parse(S);
        }
    }

    public void print() {

    }
}

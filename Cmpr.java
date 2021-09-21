public class Cmpr {

    public int option = 0;
    public Expr exprone = new Expr();
    public Expr exprtwo = new Expr();

    public void parse(Scanner S) {
        exprone.parse(S);
        if (S.currentToken() == Core.EQUAL) {
            option = 1;
            S.expectedToken(Core.EQUAL);
            exprtwo.parse(S);
        } else if (S.currentToken() == Core.LESS) {
            option = 2;
            S.expectedToken(Core.LESS);
            exprtwo.parse(S);
        } else if (S.currentToken() == Core.LESSEQUAL) {
            option = 3;
            S.expectedToken(Core.LESSEQUAL);
            exprtwo.parse(S);
        }
    }

    public void print() {

    }
}

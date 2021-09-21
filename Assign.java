public class Assign {

    public int option = 0;
    public Expr expr = new Expr();

    public void parse(Scanner S) {
        S.expectedToken(Core.ID);
        S.expectedToken(Core.ASSIGN);
        if (S.currentToken() == Core.NEW) {
            option = 1;
            S.expectedToken(Core.NEW);
            S.expectedToken(Core.SEMICOLON);
        } else if (S.currentToken() == Core.REF) {
            option = 2;
            S.expectedToken(Core.REF);
            S.expectedToken(Core.ID);
            S.expectedToken(Core.SEMICOLON);
        } else if (S.currentToken() == Core.ID || S.currentToken() == Core.CONST || S.currentToken() == Core.LPAREN) {
            option = 3;
            expr.parse(S);
            S.expectedToken(Core.SEMICOLON);
        }
    }

    public void print() {

    }
}

public class Cond {

    public static int option = 0;
    public Cmpr cmpr = new Cmpr();
    public Cond cond = new Cond();

    public void parse(Scanner S) {
        if (S.currentToken() == Core.NEGATION) {
            option = 1;
            S.expectedToken(Core.NEGATION);
            S.expectedToken(Core.LPAREN);
            cond.parse(S);
            S.expectedToken(Core.RPAREN);
        } else if (S.currentToken() == Core.ID || S.currentToken() == Core.CONST || S.currentToken() == Core.LPAREN) {
            option = 2;
            cmpr.parse(S);
            if (S.currentToken() == Core.OR) {
                option = 3;
                S.expectedToken(Core.OR);
                cond.parse(S);
            }
        }
    }

    public void print() {

    }
}

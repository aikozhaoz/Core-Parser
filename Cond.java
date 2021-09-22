public class Cond {

    public static int option = 0;

    public Cmpr cmpr = new Cmpr();
    public Cond cond = new Cond();

    public void parse(Scanner S) {
        if (S.currentToken() == Core.NEGATION) {
            option = 1;
            S.expectedToken(Core.NEGATION);
            if (!S.expectedToken(Core.LPAREN)) {
                Utility.errorhelper(Core.LPAREN, S.currentToken());
                System.exit(-1);
            }
            cond.parse(S);
            if (!S.expectedToken(Core.RPAREN)) {
                Utility.errorhelper(Core.RPAREN, S.currentToken());
                System.exit(-1);
            }
        } else if (S.currentToken() == Core.ID || S.currentToken() == Core.CONST || S.currentToken() == Core.LPAREN) {
            option = 2;
            cmpr.parse(S);
            if (S.currentToken() == Core.OR) {
                option = 3;
                cond.parse(S);
            }
        }else{
            System.out.print("The expections are not met. ");
            Utility.errorhelper(Core.NEGATION, S.currentToken());
            Utility.errorhelper(Core.ID, S.currentToken());
            Utility.errorhelper(Core.CONST, S.currentToken());
            System.exit(-1);
        }
    }

    public void print(int indent) {

    }
}

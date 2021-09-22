public class Cond {

    public static int option = 0;

    public Cmpr cmpr = new Cmpr();
    public Cond cond = new Cond();

    public void parse(Scanner S) {
        // <cond> ::= <cmpr> | ! ( <cond> ) | <cmpr> or <cond>
        // Option 1: <cond> ::= ! ( <cond> )
        if (S.currentToken() == Core.NEGATION) {
            option = 1;
            S.expectedToken(Core.NEGATION);
            if (!S.expectedToken(Core.LPAREN)) {
                Utility.expectedhelper(Core.LPAREN, S.currentToken());
                System.exit(-1);
            }
            cond.parse(S);
            if (!S.expectedToken(Core.RPAREN)) {
                Utility.expectedhelper(Core.RPAREN, S.currentToken());
                System.exit(-1);
            }
        } 
        // Option 2: <cond> ::= <cmpr>
        // <cmpr> ::= <expr> == <expr> | <expr> < <expr> | <expr> <= <expr>
        // <expr> ::= <term> | <term> + <expr> | <term> – <expr> 
        // <term> ::= <factor> | <factor> * <term>
        // <factor> ::= id | const | ( <expr> )
        else if (S.currentToken() == Core.ID || S.currentToken() == Core.CONST || S.currentToken() == Core.LPAREN) {
            option = 2;
            cmpr.parse(S);
            // Option 3: <cmpr> or <cond>
            if (S.currentToken() == Core.OR) {
                option = 3;
                S.expectedToken(Core.OR);
                cond.parse(S);
            }
        }
        // So if the currentToken != "! or id or const or ("", then syntax is invalid.
        else{
            Core[] expectedones = new Core[]{Core.NEGATION, Core.ID, Core.CONST, Core.LPAREN};
            Utility.errorhelper(expectedones, S.currentToken());
            System.exit(-1);
        }
    }

    public void print(int indent) {

    }
}

public class Cmpr {

    public int option = 0;

    public Expr exprone = new Expr();
    public Expr exprtwo = new Expr();

    public void parse(Scanner S) {
        // <cmpr> ::= <expr> == <expr> | <expr> < <expr> | <expr> <= <expr>
        // Regardless of which option we are on.
        // The first tokens is <expr>
        exprone.parse(S);
        // Option 1: <cmpr> ::= <expr> == <expr>
        if (S.currentToken() == Core.EQUAL) {
            option = 1;
            S.expectedToken(Core.EQUAL);
            exprtwo.parse(S);
        } 
        // Option 2: <cmpr> ::= <expr> < <expr>
        else if (S.currentToken() == Core.LESS) {
            option = 2;
            S.expectedToken(Core.LESS);
            exprtwo.parse(S);
        } 
        // Option 3: <cmpr> ::= <expr> <= <expr>
        else if (S.currentToken() == Core.LESSEQUAL) {
            option = 3;
            S.expectedToken(Core.LESSEQUAL);
            exprtwo.parse(S);
        }
        // So if the currentToken != ""== or < or <="", then syntax is invalid.
        else{
            Core[] expectedones = new Core[]{Core.EQUAL, Core.LESS, Core.LESSEQUAL};
            Utility.errorhelper(expectedones, S.currentToken());
            System.exit(-1);
        }
    }

    public void print(int indent) {

    }
}

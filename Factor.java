public class Factor {

    public int option = 0;

    public String id;
    public int cons;
    public Expr expr = new Expr();

    public void parse(Scanner S) {
        // <factor> ::= id | const | ( <expr> )
        // Option 1: <factor> ::= id
        if (S.currentToken() == Core.ID) {
            id = S.getID();
            option = 1;
            S.expectedToken(Core.ID);
        }
        // Option 2: <factor> ::= const
        else if (S.currentToken() == Core.CONST) {
            cons = S.getCONST();
            option = 2;
            S.expectedToken(Core.CONST);
        }
        // Option 3: <factor> ::= ( <expr> )
        else if (S.currentToken() == Core.LPAREN) {
            option = 3;
            S.expectedToken(Core.LPAREN);
            expr.parse(S);
            if (!S.expectedToken(Core.RPAREN)) {
                Utility.expectedhelper(Core.RPAREN, S.currentToken());
                System.exit(-1);
            }
        }
        // So if the currentToken != "id or const or (", then syntax is invalid.
        else {
            Core[] expectedones = new Core[] { Core.ID, Core.CONST, Core.LPAREN };
            Utility.errorhelper(expectedones, S.currentToken());
            System.exit(-1);
        }

    }

    public void print(int indent) {
        if(option == 1){
            System.out.print(id);
        }else if(option == 2){
            System.out.print(cons);
        }if(option == 3){
            System.out.print("(");
            expr.print(indent);
            System.out.print(")");
        }
    }
}

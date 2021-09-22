public class Assign {

    public int option = 0;
    public String line;

    public Expr expr = new Expr();
    public String idone = "";
    public String idtwo = "";

    public void parse(Scanner S) {
        // <assign> ::= id = new | id = ref id; | id = <expr>; 
        // Regardless of which option we are on.
        // The first two tokens are ID =
        if(S.currentToken()==Core.ID){
            idone = S.getID();
            S.nextToken();
        }else{
            Utility.expectedhelper(Core.ID, S.currentToken());
            System.exit(-1);
        }
        if(!S.expectedToken(Core.ASSIGN)){
            Utility.expectedhelper(Core.ASSIGN, S.currentToken());
            System.exit(-1);
        }
        // Option 1: <assign> ::= id = new;
        if (S.currentToken() == Core.NEW) {
            option = 1;
            S.expectedToken(Core.NEW);
        } 
        // Option 2: <assign> ::= id = ref id;
        else if (S.currentToken() == Core.REF) {
            option = 2;
            S.expectedToken(Core.REF);
            if(S.currentToken()==Core.ID){
                idtwo = S.getID();
                S.nextToken();
            }else{
                Utility.expectedhelper(Core.ID, S.currentToken());
                System.exit(-1);
            }
        } 
        // Option 3: <assign> ::= id = <expr>;
        // <expr> ::= <term> | <term> + <expr> | <term> – <expr>
        // <term> ::= <factor> | <factor> * <term>
        // <factor> ::= id | const | ( <expr> )
        else if (S.currentToken() == Core.ID || S.currentToken() == Core.CONST || S.currentToken() == Core.LPAREN) {
            option = 3;
            expr.parse(S);
        }
        // So if the currentToken != "new or id or const or (", then syntax is invalid.
        else{
            Core[] expectedones = new Core[]{Core.NEW, Core.REF, Core.ID, Core.CONST, Core.LPAREN};
            Utility.errorhelper(expectedones, S.currentToken());
            System.exit(-1);
        }
        if(!S.expectedToken(Core.SEMICOLON)){
            Utility.expectedhelper(Core.SEMICOLON, S.currentToken());
            System.exit(-1);
        }
    }

    public void print(int indent) {
        for (int i = 0; i < indent; i++) {
            line += "  ";
        }
        line += idone;
        line += "=";
        System.out.print(line);
        if(option == 1){
            System.out.println("new;");
        }else if(option==2){
            System.out.println("ref "+idtwo+";");
        }else if(option==3){
            expr.print(indent);
            System.out.println(";");
        }
    }
}

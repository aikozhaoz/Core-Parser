public class Assign {

    public int option = 0;
    public String line;

    public Expr expr = new Expr();
    public String idone = "";
    public String idtwo = "";

    public void parse(Scanner S) {
        if(S.currentToken()==Core.ID){
            idone = S.getID();
            S.nextToken();
        }else{
            Utility.errorhelper(Core.ID, S.currentToken());
            System.exit(-1);
        }
        if(!S.expectedToken(Core.ASSIGN)){
            Utility.errorhelper(Core.ASSIGN, S.currentToken());
            System.exit(-1);
        }
        // Option 1: id = new;
        if (S.currentToken() == Core.NEW) {
            option = 1;
            S.expectedToken(Core.NEW);
            if(!S.expectedToken(Core.SEMICOLON)){
                Utility.errorhelper(Core.SEMICOLON, S.currentToken());
                System.exit(-1);
            }
        } 
        // Option 2: id = ref id;
        else if (S.currentToken() == Core.REF) {
            option = 2;
            S.expectedToken(Core.REF);
            if(S.currentToken()==Core.ID){
                idtwo = S.getID();
                S.nextToken();
            }else{
                Utility.errorhelper(Core.ID, S.currentToken());
                System.exit(-1);
            }
            if(!S.expectedToken(Core.SEMICOLON)){
                Utility.errorhelper(Core.SEMICOLON, S.currentToken());
                System.exit(-1);
            }
        } 
        // Option 3: id = <expr>;
        else if (S.currentToken() == Core.ID || S.currentToken() == Core.CONST || S.currentToken() == Core.LPAREN) {
            option = 3;
            expr.parse(S);
            if(!S.expectedToken(Core.SEMICOLON)){
                Utility.errorhelper(Core.SEMICOLON, S.currentToken());
                System.exit(-1);
            }
        }
    }

    public void print(int indent) {
        for (int i = 0; i < indent; i++) {
            line += "  ";
        }
        line += idone;
        line += " = ";
    }
}

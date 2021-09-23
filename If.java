public class If {

    int option;
    String line;

    Cond cond;
    StmtSeq stmtseqone;
    StmtSeq stmtseqtwo;

    If(){
        option = 0;
        cond = null;
        stmtseqone = null;
        stmtseqtwo = null;
    }

    public void parse(Scanner S) {
        // <if> ::= if <cond> then <stmt-seq> endif | if <cond> then <stmt-seq> else <stmt-seq> endif
        // Regardless of which option we land, the first 4 tokens are: if <cond> then <stmt-seq>
        if(!S.expectedToken(Core.IF)){
            Utility.expectedhelper(Core.IF, S.currentToken());
            System.exit(-1);
        }
        cond = new Cond();
        cond.parse(S);
        if(!S.expectedToken(Core.THEN)){
            Utility.expectedhelper(Core.THEN, S.currentToken());
            System.exit(-1);
        }
        stmtseqone = new StmtSeq();
        stmtseqone.parse(S);
        // This is where options diverge!
        // Option 1: <if> ::= if <cond> then <stmt-seq> endif
        if (S.currentToken() == Core.ENDIF) {
            option = 1;
            S.expectedToken(Core.ENDIF);
        } 
        // Option 2: <if> ::= if <cond> then <stmt-seq> else <stmt-seq> endif
        else if (S.currentToken() == Core.ELSE) {
            option = 2;
            S.expectedToken(Core.ELSE);
            stmtseqtwo = new StmtSeq();
            stmtseqtwo.parse(S);
            if(!S.expectedToken(Core.ENDIF)){
                Utility.expectedhelper(Core.ENDIF, S.currentToken());
                System.exit(-1);
            }
        }else{
            Core[] expectedones = new Core[]{Core.ENDIF, Core.ELSE};
            Utility.errorhelper(expectedones, S.currentToken());
            System.exit(-1);
        }
    }

    public void print(int indent) {
        for (int i = 0; i < indent; i++) {
            line += "  ";
        }
        System.out.print(line + "if");
        cond.print(indent);
        System.out.println(" then");
        indent++;
        if(option==1){
            stmtseqone.print(indent);
            System.out.println(line + "endif");
        }else if(option ==2){
            stmtseqone.print(indent);
            System.out.println(line + "else");
            stmtseqtwo.print(indent);
            System.out.println(line + "endif");
        }
        
    }
}

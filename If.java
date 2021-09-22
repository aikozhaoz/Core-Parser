public class If {

    public static int option = 0;
    public Cond cond = new Cond();
    public StmtSeq stmtseqone = new StmtSeq();
    public StmtSeq stmtseqtwo = new StmtSeq();

    public void parse(Scanner S) {
        if(!S.expectedToken(Core.IF)){
            Utility.errorhelper(Core.IF, S.currentToken());
            System.exit(-1);
        }
        cond.parse(S);
        if(!S.expectedToken(Core.THEN)){
            Utility.errorhelper(Core.THEN, S.currentToken());
            System.exit(-1);
        }
        stmtseqone.parse(S);
        if (S.currentToken() == Core.ENDIF) {
            option = 1;
            S.expectedToken(Core.ENDIF);
        } else if (S.currentToken() == Core.ELSE) {
            option = 2;
            S.expectedToken(Core.ELSE);
            stmtseqtwo.parse(S);
            if(!S.expectedToken(Core.ENDIF)){
                Utility.errorhelper(Core.ENDIF, S.currentToken());
                System.exit(-1);
            }
        }
    }

    public void print(int indent) {
        System.out.print("if ");
        cond.print(indent);
    }
}

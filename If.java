public class If {

    public static int option = 0;
    public Cond cond = new Cond();
    public StmtSeq stmtseqone = new StmtSeq();
    public StmtSeq stmtseqtwo = new StmtSeq();

    public void parse(Scanner S) {
        S.expectedToken(Core.IF);
        cond.parse(S);
        S.expectedToken(Core.THEN);
        stmtseqone.parse(S);
        if (S.currentToken() == Core.ENDIF) {
            option = 1;
            S.expectedToken(Core.ENDIF);
        } else if (S.currentToken() == Core.ELSE) {
            option = 2;
            S.expectedToken(Core.ELSE);
            stmtseqtwo.parse(S);
            S.expectedToken(Core.ENDIF);
        }
    }

    public void print() {

    }
}

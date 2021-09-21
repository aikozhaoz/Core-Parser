public class Loop {

    public Cond cond = new Cond();
    public StmtSeq stmtseq = new StmtSeq();

    public void parse(Scanner S) {
        S.expectedToken(Core.WHILE);
        cond.parse(S);
        S.expectedToken(Core.BEGIN);
        stmtseq.parse(S);
        S.expectedToken(Core.ENDWHILE);
    }

    public void print() {

    }
}

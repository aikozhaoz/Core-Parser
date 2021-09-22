public class Loop {

    public Cond cond = new Cond();
    public StmtSeq stmtseq = new StmtSeq();

    public void parse(Scanner S) {
        if (!S.expectedToken(Core.WHILE)) {
            Utility.errorhelper(Core.WHILE, S.currentToken());
            System.exit(-1);
        }
        cond.parse(S);
        if (!S.expectedToken(Core.BEGIN)) {
            Utility.errorhelper(Core.BEGIN, S.currentToken());
            System.exit(-1);
        }
        stmtseq.parse(S);
        if (!S.expectedToken(Core.ENDWHILE)) {
            Utility.errorhelper(Core.ENDWHILE, S.currentToken());
            System.exit(-1);
        }
    }

    public void print(int indent) {
        System.out.print("while ");
        cond.print(indent);
    }
}

public class StmtSeq {

    public static int option = 0;

    public Stmt stmt = new Stmt();
    public StmtSeq stmtseq = new StmtSeq();

    public void parse(Scanner S) {
        option = 1;
        stmt.parse(S);
        if (S.currentToken() != Core.END) {
            option = 2;
            stmtseq.parse(S);
        }
    }

    public void print(int indent) {
        stmt.print(indent);
        stmtseq.print(indent);
    }
}

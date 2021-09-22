public class StmtSeq {

    public static int option = 0;

    public Stmt stmt = new Stmt();
    public StmtSeq stmtseq = new StmtSeq();

    public void parse(Scanner S) {
        // Option 1: <stmt-seq> ::= <stmt>
        option = 1;
        stmt.parse(S);
        // Option 2: <stmt-seq> ::= <stmt><stmt-seq>
        // If the current token != Core.END, continue parsing stmtseq.
        if (S.currentToken() != Core.END) {
            option = 2;
            stmtseq.parse(S);
        }
    }

    public void print(int indent) {
        stmt.print(indent);
        if (option == 2) {
            stmtseq.print(indent);
        }
    }
}

public class Prog {

    public DeclSeq declseq = new DeclSeq();
    public StmtSeq stmtseq = new StmtSeq();

    public void parse(Scanner S) {
        S.expectedToken(Core.PROGRAM);
        // If the next token is not BEGIN, it should be decl_seq.
        // If the next token is BEGIN, skip the if and jump to expectedToken(BEGIN)
        if (S.currentToken() != Core.BEGIN) {
            declseq.parse(S);
        }
        S.expectedToken(Core.BEGIN);
        stmtseq.parse(S);
        S.expectedToken(Core.END);
        S.expectedToken(Core.EOF);
    }

    public void print() {

    }
}

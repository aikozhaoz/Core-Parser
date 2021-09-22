public class Loop {

    public Cond cond = new Cond();
    public StmtSeq stmtseq = new StmtSeq();

    public void parse(Scanner S) {
        // <loop> ::= while <cond> begin <stmt-seq> endwhile
        if (!S.expectedToken(Core.WHILE)) {
            Utility.expectedhelper(Core.WHILE, S.currentToken());
            System.exit(-1);
        }
        cond.parse(S);
        if (!S.expectedToken(Core.BEGIN)) {
            Utility.expectedhelper(Core.BEGIN, S.currentToken());
            System.exit(-1);
        }
        stmtseq.parse(S);
        if (!S.expectedToken(Core.ENDWHILE)) {
            Utility.expectedhelper(Core.ENDWHILE, S.currentToken());
            System.exit(-1);
        }
    }

    public void print(int indent) {
        System.out.print("while ");
        cond.print(indent);
    }
}

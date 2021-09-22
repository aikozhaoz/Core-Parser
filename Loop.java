public class Loop {

    public String line;

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
        for (int i = 0; i < indent; i++) {
            line += "  ";
        }
        System.out.print(line + "while ");
        cond.print(indent);
        System.out.println(" begin");
        indent++;
        stmtseq.print(indent);
        System.out.println("endwhile");
    }
}

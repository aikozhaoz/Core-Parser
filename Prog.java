public class Prog {

    public static int option = 0;

    public DeclSeq declseq = new DeclSeq();
    public StmtSeq stmtseq = new StmtSeq();

    public void parse(Scanner S) {
        if (!S.expectedToken(Core.PROGRAM)) {
            Utility.errorhelper(Core.PROGRAM, S.currentToken());
            System.exit(-1);
        }
        option = 1;
        // If the next token is not BEGIN, it should be decl_seq.
        // If the next token is BEGIN, skip the if and jump to expectedToken(BEGIN)
        if (S.currentToken() != Core.BEGIN) {
            option = 2;
            declseq.parse(S);
        }
        
        if (!S.expectedToken(Core.BEGIN)) {
            Utility.errorhelper(Core.BEGIN, S.currentToken());
            System.exit(-1);
        }
        stmtseq.parse(S);
        if (!S.expectedToken(Core.END)) {
            Utility.errorhelper(Core.END, S.currentToken());
            System.exit(-1);
        }
        if (!S.expectedToken(Core.EOF)) {
            Utility.errorhelper(Core.EOF, S.currentToken());
            System.exit(-1);
        }
    }

    public void print(int indent) {
        System.out.println("program");
        indent++;
        if (option == 2) {
            declseq.print(indent);
        }
        System.out.println("begin");
        stmtseq.print(indent);
        System.out.println("end");
    }

}

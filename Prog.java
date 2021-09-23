public class Prog {

    int option = 0;

    DeclSeq declseq;
    StmtSeq stmtseq;

    Prog(){
        declseq = null;
        stmtseq = new StmtSeq();
    }

    public void parse(Scanner S) {
        // Option 1: <prog> ::= program <decl-seq> begin <stmt-seq> end
        if (!S.expectedToken(Core.PROGRAM)) {
            Utility.expectedhelper(Core.PROGRAM, S.currentToken());
            System.exit(-1);
        }
        option = 1;
        // If the next token is not BEGIN, it should be decl_seq.
        // If the next token is BEGIN, skip the if and jump to expectedToken(BEGIN)
        
        // Option 2: <prog> ::= program begin <stmt-seq> end
        if (S.currentToken() != Core.BEGIN) {
            option = 2;
            // System.out.println("Declseq");
            declseq = new DeclSeq();
            declseq.parse(S);
        }

        if (!S.expectedToken(Core.BEGIN)) {
            Utility.expectedhelper(Core.BEGIN, S.currentToken());
            System.exit(-1);
        }
        stmtseq.parse(S);
        if (!S.expectedToken(Core.END)) {
            Utility.expectedhelper(Core.END, S.currentToken());
            System.exit(-1);
        }
        if (!S.expectedToken(Core.EOF)) {
            Utility.expectedhelper(Core.EOF, S.currentToken());
            System.exit(-1);
        }
    }

    public void print(int indent) {
        System.out.println("program");
        // declseq.print(indent);
        if (option == 2) {
            declseq.print(indent);
        }
        System.out.println("begin");
        stmtseq.print(indent);
        System.out.println("end");
    }

}

public class Prog {

    public DeclSeq declseq = new DeclSeq();
    public StmtSeq stmtseq = new StmtSeq();
    public Core current;

    public void parse(Scanner S) {
        current = S.currentToken();
        if(!S.expectedToken(Core.PROGRAM)){
            Utility.errorhelper(Core.PROGRAM, current);
            System.exit(-1);
        }
        // If the next token is not BEGIN, it should be decl_seq.
        // If the next token is BEGIN, skip the if and jump to expectedToken(BEGIN)
        if (S.currentToken() != Core.BEGIN) {
            declseq.parse(S);
        }
        current = S.currentToken();
        if(!S.expectedToken(Core.BEGIN)){
            Utility.errorhelper(Core.BEGIN, current);
            System.exit(-1);
        }
        stmtseq.parse(S);
        current = S.currentToken();
        if(!S.expectedToken(Core.END)){
            Utility.errorhelper(Core.END, current);
            System.exit(-1);
        }
        if(!S.expectedToken(Core.EOF)){
            Utility.errorhelper(Core.EOF, current);
            System.exit(-1);
        }
    }

    public void print(int indent) {
        System.out.println("program"); 
        indent++;   
        if(declseq!=null){
            declseq.print(indent);
        }  
        System.out.println("begin"); 
        stmtseq.print(indent);
        System.out.println("end"); 
    }

}

public class DeclSeq {

    public static int option = 0;

    public Decl decl = new Decl();
    public DeclSeq declseq = new DeclSeq();

    public void parse(Scanner S) {
        // Option 1: <decl-seq> ::= <decl>
        option = 1;
        decl.parse(S);
        // Option 2: <decl-seq> ::= <decl><decl-seq>
        // If the current token != Core.BEGIN, continue parsing declseq.
        if (S.currentToken() != Core.BEGIN) {
            option = 2;
            declseq.parse(S);
        } 
    }

    public void print(int indent) {
        decl.print(indent);
        if (option == 2) {
            declseq.print(indent);
        }
    }
}
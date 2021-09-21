public class DeclSeq {

    public static int option = 0;
    public Decl decl = new Decl();
    public DeclSeq declseq = new DeclSeq();

    public void parse(Scanner S) {
        option = 1;
        decl.parse(S);
        if (S.currentToken() != Core.BEGIN) {
            option = 2;
            declseq.parse(S);
        }
    }

    public void print() {
        
    }
}
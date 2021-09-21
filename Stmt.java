public class Stmt {

    public static int option = 0;
    public Assign assign = new Assign();
    public If ifobj = new If();
    public Loop loop = new Loop();
    public In in = new In();
    public Out out = new Out();
    public Decl decl = new Decl();

    public void parse(Scanner S) {
        // If the current token is an ID, the current token is assign.
        if (S.currentToken() == Core.ID) {
            option = 1;
            assign.parse(S);
        } else if (S.currentToken() == Core.IF) {
            option = 2;
            ifobj.parse(S);
        } else if (S.currentToken() == Core.WHILE) {
            option = 3;
            loop.parse(S);
        } else if (S.currentToken() == Core.INPUT) {
            option = 4;
            in.parse(S);
        } else if (S.currentToken() == Core.OUTPUT) {
            option = 5;
            out.parse(S);
        } else if (S.currentToken() == Core.INT || S.currentToken() == Core.REF) {
            option = 6;
            decl.parse(S);
        }
    }

    public void print() {

    }
}

public class Decl {

    public static int option = 0;
    public DeclInt declint = new DeclInt();
    public DeclClass declclass = new DeclClass();

    public void parse(Scanner S) {
        if (S.currentToken() == Core.ID) {
            option = 1;
            declint.parse(S);
        } else if (S.currentToken() == Core.REF) {
            option = 2;
            declclass.parse(S);
        }
    }

    public void print() {

    }
}

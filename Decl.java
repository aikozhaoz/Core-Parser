public class Decl {

    public static int option = 0;

    public DeclInt declint = new DeclInt();
    public DeclClass declclass = new DeclClass();

    public void parse(Scanner S) {
        // Option 1: <decl> ::= <decl-int>
        if (S.currentToken() == Core.INT) {
            option = 1;
            declint.parse(S);
        } 
        // Option 2: <decl> ::= <decl-class>
        else if (S.currentToken() == Core.REF) {
            option = 2;
            declclass.parse(S);
        } 
        // So if the currentToken != id or ref, then syntax is invalid.
        else {
            Core[] expectedones = new Core[]{Core.REF, Core.ID};
            Utility.errorhelper(expectedones, S.currentToken());
            System.exit(-1);
        }
    }

    public void print(int indent) {
        if (option == 1) {
            declint.print(indent);
        } else if (option == 2) {
            declclass.print(indent);
        }
    }
}

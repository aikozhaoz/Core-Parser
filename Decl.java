public class Decl {

    public static int option = 0;

    public DeclInt declint = new DeclInt();
    public DeclClass declclass = new DeclClass();

    public void parse(Scanner S) {
        if (S.currentToken()==Core.ID) {
            option = 1;
            declint.parse(S);
        } else if (S.currentToken()==Core.REF) {
            option = 2;
            declclass.parse(S);
        } else{
            System.out.print("The expections are not met. ");
            Utility.errorhelper(Core.ID, S.currentToken());
            Utility.errorhelper(Core.REF, S.currentToken());
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

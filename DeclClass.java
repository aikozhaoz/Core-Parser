public class DeclClass {

    public String line;

    public IdList idlist = new IdList();

    public void parse(Scanner S) {
        if (!S.expectedToken(Core.REF)) {
            Utility.errorhelper(Core.REF, S.currentToken());
            System.exit(-1);
        }
        idlist.parse(S);
        if (!S.expectedToken(Core.SEMICOLON)) {
            Utility.errorhelper(Core.SEMICOLON, S.currentToken());
            System.exit(-1);
        }
    }

    public void print(int indent) {
        for (int i = 0; i < indent; i++) {
            line += "  ";
        }
        line += "ref ";
        System.out.print(line);
        idlist.print(indent);
        System.out.println(";");
    }
}

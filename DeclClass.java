public class DeclClass {

    public String line;

    public IdList idlist = new IdList();

    public void parse(Scanner S) {
        // <decl-class> ::= ref <id-list> ;
        if (!S.expectedToken(Core.REF)) {
            Utility.expectedhelper(Core.REF, S.currentToken());
            System.exit(-1);
        }
        idlist.parse(S);
        if (!S.expectedToken(Core.SEMICOLON)) {
            Utility.expectedhelper(Core.SEMICOLON, S.currentToken());
            System.exit(-1);
        }
    }

    public void print(int indent) {
        for (int i = 0; i < indent; i++) {
            line += "  ";
        }
        System.out.print(line + "ref ");
        idlist.print(indent);
        System.out.println(";");
    }
}

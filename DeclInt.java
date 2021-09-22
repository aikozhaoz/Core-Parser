public class DeclInt {

    public String line;

    public IdList idlist = new IdList();

    public void parse(Scanner S) {
        // <decl-int> ::= int <id-list> ;
        if (!S.expectedToken(Core.INT)) {
            Utility.expectedhelper(Core.INT, S.currentToken());
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
        System.out.print(line + "int ");
        idlist.print(indent);
        System.out.println(";");
    }
}

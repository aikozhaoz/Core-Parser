public class In {

    public String line;

    public String id;

    public void parse(Scanner S) {
        // <in> ::= input id ;
        if (!S.expectedToken(Core.INPUT)) {
            Utility.expectedhelper(Core.INPUT, S.currentToken());
            System.exit(-1);
        }
        if (S.currentToken() == Core.ID) {
            id = S.getID();
            S.nextToken();
        } else {
            Utility.expectedhelper(Core.ID, S.currentToken());
            System.exit(-1);
        }
        if (!S.expectedToken(Core.SEMICOLON)) {
            Utility.expectedhelper(Core.SEMICOLON, S.currentToken());
            System.exit(-1);
        }
    }

    public void print(int indent) {
        for (int i = 0; i < indent; i++) {
            line += "  ";
        }
        System.out.println(line + "input " + id + ";");
    }
}

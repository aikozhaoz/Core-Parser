public class DeclClass {

    public IdList idlist = new IdList();

    public void parse(Scanner S) {
        S.expectedToken(Core.REF);
        idlist.parse(S);
        S.expectedToken(Core.SEMICOLON);
    }

    public void print() {

    }
}

public class DeclInt {

    public IdList idlist = new IdList();

    public void parse(Scanner S) {
        S.expectedToken(Core.INT);
        idlist.parse(S);
        S.expectedToken(Core.SEMICOLON);
    }

    public void print() {

    }
}

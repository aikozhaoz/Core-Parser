public class IdList {

    public static int option = 0;
    public IdList idlist = new IdList();

    public void parse(Scanner S) {
        option = 1;
        S.expectedToken(Core.ID);
        if (S.currentToken() == Core.COMMA) {
            option = 2;
            S.expectedToken(Core.COMMA);
            idlist.parse(S);
        }
    }

    public void print() {

    }
}
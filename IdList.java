public class IdList {

    public static int option = 0;
    public String line;
    public String id;

    public IdList idlist = new IdList();

    public void parse(Scanner S) {
        if (S.currentToken()==Core.ID) {
            option = 1;
            id = S.getID();
            S.nextToken();
        }else{
            Utility.errorhelper(Core.ID, S.currentToken());
            System.exit(-1);
        }
        if (S.currentToken() != Core.BEGIN) {
            if (S.currentToken()==Core.COMMA) {
                option = 2;
                id += ",";
                idlist.parse(S);
            }else{
                Utility.errorhelper(Core.COMMA, S.currentToken());
                System.exit(-1);
            }
        }
    }

    public void print(int indent) {
        for (int i = 0; i < indent; i++) {
            line += "  ";
        }
        line += id;
        System.out.print(line);
        if(option==2){
            idlist.print(indent);
        }
    }
}
public class IdList {

    public static int option = 0;
    public String line;
    public String id;

    public IdList idlist = new IdList();

    public void parse(Scanner S) {
        // Option 1: <id-list> ::= id
        if (S.currentToken()==Core.ID) {
            option = 1;
            id = S.getID();
            S.nextToken();
        }else{
            Utility.expectedhelper(Core.ID, S.currentToken());
            System.exit(-1);
        }
        // Option 2: <id-list> ::= id , <id-list>
        if (S.currentToken()==Core.COMMA) {
            option = 2;
            id += ",";
            idlist.parse(S);
        }
    }

    public void print(int indent) {
        line += id;
        System.out.print(line);
        if(option==2){
            idlist.print(indent);
        }
    }
}
public class IdList {

    int option;
    String line;
    String id;
    
    IdList idlist;
    
    IdList(){
        option = 0;
        line = "";
        id = "";
        idlist = null;
    }

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
            S.expectedToken(Core.COMMA);
            idlist = new IdList();
            idlist.parse(S);
        }
    }

    public void print(int indent) {
        System.out.print(line + id);
        if(option==2){
            System.out.print(",");
            idlist.print(indent);
        }
    }
}
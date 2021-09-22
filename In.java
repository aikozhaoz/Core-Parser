public class In {
    
    public String id = "";

    public void parse(Scanner S){
        if(!S.expectedToken(Core.INPUT)){
            Utility.errorhelper(Core.INPUT, S.currentToken());
            System.exit(-1);
        }
        if(S.currentToken()==Core.ID){
            id = S.getID();
            S.nextToken();
        }else{
            Utility.errorhelper(Core.ID, S.currentToken());
            System.exit(-1);
        }
        if(!S.expectedToken(Core.SEMICOLON)){
            Utility.errorhelper(Core.SEMICOLON, S.currentToken());
            System.exit(-1);
        }
    }
    
    public void print(int indent){
        
    }
}

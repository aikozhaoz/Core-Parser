public class Out {

    public Expr expr = new Expr();
    
    public void parse(Scanner S){
        S.expectedToken(Core.OUTPUT);
        expr.parse(S);
        S.expectedToken(Core.SEMICOLON);
    }
    
    public void print(){
        
    }
}

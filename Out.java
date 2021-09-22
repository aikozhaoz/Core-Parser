public class Out {

    public Expr expr = new Expr();
    
    public void parse(Scanner S){
        S.expectedToken(Core.OUTPUT);
        if (S.currentToken() == Core.ID || S.currentToken() == Core.CONST || S.currentToken() == Core.LPAREN) {
            expr.parse(S);
        }
        S.expectedToken(Core.SEMICOLON);
    }
    
    public void print(int indent){
        
    }
}

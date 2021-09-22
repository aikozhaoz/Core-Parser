public class Stmt {

    public static int option = 0;

    public Assign assign = new Assign();
    public If ifobj = new If();
    public Loop loop = new Loop();
    public In in = new In();
    public Out out = new Out();
    public Decl decl = new Decl();

    public void parse(Scanner S) {
        // If the current token is an ID, the current token is assign.
        if (S.currentToken()== Core.ID) {
            option = 1;
            assign.parse(S);
        } else if (S.currentToken()== Core.IF) {
            option = 2;
            ifobj.parse(S);
        } else if (S.currentToken()== Core.WHILE) {
            option = 3;
            loop.parse(S);
        } else if (S.currentToken()== Core.INPUT) {
            option = 4;
            in.parse(S);
        } else if (S.currentToken()== Core.OUTPUT) {
            option = 5;
            out.parse(S);
        } else if (S.currentToken()==Core.INT || S.currentToken()==Core.REF) {
            option = 6;
            decl.parse(S);
        }else{
            System.out.print("The expections are not met. ");
            Utility.errorhelper(Core.ID, S.currentToken());
            Utility.errorhelper(Core.IF, S.currentToken());
            Utility.errorhelper(Core.WHILE, S.currentToken());
            Utility.errorhelper(Core.INPUT, S.currentToken());
            Utility.errorhelper(Core.OUTPUT, S.currentToken());
            Utility.errorhelper(Core.INT, S.currentToken());
            Utility.errorhelper(Core.REF, S.currentToken());
            System.exit(-1);
        }
    }

    public void print(int indent) {
        if(option == 1){
            assign.print(indent);
        }else if(option ==2){
            ifobj.print(indent);
        }else if(option ==3){
            loop.print(indent);
        }else if(option ==4){
            in.print(indent);
        }else if(option ==5){
            out.print(indent);
        }else if(option ==6){
            decl.print(indent);
        }

    }
}

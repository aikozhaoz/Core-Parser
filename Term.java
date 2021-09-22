public class Term {

    public int option = 0;

    public Factor factor = new Factor();
    public Term term = new Term();

    public void parse(Scanner S) {
        option = 1;
        factor.parse(S);
        if (S.currentToken() == Core.MULT) {
            option = 2;
            S.expectedToken(Core.MULT);
            term.parse(S);
        }// More conditions need to be add
        else if (S.currentToken()!= Core.SUB || S.currentToken()!= Core.ADD){
            System.out.print("The expections are not met. ");
            Utility.errorhelper(Core.MULT, S.currentToken());
            System.exit(-1);
        }
    }

    public void print(int indent) {

    }
}

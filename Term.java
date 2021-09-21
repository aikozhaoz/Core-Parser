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
        }
    }

    public void print() {

    }
}

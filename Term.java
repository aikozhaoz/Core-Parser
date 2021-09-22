public class Term {

    public int option = 0;

    public Factor factor = new Factor();
    public Term term = new Term();

    public void parse(Scanner S) {
        // <term> ::= <factor> | <factor> * <term>
        // Regardless of which option we are on.
        // The first token is <factor>
        // Option 1: <term> ::= <factor>
        option = 1;
        factor.parse(S);
        // Option 2: <factor> * <term>
        if (S.currentToken() == Core.MULT) {
            option = 2;
            S.expectedToken(Core.MULT);
            term.parse(S);
        }
    }

    public void print(int indent) {

    }
}

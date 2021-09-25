import java.util.*;

public class Factor {

    int option = 0;

    String id;
    int cons;
    Expr expr;

    Factor() {
        option = 0;
        id = "";
        expr = null;
    }

    public void parse(Scanner S) {
        // <factor> ::= id | const | ( <expr> )
        // Option 1: <factor> ::= id
        if (S.currentToken() == Core.ID) {
            id = S.getID();
            option = 1;
            S.expectedToken(Core.ID);
        }
        // Option 2: <factor> ::= const
        else if (S.currentToken() == Core.CONST) {
            cons = S.getCONST();
            option = 2;
            S.expectedToken(Core.CONST);
        }
        // Option 3: <factor> ::= ( <expr> )
        else if (S.currentToken() == Core.LPAREN) {
            option = 3;
            S.expectedToken(Core.LPAREN);
            expr = new Expr();
            expr.parse(S);
            if (!S.expectedToken(Core.RPAREN)) {
                Utility.expectedhelper(Core.RPAREN, S.currentToken());
                System.exit(-1);
            }
        }
        // So if the currentToken != "id or const or (", then syntax is invalid.
        else {
            Core[] expectedones = new Core[] { Core.ID, Core.CONST, Core.LPAREN };
            Utility.errorhelper(expectedones, S.currentToken());
            System.exit(-1);
        }

    }

    public void semantic(Stack<Map<String, Core>> scopetrack) {
        System.out.println(id);
        if (option == 3) {
            expr.semantic(scopetrack);
        }
        // Check if the ID is being declared.
        else if (option == 1) {
            boolean IDdeclared = false;
            String key = id;
            // Loop through the stack to see if the current ID is declared.
            for (Map<String, Core> currentscope : scopetrack) {
                // If the current ID is declared. Check if the declared type is right.
                if (currentscope.containsKey(key)) {
                    System.out.println(key);
                    IDdeclared = true;
                }
            }
            if (!IDdeclared) {
                Utility.UseUndeclaredIdError(key);
                System.exit(-1);
            }

        }
    }

    public void print(int indent) {
        if (option == 1) {
            System.out.print(id);
        } else if (option == 2) {
            System.out.print(cons);
        }
        if (option == 3) {
            System.out.print("(");
            expr.print(indent);
            System.out.print(")");
        }
    }
}

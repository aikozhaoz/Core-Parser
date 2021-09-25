import java.util.*;

public class If {

    int option;
    String line;

    Cond cond;
    StmtSeq stmtseqone;
    StmtSeq stmtseqtwo;

    If() {
        option = 0;
        line = "";
        cond = null;
        stmtseqone = null;
        stmtseqtwo = null;
    }

    public void parse(Scanner S) {
        // <if> ::= if <cond> then <stmt-seq> endif | if <cond> then <stmt-seq> else
        // <stmt-seq> endif
        // Regardless of which option we land, the first 4 tokens are: if <cond> then
        // <stmt-seq>
        if (!S.expectedToken(Core.IF)) {
            Utility.expectedhelper(Core.IF, S.currentToken());
            System.exit(-1);
        }
        // System.out.println(S.currentToken());
        cond = new Cond();
        cond.parse(S);
        // System.out.println("Before: " + S.tokens);
        if (!S.expectedToken(Core.THEN)) {
            Utility.expectedhelper(Core.THEN, S.currentToken());
            System.exit(-1);
        }
        // System.out.println("After: "+ S.tokens);
        // System.out.println(S.getID());
        // stmtseqone = new StmtSeq();
        // System.out.println("Before stmtseqone: " + S.tokens);
        // System.out.println();
        stmtseqone = new StmtSeq();
        stmtseqone.parse(S);
        // System.out.println("After stmtseqone: "+ S.tokens);
        // This is where options diverge!
        // Option 1: <if> ::= if <cond> then <stmt-seq> endif
        if (S.currentToken() == Core.ENDIF) {
            option = 1;
            S.expectedToken(Core.ENDIF);
        }
        // Option 2: <if> ::= if <cond> then <stmt-seq> else <stmt-seq> endif
        else if (S.currentToken() == Core.ELSE) {
            option = 2;
            S.expectedToken(Core.ELSE);
            stmtseqtwo = new StmtSeq();
            stmtseqtwo.parse(S);
            if (!S.expectedToken(Core.ENDIF)) {
                Utility.expectedhelper(Core.ENDIF, S.currentToken());
                System.exit(-1);
            }
        } else {
            Core[] expectedones = new Core[] { Core.ENDIF, Core.ELSE };
            Utility.errorhelper(expectedones, S.currentToken());
            System.exit(-1);
        }
    }

    public void semantic(Stack<Map<String, Core>> scopetrack) {
        cond.semantic(scopetrack);
        // Create a new Map because after "THEN", it enters a new scope.
        Map<String, Core> scopeone = new HashMap<>();
        scopetrack.push(scopeone);
        stmtseqone.semantic(scopetrack);
        if (option == 2) {
            // New scope starts after "ELSE".
            Map<String, Core> scopetwo = new HashMap<>();
            scopetrack.push(scopetwo);
            stmtseqtwo.semantic(scopetrack);
        }
    }

    public void print(int indent) {
        for (int i = 0; i < indent; i++) {
            line += "  ";
        }
        System.out.print(line + "if ");
        cond.print(indent);
        System.out.println(" then");
        indent++;
        if (option == 1) {
            stmtseqone.print(indent);
            System.out.println(line + "endif");
        } else if (option == 2) {
            stmtseqone.print(indent);
            System.out.println(line + "else");
            stmtseqtwo.print(indent);
            System.out.println(line + "endif");
        }

    }
}

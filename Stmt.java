import java.util.*;

public class Stmt {

    int option;

    Assign assign;
    If ifobj;
    Loop loop;
    In in;
    Out out;
    Decl decl;

    Stmt() {
        option = 0;
        assign = null;
        ifobj = null;
        loop = null;
        in = null;
        out = null;
        decl = null;
    }

    public void parse(Scanner S) {
        // Option 1: <stmt> ::= <assign>
        if (S.currentToken() == Core.ID) {
            option = 1;
            assign = new Assign();
            assign.parse(S);
        }
        // Option 2: <stmt> ::= <if>
        else if (S.currentToken() == Core.IF) {
            option = 2;
            ifobj = new If();
            ifobj.parse(S);
        }
        // Option 3: <stmt> ::= <loop>
        else if (S.currentToken() == Core.WHILE) {
            option = 3;
            loop = new Loop();
            loop.parse(S);
        }
        // Option 4: <stmt> ::= <in>
        else if (S.currentToken() == Core.INPUT) {
            option = 4;
            in = new In();
            in.parse(S);
        }
        // Option 5: <stmt> ::= <out>
        else if (S.currentToken() == Core.OUTPUT) {
            option = 5;
            out = new Out();
            out.parse(S);
        }
        // Option 6: <stmt> ::= <decl>
        else if (S.currentToken() == Core.INT || S.currentToken() == Core.REF) {
            option = 6;
            decl = new Decl();
            decl.parse(S);
        }
        // <assign> ::= id = <expr> ; | id = new ; | id = ref id ;
        // <if> ::= if <cond> then <stmt-seq> endif | if <cond> then <stmt-seq> else
        // <stmt-seq> endif
        // <loop> ::= while <cond> begin <stmt-seq> endwhile
        // <in> ::= input id ;
        // <out> ::= output <expr> ;
        // <decl> ::= <decl-int> | <decl-class>
        // So if the current token != id or if or while or input or output or int/ref,
        // then syntax error
        else {
            // System.out.println("SHOULD BE ENDIF"+S.tokens);
            Core[] expectedones = new Core[] { Core.ID, Core.IF, Core.WHILE, Core.INPUT, Core.OUTPUT, Core.INT,
                    Core.REF };
            Utility.errorhelper(expectedones, S.currentToken());
            System.exit(-1);
        }
    }

    public void semantic(Stack<Map<String, Core>> scopetrack) {
        if (option == 1) {
            assign.semantic(scopetrack);
        } else if (option == 2) {
            ifobj.semantic(scopetrack);
        } else if (option == 3) {
            loop.semantic(scopetrack);
        } else if (option == 4) {
            in.semantic(scopetrack);
        } else if (option == 5) {
            out.semantic(scopetrack);
        } else if (option == 6) {
            decl.semantic(scopetrack);
        }
    }

    public void print(int indent) {
        if (option == 1) {
            assign.print(indent);
        } else if (option == 2) {
            ifobj.print(indent);
        } else if (option == 3) {
            loop.print(indent);
        } else if (option == 4) {
            in.print(indent);
        } else if (option == 5) {
            out.print(indent);
        } else if (option == 6) {
            decl.print(indent);
        }

    }
}

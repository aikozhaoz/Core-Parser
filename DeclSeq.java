import java.util.*;

public class DeclSeq {

    int option;

    Decl decl;
    DeclSeq declseq;

    DeclSeq() {
        option = 0;
        decl = null;
        declseq = null;
    }

    public void parse(Scanner S) {
        // Option 1: <decl-seq> ::= <decl>
        option = 1;
        decl = new Decl();
        decl.parse(S);
        // Option 2: <decl-seq> ::= <decl><decl-seq>
        // If the current token != Core.BEGIN, continue parsing declseq.
        if (S.currentToken() == Core.INT || S.currentToken() == Core.REF) {
            option = 2;
            declseq = new DeclSeq();
            declseq.parse(S);
        }
    }

    public void semantic(Stack<Map<String, Core>> scopetrack) {
        decl.semantic(scopetrack);
        if (option == 2) {
            declseq.semantic(scopetrack);
        }
    }

    public void print(int indent) {
        decl.print(indent);
        if (option == 2) {
            declseq.print(indent);
        }
    }
}
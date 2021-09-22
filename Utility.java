public class Utility {

    public static void errorhelper(Core expected, Core current){
        if(current == Core.ERROR){
            System.out.println("ERROR: Invalid token!");
            System.out.println("Invalid token: "+ current);
        }else{
            System.out.println("Syntax error:  ");
            System.out.println("Expected token: " + expected);
            System.out.println("Current token: " + current);
        }
    }

}

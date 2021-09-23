public class Utility {

    public static void expectedhelper(Core expected, Core current){
        if(current == Core.ERROR){
            System.out.println("ERROR: Invalid token!");
            System.out.println("Invalid token: "+ current);
        }else{
            System.out.println("Syntax error!  ");
            System.out.println("Expected token: " + expected);
            System.out.println("Current token: " + current);
        }
    }

    public static void errorhelper(Core[] expectedones, Core current){
        if(current == Core.ERROR){
            System.out.println("ERROR: Invalid token!");
            System.out.println("Invalid token: "+ current);
        }      
        else{
            System.out.println("Syntax error:  ");
            String errormessage = "Expected tokens:  ";
            for(int i = 0; i<expectedones.length; i++){
                if(i<expectedones.length-1){
                    errormessage+=expectedones[i].name()+", ";
                }else{
                    errormessage+=expectedones[i].name();
                }
            }
            System.out.println(errormessage);
            System.out.println("Current token: " + current);
        }
    }

}

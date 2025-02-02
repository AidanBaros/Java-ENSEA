public class ExceptionChecker {
    public ExceptionChecker() {
    }
    public static void main(String[] args){
        int tester = 0;
        float output;
        try{
            output = 10/tester;
        }catch(Exception e){
            System.out.println("Oops you divided by 0");
            return;
        }
        System.out.println(output);
    }
}

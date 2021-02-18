package StringCalculator.Calculator;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws Exception
    {
        System.out.println( "Hello World!" );
        //int result = new StringCalculator().add("//;40;40\n2;-3");
        //int result = new StringCalculator().add("[!!!]40!!!4000");
        int result = new StringCalculator().add( "//;\n1;2");
        
        System.out.println("Final result" +result);
    }
}

package StringCalculator.Calculator;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        int result = new StringCalculator().add("//;40;40\n2;3");
        System.out.println("Final result" +result);
    }
}

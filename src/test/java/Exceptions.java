import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.opentest4j.AssertionFailedError;

public class Exceptions {

    @Test
    public void npeException(){
        try {
            String s = null;
            System.out.println(s.length());
        }
        catch (NullPointerException e){
            System.out.println("Значение не может быть null");

        }
    }

   @Test
    public void notTrueEx(){
       try {
           Assertions.assertTrue(false);
       }
       catch (AssertionFailedError error){
           System.out.println("Ожидаемый результат = true. Фактический = false");


       }
   }
}

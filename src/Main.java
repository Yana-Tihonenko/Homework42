import Exceptions.InvalidEmail;
import Exceptions.InvalidName;

public class Main {
    public static void main(String[] args) {

        try {
            Account account = new Account("Yanssa", "tihondddddddddenko@gmail.com");
        } catch (InvalidEmail e){
            System.err.println(e.getMessage());
        }catch (InvalidName e){
            System.err.println(e.getMessage());
        }






    }
}
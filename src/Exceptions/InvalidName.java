package Exceptions;

public class InvalidName extends IllegalArgumentException{
    public InvalidName(String a){
        throw new InvalidName(a);

    }

}

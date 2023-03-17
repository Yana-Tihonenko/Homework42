package Exceptions;

public class InvalidEmail extends IllegalArgumentException {

    public InvalidEmail(String a) {
        throw new  InvalidEmail(a);
    }
}

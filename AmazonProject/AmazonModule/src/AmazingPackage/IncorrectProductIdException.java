package AmazingPackage;

public class IncorrectProductIdException extends Exception{
    long incorrectNumber;

    public IncorrectProductIdException(long incorrectNumber) {
        this.incorrectNumber = incorrectNumber;
    }

    public String getMessage(){
        return "Incorrect productId. Must be positive number. Cannot be " + incorrectNumber;
    }
}

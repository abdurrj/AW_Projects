package ErrorHandling;

public class IncorrectInitialsLengthException extends Exception {
    String incorrectInitialsLength;

    public IncorrectInitialsLengthException(String incorrectInitials){
        this.incorrectInitialsLength = incorrectInitials;
    }

    public String getMessage(){
        return "Incorrect initials length. Cannot be more than three letters";
    }
}

package exceptions;

/***
 * Exception that determines problems with redirection to another page
 */
public class IncorrectClassRedirectionException extends Exception {

    public IncorrectClassRedirectionException(String message) {
        super(message);
    }
}

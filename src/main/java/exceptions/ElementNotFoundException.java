package exceptions;

/***
 * Exception that determines problems webElements
 */
public class ElementNotFoundException extends RuntimeException {

    public ElementNotFoundException(String message) {
        super(message);
    }
}

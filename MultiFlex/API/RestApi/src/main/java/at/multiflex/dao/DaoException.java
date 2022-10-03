package at.multiflex.dao;
/**
 * A Exception that gets thrown in the DAO classes
 */
public class DaoException extends Exception {
    /**
     * A Constructor that gives the message to the superclass
     */
    public DaoException(String errorMessage) {
        super(errorMessage);
    }
}

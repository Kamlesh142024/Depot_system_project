package interfaces;

public interface loggable {
    /**
     * Logs information messages.
     *
     * @param message the message to log
     */
    void logInfo(String message);

    /**
     * Logs error messages.
     *
     * @param message the message to log
     */
    void logError(String message);

    /**
     * Logs debugging messages.
     *
     * @param message the message to log
     */
    void logDebug(String message);
}

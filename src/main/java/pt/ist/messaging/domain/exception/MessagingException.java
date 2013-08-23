package pt.ist.messaging.domain.exception;

import pt.ist.bennu.core.domain.exceptions.DomainException;

public class MessagingException extends DomainException {

    private static final long serialVersionUID = 1L;

    private static final String bundle = "resources/MessagingResources";

    /**
     * @param key
     * @param args
     */
    public MessagingException(String key, String... args) {
        super(bundle, key, args);
    }

    /**
     * @param key
     * @param cause
     * @param args
     */
    public MessagingException(String key, Throwable cause, String... args) {
        super(cause, bundle, key, args);
    }

}

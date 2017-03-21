package hu.aronszabo.ulyssys.parking.service.api.exception;

import lombok.NoArgsConstructor;

/**
 * This class marks a not found error
 */
@NoArgsConstructor
public class NotFoundException extends Exception {

    /**
     * Constructor, which can spacifie the error message.
     */
    public NotFoundException(final String msg) {
        super(msg);
    }

}

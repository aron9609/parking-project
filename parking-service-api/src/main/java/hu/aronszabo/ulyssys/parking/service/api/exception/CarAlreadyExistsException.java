package hu.aronszabo.ulyssys.parking.service.api.exception;

import lombok.NoArgsConstructor;

/**
 * This class marks the error when the user try to save cars with the same
 * license plate number.
 */
@NoArgsConstructor
public class CarAlreadyExistsException extends Exception {

    /**
     * Constructor, which can spacifie the error message.
     */
    public CarAlreadyExistsException(final String msg) {
        super(msg);
    }
}

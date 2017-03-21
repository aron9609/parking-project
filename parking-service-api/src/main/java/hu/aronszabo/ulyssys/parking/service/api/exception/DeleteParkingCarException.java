package hu.aronszabo.ulyssys.parking.service.api.exception;

import lombok.NoArgsConstructor;

/**
 * This class marks an error, when the user try to delete a car, which is
 * parking yet.
 */
@NoArgsConstructor
public class DeleteParkingCarException extends Exception {

    /**
     * Constructor, which can spacifie the error message.
     */
    public DeleteParkingCarException(final String msg) {
        super(msg);
    }

}

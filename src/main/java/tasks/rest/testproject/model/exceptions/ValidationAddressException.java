package tasks.rest.testproject.model.exceptions;

import tasks.rest.testproject.model.exceptions.enums.ValidationErrorCode;

public class ValidationAddressException extends Exception {

    private final ValidationErrorCode errorCode;

    public ValidationAddressException(ValidationErrorCode errorCode) {
        this.errorCode = errorCode;
    }

    public ValidationErrorCode getErrorCode() {
        return errorCode;
    }
}
package tasks.rest.testproject.model.exceptions.enums;

public enum ValidationErrorCode {
    WRONG_REGION("Недопустимое имя региона"),
    NULL_REGION("Передан null в качестве региона"),
    WRONG_CITY("Недопустимое имя города"),
    NULL_CITY("Передан null к качестве города"),
    WRONG_STREET("Недопустимое имя улицы"),
    NULL_STREET("Передан null в качестве улицы"),
    WRONG_HOUSE("Недопустимый формат записи номера дома"),
    NULL_HOUSE("Передан null в качестве номера дома");

    private String errorString;

    ValidationErrorCode(String errorString) {
        this.errorString = errorString;
    }
    public String getErrorString() {
        return errorString;
    }
}
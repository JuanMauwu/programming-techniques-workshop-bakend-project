package culturemedia.exception;

public class CultureMediaException extends Exception {
    public CultureMediaException() {
        super();
    }

    public CultureMediaException(String title) {
        super(String.format("The video with the title '{}' was not found.",title));
    }

    public CultureMediaException(String title, Double duration ){
        super(String.format("The duration given('{}') for the video '{}' is not valid",duration,title));
    }

}
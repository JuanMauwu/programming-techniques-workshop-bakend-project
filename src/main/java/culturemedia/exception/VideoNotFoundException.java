package culturemedia.exception;

public class VideoNotFoundException extends CultureMediaException {

    public VideoNotFoundException() {
        super();
    }

    public VideoNotFoundException(String title) {
        super(title);
    }
    
}

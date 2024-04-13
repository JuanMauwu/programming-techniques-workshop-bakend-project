package culturemedia.exception;

import java.text.MessageFormat;

public class VideoNotFoundException extends CultureMediaException {

    public VideoNotFoundException() {
        super();
    }

    public VideoNotFoundException(String title) {
        super(MessageFormat.format("The video with title {0} was not found",title));
    }
    
}

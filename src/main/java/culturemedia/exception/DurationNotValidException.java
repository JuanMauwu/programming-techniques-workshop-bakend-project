package culturemedia.exception;

import java.text.MessageFormat;

public class DurationNotValidException extends CultureMediaException {

    public DurationNotValidException(String title, Double duration) {
        super(MessageFormat.format("The duration {0} in the video with title {1} is not valid",duration,title));
    }
    
}

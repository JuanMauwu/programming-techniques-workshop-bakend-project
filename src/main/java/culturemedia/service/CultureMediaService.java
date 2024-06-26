package culturemedia.service;

import culturemedia.exception.VideoNotFoundException;
import culturemedia.model.Video;
import culturemedia.model.View;

import java.util.List;

public interface CultureMediaService {
    List<Video> findAll() throws VideoNotFoundException;
    List<Video> findByTitle(String title) throws VideoNotFoundException;
    List<Video> findByDuration(Double fromDuration, Double toDuration) throws VideoNotFoundException;
    Video save(Video video);
    View save (View view);

}

package culturemedia.service.impl;

import culturemedia.repository.VideoRepository;
import culturemedia.repository.ViewsRepository;
import culturemedia.service.CultureMediaService;
import culturemedia.model.Video;
import culturemedia.model.View;

import java.util.List;

public class CultureMediaServiceImpl implements CultureMediaService {

    private VideoRepository videoRepository;
    private ViewsRepository viewsRepository;
   
    public List<Video> findAll() {
        return videoRepository.findAll();
    }

    public Video save(Video video) {
        return videoRepository.save(video);
    }

    public View save(View view) {
        return viewsRepository.save(view);
    }

}

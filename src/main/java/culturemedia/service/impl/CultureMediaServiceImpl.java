package culturemedia.service.impl;

import culturemedia.repository.VideoRepository;
import culturemedia.repository.ViewsRepository;
import culturemedia.service.CultureMediaService;
import culturemedia.exception.VideoNotFoundException;
import culturemedia.model.Video;
import culturemedia.model.View;

import java.util.List;

public class CultureMediaServiceImpl implements CultureMediaService {

    private VideoRepository videoRepository;
    private ViewsRepository viewsRepository;
   
    public CultureMediaServiceImpl(VideoRepository videoRepository, ViewsRepository viewsRepository) {
        this.videoRepository = videoRepository;
        this.viewsRepository = viewsRepository;

    }

    public List<Video> findAll() throws VideoNotFoundException {
        List<Video> videos = videoRepository.findAll();
        if (videos.isEmpty()) {
            throw new VideoNotFoundException("No videos found");
        }
        return videos;
    }

    public List<Video> findByTitle(String title) throws VideoNotFoundException {
        List<Video> video = videoRepository.find(title);
        if (video.isEmpty()) {
            throw new VideoNotFoundException("No videos found with title: " + title);
        }
        return video;
    }

    public List<Video> findByDuration(Double fromDuration, Double toDuration) throws VideoNotFoundException {
        List<Video> video = videoRepository.find(fromDuration, toDuration);
        if (video.isEmpty()) {
            throw new VideoNotFoundException("No videos found within the specified duration range");
        }
        return video;
    }

    public Video save(Video video) {
        return videoRepository.save(video);
    }

    public View save(View view) {
        return viewsRepository.save(view);
    }

}

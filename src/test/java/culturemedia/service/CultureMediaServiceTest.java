package culturemedia.service;



import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import culturemedia.model.Video;
import culturemedia.repository.impl.VideoRepositoryImpl;
import culturemedia.repository.impl.ViewsRepositoryImpl;
import culturemedia.service.impl.CultureMediaServiceImpl;
import culturemedia.exception.VideoNotFoundException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doReturn;

public class CultureMediaServiceTest {

    private CultureMediaService culturemediaService;
    private VideoRepositoryImpl videoRepository = Mockito.mock();

    @BeforeEach
    void init() {
        ViewsRepositoryImpl viewRepository = new ViewsRepositoryImpl();
        videoRepository = Mockito.mock(VideoRepositoryImpl.class);
        culturemediaService = new CultureMediaServiceImpl(videoRepository,viewRepository);
    }   

    @Test
    void when_FindAll_all_videos_should_be_returned_successfully() throws VideoNotFoundException {
        List<Video> videos = List.of(
            new Video("01", "Título 1", "----", 4.5),
            new Video("02", "Título 2", "----", 5.5),
			new Video("03", "Título 3", "----", 4.4),
			new Video("04", "Título 4", "----", 3.5),
			new Video("05", "Clic 5", "----", 5.7),
			new Video("06", "Clic 6", "----", 5.1)					   
        );
        doReturn(videos)
            .when(videoRepository)
            .findAll();
        assertEquals(6, videos.size());
    }

    @Test
    void when_FindAll_does_not_find_any_video_an_VideoNotFoundException_should_be_thrown_successfully() {

        doReturn(Collections.emptyList())
            .when(videoRepository)
            .findAll();
            
        assertThrows(
            VideoNotFoundException.class,
            () -> culturemediaService.findAll());
    }

    @Test
    void when_FindByTitle_existing_title_is_provided_then_videos_should_be_returned_successfully() throws VideoNotFoundException {
       
        String title  = "Titulo 1";
        List<Video> videos = List.of(new Video("01", "Título 1", "----", 4.5));

        doReturn(videos)
            .when(videoRepository)
            .find(title);
    
        assertEquals(videos, culturemediaService.findByTitle(title));
    }

    @Test
    void when_FindByTitle_non_existing_title_is_provided_then_VideoNotFoundException_should_be_thrown() {
        String title = "Title that does not exist";

        doReturn(Collections.emptyList())
            .when(videoRepository)
            .find(title);

        assertThrows(VideoNotFoundException.class, () -> culturemediaService.findByTitle(title));
    }

    @Test 
    void when_FindByDuration_existing_range_is_provided_then_videos_should_be_returned_successfully() throws VideoNotFoundException {
        Double fromDuration = 10.0;
        Double toDuration = 15.0;

        List<Video> videos = List.of(new Video("01", "Título 1", "----", 12.0));

        doReturn(videos)
            .when(videoRepository)
            .find(fromDuration, toDuration);
        
            assertEquals(videos, culturemediaService.findByDuration(fromDuration, toDuration));
    }

    @Test
    void when_FindByDuration_non_existing_range_is_provided_then_VideoNotFoundException_should_be_thrown() {
        Double fromDuration = 10.0;
        Double toDuration = 15.0;

        doReturn(Collections.emptyList())
            .when(videoRepository)
            .find(fromDuration, toDuration);

        assertThrows(VideoNotFoundException.class, () -> culturemediaService.findByDuration(fromDuration, toDuration));
    }
    


}

package culturemedia.controllers;

import java.util.List;

import culturemedia.exception.VideoNotFoundException;
import culturemedia.model.Video;
import culturemedia.service.impl.CultureMediaServiceImpl;

public class CultureMediaController {

	private final CultureMediaService cultureMediaService;


	public CultureMediaController(CultureMediaService cultureMediaService) {
		this.cultureMediaService = cultureMediaService;
	}


	public List<Video> find_allVideos() throws VideoNotFoundException {
		List<Video> videos = cultureMediaService.findAll();
		
		return videos;
	}


}
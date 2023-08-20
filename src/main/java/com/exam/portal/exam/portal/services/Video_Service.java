package com.exam.portal.exam.portal.services;

import com.exam.portal.exam.portal.entities.Video;

public interface Video_Service {
	
	public Video addVideo(Video video);

	public Video findVideo(Integer videoId);
	
	public String deleteVideo(Video video);

}

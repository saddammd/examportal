package com.exam.portal.exam.portal.controllers;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exam.portal.exam.portal.dto.Add_Video_dto;
import com.exam.portal.exam.portal.dto.Edit_Lesson_dto;
import com.exam.portal.exam.portal.dto.Edit_Video_dto;
import com.exam.portal.exam.portal.entities.Lesson;
import com.exam.portal.exam.portal.entities.Video;
import com.exam.portal.exam.portal.services.Lesson_Service;
import com.exam.portal.exam.portal.services.Video_Service;
import com.exam.portal.exam.portal.services.Video_ServiceImpl;

@RestController
@RequestMapping("/videos")
public class Video_Controller {

	@Autowired
	Lesson_Service lessonService;
	
	@Autowired
	Video_Service videoService;
	
	@PostMapping("/video")
	public ResponseEntity<String> addVideo(@RequestBody Add_Video_dto addvideo){
		
		Video video = new Video();
		Lesson findLesson = lessonService.findLesson(addvideo.getLessonId());
		if(findLesson!=null) {
			video.setLesson(findLesson);
			BeanUtils.copyProperties(addvideo, video);
			videoService.addVideo(video);
			return ResponseEntity.status(HttpStatus.ACCEPTED).body("Video Added Successfully");
		}
		return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("Lesson Not Found");
		
		
	}
	
	@PutMapping("/video")
	public ResponseEntity<String> editVideo(@RequestBody Edit_Video_dto edit_Video_dto){
		
		Video video = new Video();
		Lesson findLesson = lessonService.findLesson(edit_Video_dto.getLessonId());
		if(findLesson!=null) {
			video.setLesson(findLesson);
			BeanUtils.copyProperties(edit_Video_dto, video);
			videoService.addVideo(video);
			return ResponseEntity.status(HttpStatus.ACCEPTED).body("Video details updated Successfully");
		}
		return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("Lesson Not Found");
		
		
	}
	
	@DeleteMapping("/video/{id}")
	public ResponseEntity<String> deleteVideo(@PathVariable Integer id){
		
	
		Video findVideo = videoService.findVideo(id);
		String deleteVideo = videoService.deleteVideo(findVideo);
		return ResponseEntity.status(HttpStatus.OK).body(deleteVideo);
		
		
	}
	
}

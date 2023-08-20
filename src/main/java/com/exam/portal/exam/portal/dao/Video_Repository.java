package com.exam.portal.exam.portal.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exam.portal.exam.portal.entities.Video;

public interface Video_Repository extends JpaRepository<Video, Integer> {

	public Video findVideoById(Integer videoId);

}

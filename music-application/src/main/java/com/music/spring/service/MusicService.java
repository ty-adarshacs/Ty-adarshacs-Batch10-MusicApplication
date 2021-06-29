package com.music.spring.service;

import java.util.List;

import com.music.spring.bean.MusicFiles;

public interface MusicService {
	MusicFiles saveMusicFiles( MusicFiles musicfiles);
	List<MusicFiles> getAllMusicFileDetails();
	MusicFiles getmusicfileById(Integer id);
	MusicFiles updateMusicFiles( MusicFiles musicfiles ,Integer id);
    void deletmusicfileById( Integer id);
}

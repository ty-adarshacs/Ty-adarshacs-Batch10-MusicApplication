package com.music.spring.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.music.spring.bean.MusicFiles;
import com.music.spring.exception.ResourceNotFoundException;
import com.music.spring.repositary.MusicRepository;
import com.music.spring.service.MusicService;
@Service
@Transactional
public class MusicServiceImpl implements MusicService{
	@Autowired
   private MusicRepository musicrepository;
	
	public MusicServiceImpl(MusicRepository musicrepository) {
		super();
		this.musicrepository = musicrepository;
	}
	
	public MusicFiles saveMusicFiles(MusicFiles musicfiles) {
		// TODO Auto-generated method stub
		return musicrepository.save(musicfiles);
	}

	@Override
	public List<MusicFiles> getAllMusicFileDetails() {
		// TODO Auto-generated method stub
		return musicrepository.findAll();
	}

	@Override
	public MusicFiles getmusicfileById(Integer id) {
		Optional<MusicFiles> music=musicrepository.findById(id);
		if(music.isPresent()) {
			return music.get();
		}else {
			throw new ResourceNotFoundException("MusicFiles", "Id", id);
		}
		
	}

	@Override
	public MusicFiles updateMusicFiles(MusicFiles musicfiles, Integer id) {
		//we needd check whether given id exist are not 
		MusicFiles exitmusicfile=musicrepository.findById(id).orElseThrow(
				()->new ResourceNotFoundException("MusicFiles", "Id", id));
		exitmusicfile.setAlbumname(musicfiles.getAlbumname());
		exitmusicfile.setArtistname(musicfiles.getArtistname());
		exitmusicfile.setDescription(musicfiles.getDescription());
		exitmusicfile.setSonglocation(musicfiles.getSonglocation());
		exitmusicfile.setSongtitle(musicfiles.getSonglocation());
		musicrepository.save(exitmusicfile);
		return exitmusicfile;
	}

	@Override
	public void deletmusicfileById(Integer id) {
		musicrepository.findById(id).orElseThrow(()->
		new ResourceNotFoundException("MusicFiles", "Id", id));
		musicrepository.deleteById(id);
		
	}
	

}

package com.music.spring.repositary;

import org.springframework.data.jpa.repository.JpaRepository;

import com.music.spring.bean.MusicFiles;
// no need to add @repository
public interface MusicRepository extends JpaRepository<MusicFiles, Integer>{

}

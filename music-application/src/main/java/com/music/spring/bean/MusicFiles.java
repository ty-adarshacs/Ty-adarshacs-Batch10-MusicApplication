package com.music.spring.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "musicfiles")
public class MusicFiles {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "Song_Title", nullable = true)
	private String songtitle;
	@Column(name = "Artist_Name")
	private String artistname;
	@Column(name = "Album_Name")
	private String albumname;
	@Column(name = "Song_Location")
	private String songlocation;
	@Column(name = "Description")
	private String description;

	
	public String getSongtitle() {
		return songtitle;
	}

	public void setSongtitle(String songtitle) {
		this.songtitle = songtitle;
	}

	public String getArtistname() {
		return artistname;
	}

	public void setArtistname(String artistname) {
		this.artistname = artistname;
	}
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	public String getAlbumname() {
		return albumname;
	}

	public void setAlbumname(String albumname) {
		this.albumname = albumname;
	}

	public String getSonglocation() {
		return songlocation;
	}

	public void setSonglocation(String songlocation) {
		this.songlocation = songlocation;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	
	
	
}

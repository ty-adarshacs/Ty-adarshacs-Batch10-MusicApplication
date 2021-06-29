package com.music.spring.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.music.spring.bean.MusicFiles;
import com.music.spring.service.MusicService;

@RestController
//@RequestMapping("/api/musicfile")
public class MusicController {
  private MusicService musicservice;

public MusicController(MusicService musicservice) {
	super();
	this.musicservice = musicservice;
}
 // @PostMapping("/save")
 // @GetMapping("/getsave")
	/*
	 * public ResponseEntity<MusicFiles> savemusicfile(){
	 * System.out.println(" method is running"); MusicFiles m1=new MusicFiles();
	 * 
	 * m1.setAlbumname("qw"); m1.setArtistname("ravi"); m1.setDescription("dood");
	 * m1.setSonglocation("banglore"); m1.setSongtitle("raja"); return new
	 * ResponseEntity<MusicFiles>(musicservice.saveMusicFiles(m1),
	 * HttpStatus.CREATED);
	 * 
	 * }
	 */
	/*
	 * @GetMapping("/get") public String getname() { return
	 * "hi welcomemto new yark"; }
	 */
  @PostMapping("/save")
  public ResponseEntity<MusicFiles> savemusicfile1(@RequestBody MusicFiles musicfiles){
		System.out.println(" method is runningeee");
		/*
		 * MusicFiles m1=new MusicFiles();
		 * 
		 * m1.setAlbumname("qw"); m1.setArtistname("ravi"); m1.setDescription("dood");
		 * m1.setSonglocation("banglore"); m1.setSongtitle("raja");
		 */
		return new ResponseEntity<MusicFiles>(musicservice.saveMusicFiles(musicfiles), HttpStatus.CREATED);
		  
	  }
  @GetMapping("/getall")
  public List<MusicFiles> getAllMusicFiles(){
	  System.out.println(" hi every one mmmmm");
	  return musicservice.getAllMusicFileDetails();
  }
 @GetMapping("{id}")
  public ResponseEntity<MusicFiles> getmusicfileById( @PathVariable("id") Integer musicid){
	  return new ResponseEntity<MusicFiles>(musicservice.getmusicfileById(musicid), HttpStatus.OK);
	  
  }
 @PutMapping("{id}")
  public  ResponseEntity<MusicFiles> updateEmploy(@PathVariable("id") Integer id,@RequestBody MusicFiles musicfile){
	 return new ResponseEntity<MusicFiles>(musicservice.updateMusicFiles(musicfile, id), HttpStatus.OK);
	 
 }
 
 @DeleteMapping("{id}")
 public ResponseEntity<String> deletefile(@PathVariable("id") Integer id){
	 musicservice.deletmusicfileById(id);
	 return new ResponseEntity<String>("employee deletetd suceffully",HttpStatus.OK);
	 
 }
  
}

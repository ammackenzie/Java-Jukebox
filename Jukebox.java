package jukebox;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.util.LinkedList;
import java.util.TreeSet;




public class Jukebox {
	
	private LinkedList <Song> playList = new LinkedList <Song> ();
	private final String FILE_NAME = "playList.ser";
	File myFile = new File("MyFile.txt");
	

	FileInputStream fis;
	FileOutputStream fos;
	PrintStream ps; 

	BufferedInputStream bis;
	BufferedReader br;
	
	public Jukebox(){}
	
	private void serialize() {
		try{
			//declare output streams
			FileOutputStream out = new FileOutputStream(this.FILE_NAME);
			ObjectOutputStream objOut = new ObjectOutputStream(out);
			
			//save data
			objOut.writeObject(this.playList);
			objOut.close();
		} catch(IOException e){
			e.printStackTrace();
		}
	}
	
	public void writeOutPlaylist(){
		try{
			fos = new FileOutputStream(this.myFile);
			
			ps = new PrintStream(fos);
			for(Song tempSong : this.playList){
				ps.println(tempSong.getTitle());
			}
			
		} catch(FileNotFoundException e){
			e.printStackTrace();
		} catch(IOException e){
			e.printStackTrace();
		} 
		
	}
	
	public void readInPlaylist(){
		try{
			fis = new FileInputStream(this.myFile);
			bis = new BufferedInputStream(fis);
			br  = new BufferedReader(new InputStreamReader(bis));
			
			while(br.ready()) {
				System.out.println(br.readLine());
			}
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	private void deserialize() {
		try{
			//declare input streams
			FileInputStream in = new FileInputStream(this.FILE_NAME);
			ObjectInputStream objIn = new ObjectInputStream(in);
			
			//assign playlist to loaded playlist
			this.playList = (LinkedList) objIn.readObject();
		} catch(ClassNotFoundException e){
			e.printStackTrace();
		} catch(IOException e){
			e.printStackTrace();
		}
	}
	
	public void savePlaylist(){
		serialize();
	}
	
	public void loadPlaylist(){
		deserialize();
	}
	
	public Jukebox(String triggerSample){
		
		Song s1 = new Song("Hello");
		Song s2 = new Song("Hungry Eyes");
		Song s3 = new Song("Take On Me");
		Song s4 = new Song("I Feel like a Woman");
		Song s5 = new Song("California Love");
		Song s6 = new Song("Big Papa");
		Song s7 = new Song("A Change is Gonna Come");
		
		LinkedList<Song> songs = new LinkedList<Song>();
		songs.add(s1);
		songs.add(s2);
		songs.add(s3);
		songs.add(s4);
		songs.add(s5);
		songs.add(s6);
		songs.add(s7);
		
		this.playList = songs;
	}
	
	public Jukebox(LinkedList<Song> input){
		this.playList = input;
	}
	public void addSong(Song s){
		this.playList.add(s);
	}
	
	public void play(){
		this.playList.removeFirst();
	}
	
	public String printPlayList(){
		String output = "";
		for ( Song tempSong : playList ){
			output += tempSong.getTitle();
			output += "\n";
		}
		
		return output;
	}
	
	
	//more complex methods
	
	public void sort(){
		TreeSet<Song> ordered = new TreeSet<Song>();
		for (Song tempSong : this.playList){
			ordered.add(tempSong);
		}
		this.playList.clear();
		
		for (Song tempSong : ordered){
			this.playList.add(tempSong);
		}
		
	}
	
	public void reverseSort(){
		TreeSet<Song> ordered = new TreeSet<Song>();
		for (Song tempSong : this.playList){
			ordered.add(tempSong);
		}
		
		
		this.playList.clear();
		
		for (Song tempSong : ordered){
			this.playList.addFirst(tempSong);;
		}
	}
	
	public int numberPopular(){
		int total = 0;
		for (Song tempSong : this.playList){
			if(tempSong.checkIfContains()){
				total++; 
			}
		}
		return total;
	}
	
	public int numberUnusual(){
		int total = 0;
		for (Song tempSong : this.playList){
			if(tempSong.checkIfContains()){
			   //do nothing
			} else {
				total++;
			}
		}
		return total;
	}
	
	public void removeSoppySongs(){
		LinkedList<Song> tempList = new LinkedList<Song>();
		String triggerWord = "love";
		for(Song tempSong : this.playList){
			try{
				if(tempSong.getTitle().toLowerCase().contains(triggerWord)){
					throw new noSoppyLoveSong();
				}
			}catch(noSoppyLoveSong e){
				tempList.add(tempSong);
			}
		}
		this.playList.removeAll(tempList);
	}
	
	public LinkedList<Song> getPlaylist(){
		return this.playList;
	}
	
	public boolean playlistContains(Song input){
		boolean contains = false;
		for(Song tempsong : this.playList){
			if(input.getTitle().matches(tempsong.getTitle())){
				contains = true;
			}
		}
		return contains;
	}
	
	public boolean playlistContains(String input){
		boolean contains = false;
		Song inputSong = new Song(input);
		for(Song tempsong : this.playList){
			if(inputSong.getTitle().toLowerCase().matches(tempsong.getTitle().toLowerCase())){
				contains = true;
			}
		}
		return contains;
	}

	public void removeSong(String input){
		
		LinkedList<Song> tempList = new LinkedList<Song>();
		for(Song tempSong : this.playList){
			if(tempSong.getTitle().toLowerCase().contentEquals(input.toLowerCase())){
				tempList.add(tempSong);
			}
		}
		this.playList.removeAll(tempList);
	}
}

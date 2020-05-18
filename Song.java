package jukebox;

import java.io.Serializable;

public class Song implements Comparable, Serializable{
	private String title;
	
	public Song(String title){
		setTitle(title);
	}
	
	public String getTitle(){
		return this.title;
	}
	
	public void setTitle(String title){
		this.title = title;
	}
	
	public String displayDetails(){
		String output = "";
		output += getTitle();
		return output;
	}

	public int compareTo(Object input) {
		Song tempSong = (Song) input;
		return this.getTitle().compareTo(tempSong.getTitle());
	}
	
	public boolean checkIfContains(){
		boolean doesItContain = false;
		String tempEnum;
		for (PopularSongTitleWords Popword : PopularSongTitleWords.values()){
			tempEnum = Popword.toString().toLowerCase();
			if(this.title.toLowerCase().contains(tempEnum)){
				doesItContain = true;
				break;
			}
		}
		return doesItContain;
	}


}
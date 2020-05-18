package jukebox;

import java.util.LinkedList;

import javax.swing.JOptionPane;
public class Test {

	public static void main(String[] args) {
		Song s1 = new Song("love");
		Song s2 = new Song("love again");
		Song s3 = new Song("i love love");
		Song s4 = new Song("a");
		Song s5 = new Song("girl");
		Song s6 = new Song("h");
		Song s7 = new Song("k");

		
		
		LinkedList<Song> songs = new LinkedList<Song>();
		songs.add(s1);
		songs.add(s2);
		songs.add(s3);
		songs.add(s4);
		songs.add(s5);
		songs.add(s6);
		songs.add(s7);
		
		
		Jukebox test = new Jukebox(songs);

		test.writeOutPlaylist();
		test.readInPlaylist();
		/*System.out.println("About to sort");
		test.sort();
		System.out.println("Just sorted");
		
		test.printPlayList();
		System.out.println("About to reverse");
		test.reverseSort();
		System.out.println("Just reversed");
		test.printPlayList();
		
		
		int popular = test.numberPopular();
		int unpopular = test.numberUnusual();
		
		System.out.println("Popular : " + popular);
		System.out.println("Unpopular: " + unpopular);
		*/
		
		
		/*String test1 = "hello";
		String test2 = "hello";
		
		if(test1.matches(test2)){
			System.out.println("It works!");
		} else{
			System.out.println("NAH SON!");
		}*/
		
		
	}


}

package jukebox;

import java.util.LinkedList;

import junit.framework.TestCase;

public class JukeboxTest extends TestCase {

	public void testPrintPlayList() {
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
		
		test.printPlayList();
		
	}

	public void testNumberPopular() {
		fail("Not yet implemented");
	}

	public void testNumberUnusual() {
		fail("Not yet implemented");
	}

	public void testRemoveSoppySongs() {
		
		Song s1 = new Song("love");
		Song s2 = new Song("love again");
		Song s3 = new Song("a");

		LinkedList<Song> testing = new LinkedList<Song>();
		testing.add(s3);
		Jukebox expected = new Jukebox(testing);
		
		LinkedList<Song> songs = new LinkedList<Song>();
		songs.add(s1);
		songs.add(s2);
		songs.add(s3);
		Jukebox actual = new Jukebox(songs);
		
		actual.removeSoppySongs();
		assertTrue(expected.getPlaylist().size() == actual.getPlaylist().size() && actual.playlistContains(expected.getPlaylist().getFirst()));
		
		
		
		
	}

}

package musicCollection;

import org.junit.Test;

public class MusicCollectionTest {


	public void testMusicCollection() {
		MusicCollection m = new MusicCollection("Test");
		assertNotNull(m);
		assertEquals(0,m.getTotalTracks());
		assertEquals("Test",m.getName());
	}

	@Test
	public void testSetName() {
		MusicCollection m = new MusicCollection("Test");
		m.setName("Second test");
		assertEquals("Second test",m.getName());
	}

	@Test
	public void testAddTrack() {
		MusicCollection m = new MusicCollection("Test");
		Track tr = new Track("Title", "Artist", "Album", 0, 127);
		m.addTrack(tr);
		assertEquals(tr, m.removeTrack("Title", "Album"));		
	}

	@Test
	public void testRenameTrack() {
		MusicCollection m = new MusicCollection("Test");
		Track tr = new Track("Title", "Artist", "Album", 0, 127);
		m.addTrack(tr);
		m.renameTrack("Title", "Album", "New title");

		try{
			if(m.removeTrack("Title", "Album")!=null)
				fail();
		}catch (Exception OK){}
		
		Track tr1 = m.getMostPlayed();
		assertEquals(tr1, m.removeTrack("New title", "Album"));
	}

	@Test
	public void testRemoveAll() {
		MusicCollection m = new MusicCollection("Test");
		Track tr = new Track("Title", "Artist", "Album", 0, 127);
		Track tr1 = new Track("Title2", "Artist2", "Album2", 0, 234);
		Track tr2 = new Track("Title3", "Artist3", "Album3", 0, 232);
		Track tr3 = new Track("Title4", "Artist4", "Album4", 0, 63);
		m.addTrack(tr);
		m.addTrack(tr1);
		m.addTrack(tr2);
		m.addTrack(tr3);
		
		assertEquals(4, m.getTotalTracks());
		
		m.removeAll();
		
		try{
			if(m.removeTrack("Title", "Album")!=null)
				fail();
		}catch (Exception OK){}
		try{
			if(m.removeTrack("Title2", "Album2")!=null)
				fail();
		}catch (Exception OK){}
		try{
			if(m.removeTrack("Title3", "Album3")!=null)
				fail();
		}catch (Exception OK){}
		try{
			if(m.removeTrack("Title4", "Album4")!=null)
				fail();
		}catch (Exception OK){}
		
		
	}

	@Test
	public void testPlayTrack() {
		MusicCollection m = new MusicCollection("name");
		int time = 0;
		Track tr;
		
		m.addTrack(new Track("title", "artist", "album", 0 ,180));
		m.playTrack("title", "album");
		time = m.getTotalTime();
		tr = m.getMostPlayed();
		assertEquals(time, 180);
		assertEquals(tr.getPlays(), 1);
		m.playTrack("title", "album");
		assertEquals(360, m.getTotalTime());
	}

	@Test
	public void testGetMostPlayed() {
		MusicCollection m = new MusicCollection("Test");
		Track tr = new Track("Title", "Artist", "Album", 0, 127);
		Track tr1 = new Track("Title2", "Artist2", "Album2", 0, 234);
		Track tr2 = new Track("Title3", "Artist3", "Album3", 0, 232);
		m.addTrack(tr);
		m.addTrack(tr1);
		m.addTrack(tr2);

		m.playTrack("Title", "Album");
		m.playTrack("Title2", "Album2");
		m.playTrack("Title2", "Album2");
		m.playTrack("Title3", "Album3");
		m.playTrack("Title3", "Album3");
		m.playTrack("Title2", "Album2");

		assertEquals(tr1, m.getMostPlayed());
	}

}

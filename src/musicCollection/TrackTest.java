package musicCollection;

import org.junit.Test;

public class TrackTest {

	@Test
	public void testTrack() {
		Track tr = new Track("onoma", "artist", "album", 0, 188);
		assertEquals(tr.getTitle(), "onoma");
		assertEquals(tr.getArtist(), "artist");
		assertEquals(tr.getAlbum(), "album");
		assertEquals(tr.getPlays(), 0);
		assertEquals(tr.getDuration(), 188);
	}

	@Test
	public void testSetTitle() {
		Track tr = new Track("onoma", "artist", "album", 0, 188);
		tr.setTitle("neo onoma");
		assertEquals(tr.getTitle(), "neo onoma");
	}

	@Test
	public void testSetArtist() {
		Track tr = new Track("onoma", "artist", "album", 0, 188);
		tr.setArtist("neos artist");
		assertEquals(tr.getArtist(), "neos artist");
	}

	//@Test
	public void testSetAlbum() {
		Track tr = new Track("onoma", "artist", "album", 0, 188);
		tr.setAlbum("neo album");
		assertEquals(tr.getAlbum(), "neo album");
	}

	//@Test
	public void testPlay() {
		Track tr = new Track("onoma", "artist", "album", 0, 188);
		tr.play();
		tr.play();
		tr.play();
		assertEquals(tr.getPlays(), 3);
	}

}

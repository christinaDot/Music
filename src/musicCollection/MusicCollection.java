package musicCollection;

import java.util.*;

//This class implements an Abstract Data Type of a music collection

public class MusicCollection {
	private String name;
	private int total;
	private LinkedList<Track> trackList;
	
	
	//Private method
	private int getIndexOf(String title, String album){
		for(Track tr : this.trackList)
			if(tr.getTitle().equals(title) & tr.getAlbum().equals(album))
				return this.trackList.indexOf(tr);
		return -1;
	}

	
	
	//**Constructor**//
	// Creates an empty MusicCollection with name newName
	public MusicCollection(String newName){
		this.name = newName;
		this.total = 0;
		this.trackList = new LinkedList<Track>();
	}
	
	public String getName(){
		return this.name;
	}


	public void setName(String newName){
		this.name = newName;
	}

	//Inserts the given song into the track list of the music collection and increases the counter of the tracks in the track list by 1
	
	 
	public boolean addTrack(Track newTrack){
		boolean ret = this.trackList.add(newTrack);
		this.total++;
		
		return ret;
	}
	
	//Removes the track with the given track and album titles from the tracklist and decreases the counter of the tracks in the track list by 1
	
	public Track removeTrack(String title, String album){
		int i;
		Track tr;
		
		i = this.getIndexOf(title, album);
		if(i != -1){
			tr = this.trackList.remove(i);
			this.total--;
			return tr;
		}
		else
			throw new IllegalArgumentException("The track with title \"" + title + "\" and album title \"" + album +"\" is not present in the track list\n");
	}
	
	//Renames the track with the given title and album title into newTitle
	
	public void renameTrack(String oldTitle, String album, String newTitle){
		int i;
		
		i = this.getIndexOf(oldTitle, album);
		if(i != -1){
			Track newTrack = this.trackList.get(i);
			newTrack.setTitle(newTitle);
		}
		else
			throw new IllegalArgumentException("The track with title \"" + oldTitle + "\" and album title \"" + album +"\" is not present in the track list\n");
	}

	//Changes the track album of the track with the given title and album title into newAlbum
	
	public void setAlbum(String title, String oldAlbum, String newAlbum){
		int i;
		
		i = this.getIndexOf(title, oldAlbum);
		if(i != -1){
			Track newTrack = this.trackList.get(i);
			newTrack.setAlbum(newAlbum);
		}
		else
			throw new IllegalArgumentException("The track with title \"" + title + "\" and album title \"" + oldAlbum +"\" is not present in the track list\n");
	}

	// Changes the track artist of the track with the given title and album title into newArtist
	 
	public void setArtist(String title, String album, String newArtist){
		int i;
		
		i = this.getIndexOf(title, album);
		if(i != -1){
			Track newTrack = this.trackList.get(i);
			newTrack.setArtist(newArtist);
		}
		else
			throw new IllegalArgumentException("The track with title \"" + title + "\" and album title \"" + album +"\" is not present in the track list\n");
	}

	// Increases the plays of the track with the given track and album titles
	 
	public void playTrack(String title, String album){
		int i;
		i = this.getIndexOf(title, album);
		if(i != -1){
			Track newTrack = this.trackList.get(i);
			newTrack.play();
		}
		else
			throw new IllegalArgumentException("The track with title \"" + title + "\" and album title \"" + album +"\" is not present in the track list\n");
	}
	
	//Returns the total number of tracks in the track list of the collection
	
	public int getTotalTracks(){
		return this.total;
	}
		
	// Returns the total play time of all the track list
	
	public int getTotalTime(){
		int totalTime = 0;
		for(Track tr : this.trackList)
			totalTime += tr.getPlays()*tr.getDuration();
		return totalTime;
	}
	
	//Returns the most played track in the track list
	
	public Track getMostPlayed(){
		int plays = -1;
		Track mostplayed = null;
		
		for(Track tr : this.trackList)
			if(tr.getPlays() > plays){
				mostplayed = tr;
				plays = mostplayed.getPlays();
			}
		
		return mostplayed;
	}
	
	// Removes all the tracks from the track list
	
	public void removeAll(){
		this.trackList.clear();
		this.total = 0;
	}
	
	//Returns the string representation of this
	 
	public String toString() {
        StringBuilder sb = new StringBuilder();
        int count = 1;
        
        sb.append("Music collection: " + this.getName());
        sb.append("\n------------------------------------------\n\n");
        for (Track tr : this.trackList) {
        	sb.append("Track "+ count + "\n");
        	sb.append("---------\n");
        	sb.append(tr.toString());
        	sb.append("---------\n");
            count++;
        }
        
        return sb.toString();
    }
}

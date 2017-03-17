package musicCollection;

public class Track {

	private String title;
	private String artist;
	private String album;
	private int plays;
	private int duration;
	
	

	public Track(String newTitle, String newArtist, String newAlbum, int newPlays, int newDuration){
		this.title = newTitle;
		this.artist = newArtist;
		this.album = newAlbum;
		this.plays = newPlays;
		this.duration = newDuration;
	}
	
	
	public String getTitle(){
		return this.title;
	}

	
	public void setTitle(String newTitle){
		this.title = newTitle;
	}

	
	public String getArtist(){
		return this.artist;
	}
	
	
	public void setArtist(String newArtist){
		this.artist = newArtist;
	}

	
	public String getAlbum(){
		return this.album;
	}
	
	
	public void setAlbum(String newAlbum){
		this.album = newAlbum;
	}

	
	public int getPlays(){
		return this.plays;
	}
	
	
	public int getDuration(){
		return this.duration;
	}
	
	
	public void play(){
		this.plays++;
	}
	
	// Returns the string representation of this
	 
	public String toString(){
        StringBuilder sb = new StringBuilder();
    	
    	sb.append("Track title:\t");
    	sb.append(this.getTitle());
        sb.append("\n");
    	sb.append("Track artist:\t");
    	sb.append(this.getArtist());
        sb.append("\n");            
    	sb.append("Track album:\t");
    	sb.append(this.getAlbum());
        sb.append("\n");
    	sb.append("Track duration:\t");
    	sb.append(this.getDuration());
        sb.append(" (seconds)\n");
    	sb.append("Track plays:\t");
    	sb.append(this.getPlays());
        sb.append("\n");   

        return sb.toString();
	}
}

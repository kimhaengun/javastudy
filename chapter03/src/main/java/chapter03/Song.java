package chapter03;

public class Song {
	private String title;
	private String artist;
	private String album;
	private String composer;
	private int year;
	private String track;
	
	//생성자 오버로딩
	public Song(String title, String artist) {
//		this.title = title;
//		this.artist = artist;
		this(title,artist,null,null,0,null);
	}
	
	//생성자
	public Song(String title, String artist, String album, String composer, int year, String track) {
		this.title = title;
		this.artist = artist;
		this.album = album;
		this.composer = composer;
		this.year = year;
		this.track = track;
		System.out.println("some code~");
	}
	
	public String getTitle() {
		return title;
	}
	void show() {
		System.out.println(artist+" "+title+" "+"("+album+","+year+","+track+","+composer+")");
	}
	public void setTitle(String title) {
		this.title = title;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public String getAlbum() {
		return album;
	}

	public void setAlbum(String album) {
		this.album = album;
	}

	public String getComposer() {
		return composer;
	}

	public void setComposer(String composer) {
		this.composer = composer;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getTrack() {
		return track;
	}

	public void setTrack(String track) {
		this.track = track;
	}

	
	
}

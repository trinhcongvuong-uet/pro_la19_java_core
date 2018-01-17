/**
 * Copyright C Luvina JSC
 */
package items;

/**
 * @author Trịnh Công Vượng
 *
 */
public class TblCDs {
	private String artist;
	private String title;
	
	/**
	 * @param artist: Tên nghệ sĩ
	 * @param title: Tên CD
	 */
	public TblCDs(String artist, String title) {
		this.artist = artist;
		this.title = title;
	}

	
	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Artist:\t" + artist +"\nTitle:\t" + title;
	}
	
	
}

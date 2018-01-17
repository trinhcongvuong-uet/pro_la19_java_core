/**
 * Copyright C Luvina JSC
 */
package connections;

import java.util.Scanner;

import items.TblCDs;

/**
 * @author Trịnh Công Vượng
 *
 */
public class FillDatabase {
	private TblCDs tblCDs;
	
	public FillDatabase() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter artist:\t");
		String artist = scanner.nextLine();
		System.out.print("Enter title:\t");
		String title = scanner.nextLine();
		tblCDs = new TblCDs(artist, title);
	}

	public TblCDs getTblCDs() {
		return tblCDs;
	}

	public void setTblCDs(TblCDs tblCDs) {
		this.tblCDs = tblCDs;
	}
	
	
}

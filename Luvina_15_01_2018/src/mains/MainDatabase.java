/**
 * Copyright C Luvina JSC
 * 
 */
package mains;

import java.util.ArrayList;
import java.util.Scanner;

import connections.CDDatabase;
import connections.FillDatabase;
import items.TblCDs;

/**
 * @author Trịnh Công Vượng
 *
 */
public class MainDatabase {
	public static void main(String[] args) {
		CDDatabase cdDatabase = new CDDatabase();
		while (true) {
			System.out.println("Enter 1: Insert CD to database.");
			System.out.println("Enter 2: Remove CD from database.");
			System.out.println("Enter 3: Search list CD from database by title.");
			System.out.println("Enter 4: Search list CD from database by artist.");
			System.out.println("Enter different value: Repeat enter.");
			String choose = new Scanner(System.in).nextLine();
			switch (choose) {
			case "1":
				insertCD(cdDatabase);
				break;
			case "2":
				removeCD(cdDatabase);
				break;
			case "3":
				findByTitle(cdDatabase);
				break;
			case "4":
				findByArtist(cdDatabase);
				break;

			default:
				break;
			}
		}
	}

	private static void insertCD(CDDatabase cdDatabase) {
		// TODO Auto-generated method stub
		FillDatabase database = new FillDatabase();
		boolean isInsert = cdDatabase.insertCD(database.getTblCDs());
		if (isInsert) {
			System.out.println("Insert suscess.");
		} else {
			System.out.println("Insert fail.");
		}
	}

	private static void removeCD(CDDatabase cdDatabase) {
		// TODO Auto-generated method stub
		FillDatabase database = new FillDatabase();
		boolean isRemove = cdDatabase.removeCD(database.getTblCDs());
		if (isRemove) {
			System.out.println("Remove suscess.");
		} else {
			System.out.println("Remove fail.");
		}
	}

	private static void findByTitle(CDDatabase cdDatabase) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter title search:\t");
		String title = scanner.nextLine();
		ArrayList<TblCDs> listCDs = cdDatabase.findByTitle(title);
		if(listCDs == null) {
			System.out.println("Empty.");
		}else {
			for (TblCDs tblCDs : listCDs) {
				System.out.println(tblCDs);
			}
		}
	}

	private static void findByArtist(CDDatabase cdDatabase) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter artist search:\t");
		String artist = scanner.nextLine();
		ArrayList<TblCDs> listCDs = cdDatabase.findByArtist(artist);
		if(listCDs == null) {
			System.out.println("Empty.");
		}else {
			for (TblCDs tblCDs : listCDs) {
				System.out.println(tblCDs);
			}
		}
	}

}

/**
 * Copyright C Luvina JSC
 */
package items;

/**
 * @author Trịnh Công Vượng
 *
 */
public class SQLQuery {
	public static final String CREATE_DATABASE  = "create database if not exists CDs character set utf8;";
	public static final String CONNECT_DATABASE = "use CDs;";
	public static final String CREATE_TABLE_CDS = "create table if not exists CDs"
			+ "(artist varchar(45) not null, title varchar(255) not null, primary key(artist,title));";
	public static final String SHOW_ALL_CDs = "select * from CDs;";
	public static final String INSERT_CDS = "insert into CDs values(?,?);";
	public static final String REMOVE_CDS = "delete from CDs where artist = ? and title = ?;";
	public static final String SEARCH_TITLE = "select * from CDs where title = ?;";
	public static final String SEARCH_ARTIST = "select * from CDs where artist = ?;";
}

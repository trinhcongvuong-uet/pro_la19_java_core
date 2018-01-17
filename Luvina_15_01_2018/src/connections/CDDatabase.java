/**
 * Copyright C Luvina JSC
 */
package connections;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import items.SQLQuery;
import items.TblCDs;

/**
 * @author Trịnh Công Vượng
 *
 */
public class CDDatabase {
	private static final String URL_MYSQL = "jdbc:mysql://localhost:3306?useSSL=false";
	private static final String ACCOUNT_MYSQL = "root";
	private static final String PASSWORD_MYSQL = "vuong411995";

	private Connection connection = null;
	private Statement statement = null;

	public CDDatabase() {
		connection();
		createDatabase();
		connectDatabase();
		createTable();
	}

	public boolean insertCD(TblCDs cds) {
		try {
			checkConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(SQLQuery.INSERT_CDS);
			preparedStatement.setString(1, cds.getArtist());
			preparedStatement.setString(2, cds.getTitle());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean removeCD(TblCDs cds) {
		try {
			checkConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(SQLQuery.REMOVE_CDS);
			preparedStatement.setString(1, cds.getArtist());
			preparedStatement.setString(2, cds.getTitle());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public ArrayList<TblCDs> findByArtist(String artist) {
		ArrayList<TblCDs> listCDs = new ArrayList<TblCDs>();
		ResultSet resultSet = null;
		try {
			checkConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(SQLQuery.SEARCH_ARTIST);
			preparedStatement.setString(1, artist);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				listCDs.add(new TblCDs(resultSet.getString("artist"), resultSet.getString("title")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return listCDs;
		}
		return listCDs;
	}
	
	public ArrayList<TblCDs> findByTitle(String title) {
		ArrayList<TblCDs> listCDs = new ArrayList<TblCDs>();
		ResultSet resultSet = null;
		try {
			checkConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(SQLQuery.SEARCH_TITLE);
			preparedStatement.setString(1, title);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				listCDs.add(new TblCDs(resultSet.getString("artist"), resultSet.getString("title")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return listCDs;
		}
		return listCDs;
	}
	
	public ArrayList<TblCDs> findAll(){
		ArrayList<TblCDs> listCDs = new ArrayList<TblCDs>();
		ResultSet resultSet = null;
		try {
			checkConnection();
			resultSet = statement.executeQuery(SQLQuery.SHOW_ALL_CDs);
			while (resultSet.next()) {
				listCDs.add(new TblCDs(resultSet.getString("artist"), resultSet.getString("title")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return listCDs;
		}
		return listCDs;
	}

	public void connectDatabase() {
		try {
			checkConnection();
			statement.executeUpdate(SQLQuery.CONNECT_DATABASE);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void createDatabase() {
		try {
			statement.executeUpdate(SQLQuery.CREATE_DATABASE);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void createTable() {
		try {
			statement.executeUpdate(SQLQuery.CREATE_TABLE_CDS);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void connection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(URL_MYSQL, ACCOUNT_MYSQL, PASSWORD_MYSQL);
			statement = connection.createStatement();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void disConnect() {
		try {
			if (!connection.isClosed()) {
				connection.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void checkConnection() throws SQLException {
		if (connection == null || connection.isClosed()) {
			connection();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#finalize()
	 */
	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		disConnect();
	}

}

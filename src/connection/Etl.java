package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Etl
{
	public static void main(String[] args) throws ParseException
	{		
		SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		Date data = fmt.parse("29/05/2019 10:00"); 
		String str = fmt.format(data); 
		
		System.out.println(data);
		System.out.println(str);
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://www.db4free.net:3306/edu_ffiaux", "edu_ffiaux",
					"6l00dy88");
		} catch (ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
		}
	}

	private static void insert(Connection conn) throws SQLException
	{
		String insertTableSQL = "INSERT INTO DBUSER"
				+ "(USER_ID, USERNAME, CREATED_BY, CREATED_DATE) VALUES"
				+ "(?,?,?,?)";
		PreparedStatement preparedStatement = conn.prepareStatement(insertTableSQL);

		preparedStatement.setInt(1, 11);
		preparedStatement.setString(2, "mkyong");
		preparedStatement.setString(3, "system");
		preparedStatement.setTimestamp(4, new Timestamp(new Date().getTime()));

		// execute insert SQL stetement
		preparedStatement.executeUpdate();
	}

	private static void update(Connection conn) throws SQLException
	{
		String updateTableSQL = "UPDATE DBUSER SET USERNAME = ? WHERE USER_ID = ?";
		PreparedStatement preparedStatement = conn.prepareStatement(updateTableSQL);
		preparedStatement.setString(1, "mkyong_new_value");
		preparedStatement.setInt(2, 1001);
		// execute insert SQL stetement
		preparedStatement.executeUpdate();
	}

	private static void delete(Connection conn) throws SQLException
	{
		String deleteSQL = "DELETE DBUSER WHERE USER_ID = ?";
		PreparedStatement preparedStatement = conn.prepareStatement(deleteSQL);
		preparedStatement.setInt(1, 1001);
		// execute delete SQL stetement
		preparedStatement.executeUpdate();
	}

	private static void select(Connection conn) throws SQLException
	{
		String selectSQL = "SELECT USER_ID, USERNAME FROM DBUSER WHERE USER_ID = ?";
		PreparedStatement preparedStatement = conn.prepareStatement(selectSQL);
		preparedStatement.setInt(1, 1001);
		ResultSet rs = preparedStatement.executeQuery(selectSQL);
		while (rs.next())
		{
			String userid = rs.getString("USER_ID");
			String username = rs.getString("USERNAME");
		}
	}
}
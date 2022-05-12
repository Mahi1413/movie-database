package mypackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MyClass {

	public static void main(String[] args) {
		String jdbcUrl = "jdbc:sqlite:C:\\sqlite\\sqlite-tools-win32-x86-3380500\\mydb.db";
		try {
			Connection connection = DriverManager.getConnection(jdbcUrl);
			String sql = "SELECT*FROM movie";
			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery(sql);
			while (result.next())
			{
				String name = result.getString("moviename");
				String actor = result.getString("actor");
				String actress= result.getString("actress");
				String year = result.getString("year"+"");
				String directorname = result.getString("directorname");
				System.out.println(name + " " +actor +" "+ actress + " "+year +" "+ directorname);
			}
		} catch (SQLException e) {
			System.out.println("error connecting to SQLite database");
			e.printStackTrace();
		}
		
		

	}

}

package mypackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class ActorSearch {

	public static void main(String[] args) {
		String jdbcUrl = "jdbc:sqlite:C:\\sqlite\\sqlite-tools-win32-x86-3380500\\mydb.db";
		try {
			Scanner sc=new Scanner(System.in);
																
			Connection connection = DriverManager.getConnection(jdbcUrl);
			System.out.println("Enter Actor name");
			String act=sc.next();
			String sql = "SELECT moviename FROM movie where actor=? ";
			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setString(1,act);
			ResultSet result = pstmt.executeQuery();
			while (result.next()) {
				String name = result.getString("moviename");
				
				System.out.println("Movie Name="+name );
				System.out.println();
				
											
			}
			
		} catch (SQLException e) {
			System.out.println("error connecting to SQLite database ");
			e.printStackTrace();
		}
		
		

		}
	}


package pro_06_19_project;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.sql.ResultSet;

public class Db_Repository {

	public ArrayList<LoginModel> getLoginInfo()
	{
		ArrayList<LoginModel> login_list = new ArrayList<LoginModel>();
		
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java_db","root","");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from " + "login");

			while(rs.next())
			{
//				System.out.println("\nUsername: " + rs.getString(1));
//				System.out.println("Password: " + rs.getString(2));
//				System.out.println("Type: " + rs.getString(3));
				login_list.add(new LoginModel(rs.getString(1), rs.getString(2), rs.getString(3)));
			}
	
			con.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return login_list;
	}
	
	public ArrayList<Orphan_Info> getOrphanInfo()
	{
		ArrayList<Orphan_Info> orphan_list = new ArrayList<Orphan_Info>();

		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java_db","root","");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from " + "orphan_info");

			while(rs.next())
			{
//				System.out.println("\nId: " + rs.getInt(1));
//				System.out.println("Name: " + rs.getString(2));
//				System.out.println("Adopter Id: " + rs.getInt(6));
				orphan_list.add(new Orphan_Info(rs.getInt(1), rs.getString(2), rs.getInt(6)));
			}
	
			con.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return orphan_list;
	}
	
	public ArrayList<Adopter_Background_Info> getAdopterInfo()
	{
		ArrayList<Adopter_Background_Info> adopter_list = new ArrayList<Adopter_Background_Info>();

		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java_db","root","");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from adopter_info inner join adopter_background_info ON adopter_info.adopter_id = adopter_background_info.adopter_id");
			
			while(rs.next())
			{
//				System.out.println("\nId: " + rs.getInt(1));
//				System.out.println("Name: " + rs.getString(2));
//				System.out.println("Orphan Id: " + rs.getInt(3));
//				System.out.println("Date of adoption: " + rs.getString(4));
//				System.out.println("gender: " + rs.getString(7));
//				System.out.println("Marital Status: " + rs.getString(10));
//				System.out.println("Income: " + rs.getInt(11));
				adopter_list.add(new Adopter_Background_Info(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(7), rs.getString(10), rs.getInt(11)));
			}
	
			con.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return adopter_list;
	}
	
	public void setOrphanInfo(int id, String name, int adopterId)
	{
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java_db","root","");
			PreparedStatement st = con.prepareStatement("insert into orphan_info values(?,?,?,?,?,?)");
			st.setInt(1, id);
			st.setString(2, name);
			st.setDate(3, new Date(0,0,0));				// dummy data
			st.setString(4, "male");					// dummy data
			st.setInt(5, 2);							// dummy data
			st.setInt(6, adopterId);
			
			if(st.executeUpdate() == 1)
			{
				System.out.println("Data inserted successfully");
			}
			else
			{
				System.out.println("Data not inserted. Try Again.");
			}
	
			con.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}		
	}
	
	public void setAdopterInfo(int id, String name, int orphanId, Date date, String gender, String maritalStatus, int income)
	{
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java_db","root","");
			PreparedStatement st = con.prepareStatement("insert into adopter_info values(?,?,?,?)");
			st.setInt(1, id);
			st.setString(2, name);
			st.setInt(3, orphanId);
			st.setDate(4, date);
			
			if(st.executeUpdate() == 1)
			{
				System.out.println("Data inserted successfully");
			}
			else
			{
				System.out.println("Data not inserted. Try Again.");
			}
			
			PreparedStatement st1 = con.prepareStatement("insert into adopter_background_info values(?,?,?,?,?,?,?)");
			st1.setInt(1, id);
			st1.setDate(2, new Date(0,0,0));					// dummy data
			st1.setString(3, gender);
			st1.setString(4, "Service");					// dummy data
			st1.setString(5, "India");						// dummy data
			st1.setString(6, maritalStatus);
			st1.setInt(7, income);
			
			
			if(st1.executeUpdate() == 1)
			{
				System.out.println("Data inserted successfully");
			}
			else
			{
				System.out.println("Data not inserted. Try Again.");
			}
	
			con.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}		
	}

	public static void main(String[] args) {
//		new Db_Repository().getLoginInfo();
//		new Db_Repository().getOrphanInfo();
//		new Db_Repository().getAdopterInfo();
//		new Db_Repository().setOrphanInfo(777, "NNN", 777);
//		new Db_Repository().setAdopterInfo(777, "NNN", 777, new Date(0,0,0), "male", "single", 777777);
	}

}

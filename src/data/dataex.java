package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class dataex {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String url="jdbc:mysql://192.168.169.135:3306/student";
		String user="root";
		String password="123456";
		ResultSet rs=null;
		PreparedStatement ptsm =null;
		Connection con =null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url, user, password);
			ptsm = con.prepareStatement("select * from student");
			rs=ptsm.executeQuery();
			System.out.println(rs);
			while(rs.next()) {
			System.out.println(rs.getInt("sno")+" "+rs.getString("sname"));}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
				try {
					if (rs!=null)
					    rs.close();
					if(ptsm!=null)
						ptsm.close();
					if(con!=null)
						con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}

}

package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class dataad {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String url="jdbc:mysql://192.168.169.135:3306/student?useUnicode=true&characterEncoding=utf8";
		String user="root";
		String password="123456";
		Connection con =null;
		PreparedStatement pstm = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			 con=DriverManager.getConnection(url, user, password);
			 pstm=con.prepareStatement("insert into student(sno,sname,ssex) values(?,?,?)");
			 pstm.setString(1,"128");
			 pstm.setString(2,"ÕÅ¾ü");
			 pstm.setString(3,"ÄÐ");
			
			 int i=pstm.executeUpdate();
			 System.out.println(i);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
			
				if(pstm!=null)
					pstm.close();
				if(con!=null)
					con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	}

}

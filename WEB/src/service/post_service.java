package service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import dbconection.dbconection;
import model.post;

public class post_service {
	static private Statement statement = null;
	static private PreparedStatement preparedStatement = null;
	static private ResultSet resultSet = null;

	static dbconection db = new dbconection();
	
	public static List<post> LayPost() {
		try {
			db.conecToDB(); // Mở kết nối CSDL
			statement = db.conect.createStatement();
			resultSet = statement.executeQuery("select * from " + db.database + ".post");

			List<post> post= new ArrayList<post>(); 

			while (resultSet.next()) {
				String idpost = resultSet.getString("idpost");
				String tieude = resultSet.getString("tieude");
				String hinhanh = resultSet.getString("hinhanh");
				String diachi = resultSet.getString("diachi");

				post p = new post(); 
				p.setIdpost(idpost);
				p.setTieude(tieude);
				p.setHinhanh(hinhanh);
				p.setDiachi(diachi);
				post.add(p); 

			}

			return post;
		} catch (Exception e) {
			System.out.println("Error getting post !!");
		} finally {
			db.close();// đóng kết nối CSDL
		}
		return null;
	}

	// Hàm lấy sản phẩm dựa vào idpost
	public static post Layposttheoid(String id) {
		try {
			db.conecToDB(); // Mở kết nối CSDL
			statement = db.conect.createStatement();
			System.out.println(1234);
			resultSet = statement
					.executeQuery("select * from " + db.database + ".post where idpost='" + id + "'");

			if (resultSet.next()) {
				String idpost = resultSet.getString("idpost");
				String tieude = resultSet.getString("tieude");
				String hinhanh = resultSet.getString("hinhanh");
				String diachi = resultSet.getString("diachi");
				System.out.println(resultSet);
				post p = new post(); 
				p.setIdpost(idpost);
				p.setTieude(tieude);
				p.setHinhanh(hinhanh);
				p.setDiachi(diachi);

				return p;

			} else {
				return null;
			}

		} catch (Exception e) {
			System.out.println("Error getting product by id !!");
			return null;
		} finally {
			db.close();// đóng kết nối CSDL
		}
	}

}

package dic.dao;

import dic.model.User;
import dic.dao.Database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.PreparedStatement;


public class UserDAO {
	
	public ArrayList<User> getUsers(String s) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{
		
		ArrayList<User> userList = new ArrayList<User>();
		Database db = new Database();
		Connection connection = db.getConnection();
		
		try{
			PreparedStatement ps = connection.prepareStatement("SELECT * FROM user WHERE name like ?");
			ps.setString(1, "%" +s+"%");
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				User user = new User();
				user.setId(rs.getString("id"));
				user.setName(rs.getString("name"));
				userList.add(user);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return userList;
	}
}

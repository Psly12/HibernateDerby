package dic.dao;

import dic.model.ODictionary;
import dic.dao.Database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.PreparedStatement;


public class DictionaryDAO {
	
	public ArrayList<ODictionary> getWords(String s) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{
		
		ArrayList<ODictionary> wordList = new ArrayList<ODictionary>();
		Database db = new Database();
		Connection connection = db.getConnection();
		
		try{
			PreparedStatement ps = connection.prepareStatement("SELECT * FROM dictionary WHERE words like ?");
			ps.setString(1, "%" +s+"%");
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				ODictionary dic = new ODictionary();
				dic.setWord(rs.getString("words"));
				dic.setMeaning(rs.getString("meaning"));
				wordList.add(dic);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return wordList;
	}
}

package com.skilldistillery.filmquery.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.skilldistillery.filmquery.entities.Actor;
import com.skilldistillery.filmquery.entities.Film;

public class DatabaseAccessorObject implements DatabaseAccessor {
	private static final String URL = "jdbc:mysql://localhost:3306/sdvid?useSSL=false&useLegacyDatetimeCode=false&serverTimezone=US/Mountain";
  
	@Override
  public Film findFilmById(int filmId) {
	  Film film = null;
	  String user = "student";
	  String pass = "student";
	  try {
	  Connection conn = DriverManager.getConnection(URL, user, pass);
	  	//					1	 2			3			4			5	
	  String sql = "SELECT id, title, description, release_year, language_id, "
			  //     6				7			8			9		
	  		+ "rental_duration, rental_rate, length, replacement_cost, "
	  		//	 10 		  11        
	  		+ "rating, special_features FROM film WHERE id=?";
	  
	  PreparedStatement stmt = conn.prepareStatement(sql);
	  stmt.setInt(1 ,filmId);
	  
	  ResultSet rs = stmt.executeQuery();
	  
	  if(rs.next())
	  {
		  film = new Film(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), 
				  rs.getInt(5), rs.getInt(6), rs.getDouble(7), rs.getInt(8), rs.getDouble(9), 
				  rs.getString(10), rs.getString(11));
		  
	  }
	  rs.close();
	  stmt.close();
	  conn.close();
	  
	  }catch(SQLException e){
		  e.printStackTrace();
	  }
	  
    return film;
  }

@Override
public Actor findActorById(int actorId) {
	Actor actor = null;
	  String user = "student";
	  String pass = "student";
	try {
		Connection conn = DriverManager.getConnection(URL, user, pass);
		String sqltext= "Select actor.id, actor.first_name, actor.last_name FROM actor";
		
		PreparedStatement stmt = conn.prepareStatement(sqltext);
		ResultSet rs = stmt.executeQuery();
		if(rs.next())
		{
			actor = new Actor();
			actor.setId(rs.getInt(1));
			actor.setFirst_name(rs.getString(2));
			actor.setLast_name(rs.getString(3));
		}
		
		
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	
	return null;
}



@Override
public List<Actor> findActorsByFilmId(int filmId) {
	List<Actor> actorList = new ArrayList<Actor>();
	 String user = "student";
	  String pass = "student";
	  try {
	  Connection conn = DriverManager.getConnection(URL, user, pass);
	  	//					1		2			3	
	  String sql = "\n"
	  		+ "SELECT film.id, actor.id, actor.first_name, actor.last_name \n"
	  		+ "	FROM film JOIN film_actor\n"
	  		+ "		ON film.id = film_actor.film_id\n"
	  		+ "	JOIN actor\n"
	  		+ "		ON actor.id=film_actor.actor_id\n"
	  		+ "	WHERE film.id?";
	  
	  PreparedStatement stmt = conn.prepareStatement(sql);
	  stmt.setInt(1 ,filmId);
	  
	  ResultSet rs = stmt.executeQuery();
	  
	  if(rs.next())
	  {
		  Actor actor = new Actor();
		  actor.setId(rs.getInt(1));
		  actor.setFirst_name(rs.getString(3));;
		  actor.setLast_name(rs.getString(4));;
		  
		  
		  actorList.add(actor);
		 
		  
	  }
	  rs.close();
	  stmt.close();
	  conn.close();
	  
	  }catch(SQLException e){
		  e.printStackTrace();
	  }
	  
	
	
	
	return actorList;
}

static {
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
	} catch (ClassNotFoundException e) {
		System.out.println("Unable to load MySql driver");
		e.printStackTrace();

	}
}







}

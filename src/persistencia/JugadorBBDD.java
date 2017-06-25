package persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

import domini.Jugador;
import persistencia.ConnectionBBDD;

public class JugadorBBDD {

	public Map<Integer, Timestamp> getTimestamps (Jugador jugador) throws Exception{
		
		Map<Integer,Timestamp> map = new HashMap<Integer,Timestamp>();
		
		ConnectionBBDD connection = ConnectionBBDD.getInstance();

		String sql = "SELECT ID,CREATIONTIME FROM SUDOKU WHERE USERNAME = ?";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.clearParameters();
		preparedStatement.setString(1, jugador.getNom());
		ResultSet rs = preparedStatement.executeQuery();

		while (rs.next()) {
			map.put(rs.getInt("ID"), rs.getTimestamp("CREATIONTIME"));
		}
		return map;
	}

	public boolean exists(Jugador jugador) throws Exception {
		
		ConnectionBBDD connection = ConnectionBBDD.getInstance();

		String sql = "SELECT COUNT(*) FROM PLAYER WHERE USERNAME = ?";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.clearParameters();
		preparedStatement.setString(1, jugador.getNom());
		ResultSet rs = preparedStatement.executeQuery();

		if (rs.next()) {
			if(rs.getInt(1) > 0) return true;
		}
		return false;
	}
	public void insert(Jugador jugador) throws Exception {
		ConnectionBBDD connection = ConnectionBBDD.getInstance();

		String sql = "INSERT INTO PLAYER VALUES (?,?)";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.clearParameters();
		preparedStatement.setString(1, jugador.getNom());
		preparedStatement.setBoolean(2, jugador.isPlaying());
		preparedStatement.executeQuery();
		
	}
	
	public void setPlaying(Jugador jugador) throws Exception{
		ConnectionBBDD connection = ConnectionBBDD.getInstance();

		String sql = "UPDATE PLAYER SET ISPLAYING = ? WHERE USERNAME = ?";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.clearParameters();
		preparedStatement.setBoolean(1, jugador.isPlaying());
		preparedStatement.setString(2, jugador.getNom());
		preparedStatement.executeQuery();
	}
	public boolean isPlaying(Jugador jugador) throws Exception{
		ConnectionBBDD connection = ConnectionBBDD.getInstance();
		
		String sql = "SELECT ISPLAYING FROM PLAYER WHERE USERNAME = ?";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.clearParameters();
		preparedStatement.setString(1, jugador.getNom());
		ResultSet rs = preparedStatement.executeQuery();
	
		if (rs.next()) {
			if(rs.getInt(1) == 1) return true;
		}
		return false;
	}
}

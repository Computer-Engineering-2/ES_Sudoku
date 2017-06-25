package domini;

import java.sql.Timestamp;

public class Sudoku {
	private int idPartida;
	private Timestamp timestamp;
	private Taulell taulell;
	private Jugador jugador;
	private boolean isNew;
	
	
	public Sudoku(int idPartida,Timestamp timestamp, Jugador jugador) {
		this.idPartida = idPartida;
		this.timestamp = timestamp;
		this.jugador = jugador;
	}
	
	public int getIdPartida() {
		return idPartida;
	}
	public void setIdPartida(int idPartida) {
		this.idPartida = idPartida;
	}
	public Timestamp getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}

	public Taulell getTaulell() {
		return taulell;
	}

	public void setTaulell(Taulell taulell) {
		this.taulell = taulell;
	}

	public Jugador getJugador() {
		return jugador;
	}
	
	public String getNomJugador(){
		return jugador.getNom();
	}

	public void setJugador(Jugador jugador) {
		this.jugador = jugador;
	}

	public Casella[][] getGraella() {
		return this.taulell.getGraella();
	}
	public boolean isNew(){ return this.isNew; }
	public void setNew(boolean isNew){this.isNew = isNew; }
}

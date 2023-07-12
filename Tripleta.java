package juegoVida;

public class Tripleta {
	protected int generacion;
	protected int vivas;
	protected int nuevas;
	
	public Tripleta(int generacion, int vivas, int nuevas) {
		this.generacion = generacion;
		this.vivas = vivas;
		this.nuevas = nuevas;
	}
	
	public int getGeneracion() {
		return generacion;
	}
	public void setGeneracion(int generacion) {
		this.generacion = generacion;
	}
	public int getVivas() {
		return vivas;
	}
	public void setVivas(int vivas) {
		this.vivas = vivas;
	}
	public int getNuevas() {
		return nuevas;
	}
	public void setNuevas(int nuevas) {
		this.nuevas = nuevas;
	}
	
	@Override
	public String toString() {
		return "Generacion = " + generacion + ", Celulas vivas = " + vivas + ", Celulas nuevas = " + nuevas ;
	}

}

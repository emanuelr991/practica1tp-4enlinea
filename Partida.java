package practica1;

public class Partida {
	private Tablero tablero;
	private Ficha turno = Ficha.BLANCA;
	private boolean terminada = false;
	private Ficha ganador = Ficha.VACIA;
	private int[] undoStack = new int [10];		
	private int numUndo = 0;
	
	public Partida(int x, int y){
		this.tablero = new Tablero(x,y);
	}
	
	public Ficha getFichaTurno(){
		return this.turno;
	}
	
	public Ficha getFichaGanador(){
		return this.ganador;
	}
	
	public boolean getTerminada(){
		return this.terminada;
	}
	
	public void reset(){
		this.tablero.reset();
	}
	
	public boolean ejecutaMovimiento(Ficha color, int col){
		boolean moValido = false;
		color = this.turno;
		int altura = this.tablero.devolverAltura(col), consultaAlto = tablero.getAlto();
		if(altura <= consultaAlto){
			this.tablero.setFicha(color, col, altura);
			moValido = true;
			if(numUndo < 10){
				this.undoStack[numUndo] = col;
				numUndo++;
			}
			else{
				numUndo = 0;
				this.undoStack[numUndo] = col;
				numUndo++;
				}
			if(this.tablero.cuatroEnLinea(color,col, altura) == 4){
				this.terminada = true;
				this.ganador = this.turno;
			}
		}
		if(this.terminada == false && moValido == true){
			if(this.turno == Ficha.BLANCA){
				this.turno = Ficha.NEGRA;
			}
			else if(this.turno == Ficha.NEGRA){
				this.turno = Ficha.BLANCA;
			}
		}
		return moValido;
	}
	
	public String toString(){
		String mensaje = this.tablero.toString();
		String nuevalinea = System.getProperty("line.separator");
		String ficha = "";
		if(this.turno == Ficha.BLANCA){
			ficha = "blancas";
		}
		else if(this.turno == Ficha.NEGRA){
			ficha = "negras";
		}
		return mensaje = mensaje + nuevalinea + "Juegan " + ficha;
	
	}
	
}

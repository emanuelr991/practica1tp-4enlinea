package practica1;

public class Tablero {
	private Ficha [][] tablero;
	private int ancho;
	private int alto;
	
	public Tablero(int ancho, int alto){
		this.tablero = new Ficha [ancho][alto];
		this.ancho = ancho;
		this.alto = alto;
	}
	
	public void reset(){
		for (int i = 0; i < this.ancho; i++){
			for (int j = 0; j < this.alto; j++){
				this.tablero[i][j] = Ficha.VACIA;
			}
		}
	}
	
	public int devolverAltura(int col){
		int i = 0;
		boolean encontrado = false;
		while(i < this.alto && !encontrado){
			if (this.tablero[col][i] != Ficha.VACIA){
				encontrado = true;
			}
			else{
				i++;
			}
		}
		return i;
	}
	
	public int cuatroEnLinea(Ficha color, int x, int y){
		int i = 0;
		while(y > 0 && this.tablero[x][i] == color){
			i++;
			y = y - i;
		}
		return i;
	}
	
	public int getAlto(){
		return this.alto;
	}
	
	public int getAncho(){
		return this.ancho;
	}
	
	public Ficha getFicha(int x, int y){
		return this.tablero[x][y];
	}
	
	public void setFicha(Ficha ficha, int x, int y){
		this.tablero[x][5-y] = ficha;
	}
	
	public String toString(){
		String mensaje = "";
		String nuevalinea = System.getProperty("line.separator");
		for(int i = 0; i < this.ancho; i++){
			for(int j = 0; j < this.alto; j++){
				if(this.tablero[i][j] == Ficha.VACIA){
					mensaje = mensaje + "O ";
				}
				else if(this.tablero[i][j] == Ficha.BLANCA){
					mensaje = mensaje + "B ";
				}
				else if(this.tablero[i][j] == Ficha.NEGRA){
					mensaje = mensaje + "N ";
				}
			}
			mensaje = mensaje + nuevalinea;
		}
		return mensaje;
	}
}

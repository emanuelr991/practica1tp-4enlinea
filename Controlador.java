package practica1;

import java.util.Scanner;

public class Controlador {
	private Partida partida;
	private Scanner in;
	
	public Controlador(int x, int y){
		this.partida = new Partida(x, y);
	}
	
	public void reset(){
		this.partida.reset();
	}
	
	public void run(){
		String opcion = "";
		Ficha turno;
		this.in = new java.util.Scanner(System.in);
		while(opcion != "salir"){
			System.out.println(this.partida.toString());
			System.out.println("Que quieres hacer? ");
			opcion = this.in.next();
			System.out.println("-- Introduce la columna: ");
			int col = this.in.nextInt();
			turno = this.partida.getFichaTurno();
			if(!this.partida.ejecutaMovimiento(turno, col)){
				System.out.println("Movimiento incorrecto");
			}
			else{
				if(this.partida.getTerminada()){
					Ficha ganador = this.partida.getFichaGanador();
					System.out.println("Ganan las " + ganador);
					opcion = "salir";
				}
			/*if(opcion == "poner"){

				}*/
			}
		}
	}
	
}

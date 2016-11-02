package Chap7Ex1;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Baralho {
	private List<Carta> cartas = new ArrayList<Carta>();
	
	private Baralho(){
		
	}
	
	public void shuffle(int iter){
		Random rand = new Random();
		for(int i = 0; i < iter; i++){
			int a = rand.nextInt(cartas.size());
			int b = rand.nextInt(cartas.size());
			Carta temp = cartas.get(a);
			cartas.set(a,cartas.get(b));
			cartas.set(b, temp);
		}
	}
	
	public static Baralho newBaralhoDeSueca(){
		Baralho bar = new Baralho();
		for(Carta.Valor valor : Carta.Valor.values()){
			for(Carta.Naipe naipe : Carta.Naipe.values()){
				bar.cartas.add(new Carta(naipe,valor));
			}
		}
		
		return bar;
	}
	
	public Carta nextUp(){
		if(this.cartas.isEmpty())
			throw new IllegalStateException("Baralho não contém cartas");
		
		Carta car = cartas.get(0);
		cartas.remove(0);
		return car;
	}
	
	public Carta nextDown(){
		if(this.cartas.isEmpty())
			throw new IllegalStateException("Baralho não contém cartas");
		
		Carta car = cartas.get(cartas.size()-1);
		cartas.remove(cartas.size()-1);
		return car;
	}
	
	public int size(){
		return this.cartas.size();
	}
}
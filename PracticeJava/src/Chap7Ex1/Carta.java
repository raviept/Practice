package Chap7Ex1;

public class Carta implements Comparable<Carta>{
	public static enum Naipe{
		Espadas,
		Copas,
		Paus,
		Ouros
	}
	
	public static enum Valor{
		Dois(0,1),
		Tres(1,1),
		Quatro(2, 1),
		Cinco(3,1),
		Seis(4,1),
		Sete(5,10),
		Oito(6,0),
		Nove(7,0),
		Dama(8,2),
		Valete(9,3),
		Rei(10,4),
		As(11,11);
		
		private int pontos;
		private int ranking;
		
		private Valor(int ranking, int pontos){
			this.pontos = pontos;
			this.ranking = ranking;
		}
		
		public int pontos(){
			return this.pontos;
		}
		
		public int ranking(){
			return this.ranking;
		}
	}
	
	public final Naipe naipe;
	public final Valor valor;
	
	public Carta(Naipe naipe, Valor valor){
		this.naipe = naipe;
		this.valor = valor;
	}	
	
	@Override
	public boolean equals(Object obj){
		if(obj == null)
			return false;
		if(!obj.getClass().isInstance(this.getClass()))
			return false;
		
		Carta c = (Carta)obj;
		return (this.naipe == c.naipe) && (this.valor == c.valor);		
	}
	
	public int compareTo(Carta c){
		if(c.valor == this.valor)
			return 0;
				
		return (c.valor.ranking() > this.valor.ranking())? -1 : 1;
	}
}
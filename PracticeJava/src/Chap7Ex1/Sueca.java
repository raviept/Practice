package Chap7Ex1;

import java.util.ArrayList;
import java.util.List;

public class Sueca extends Jogo{
	private static int MAX_ITER = 40;
	
	private int turn = 0;
	private int playsThisRound = 0;
	private int numRounds = 0;
	
	private Carta.Naipe trunfo;
	private List<Carta> mesa = new ArrayList<>();
	private List<Carta> team1 = new ArrayList<>();
	private List<Carta> team2 = new ArrayList<>();
	
	public Sueca(List<Jogador> jogadores){
		super.baralho = Baralho.newBaralhoDeSueca();
		if(jogadores.size() != 4)
			throw new IllegalArgumentException("Um jogo de sueca requer 4 jogadores!");
		super.jogadores = new ArrayList<>();
		this.jogadores.addAll(jogadores);
	}
	
	public void distributeCards(boolean up){
		this.baralho.shuffle(MAX_ITER);
		
		int j = (up)? 1 : 0;
		int numCards = baralho.size();
		for(int i = 0; i < numCards; i++){
			if(up){
				Carta carta = baralho.nextUp();
				jogadores.get(j).addToMao(carta);
				if(i == 0){
					this.trunfo = carta.naipe;
				}
				
				j = (j + 1)%4;
			}
			else{
				jogadores.get(j).addToMao(baralho.nextDown());
				j = (j + 3)%4;
			}
		}
	}
	
	private boolean canPlay(Jogador jogador, Carta carta){
		if(playsThisRound == 0)
			return true;
		
		Carta first = this.mesa.get(0);
		if((carta.naipe == this.trunfo) || (carta.naipe == first.naipe))
			return true;
		
		return (!jogador.containsNaipe(carta.naipe) && !jogador.containsNaipe(trunfo));
	}
	
	private int compareCartas(Carta c1, Carta c2, Carta.Naipe trunfo){
		if(c1.equals(c2))
			return 0;
		if(c1.naipe == c2.naipe)
			return c1.compareTo(c2);
		if(c2.naipe == trunfo)
			return 1;
		return -1;		
	}
	
	private void prepareNextRound(){
		Carta first = this.mesa.get(0);
		Carta maxCarta = first;
		int max = 0;
		for(int i = 1; i < 4; i++){
			if(compareCartas(maxCarta,this.mesa.get(i),this.trunfo) < 0){
				maxCarta = this.mesa.get(i);
				max = i;
			}
		}
		this.turn = max;
		max = max%2;
		if(max == 0)
			this.team1.addAll(mesa);
		else
			this.team2.addAll(mesa);
		this.mesa.clear();
	}
	
	public void play(Carta carta){
		if(!this.jogadores.get(turn).contains(carta))
			throw new IllegalArgumentException("Jogador não possui esta carta!");
		if(!canPlay(this.jogadores.get(turn), carta))
			throw new IllegalArgumentException("Carta não é do naipe da mesa nem trunfo "
					+ "e jogador possui carta válida!");
		
		this.jogadores.get(turn).play(carta);
		this.mesa.add(carta);		
		turn = (turn + 1)%4;
		playsThisRound++;
		if(playsThisRound == 4){
			playsThisRound = 0;
			prepareNextRound();
			numRounds++;
		}
	}
	
	private int calculatePoints(List<Carta> cartas){
		int p = 0;
		for(Carta carta : cartas)
			p+= carta.valor.pontos();
		
		return p;
	}
	
	public int winnerTeam(){
		if(this.numRounds < 10)
			throw new IllegalStateException("O jogo não terminou, ainda!");
		
		int p1 = calculatePoints(this.team1);
		int p2 = calculatePoints(this.team2);
		
		return (p1 == p2)? 0 : ((p1 < p2)? -1 : 1);
	}
}
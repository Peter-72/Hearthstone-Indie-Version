package model.heroes;

import java.io.*;
import java.util.*;

import exceptions.FullFieldException;
import exceptions.FullHandException;
import exceptions.HeroPowerAlreadyUsedException;
import exceptions.NotEnoughManaException;
import exceptions.NotYourTurnException;
import model.heroes.Hero;
import model.cards.Card;
import model.cards.Rarity;
import model.cards.minions.Minion;
import model.cards.spells.*;

public class Hunter extends Hero {
	public Hunter() throws IOException, CloneNotSupportedException{
		super("Rexxar");
	}
	public void buildDeck() throws IOException, CloneNotSupportedException{
		ArrayList<Card>deck=new ArrayList<Card>();
		deck.addAll(getNeutralMinions(getAllNeutralMinions("neutral_minions.csv"),15));
		for(int i=0; i<deck.size();i++){
			((Minion) deck.get(i)).setListener(this);
		}
		deck.add(new KillCommand().clone());
		deck.add(new KillCommand().clone());
		deck.add(new MultiShot().clone());
		deck.add(new MultiShot().clone());
		Minion H = new Minion("King Krush",9,Rarity.LEGENDARY,8,8,false,false,true);
		H.setListener(this);
		deck.add(H.clone());
		Collections.shuffle(deck);
		this.getDeck().addAll(deck);
	}
	
	public void useHeroPower() throws NotEnoughManaException,
	HeroPowerAlreadyUsedException, NotYourTurnException, FullHandException,
	FullFieldException, CloneNotSupportedException{
		super.useHeroPower();
		getListener().damageOpponent(2);
	}

}
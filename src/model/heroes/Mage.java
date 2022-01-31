package model.heroes;

import java.io.*;
import java.util.*;

import exceptions.*;
import model.heroes.Hero;
import model.cards.Card;
import model.cards.Rarity;
import model.cards.minions.Minion;
import model.cards.spells.*;

public class Mage extends Hero{
	public Mage() throws IOException, CloneNotSupportedException{
		super("Jaina Proudmoore");
	}
	public void buildDeck() throws IOException, CloneNotSupportedException{
		ArrayList<Card>deck=new ArrayList<Card>();
		deck.addAll(getNeutralMinions(getAllNeutralMinions("neutral_minions.csv"),13));
		for(int i=0; i<deck.size();i++){
			((Minion) deck.get(i)).setListener(this);
		}
		deck.add(new Polymorph().clone());
		deck.add(new Polymorph().clone());
		deck.add(new Flamestrike().clone());
		deck.add(new Flamestrike().clone());
		deck.add(new Pyroblast().clone());
		deck.add(new Pyroblast().clone());
		Minion M = new Minion("Kalycgos",10,Rarity.LEGENDARY,4,12,false,false,false);
		M.setListener(this);
		deck.add(M.clone());
		this.getDeck().addAll(deck);
		Collections.shuffle(getDeck());
	}
	public void useHeroPower(Hero target) throws NotEnoughManaException,
	HeroPowerAlreadyUsedException, NotYourTurnException, FullHandException,
	FullFieldException, CloneNotSupportedException{
		super.useHeroPower();
		target.setCurrentHP(target.getCurrentHP()-1);
	}
	public void useHeroPower(Minion m) throws NotEnoughManaException,
	HeroPowerAlreadyUsedException, NotYourTurnException, FullHandException,
	FullFieldException, CloneNotSupportedException{
		super.useHeroPower();
		if(m.isDivine())
			m.setDivine(false);
		else
		m.setCurrentHP(m.getCurrentHP()-1);

		;
	}
}

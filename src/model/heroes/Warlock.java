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

public class Warlock extends Hero{
	public Warlock() throws CloneNotSupportedException, IOException {
		super("Gul'dan");
	}
	
	public void buildDeck() throws IOException, CloneNotSupportedException{
		ArrayList<Card>deck=new ArrayList<Card>();
		deck.addAll(getNeutralMinions(getAllNeutralMinions("neutral_minions.csv"),13));
		for(int i=0; i<deck.size();i++){
			((Minion) deck.get(i)).setListener(this);
		}
		deck.add(new CurseOfWeakness().clone());
		deck.add(new CurseOfWeakness().clone());
		deck.add(new SiphonSoul().clone());
		deck.add(new SiphonSoul().clone());
		deck.add(new TwistingNether().clone());
		deck.add(new TwistingNether().clone());
		Minion W = new Minion ("Wilfred Fizzlebang",6,Rarity.LEGENDARY,4,4,false,false,false);
		W.setListener(this);
		deck.add(W.clone());
		Collections.shuffle(deck);
		this.getDeck().addAll(deck);
	}
	public void useHeroPower() throws NotEnoughManaException,
	HeroPowerAlreadyUsedException, NotYourTurnException, FullHandException,
	FullFieldException, CloneNotSupportedException{
		super.useHeroPower();
		Card c=this.drawCard();
		for(int i =0;i<this.getField().size();i++){
			if(this.getField().get(i).getName().equals("Wilfred Fizzlebang"))
				if(c instanceof Minion)
				c.setManaCost(0);
		}
		this.setCurrentHP(this.getCurrentHP()-2);
}
}
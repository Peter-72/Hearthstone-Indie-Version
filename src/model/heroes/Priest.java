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

public class Priest extends Hero {
	public Priest() throws IOException, CloneNotSupportedException{
		super("Anduin Wrynn");
	}
	public void buildDeck() throws IOException, CloneNotSupportedException{
		ArrayList<Card>deck=new ArrayList<Card>();
		deck.addAll(getNeutralMinions(getAllNeutralMinions("neutral_minions.csv"),13));
		for(int i=0; i<deck.size();i++){
			((Minion) deck.get(i)).setListener(this);
		}
		deck.add(new DivineSpirit().clone());
		deck.add(new DivineSpirit().clone());
		deck.add(new HolyNova().clone());
		deck.add(new HolyNova().clone());
		deck.add(new ShadowWordDeath().clone());
		deck.add(new ShadowWordDeath().clone());
		Minion Pr = new Minion("Prophet Velen",7,Rarity.LEGENDARY,7,7,false,false,false);
		Pr.setListener(this);
		deck.add(Pr.clone());
		Collections.shuffle(deck);
		this.getDeck().addAll(deck);
	}
	public void useHeroPower(Hero h) throws NotEnoughManaException,
	HeroPowerAlreadyUsedException, NotYourTurnException, FullHandException,
	FullFieldException, CloneNotSupportedException{
		super.useHeroPower();
		for(int i=0; i<this.getField().size();i++)
			if(this.getField().get(i).getName().equals("Prophet Velen")){
				h.setCurrentHP(h.getCurrentHP()+8);
				return;
			}
		h.setCurrentHP(h.getCurrentHP()+2);
		
	}
	public void useHeroPower(Minion m) throws NotEnoughManaException,
	HeroPowerAlreadyUsedException, NotYourTurnException, FullHandException,
	FullFieldException, CloneNotSupportedException{
		super.useHeroPower();
		for(int i=0; i<this.getField().size();i++)
			if(this.getField().get(i).getName().equals("Prophet Velen")){
				m.setCurrentHP(m.getCurrentHP()+8);
				return;
			}
		m.setCurrentHP(m.getCurrentHP()+2);
}
}

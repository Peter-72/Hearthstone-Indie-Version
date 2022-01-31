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

public class Paladin extends Hero {
	public Paladin() throws IOException, CloneNotSupportedException{
		super("Uther Lightbringer");
	}
	public void buildDeck() throws IOException, CloneNotSupportedException{
		ArrayList<Card>deck=new ArrayList<Card>();
		deck.addAll(getNeutralMinions(getAllNeutralMinions("neutral_minions.csv"),15));
		for(int i=0; i<deck.size();i++){
			((Minion) deck.get(i)).setListener(this);
		}
		deck.add(new SealOfChampions().clone());
		deck.add(new SealOfChampions().clone());
		deck.add(new LevelUp().clone());
		deck.add(new LevelUp().clone());
		Minion Pa = new Minion("Tirion Fordring",4,Rarity.LEGENDARY,6,6,true,true,false);
		Pa.setListener(this);
		deck.add(Pa.clone());
		Collections.shuffle(deck);
		this.getDeck().addAll(deck);
	}
	public void useHeroPower() throws NotEnoughManaException,
	HeroPowerAlreadyUsedException, NotYourTurnException, FullHandException,
	FullFieldException, CloneNotSupportedException{
		super.useHeroPower();	
		Minion m = new Minion("Silver Hand Recruit",1,Rarity.BASIC,1,1,false,false,false);
		m.setListener(this);
		if(this.getField().size()==7) 
			throw new FullFieldException("Field is Full cannot use hero power");	
			this.getField().add(m);
		}
	}
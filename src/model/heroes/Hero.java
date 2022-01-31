package model.heroes;
import java.util.*;
import java.io.*;

import engine.ActionValidator;
import exceptions.*;
import model.cards.Card;
import model.cards.Rarity;
import model.cards.minions.Icehowl;
import model.cards.minions.Minion;
import model.cards.minions.MinionListener;
import model.cards.spells.*;


public abstract class Hero extends Card implements MinionListener{
	private String name;
	private int currentHP = 30;
	private boolean heroPowerUsed;
	private int totalManaCrystals;
	private int currentManaCrystals;
	private ArrayList<Card> deck;
	private ArrayList<Minion> field;
	private ArrayList<Card> hand;
	private int fatigueDamage=1;
	private HeroListener listener;
	private ActionValidator validator;
	
	public HeroListener getListener() {
		return listener;
	}
	public void setListener(HeroListener listener) {
		this.listener = listener;
	}
	public void setValidator(ActionValidator validator) {
		this.validator = validator;
	}
	public void onMinionDeath(Minion m){
		this.field.remove(m);
	}
	public Hero(String name) throws CloneNotSupportedException, IOException{
		this.name = name;
        currentHP = 30;
        deck = new ArrayList<Card>();
        field = new ArrayList<Minion>();
        hand = new ArrayList<Card>();
        buildDeck();
	}
	
	public int getCurrentHP() {
		return currentHP;
	}
	public void setCurrentHP(int currentHP) { 
			if(currentHP>30)
			this.currentHP=30;
			else 
				this.currentHP = currentHP;
			if (currentHP<=0){
				currentHP=0;
				getListener().onHeroDeath();
			}
	}
	public boolean isHeroPowerUsed() {
		return heroPowerUsed;
	}
	public void setHeroPowerUsed(boolean heroPowerUsed) {
		this.heroPowerUsed = heroPowerUsed;
	}
	public int getTotalManaCrystals() {
		return totalManaCrystals;
	}
	public void setTotalManaCrystals(int totalManaCrystals) {
		if(totalManaCrystals<0)
			this.totalManaCrystals=0;
		else if(totalManaCrystals>10)
			this.totalManaCrystals=10;
		else this.totalManaCrystals = totalManaCrystals;
	}
	public int getCurrentManaCrystals() {
		return currentManaCrystals;
	}
	public void setCurrentManaCrystals(int currentManaCrystals) {
		if(currentManaCrystals<0)
			this.currentManaCrystals=0;
		else if(currentManaCrystals>10)
			this.currentManaCrystals=10;
		else this.currentManaCrystals = currentManaCrystals;

	}
	public String getName() {
		return name;
	}
	public ArrayList<Card> getDeck() {
		return deck;
	}
	public ArrayList<Minion> getField() {
		return field;
	}
	public ArrayList<Card> getHand() {
		return hand;
	}
	public static final ArrayList<Minion> getAllNeutralMinions(String Filepath) throws IOException{
		ArrayList<Minion> Minions = new ArrayList<Minion>();
		String path = Filepath;
		FileReader f = new FileReader(path);
		BufferedReader x = new BufferedReader(f);
		String CurrentLine="";
		while((CurrentLine=x.readLine())!=null){
			String[] line = CurrentLine.split(",");
			String name = line[0];
			int mana_cost = Integer.parseInt(line[1]);
			char type = line[2].charAt(0);
			Rarity r = Rarity.BASIC;
			switch(type){
			case 'b': r = Rarity.BASIC;break;
			case 'c' : r = Rarity.COMMON;break;
			case 'r' : r = Rarity.RARE;break;
			case 'e' : r = Rarity.EPIC;break;
			case 'l' : r = Rarity.LEGENDARY;break;
			default:
				x.close();
			}
			int attack = Integer.parseInt(line[3]);
			int max_HP = Integer.parseInt(line[4]);
			boolean taunt = Boolean.parseBoolean(line[5]);
			boolean divine = Boolean.parseBoolean(line[6]);
			boolean charge = Boolean.parseBoolean(line[7]);
			if(line[0].equals("Icehowl"))
				Minions.add(new Icehowl());
			else
			Minions.add(new Minion(name,mana_cost,r,attack,max_HP,taunt,divine,charge));
		}
			return Minions;
		}
	public final static ArrayList<Minion> getNeutralMinions(ArrayList<Minion> Minions,int count)throws IOException, CloneNotSupportedException{
		ArrayList<Minion> Result = new ArrayList<Minion>();
		ArrayList<Minion> Select = new ArrayList<Minion>();
		ArrayList<Minion> Minions2 = new ArrayList<Minion>();
		Minions2 .addAll(Minions);
		Select.addAll(Minions);
		for(int i =0; i<Minions2.size();i++){
			if(Minions2.get(i).getRarity()==Rarity.BASIC || Minions2.get(i).getRarity()==Rarity.RARE)
				Select.add(Minions2.get(i));
		}
		for(int i=0;i<count;i++){
			int x = (int)((Math.random()*Select.size())+1)-1;
			Minion z = new Minion();
			z = Select.get(x);
			Result.add(z.clone());
			Select.remove(Select.get(x));
		}
		return Result; 
	}

	public abstract void buildDeck() throws IOException, CloneNotSupportedException;
	
	public void useHeroPower() throws NotEnoughManaException,
	HeroPowerAlreadyUsedException, NotYourTurnException, FullHandException,
	FullFieldException, CloneNotSupportedException{ 
		validator.validateTurn(this);
		validator.validateUsingHeroPower(this);
		this.setHeroPowerUsed(true);
		this.setCurrentManaCrystals(this.getCurrentManaCrystals()-2);
	}
	
	public void playMinion(Minion m) throws NotYourTurnException,
	NotEnoughManaException, FullFieldException{
		validator.validateTurn(this);
		validator.validateManaCost(m);
		validator.validatePlayingMinion(m);
		this.getHand().remove(m);
		this.getField().add(m);
		this.setCurrentManaCrystals(this.getCurrentManaCrystals()-m.getManaCost());
	}
	
	public void attackWithMinion(Minion attacker, Minion target) throws
	CannotAttackException, NotYourTurnException, TauntBypassException,
	InvalidTargetException, NotSummonedException{
		validator.validateTurn(this);
		validator.validateAttack(attacker, target);
		attacker.attack(target);
	}
	
	public void attackWithMinion(Minion attacker, Hero target) throws
	CannotAttackException, NotYourTurnException, TauntBypassException,
	NotSummonedException, InvalidTargetException{
		validator.validateTurn(this);
		validator.validateAttack(attacker, target);
		attacker.attack(target);
	}
	
	public void castSpell(FieldSpell s) throws NotYourTurnException,
	NotEnoughManaException{
		for(int i =0; i<this.getField().size();i++)
			if(this.getField().get(i).getName().equals("Kalycgos"))
				((Card) s).setManaCost(((Card) s).getManaCost()-4);
		validator.validateTurn(this);
		validator.validateManaCost((Card) s);
		this.getHand().remove((Card) s);
		s.performAction(this.getField());
		this.setCurrentManaCrystals(this.getCurrentManaCrystals()-((Card) s).getManaCost());
	}
	
	public void castSpell(AOESpell s, ArrayList<Minion>oppField) throws
	NotYourTurnException, NotEnoughManaException{
		for(int i =0; i<this.getField().size();i++)
			if(this.getField().get(i).getName().equals("Kalycgos"))
				((Card) s).setManaCost(((Card) s).getManaCost()-4);
		validator.validateTurn(this);
		validator.validateManaCost((Card) s);
		this.getHand().remove((Card) s);
		s.performAction(oppField,this.getField());
		this.setCurrentManaCrystals(this.getCurrentManaCrystals()-((Card) s).getManaCost());
	}
	
	public void castSpell(MinionTargetSpell s, Minion m) throws NotYourTurnException,
	NotEnoughManaException, InvalidTargetException{
		for(int i =0; i<this.getField().size();i++)
			if(this.getField().get(i).getName().equals("Kalycgos"))
				((Card) s).setManaCost(((Card) s).getManaCost()-4);
		validator.validateTurn(this);
		validator.validateManaCost((Card) s);
		this.getHand().remove((Card) s);
		s.performAction(m);
		this.setCurrentManaCrystals(this.getCurrentManaCrystals()-((Card) s).getManaCost());
		}
	
	public void castSpell(HeroTargetSpell s, Hero h) throws NotYourTurnException,
	NotEnoughManaException{
		for(int i =0; i<this.getField().size();i++)
			if(this.getField().get(i).getName().equals("Kalycgos"))
				((Card) s).setManaCost(((Card) s).getManaCost()-4);
		validator.validateTurn(this);
		validator.validateManaCost((Card) s);
		this.getHand().remove((Card) s);
		s.performAction(h);
		this.setCurrentManaCrystals(this.getCurrentManaCrystals()-((Card) s).getManaCost());
	}
	
	public void castSpell(LeechingSpell s, Minion m) throws NotYourTurnException,
	NotEnoughManaException{
		for(int i =0; i<this.getField().size();i++)
			if(this.getField().get(i).getName().equals("Kalycgos"))
				((Card) s).setManaCost(((Card) s).getManaCost()-4);
		validator.validateTurn(this);
		validator.validateManaCost((Card) s);
		this.getHand().remove((Card) s);
		this.setCurrentHP(this.getCurrentHP()+s.performAction(m));
		this.setCurrentManaCrystals(this.getCurrentManaCrystals()-((Card) s).getManaCost());
	}
	public void endTurn() throws FullHandException, CloneNotSupportedException{
		getListener().endTurn();
	}
	
	public Card drawCard() throws FullHandException, CloneNotSupportedException{
		Card c = null;
		if(this.getDeck().size()!=0){
			 c= this.getDeck().remove(0);
			if(this.getHand().size()==10) 
				throw new FullHandException("Hand cannot contain more than 10 cards, card burnt: "+c.getName(),c);
		}
		else{
			this.setCurrentHP(this.getCurrentHP()-this.fatigueDamage);
			this.fatigueDamage++;
			return null;
		}	
		
		for(int i =0;i<this.getField().size();i++){
			if(this.getField().get(i).getName().equals("Chromaggus") && this.getHand().size()<9){
				Card d = c.clone();
				if(d instanceof Minion || c instanceof Minion)
				((Minion) d).setListener(this);
				this.getHand().add(d);
		}
			}
		this.getHand().add(c);
		return c ;
		
	}
	
}
	
	


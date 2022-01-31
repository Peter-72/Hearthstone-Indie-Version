package model.cards.minions;

import exceptions.InvalidTargetException;
import model.cards.Card;
import model.cards.Rarity;
import model.heroes.Hero;

public class Minion extends Card implements Cloneable{
	private int attack;
	private int maxHP;
	private int currentHP;
	private boolean taunt;
	private boolean divine;
	private boolean sleeping;
	private boolean attacked;
	private MinionListener listener;
	public Minion(){}
	public Minion(String name,int manaCost,Rarity rarity, int attack,int maxHP,boolean
			taunt,boolean divine,boolean charge){
		super(name,manaCost,rarity);
		this.attack = attack;
		this.maxHP = maxHP;
		this.currentHP = maxHP;
		this.taunt = taunt;
		this.divine = divine;
		this.sleeping = !charge;
		this.attacked = attacked;	
	}
	public String toString(){
		return getName();
	}
	public int getAttack() {
		return attack;
	}
	public void setAttack(int attack) {
		if (attack >= 0)
		this.attack = attack;
		else if (attack<0)
			this.attack=0;
	}
	public int getMaxHP() {
		return maxHP;
	}
	public void setMaxHP(int maxHP) {
		this.maxHP = maxHP;
	}
	public int getCurrentHP() {
		return currentHP;
	}
	public void setCurrentHP(int CurrentHP) {
		if(CurrentHP > this.maxHP)
			this.currentHP = maxHP;
		else if(CurrentHP<=0)
			listener.onMinionDeath(this);
		else
			this.currentHP = CurrentHP;
		
	}
	public boolean isTaunt() {
		return taunt;
	}
	public void setTaunt(boolean taunt) {
		this.taunt = taunt;
	}
	public boolean isDivine() {
		return divine;
	}
	public void setDivine(boolean divine) {
		this.divine = divine;
	}
	public boolean isSleeping() {
		return sleeping;
	}
	public void setSleeping(boolean sleeping) {
		this.sleeping = sleeping;
	}
	public boolean isAttacked() {
		return attacked;
	}
	public void setAttacked(boolean attacked) {
		this.attacked = attacked;
	}
	public void onMinionDeath(Minion m) {
	}
	public void setListener(MinionListener listener) {
		this.listener = listener;
	}
	public void attack(Minion target){
		if(!this.isDivine() && !target.isDivine()){
			this.setCurrentHP(this.getCurrentHP()-target.getAttack());
			target.setCurrentHP(target.getCurrentHP()-this.getAttack());
		}
		if(this.isDivine() && !target.isDivine()){
			if(target.getAttack()!=0)
			this.setDivine(false);
			target.setCurrentHP(target.getCurrentHP()-this.getAttack());
		}
		if(!this.isDivine() && target.isDivine()){
			if(target.getAttack()!=0)
				this.setDivine(false);
			if(this.getAttack()!=0)
				target.setDivine(false);
			this.setCurrentHP(this.getCurrentHP()-target.getAttack());
		}
		if(this.isDivine() && target.isDivine()){
			if(target.getAttack()!=0)
				this.setDivine(false);
			if(this.getAttack()!=0)
				target.setDivine(false);
		}
		this.setAttacked(true);
	}
	
	public void attack(Hero target) throws InvalidTargetException{
			target.setCurrentHP(target.getCurrentHP()-this.getAttack());
		this.setAttacked(true);
		
	}
	public Minion clone() throws CloneNotSupportedException{
		return (Minion) super.clone();
	}
	
	}


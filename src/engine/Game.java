package engine;

import model.cards.Card;
import model.cards.minions.Icehowl;
import model.cards.minions.Minion;
import model.heroes.Hero;
import model.heroes.HeroListener;

import java.util.*;

import exceptions.CannotAttackException;
import exceptions.FullFieldException;
import exceptions.FullHandException;
import exceptions.HeroPowerAlreadyUsedException;
import exceptions.InvalidTargetException;
import exceptions.NotEnoughManaException;
import exceptions.NotSummonedException;
import exceptions.NotYourTurnException;
import exceptions.TauntBypassException;

public class Game implements ActionValidator, HeroListener, GameListener {
	private Hero firstHero;
	private Hero secondHero;
	private GameListener listener;

	public void setListener(GameListener listener) {
		this.listener = listener;
	}

	public Hero getCurrentHero() {
		return currentHero;
	}

	public Hero getOpponent() {
		return opponent;
	}

	private Hero currentHero;
	private Hero opponent;

	public Game(Hero p1, Hero p2) throws FullHandException, CloneNotSupportedException{
		firstHero=p1;
        secondHero=p2;

        int coin = (int) (Math.random()*2);
        currentHero= coin==0?firstHero:secondHero;
        opponent= currentHero==firstHero?secondHero:firstHero;
        currentHero.setCurrentManaCrystals(1);
        currentHero.setTotalManaCrystals(1);
		currentHero.setListener(this);
		opponent.setListener(this);
		currentHero.setValidator(this);
		opponent.setValidator(this);
		
		currentHero.drawCard();
		currentHero.drawCard();
		currentHero.drawCard();
		opponent.drawCard();
		opponent.drawCard();
		opponent.drawCard();
		opponent.drawCard();
		

	}

	public void validateTurn(Hero user) throws NotYourTurnException {
			if(!(this.currentHero.equals(user))) 
					throw new NotYourTurnException("Not Your Turn");
	}

	public void validateAttack(Minion attacker, Minion target)throws CannotAttackException, NotSummonedException,
			TauntBypassException, InvalidTargetException {
		if (attacker.getAttack() <= 0)
			throw new CannotAttackException("This Minion has 0 attack points");
		if (attacker.isSleeping())
			throw new CannotAttackException("Minion is Sleeping");
		if (attacker.isAttacked())
			throw new CannotAttackException("Minion attacked once this turn");
		if (!currentHero.getField().contains(attacker))
			throw new NotSummonedException("Minion is not present on field");
		if (currentHero.getField().contains(target))
			throw new InvalidTargetException("Cannot attack a friendly minion");
		if (!opponent.getField().contains(target))
			throw new NotSummonedException("Target Minion is not present on field");
		if (!target.isTaunt()) {
			for (int i = 0; i < opponent.getField().size(); i++) {
				if (opponent.getField().get(i).isTaunt())
					throw new TauntBypassException(opponent.getField().get(i).getName()+" is Taunted");
			}

		}

	}
	

	public void validateAttack(Minion attacker, Hero target)
			throws CannotAttackException, NotSummonedException,
			TauntBypassException, InvalidTargetException {
		if (attacker.getAttack() <= 0)
			throw new CannotAttackException("This Minion has 0 attack points");
		if (attacker.isSleeping())
			throw new CannotAttackException("Minion is Sleeping");
		if (attacker.isAttacked())
			throw new CannotAttackException("Minion attacked once this turn");
		if (!currentHero.getField().contains(attacker))
			throw new NotSummonedException("Minion is not present on field");
		if (target.getField().contains(attacker))
			throw new InvalidTargetException("Minion cannot attack their fellow hero");
		for (int i = 0; i < opponent.getField().size(); i++) {
			if (opponent.getField().get(i).isTaunt())
				throw new TauntBypassException(opponent.getField().get(i).getName()+" is Taunted");
		}
	}
	
	public void validateManaCost(Card card) throws NotEnoughManaException {
		if(currentHero.getCurrentManaCrystals()<card.getManaCost())
			throw new NotEnoughManaException("Not enough mana");		
	}

	public void validatePlayingMinion(Minion minion) throws FullFieldException {
		if(currentHero.getField().size()==7)
			throw new FullFieldException("Not enough space in field");
	}

	public void validateUsingHeroPower(Hero hero)
			throws NotEnoughManaException, HeroPowerAlreadyUsedException {
		if(currentHero.getCurrentManaCrystals()<2)
			throw new NotEnoughManaException("Not enough mana to use hero power");
		if(currentHero.isHeroPowerUsed())
			throw new HeroPowerAlreadyUsedException("Hero has used its power this turn");
		
	}

	public void onHeroDeath() {
		listener.onGameOver();		
	}

	public void damageOpponent(int amount) {
		opponent.setCurrentHP(opponent.getCurrentHP()-amount);
	}
	public void endTurn() throws FullHandException, CloneNotSupportedException {
		Hero temp = this.currentHero;
		this.currentHero=this.opponent;
		this.opponent=temp;
		
		currentHero.setTotalManaCrystals(currentHero.getTotalManaCrystals()+1);
		currentHero.setCurrentManaCrystals(currentHero.getTotalManaCrystals());
		
		currentHero.setHeroPowerUsed(false);
		
		for(int i=0; i<currentHero.getField().size();i++){
			currentHero.getField().get(i).setAttacked(false);
			currentHero.getField().get(i).setSleeping(false);
		}
				currentHero.drawCard();
	}

	public void onGameOver() {
		// MileStone 3
	}
	
}

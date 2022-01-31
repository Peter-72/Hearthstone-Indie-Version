package model.cards.spells;

import java.util.ArrayList;

import model.cards.Rarity;
import model.cards.minions.Minion;

public class HolyNova extends Spell implements AOESpell{
 public HolyNova(){
	 super("Holy Nova",5,Rarity.BASIC);
 }

public void performAction(ArrayList<Minion> oppField, ArrayList<Minion> curField) {
	int i=0;
	while(i < oppField.size()){	

			if(oppField.get(i).isDivine()){
				oppField.get(i).setDivine(false);
			i++;
			}
			else
				if(oppField.get(i).getCurrentHP()<=2){
					oppField.get(i).setCurrentHP(oppField.get(i).getCurrentHP()-2);
					continue;
				}
					else
					{
						oppField.get(i).setCurrentHP(oppField.get(i).getCurrentHP()-2);
						i++;
					}
					
			
		}

	
	for(int c=0; c<curField.size();c++)
		curField.get(c).setCurrentHP(curField.get(c).getCurrentHP()+2);
}
}

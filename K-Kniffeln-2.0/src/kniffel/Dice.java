package kniffel;

import java.util.Arrays;
import java.util.Collections;

public class Dice  {							

	public void diceRun(Integer[]dice, int[]numberOfThrows,int[] halten ) {		             // Method "Run the Dice"
		
						
		if (numberOfThrows[0] <3)  {                 
			   
			  numberOfThrows[0]++;
				
					
			  for (int z=0; z<5; z++) {
				  
				  if (halten[z] == 0)  { 
					  
					  dice[z] = (int)(Math.random()*6+1);
			      	  }
			      	  } 
		    	dice[5] = dice[0] + dice[1] + dice[2] + dice[3] + dice[4];
			      				      	
  		}
	}

	public void diceEvaluation(int[] evaluation,int[] currentDiceResult,Integer[]dice ) {				
		
		int[] evalDiceNumbers = {0,0,0,0,0,0,0}; 												 // Frequency table for evaluation occurance of the dice numbers 1-6	    
	   
		for (int z=0; z<6; z++) {
		
			evalDiceNumbers[z] = Collections.frequency(Arrays.asList(dice), (z+1));  
				
			}	
		
				
		if (evalDiceNumbers[0] >= 1 ) 
		{
			evaluation[0] = 1;
			currentDiceResult[0] = evalDiceNumbers[0];											
		 }	
		
// Evaluation 3-er Pasch
		
		if (evalDiceNumbers[0] >= 3 || evalDiceNumbers[1] >= 3 || evalDiceNumbers[2] >= 3 || evalDiceNumbers[3] >= 3 || evalDiceNumbers[4] >= 3 || evalDiceNumbers[5] >= 3)
		{												
			evaluation[1] = 1;
			currentDiceResult[1] = dice[5];
					 }	
  
// Evaluation Chance
		
		evaluation[2] = 1;
		currentDiceResult[2] = dice[5];
			 								
// Evaluation Full house
			
			if (evaluation[1] == 1 &&(evalDiceNumbers[0] == 2 || evalDiceNumbers[1] == 2 || evalDiceNumbers[2] == 2 || evalDiceNumbers[3] == 2 || evalDiceNumbers[4] == 2 || evalDiceNumbers[5] == 2))
			{												
				evaluation[3] = 1;
				currentDiceResult[3] = 25;
			 }	
					
// Evaluation große oder kleine Strasse  ( Numbers 3 and 4 must be occured in all cases )
			
			if (evalDiceNumbers[2] >= 1 && evalDiceNumbers[3] >= 1 )
				{
				
				// evaluation kleine Strasse
				
				if ((evalDiceNumbers[0] >= 1 && evalDiceNumbers[1] >= 1 )  || ( evalDiceNumbers[1] >= 1 && evalDiceNumbers[4] >= 1 ) || (evalDiceNumbers[4] >= 1 && evalDiceNumbers[5] >= 1 ))
				{
					evaluation[4] = 1;
					currentDiceResult[4] = 30;
				
					// evaluation grosse Strasse
				
					if ((evalDiceNumbers[1] == 1 && evalDiceNumbers[4] == 1 ) && (evalDiceNumbers[0] == 1 || evalDiceNumbers[5] == 1 ) )
					{
						evaluation[5] = 1;
						currentDiceResult[5] = 40;	
					}
				}
								
			}
			
		
// Evaluation Kniffel
	
			if (evalDiceNumbers[0] == 5 || evalDiceNumbers[1] == 5 || evalDiceNumbers[2] == 5 || evalDiceNumbers[3] == 5 ||evalDiceNumbers[4] == 5 || evalDiceNumbers[5] == 5)
			{										
				evaluation[6] = 1;
				currentDiceResult[6] = 50;
			}
			
			
	}
}





















	




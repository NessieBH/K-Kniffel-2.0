package kniffel;

public class Player {

	private Player() {}
	
	
  
public static void displayZero(int[] currentDiceResult, int[] decision) {		//  Set Display dice results to default=0
		
		
	for (int z=0; z<6; z++) {
		
	if ( decision[z] == 0 )
	{
		currentDiceResult[z] = 0;
	}
	}
	}


public static void displayCurrentDiceResult(int[]enableSelection,int[] auswertung,  int[]decision, int[]result) {		  
	
	
	for (int z=0; z<7; z++) {
	
if (  decision[z] == 0  && ( result[z] == 0 || auswertung[z] == 1))
{
	enableSelection[z] =1;
	}
	}
	}


public static void decisioneinser(int[] currentDiceResult, int[] result, int[] decision) {

	result[0]  =  currentDiceResult[0];
	decision[0] = 1;
	result[7] = result[7] + result[0];
    	
}

public static void decision3erpasch(int[] currentDiceResult, int[] result, int[] decision) {

	result[1]  =  currentDiceResult[1];
	decision[1] = 1;
	result[7] = result[7] + result[1];
			
}


public static void decisionchance(int[] currentDiceResult, int[] result, int[] decision) {

	result[2]  =  currentDiceResult[2];
	decision[2] = 1;
	result[7] = result[7] + result[2];
		
}

public static void decisionfullhouse(int[] currentDiceResult, int[] result, int[] decision) {

	result[3]  =  currentDiceResult[3];
	decision[3] = 1;
	result[7] = result[7] + result[3];
			
}

public static void decisionkleinestrasse(int[] currentDiceResult, int[] result, int[] decision) {

	result[4]  =  currentDiceResult[4];
	decision[4] = 1;
	result[7] = result[7] + result[4];
			
}

public static void decisiongrossestrasse(int[] currentDiceResult, int[] result, int[] decision) {

	result[5]  =  currentDiceResult[5];
	decision[5] = 1;
	result[7] = result[7] + result[5];
	
}


public static void decisionkniffel(int[] currentDiceResult, int[] result, int[] decision) {

	result[6]  =  currentDiceResult[6];
	decision[6] = 1;
	result[7] = result[7] + result[6];
			
}
}

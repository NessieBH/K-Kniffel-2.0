/**
 * @author Vanessa Lutz  Date : 19.11.2020 08:20
 *
 */

package kniffel;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.net.URL;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.util.*;     						

public class Controller implements Initializable {
 
// Definition general variables
	
   int numberOfRounds = 0;
   int player = 1;
   int noPlayerChange = 1;			  
   Integer[] dice = {0,0,0,0,0,0};									    // Array Result Dice 1-5 and summary dice 1-5
   int[] numberOfThrows= {0};
   int[] keepDice = {0,0,0,0,0};									  	// Array keep Dice 1-5
   
// Arrays for current dice result
   
   int[] evaluationCurrentDiceResult = {0,0,0,0,0,0,0}; 				// Result evaluation ( Einser, Chance, full house etc )
   int[] currentDiceResult = {0,0,0,0,0,0,0}; 					 		// Points scored ( Einser, Chance, full house etc )
   int[] enableSelection = {0,0,0,0,0,0,0}; 				     		// Enable selection ( Einser, Chance, full house etc )
   
// Arrays for current dice result after decision of player1 / player 2 
   
   int[] resultPlayer1 = {0,0,0,0,0,0,0,0};
   int[] resultPlayer2 = {0,0,0,0,0,0,0,0};
   int[] decisionPlayer1 = {0,0,0,0,0,0,0};
   int[] decisionPlayer2 = {0,0,0,0,0,0,0};
   
// GUI : Definiton of the common fields "roll the dice"
                             
   @FXML private Button gameInstructions;
   @FXML private Button newGame;
   @FXML private Button runTheDice;
   @FXML private Button changePlayer;
   @FXML private TextField displNamePlayer1;
   @FXML private TextField displNamePlayer2;
   @FXML private TextField displaySummaryDices;
   @FXML private TextField displayNumberOfThrows;
   @FXML private TextField statusMessage;
   @FXML private TextField displayPlayerNumber;
   @FXML private Button keepDice1;
   @FXML private Button keepDice2;
   @FXML private Button keepDice3;
   @FXML private Button keepDice4;
   @FXML private Button keepDice5;
   @FXML private ImageView dice1;
   @FXML private ImageView dice2;
   @FXML private ImageView dice3;
   @FXML private ImageView dice4;
   @FXML private ImageView dice5; 
      
// GUI : Definiton of the fields for evaluation of the current dice result after "roll the dice"
   
   @FXML private Button einser;
   @FXML private Button dreierpasch;
   @FXML private Button chance;
   @FXML private Button fullhouse;
   @FXML private Button kleinestrasse;
   @FXML private Button grossestrasse;
   @FXML private Button kniffel;
   @FXML private TextField dspCurrentDiceResultEinser;
   @FXML private TextField dspCurrentDiceResultDreierpasch;
   @FXML private TextField dspCurrentDiceResultChance;
   @FXML private TextField dspCurrentDiceResultFullhouse;
   @FXML private TextField dspCurrentDiceResultKleinestrasse;
   @FXML private TextField dspCurrentDiceResultGrossestrasse;
   @FXML private TextField dspCurrentDiceResultKniffel;
         
// GUI : Definiton of the fields for display of the results after decision player 1 / player 2 
   
   @FXML private TextField displEinserPlayer1;
   @FXML private TextField displ3erpaschPlayer1;
   @FXML private TextField displChancePlayer1;
   @FXML private TextField displFullHousePlayer1;
   @FXML private TextField displKlStrPlayer1;
   @FXML private TextField displGrStrPlayer1;
   @FXML private TextField displKniffelPlayer1;
   @FXML private TextField displSumPlayer1;
   
   @FXML private TextField displEinserPlayer2;
   @FXML private TextField displ3erpaschPlayer2;
   @FXML private TextField displChancePlayer2;
   @FXML private TextField displFullHousePlayer2;
   @FXML private TextField displKlStrPlayer2;
   @FXML private TextField displGrStrPlayer2;
   @FXML private TextField displKniffelPlayer2;
   @FXML private TextField displSumPlayer2; 
   
                   
   @Override
      
     public void initialize(URL location, ResourceBundle resources) {
     	
    	keepDiceResultDisable();
    	selectionDisable();
        resetGUI();
       
     }
   	        
    Dice run = new Dice();   											// Definition class Dice
        
    // New Game : clear GUI, reset all values
    
    public void newGame ( ) {
	    numberOfThrows = new int []{0};
	    numberOfRounds=0;														    
	    keepDice = new int[]{0,0,0,0,0};									
		dice[5] = 0;													// Reset summary dice 1-5
		player = 1;
		
		resetGUI();													
		keepDiceResultDisable();												
		selectionDisable();												
		
		displEinserPlayer1.clear();	 
		displEinserPlayer2.clear();						
		displ3erpaschPlayer1.clear();	
		displ3erpaschPlayer2.clear();	
		displChancePlayer1.clear();	
		displChancePlayer2.clear();	
		displFullHousePlayer1.clear();	
		displFullHousePlayer2.clear();	
		displKlStrPlayer1.clear();	
		displKlStrPlayer2.clear();	
		displGrStrPlayer1.clear();	
		displGrStrPlayer2.clear();	
		displKniffelPlayer1.clear();	
		displKniffelPlayer2.clear();	
		displSumPlayer1.clear();	
		displSumPlayer2.clear();	
				
		runTheDice.setDisable(false);				
		
		Arrays.fill(decisionPlayer1,0 );
		Arrays.fill(resultPlayer1,0 );
		Arrays.fill(decisionPlayer2,0 );
		Arrays.fill(resultPlayer2,0 );
		}

   // With "Roll the Dice" ( on Action = run ) the following functions will be executed:
   // 1.) Roll the Dice depending whether keep dice is selected
   // 2.) Display the Dice images based on the dice result
   // 3.) Evaluation of the dice result  (3er-Pasch, Full House Kniffel etc )
   // 4.) Display of the results depending whether player 1 / player 2, store results in corresponding Array
   
   public void runTheDice() {
	     
	 	   
	   run.diceRun(dice, numberOfThrows,keepDice);					   
	   
	   displayDiceImages();
	   
	    displayPlayerNumber.setText("" + player);    
	  	displayNumberOfThrows.setText("" +numberOfThrows[0]);   		
		displaySummaryDices.setText(""+ dice[5]);
		  		  
		  if (numberOfThrows[0] ==1)  { 
		  			  			  
			  keepDice1.setDisable(false);								
			  keepDice2.setDisable(false);
			  keepDice3.setDisable(false);
			  keepDice4.setDisable(false);
			  keepDice5.setDisable(false);
		  }
		  
		  if (numberOfThrows[0] ==3)  {
			  
			  statusMessage.setText("Die maximale Anzahl Würfe ist erreicht !"); 
			  runTheDice.setDisable(true);
			  keepDiceResultDisable();
			  		  
		  }
		
		  		  
		  // Preset display of actual dice result to zero and enable keepDice button
		  	  		  
		  
		  if (player ==1) {
			  Player.displayZero(currentDiceResult, decisionPlayer1);				
		  }
		  else {
			  Player.displayZero(currentDiceResult, decisionPlayer2);				
		  }
		  
		  evaluationCurrentDiceResult = new int []{0,0,0,0,0,0,0} ;  				
		    		   
		   	run.diceEvaluation(evaluationCurrentDiceResult,currentDiceResult, dice);
		   	
		   	  				
		   	enableSelection = new int[]{0,0,0,0,0,0,0};
		   	
		   	 		if (player ==1) {
		   	 		Player.displayCurrentDiceResult(enableSelection,evaluationCurrentDiceResult,decisionPlayer1, resultPlayer1 );				
					 }
					else {
					Player.displayCurrentDiceResult(enableSelection,evaluationCurrentDiceResult,decisionPlayer2, resultPlayer2 );			    
					 }
								
					   	 		
		   	 		
		   	 		if ( enableSelection[0] == 1 ) {
						  einser.setDisable(false);
						  dspCurrentDiceResultEinser.setText("" + (currentDiceResult[0]));
					  }
					  if ( enableSelection[1] == 1 ) {
						  dreierpasch.setDisable(false);
						  dspCurrentDiceResultDreierpasch.setText("" + (currentDiceResult[1]));
					  } 
					  if ( enableSelection[2] == 1 ) {
						  chance.setDisable(false);
						  dspCurrentDiceResultChance.setText("" + (currentDiceResult[2]));
					  } 
					  if ( enableSelection[3] == 1 ) {
						  fullhouse.setDisable(false);
						  dspCurrentDiceResultFullhouse.setText("" + (currentDiceResult[3]));
					  } 
					  if ( enableSelection[4] == 1 ) {
						  kleinestrasse.setDisable(false);
						  dspCurrentDiceResultKleinestrasse.setText("" + (currentDiceResult[4]));
					  } 
					  if ( enableSelection[5] == 1 ) {
						  grossestrasse.setDisable(false);
						  dspCurrentDiceResultGrossestrasse.setText("" + (currentDiceResult[5]));
					  } 
					  if ( enableSelection[6] == 1 ) {
						  kniffel.setDisable(false);
						  dspCurrentDiceResultKniffel.setText("" + (currentDiceResult[6]));
					  }
			}
	  	
      // Keep Dice result dice 1-5
   
   		public void actionKeepDice1 () {
   			keepDice[0] = 1;
   			keepDice1.setDisable(true);
   			}
   
	   public void  actionKeepDice2 () {
		   keepDice[1] = 1;
		   keepDice2.setDisable(true);
		 	} 
	   
	   public void  actionKeepDice3 () {
		   keepDice[2] = 1;
		   keepDice3.setDisable(true);
		 	} 
	   
	   public void  actionKeepDice4 () {
		   keepDice[3] = 1;
		   keepDice4.setDisable(true);
		 	} 
	   
	   public void  actionKeepDice5 () {
		   keepDice[4] = 1;
		   keepDice5.setDisable(true);
		 	} 
	   
   
	   // Decision player 1 / 2  (  3-er_pasch, full House Kniffel etc ) 
	   	
   
	   public void einser () {								    
	   	   
		   if (player ==1) {
				  Player.decisioneinser(currentDiceResult, resultPlayer1, decisionPlayer1 ); 			       
				  displEinserPlayer1.setText(""+ currentDiceResult[0]);
			  }
			  else {
				  Player.decisioneinser(currentDiceResult, resultPlayer2, decisionPlayer2 ); 					
				  displEinserPlayer2.setText(""+ currentDiceResult[0]);
			  }
		   	   	   
		   functionsAfterDecision();
			}
	      
	      public void dreierpasch () {	
		   		    

	    	  if (player ==1) {
	   		       Player.decision3erpasch(currentDiceResult, resultPlayer1, decisionPlayer1 ); 					    
	   			   displ3erpaschPlayer1.setText(""+ currentDiceResult[1]);
	    	  }
			  else {
	   			    Player.decision3erpasch(currentDiceResult, resultPlayer2, decisionPlayer2 );					
	   			    displ3erpaschPlayer2.setText(""+ currentDiceResult[1]);
	   		  }
	   	   	   	   
	   	   functionsAfterDecision();
	    			   
	   		}    
	   
	   public void chance () {
		   
		   if (player ==1) {
			      Player.decisionchance(currentDiceResult, resultPlayer1, decisionPlayer1 );				    
				  displChancePlayer1.setText(""+ currentDiceResult[2]);
		   }
			  else {		    	  
			  	  Player.decisionchance(currentDiceResult, resultPlayer2, decisionPlayer2 );					
				  displChancePlayer2.setText(""+ currentDiceResult[2]);
		   }
		   	   	   
		   	functionsAfterDecision();    
		}     
	   
	   public void fullhouse () {
		   
		   if (player ==1) {
			      Player.decisionfullhouse(currentDiceResult, resultPlayer1, decisionPlayer1 );				  
				  displFullHousePlayer1.setText(""+ currentDiceResult[3]);
			  }
			  else {
				  Player.decisionfullhouse(currentDiceResult, resultPlayer2, decisionPlayer2 );				
				  displFullHousePlayer2.setText(""+ currentDiceResult[3]);
			  }
		   
		   	functionsAfterDecision();    
		}     

	   public void kleinestrasse () {
		   
		   if (player ==1) {
		   
			      Player.decisionkleinestrasse(currentDiceResult, resultPlayer1, decisionPlayer1 );					                   
				  displKlStrPlayer1.setText(""+ currentDiceResult[4]);
		   }
			  else {
				  Player.decisionkleinestrasse(currentDiceResult, resultPlayer2, decisionPlayer2 );				
				  displKlStrPlayer2.setText(""+ currentDiceResult[4]);
			  }
		   
		   
		   
		   functionsAfterDecision();    
		}     

	   public void grossestrasse () {
		   
		   if (player ==1) {
			      Player.decisiongrossestrasse(currentDiceResult, resultPlayer1, decisionPlayer1 );				   
				  displGrStrPlayer1.setText(""+ currentDiceResult[5]);
		   }
			  else {
				  Player.decisiongrossestrasse(currentDiceResult, resultPlayer2, decisionPlayer2 );	
				  displGrStrPlayer2.setText(""+ currentDiceResult[5]);
			  }
		   
		   	functionsAfterDecision();    
		}     

	   public void kniffel () {
		   
		   if (player ==1) {
			      Player.decisionkniffel(currentDiceResult, resultPlayer1, decisionPlayer1 );				   
				  displKniffelPlayer1.setText(""+ currentDiceResult[6]);
				   }
			  else {
				  Player.decisionkniffel(currentDiceResult, resultPlayer2, decisionPlayer2 );					
				  displKniffelPlayer2.setText(""+ currentDiceResult[6]);
		   }

		   	functionsAfterDecision();    
		}     

   public void changePlayer () {
	   
	   noPlayerChange = 0;		 
	
	   if (player ==1) {
		   player =2;
	   }
		  else {
		   player=1;
	   } 
	   
	   displayPlayerNumber.setText("" + player);
	
	   	runTheDice.setDisable(false);								
	   	numberOfThrows = new int []{0};                             
		keepDice = new int[]{0,0,0,0,0};									// Reset Array Würfel halten
		dice[5] = 0;												    // Summe Augen = 0
	
		resetGUI();
	}     

   public void gameInstructions () {
	   
	        JFrame anzspielanleitung = new JFrame();
	        anzspielanleitung.setBounds(000, 000, 000, 000);
	        anzspielanleitung.setVisible(true);
	        anzspielanleitung.add(new JLabel(new ImageIcon("Spielanleitung.jpg")));
	        anzspielanleitung.pack();
	}

private void resetGUI() {	
	
	displayNumberOfThrows.setText("" +numberOfThrows[0]);   		
	statusMessage.clear();	
	displaySummaryDices.clear();	
	displayPlayerNumber.setText("" + player);
	dspCurrentDiceResultEinser.clear();	
	dspCurrentDiceResultDreierpasch.clear();	
	dspCurrentDiceResultChance.clear();	
	dspCurrentDiceResultFullhouse.clear();	
	dspCurrentDiceResultKleinestrasse.clear();	
	dspCurrentDiceResultGrossestrasse.clear();	
	dspCurrentDiceResultKniffel.clear();	
		
	Image picDiceEyes0 = new Image("DiceEyes0.png");
	dice1.setImage(picDiceEyes0);
	dice2.setImage(picDiceEyes0);
	dice3.setImage(picDiceEyes0);
	dice4.setImage(picDiceEyes0);
	dice5.setImage(picDiceEyes0);
	
}

  private void functionsAfterDecision() {
	  
	  displSumPlayer1.setText(""+ resultPlayer1[7]);
	  displSumPlayer2.setText(""+ resultPlayer2[7]);
	 	  
	  resetGUI();													       
      
	   evaluationCurrentDiceResult = new int []{0,0,0,0,0,0,0} ;    			   
	   enableSelection = new int[]{0,0,0,0,0,0,0}; 			   
	   
	    changePlayer.setDisable(false);
	    runTheDice.setDisable(false);									
	    keepDiceResultDisable();
		selectionDisable();
 
		numberOfThrows = new int []{0};											 
		displayNumberOfThrows.setText("" + numberOfThrows[0]);   
		statusMessage.setText(" ");
		keepDice = new int[]{0,0,0,0,0};									
		numberOfRounds++;
		
		if (( numberOfRounds == 7 && noPlayerChange == 1 )  || ( numberOfRounds == 14 && noPlayerChange == 0 ))
		{
		runTheDice.setDisable(true);
		changePlayer.setDisable(true);
		
		String namePlayer1;
		String namePlayer2;
		
		namePlayer1 = displNamePlayer1.getText();
		namePlayer2 = displNamePlayer2.getText();
						
		if ( resultPlayer1[7] >resultPlayer2[7]  )
			{
				statusMessage.setText("Player 1 " + namePlayer1  + " hat mit " + resultPlayer1[7] + " Punkten gewonnen !!!!"); 
			}
			if ( resultPlayer1[7] < resultPlayer2[7]  )
			{
				statusMessage.setText("Player 2 "  +  namePlayer2 +" hat mit " + resultPlayer2[7] + " Punkten gewonnen !!!!"); 
			}
			if ( resultPlayer1[7] == resultPlayer2[7]  )
			{
				statusMessage.setText("Unentschieden !!!!"); 
			}
		} 
  }
  
		private void keepDiceResultDisable() {
			keepDice1.setDisable(true);								
			keepDice2.setDisable(true);
			keepDice3.setDisable(true);
			keepDice4.setDisable(true);
			keepDice5.setDisable(true);
  
  }
		private void selectionDisable() {
			einser.setDisable(true);								
			dreierpasch.setDisable(true);
			chance.setDisable(true);
			fullhouse.setDisable(true);
			kleinestrasse.setDisable(true);
			grossestrasse.setDisable(true);
			kniffel.setDisable(true);
  
  }

		
		private void displayDiceImages() {
		
			Image picDiceEyes1 = new Image("DiceEyes1.png");
			   Image picDiceEyes2 = new Image("DiceEyes2.png");
			   Image picDiceEyes3 = new Image("DiceEyes3.png");
			   Image picDiceEyes4 = new Image("DiceEyes4.png");
			   Image picDiceEyes5 = new Image("DiceEyes5.png");
			   Image picDiceEyes6 = new Image("DiceEyes6.png");
			   
			   switch(dice[0]) {
			   case 1 :dice1.setImage(picDiceEyes1); break; 
			   case 2 :dice1.setImage(picDiceEyes2); break;  
			   case 3 :dice1.setImage(picDiceEyes3); break; 
			   case 4 :dice1.setImage(picDiceEyes4); break; 
			   case 5 :dice1.setImage(picDiceEyes5); break; 
			   case 6 :dice1.setImage(picDiceEyes6); break; 
			   default:break;
			   }
			   
			   switch(dice[1]) {
			   case 1 :dice2.setImage(picDiceEyes1); break; 
			   case 2 :dice2.setImage(picDiceEyes2); break;  
			   case 3 :dice2.setImage(picDiceEyes3); break; 
			   case 4 :dice2.setImage(picDiceEyes4); break; 
			   case 5 :dice2.setImage(picDiceEyes5); break; 
			   case 6 :dice2.setImage(picDiceEyes6); break; 
			   default:break;
			   }
			   
			   switch(dice[2]) {
			   case 1 :dice3.setImage(picDiceEyes1); break; 
			   case 2 :dice3.setImage(picDiceEyes2); break;  
			   case 3 :dice3.setImage(picDiceEyes3); break; 
			   case 4 :dice3.setImage(picDiceEyes4); break; 
			   case 5 :dice3.setImage(picDiceEyes5); break; 
			   case 6 :dice3.setImage(picDiceEyes6); break; 
			   default:break;
			   }
			   
			   switch(dice[3]) {
			   case 1 :dice4.setImage(picDiceEyes1); break; 
			   case 2 :dice4.setImage(picDiceEyes2); break;  
			   case 3 :dice4.setImage(picDiceEyes3); break; 
			   case 4 :dice4.setImage(picDiceEyes4); break; 
			   case 5 :dice4.setImage(picDiceEyes5); break; 
			   case 6 :dice4.setImage(picDiceEyes6); break; 
			   default:break;
			   }
			   switch(dice[4]) {
			   case 1 :dice5.setImage(picDiceEyes1); break; 
			   case 2 :dice5.setImage(picDiceEyes2); break;  
			   case 3 :dice5.setImage(picDiceEyes3); break; 
			   case 4 :dice5.setImage(picDiceEyes4); break; 
			   case 5 :dice5.setImage(picDiceEyes5); break; 
			   case 6 :dice5.setImage(picDiceEyes6); break; 
			   default:break;
			   }
		 }
  }


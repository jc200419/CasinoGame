package casinogame;

import java.util.*; 


public class CasinoGame {
    public static int PlayerCoins = 1000;

    public static Scanner input = new Scanner(System.in);
    
    public static void main(String[] args) {
        System.out.println("Hi, and welcome to my casino! \nYou can pick games to play and you scores will be recorded");
        
        
        
        while (true){
            System.out.println("please enter one of the following");
            System.out.println("1 - To play BlackJack");
            int UserChoice = input.nextInt();
            
            
            switch (UserChoice) {
                case 1:
                    BlackJack();        
            }
   
        }
        
    }
    
    public static void BlackJack(){
        
        try{
            int currentcardvalue = 0;
            System.out.println("welcome to BlackJack!");
            System.out.println("lets begin...");
            Thread.sleep(1000);
            while (true){
                int FirstCard = Random(12);
                int SecondCard = Random(12);
                int AICard = Random(12);
                int AISecondCard = Random(12);
                System.out.println("Your first card is a : " + FirstCard);
                System.out.println("The dealer got a :" + AICard);
                System.out.println("CURRENT BALANCE: " + PlayerCoins);
                System.out.println("enter your bet :");
                int PlayerBet = input.nextInt(); 
                System.out.println("Your Second card is a : " + SecondCard);
                currentcardvalue = FirstCard + SecondCard;
                
                if ((currentcardvalue) == 21){
                    System.out.println("congrats you got a blackjack");
                    PlayerCoins = PlayerCoins + (PlayerBet * 3);
                    System.out.println("YOUR BALANCE IS NOW : " + PlayerCoins);
                    break;
                    
                }else{
                    while (true){
                        if (currentcardvalue > 21){
                                System.out.println("You went bust sorry");
                                PlayerCoins = PlayerCoins - (PlayerBet);
                                System.out.println("YOUR BALANCE IS NOW : " + PlayerCoins);
                                break;
                        }else{
                            System.out.println("would you like to 'hit' or 'stand'?");
                            String HitOrStand = input.next(); 
                            if (HitOrStand.equalsIgnoreCase("hit")){
                                int hitcard = Random(12);
                                System.out.println("you got a : " + hitcard);
                                currentcardvalue = currentcardvalue + hitcard;

                            }else{
                                System.out.println("The dealers second card is a : " + AISecondCard);
                                int aicurrentvalue = AICard + AISecondCard;
                                while (aicurrentvalue < 16){
                                    int AIHitCard = Random(12);
                                    aicurrentvalue = aicurrentvalue + AIHitCard;
                                    
                                }
                                System.out.println("the dealer ended on : " + aicurrentvalue);
                                if (aicurrentvalue > 21){
                                    System.out.println("the Ai went bust");
                                    PlayerCoins = PlayerCoins + (PlayerBet);
                                    System.out.println("YOUR BALANCE IS NOW : " + PlayerCoins);
                                    break;
                               
                                }else if (aicurrentvalue == currentcardvalue){
                                    System.out.println("its a tie, you keep you money ");
                                    break;                                    
                                }else if (aicurrentvalue > currentcardvalue){
                                    System.out.println("You lost");
                                    PlayerCoins = PlayerCoins - (PlayerBet);
                                    System.out.println("YOUR BALANCE IS NOW : " + PlayerCoins);
                                    break;
                                }else{
                                    System.out.println("You win!!!");
                                    PlayerCoins = PlayerCoins + (PlayerBet);
                                    System.out.println("YOUR BALANCE IS NOW : " + PlayerCoins);
                                    break;
                                }
                                
                            }
                        }    
                    }
                    System.out.println("Do you want to play again? \n1 -  for yes \n2 - for no");
                    int PlayAgain = input.nextInt();
                    if (PlayAgain == 2){
                        break;
                    }
                    
                    
                    
                }
                
                
            }
            
            
            
            
            
            
        }catch(Exception e){
            System.out.println("error" + e);
        }    
        
        
    }
    public static int Random(int ran){
        Random random = new Random(); 
        return random.nextInt(ran + 1);
        
        
    }
    
}

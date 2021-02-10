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
            System.out.println("2 - To play Roulette");
            int UserChoice = input.nextInt();
            
            
            switch (UserChoice) {
                case 1:
                    BlackJack();  
                case 2: 
                    Roulette();
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
    public static void Roulette(){
        
        try{
            System.out.println("welcome to Roulette!");
            Thread.sleep(1000);
            System.out.println("You will need to choose a colour and number you wish to bet on.");
            Thread.sleep(1000);
            System.out.println("lets begin...");
            Thread.sleep(1000);
            
            while(true){


                System.out.println("Firstly chose how much you want to bet on a colour :");
                int RouletteBetColour = input.nextInt(); 

                System.out.println("Pick a colour, Red (x2) - Black (x2)- Green (x16)");
                String Colour = input.next(); 
                System.out.println("Now chose how much you want to bet on a Number :");
                int RouletteBetNumber = input.nextInt(); 

                System.out.println("pick a number between 1 - 36 (x35 if you win): ");
                int Number = input.nextInt(); 
                System.out.println("The ball has been spun");            
                Thread.sleep(1000);
                System.out.println("Rolling...");
                Thread.sleep(1000);
                System.out.println("Rolling...");
                Thread.sleep(1000);

                int RandomNum = Random(36);
                String RandomColour = RandomColour();

                System.out.println("The Colour was " + RandomColour);
                Thread.sleep(1000);
                System.out.println("And the Number was " + RandomNum);
                Thread.sleep(1000);
                System.out.println("this means...");
                Thread.sleep(1000);


                if (Number == RandomNum){
                    System.out.println("CONGRATS you guessed the number correct");
                    System.out.println("You won x35 of you bet");
                    PlayerCoins = PlayerCoins + (RouletteBetNumber * 35);

                }else{
                    System.out.println("Sorry you didnt win the number ");
                    PlayerCoins = PlayerCoins - RouletteBetNumber;

                }
                if (Colour.equalsIgnoreCase(RandomColour)){
                    System.out.println("CONGRATS you guessed the colour correct");
                    if (Colour.equalsIgnoreCase("Green")){
                        System.out.println("You won x16 of your bet");
                        PlayerCoins = PlayerCoins + (RouletteBetColour * 16);
                    }else{
                        System.out.println("You won x2 of you bet");
                        PlayerCoins = PlayerCoins + (RouletteBetColour * 2);
                    }
                }else{
                    System.out.println("Sorry you didn't win the colour");
                    PlayerCoins = PlayerCoins - RouletteBetColour;
                }


                System.out.println("YOUR BALANCE IS NOW : " + PlayerCoins);
                
                System.out.println("Do you want to play again? \n1 -  for yes \n2 - for no");
                int PlayAgain = input.nextInt();
                if (PlayAgain == 2){
                    break;
                }    
                    
            }  
            


        }    
        catch (Exception e){
            System.out.println("error" + e);
        }
        
    }
    public static String RandomColour(){
        Random random = new Random(); 
        String[] ColourArray = {"green", "red", "black"};
        int tempRanNum = random.nextInt(36);
        if (tempRanNum == 1 || tempRanNum == 0){
            return (ColourArray[0]);
   
        }else if ((tempRanNum % 2) == 0){
            return (ColourArray[1]);
        }else{
            return (ColourArray[2]);
        }
        
    }
    
    
}

package casinogame;

import java.util.*; 
import java.io.*;


public class CasinoGame {
    public static ArrayList<Data> UserData = new ArrayList<>();
    public static int PlayerCoins;
    public static Scanner input = new Scanner(System.in);
    public static String path = System.getProperty("user.dir") + "\\users.txt";
    public static String Username;
    public static String Userpassword;
    public static String line;
    public static void main(String[] args) {
        System.out.println("Hi, and welcome to my casino! \nYou can pick games to play and you scores will be recorded");
        
        System.out.println("if you want to check the code works first create a account \nFYI the save and exit or changeing the player coin total i couldn't figure out ");
        
        Login();
        
        
        while (true){
            System.out.println("please enter one of the following");
            System.out.println("1 - To play BlackJack");
            System.out.println("2 - To play Roulette");
            System.out.println("3 - To Use the Slot Machine");
            System.out.println("4 - To Save and Exit");
            int UserChoice = input.nextInt();
            
            
            switch (UserChoice) {
                case 1:
                    BlackJack();  
                case 2: 
                    Roulette();
                case 3:
                    SlotMachine();
                case 4:
                    SaveAndExit(); 
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
    
    public static void SlotMachine(){
        try{
            System.out.println("welcome the slot machine!");
            Thread.sleep(1000);
            System.out.println("You will need to choose a number between 1 and 10 then spin the wheel \nYou have a 1 in 5 chance to win each time.");
            Thread.sleep(1000);
            System.out.println("lets begin...");
            Thread.sleep(1000);
            while (true){
                System.out.println("Enter how much you would like to bet :");
                int SlotBet = input.nextInt(); 
                System.out.println("Pick your number : (1 - 10)");
                int PlayerGuess = input.nextInt(); 

                Thread.sleep(1000);
                while (true){
                    int win = Random(5);
                    if (win == 1){
                        System.out.print(PlayerGuess + "  ");
                        Thread.sleep(1000);
                        System.out.print(PlayerGuess + "  ");
                        Thread.sleep(1000);
                        System.out.print(PlayerGuess + "  ");
                        Thread.sleep(1000);
                        System.out.println("Congrats u won!");
                        PlayerCoins = PlayerCoins + (SlotBet * 2);
                        System.out.println("YOUR BALANCE IS NOW : " + PlayerCoins);
                        
                        break;
                    }else{
                        System.out.print(Random(10) + "  ");
                        Thread.sleep(1000);
                        System.out.print(Random(10) + "  ");
                        Thread.sleep(1000);
                        System.out.print(Random(10) + "  ");
                        Thread.sleep(1000);
                        System.out.println("Sorry, you didn't win this time");
                        PlayerCoins = PlayerCoins - SlotBet;
                        System.out.println("YOUR BALANCE IS NOW : " + PlayerCoins);
                        System.out.println("would you like to spin again with the same bet and number? yes or no :");
                        String Spin = input.next();
                        if (Spin.equalsIgnoreCase("no")){
                            break;
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
        catch (Exception e){
            System.out.println("error" + e);
        }
        
        
        
    }
    
    public static void Login (){
        
        System.out.println("1 - LogIn");
        System.out.println("2 - Register");
        int pick = input.nextInt(); 
        
        switch (pick){
            case 1:
                boolean correct = false; 
                System.out.println("enter Name:");
                String UserName = input.next(); 
                System.out.println("enter Password:");
                String UserPassword = input.next();
                
                try{
                    BufferedReader read = new BufferedReader(new FileReader(path));
                    int i = 0;
                    while ((line = read.readLine()) != null){
                        String[] info = line.split(", ");

                        if (info[i].equalsIgnoreCase(UserName)){
                            if (info[i+1].equalsIgnoreCase(UserPassword)){
                                System.out.println("Welcome");
                                PlayerCoins = Integer.parseInt(info[i+2]);
                                Username = UserName;
                                Userpassword = UserPassword;
                                correct = true; 
                                
                            }
                            
                        }
                        i++;
                    }
                    if (correct == false){
                        
                        System.out.println("sorry wrong username or password");
                        System.exit(0);
                    }
                    
                    
                    
                }catch (Exception e){
                    System.out.println("error" + e);
                }
                
            break;
                
                
                
            case 2:
                System.out.println("enter Name:");
                String Name = input.next(); 
                System.out.println("enter Password");
                String Password = input.next(); 
                int coins = 1000; 
                Data NewCustomer = new Data(Name, Password, coins);
                UserData.add(NewCustomer);
                try{
                    FileWriter writeToFile = new FileWriter(path, true); 
                    PrintWriter printToFile = new PrintWriter(writeToFile);
                    
                    for (int i = 0; i < UserData.size(); i++) {
                        printToFile.println(UserData.get(i).toString());
                        
                    }
                    printToFile.close();
                    writeToFile.close();
            

                }catch (Exception e){
                    System.out.println("error" + e);
                }
                System.out.println("Ok you are in the system. As a welcome you get 1000 coins");
            break;    
        }
        
        
        
    }
    
    public static void SaveAndExit(){
        System.exit(0);
        
//        Data overide = new Data(Username, Userpassword, PlayerCoins);
//        UserData.add(overide);
//        try{
//            FileWriter writeToFile = new FileWriter(path, false); 
//            PrintWriter printToFile = new PrintWriter(writeToFile);
//            BufferedReader read = new BufferedReader(new FileReader(path));
//            
//            while ((line = read.readLine()) != null){
//                        String[] info = line.split(", ");
//
//            
//            
//        }catch (Exception e){
//            System.out.println("error" + e);
//        }
//        
    }
    
}

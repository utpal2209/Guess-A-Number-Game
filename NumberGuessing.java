import java.util.Scanner;
import java.util.Random;

public class NumberGuessing {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    
    public static int guessnum(){
            Random r=new Random();
            System.out.println(ANSI_BLUE + "Generating a random number..." + ANSI_RESET);
            int gamenum=r.nextInt(100);
            System.out.println(ANSI_GREEN + "the random number has been generated..." + ANSI_RESET);
            return gamenum;
    }
    public static int userguess(){
        Scanner sc=new Scanner(System.in);
        System.out.println(ANSI_YELLOW + "please guess a number: " + ANSI_RESET);
        int usernum=sc.nextInt();
        if(usernum<=100 && usernum>=0){
            return usernum;
        }
        else{
            System.out.println(ANSI_RED + "please guess a num between 0 to 100" + ANSI_RESET);
            return 0;
        }
    }
    public static void game(){
        int gamenum=guessnum();
        int usernum=userguess();
        int count=0;
        while(true){
          if(count==10){
              System.out.println(ANSI_RED + "Sorry you were unable to guess the number within 10 trials" + ANSI_RESET);
              System.out.println(ANSI_YELLOW + "The number guessed by computer is: "+gamenum + ANSI_RESET);
              break;
          }
          else if(usernum>gamenum){
              System.out.println(ANSI_RED + "Too high please guess again!" + ANSI_RESET);
              usernum=userguess();
              count++;
          }
          else if(usernum<gamenum){
              System.out.println(ANSI_RED + "Too low please guess again!" + ANSI_RESET);
              usernum=userguess();
              count++;
          }
          else if(usernum==gamenum){
              System.out.printf(ANSI_GREEN + "you have guessed the correct number in %d trials\n" + ANSI_RESET,count+1);
              break;
          }
      }
    }
    public static void playagain(){
        Scanner sc=new Scanner(System.in);
        System.out.println(ANSI_BLUE + "Do you wish to play again,if yes choose 1 else 0" + ANSI_RESET);
        int again=sc.nextInt();
        if(again==0){
         System.out.println(ANSI_YELLOW + "game over" + ANSI_RESET);
         System.out.println(ANSI_RED + "Taking you out of the game.... " + ANSI_RESET);
        }
        else if(again==1){
        game();
        playagain();
       }
       else{
        System.out.println(ANSI_RED + "please choose a valid number between 0 to 1..." + ANSI_RESET);
       }
    }
    public static void main(String[]args){
        Scanner sc=new Scanner(System.in);
        game();
        playagain();
       }
   }
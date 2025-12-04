package hangman_isaias_samson_hugo;

import java.util.Scanner;

class Level {
    String word = "hello".toUpperCase();
    int trials;

    public void katawan(int trials){
        if(trials == 6){
            System.out.println("+__+");
             System.out.println("  |");
        }
        else if(trials == 5){
            System.out.println("+__+");
            System.out.println("   |");
            System.out.println("  ( )");   
        }
        else if(trials == 4){
            System.out.println("+__+");
            System.out.println("   |");
            System.out.println("  ( )");  
            System.out.println("   |");
        }
        else if(trials == 3){
            System.out.println("+__+");
            System.out.println("   |");
            System.out.println("  ( )");  
            System.out.println("  /|");
        }
        else if(trials == 2){
            System.out.println("+__+");
            System.out.println("   |");
            System.out.println("  ( )");  
            System.out.println("  /|\\");
        }
        else if(trials == 1){
            System.out.println("+__+");
            System.out.println("   |");
            System.out.println("  ( )");  
            System.out.println("  /|\\");
            System.out.println("  /");
        }
        else if(trials == 0){
            System.out.println("+__+");
            System.out.println("   |");
            System.out.println("  ( )");  
            System.out.println("  /|\\");
            System.out.println("  / \\");
        }
        
    }
    public Level(int trials) {
        this.trials = trials;
    }
}

class Game {

    char[] placeholder_arr;
    String placeholder;
    String letter;
    int tries;
    
    public void mainGame(Level l, String ph) {
        
        if (l.trials == 0) {
            System.out.println("GAME OVER BITCH");
            System.exit(0);
        }
        
        if (ph.equals(l.word)) {
            System.out.println("Congrats! The correct answer is " + l.word);
            System.exit(0);
        }
        
        Scanner input = new Scanner(System.in);        
        
        for (int i = 0; i < this.placeholder_arr.length; i++) {
            System.out.printf("%s ", this.placeholder_arr[i]);
        }
        System.out.println();
        System.out.print("Enter the Letter: ");
        letter = input.next().toUpperCase();

        char[] let_pl = letter.toCharArray();
        char let = let_pl[0];

        if (!l.word.contains(letter)) {
            l.trials--;
            l.katawan(l.trials);
            this.tries++;
            mainGame(l, ph);
        }
        
        for (int j = 0; j < l.word.length(); j++) {
            if (l.word.charAt(j) == let && placeholder_arr[j] == '_') {
                placeholder_arr[j] = l.word.charAt(j);
                ph = new String(placeholder_arr);
                mainGame(l, ph);
            }
        }
        
    }
    
    public void init() {
        Level l = new Level(7);
        
        this.placeholder_arr = new char[l.word.length()];
        
        for (int i = 0; i < l.word.length(); i++) {
            this.placeholder_arr[i] = '_';
        }
        this.placeholder = new String(this.placeholder_arr);
        this.mainGame(l, this.placeholder);
    }
}

public class HANGMAN_ISAIAS_SAMSON_HUGO {
    public static void main(String[] args) {
        Game g = new Game();
        g.init();
    }
    
}

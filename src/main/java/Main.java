
/**
 *
 * @author x7a95
 */
import java.io.*;
import java.util.*;

class Main {
  // Application (is all of the looped code in the main try and 2 catches )

  static boolean wordValid(String x, List<String> yourArray) {
              // ^^^^^^^^^this should check the existence of the word in the dictionary. 
    if (yourArray.contains(x)){
      return true;
    }
    else {
      return false;
    }
  }
  
  static String[] gameRestart(String[] ArrayPrior) {
                //^^^^^^^^^^^should initialize the array again and start looping again.
    String[] ArraySuccessor = new String[ArrayPrior.length + 1];
    for (int i = 0; i < ArrayPrior.length; i++) {
      ArraySuccessor[i] = ArrayPrior[i];
    }
    return ArraySuccessor;
  }
  

  public static void main(String[] args){
  
  //gameStart
    try{
      BufferedReader comprehend = new BufferedReader(new FileReader("dictionary.txt"));
      String eachline = comprehend.readLine();
      List<String> dictionary = new ArrayList<String>();
      while(eachline != null) {
          String[] dictionaryLine = eachline.split(" ");
          for(String pick : dictionaryLine) {
              dictionary.add(pick);
          }
          eachline = comprehend.readLine();
      }
      Random rand = new Random();
      String[] words = new String[0];
            // ^^^^^An array of words listed while playing the game to fulfil
      boolean outcome = true;
            //^^^^^^^A Boolean variable which is true when game is over. 
      boolean empty = false;
      boolean InExistance = false;
      boolean replication = false;
      boolean continueORterminate = true;
            //^^^^^^^^^^^^^^^^^^^A Boolean variable which is true for continuation of the message display. 
      int count = 0;
      Scanner scanner = new Scanner(System.in);
      String playersChoice = "";
      String randomWord = dictionary.get(rand.nextInt(dictionary.size()));
      while (true) {
        words = new String[0];
        words = gameRestart(words);
        words[0] = dictionary.get(rand.nextInt(dictionary.size()));
        InExistance = false;
        count = 0;
        outcome = true;
        
        words[0] = randomWord;
        System.out.println("Word Game started with: "+ words[0] +"\nEnter a word (caseSensitive) to play the game, such as 'empathy->yet->top...':");
        for (String i : words) {
        System.out.print(i + " ");
        }
        do {
          InExistance = false;
          empty = false;
          replication = false;
          System.out.print("\nEnter a word (caseSensitive) to play the game, such as 'empathy->yet->top...:' ");
          playersChoice = scanner.nextLine();
            if (wordValid(playersChoice, dictionary) == true) {
              InExistance = true;
            }
            for (int i=0; i<words.length; i++) {
              if (playersChoice.equalsIgnoreCase((words[i]))) {
              replication = true;
            }
            }
          try {
            if ((words[count].charAt(words[count].length()-1)) != (playersChoice.charAt(0))){
              //^^Fulfils Rule 1 condition of which: The first character of the next word should start with the last character of the previous word and they are case sensitive (for example, “Eat” and “eat” are different). For an invalid word, the game should continue with a message “Entered word is invalid or does not exist in the dictionary, please try again”. 
              System.out.println("\nEntered word is invalid or does not exist in the dictionary, please try again");
            } else if (playersChoice.matches("[a-zA-Z]+") == false) {
                    //^^Fulfils Rule 3 condition of which: The word should have only the alphanumeric characters (such as [A-Z] and [a to z]), and should not have any numeric character (such as numbers 4 or 7) or space or hyphenated (such as co-worker) or special characters (such as ; , :) within itself. For an invalid word, the game should continue with a message “Entered word is invalid or does not exist in the dictionary, please try again”. 
              System.out.println("\nEntered word is invalid or does not exist in the dictionary, please try again");
            } else if (InExistance == false) {
              //Fulfils Rule 4: The word should be a valid word existing in the dictionary. Use the attached dictionary.zip (containing dictionary.txt) file as the dictionary. For an invalid word, the game should continue with a message “Entered word is invalid or does not exist in the dictionary, please try again”. 
              System.out.println("\nEntered word is invalid or does not exist in the dictionary, please try again");
            } else if (replication == true) {
              outcome = true;
              System.out.println("Game Over");
              System.exit(0);
              //^Fulfils Rule 2 condition of which: The word must not be entered in the game before. The game must be terminated if any word is repeated with a message “Game over”. 
            } else {
              //^this whole else statement is dedicated to the Rule 5: If nothing is entered by the user (empty string or word with length 0), the game must restart from the beginning. 
              System.out.println("continue");
              continueORterminate = false;
              words = gameRestart(words);
              count++;
              words[count] = playersChoice;
              System.out.println();
              for (String i : words) {
                System.out.print(i + " ");
              }
            }
          } catch (StringIndexOutOfBoundsException e) {
            System.out.println("\nGame Restarting as the entered word was empty");
            empty = true;
            break;
          } 
        } while (empty == false);
        System.out.println();
    }
  } 
    catch (FileNotFoundException e) {
      System.out.println("file not found on this computer please upload 'dictionary.txt' file onto this software ");
              System.exit(0);
  } 
    catch (IOException e) {
      System.out.println("IOException error when trying to access 'dictionary.txt' file");
  }
  }
}
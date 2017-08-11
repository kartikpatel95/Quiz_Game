/*Kartik Patel
 * 12.11.2013
 * Application class for creating window
 */
package Quiz;
import javax.swing.*;

public class Quiz{
  public static void main(String [] args){ 

    
    JFrame window = new JFrame("Quiz Game");//sets the title on the title bar
    window.getContentPane().add(new QuizPanel());
    window.setVisible(true);
    window.pack();
    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
 }
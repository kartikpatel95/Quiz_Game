/*Kartik Patel
 * 12.11.2013
 * GUI class for design and program
 */

//package for folder
package Quiz;

//imports 
import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*; //step 1
import java.io.*;


/**Stores, editors & displays arrayLists, image icons, JLabels, JButtons, JRadioButtons, JTextFields & questionNumber and score
  * author Kartik Patel
  * @version 11, November 12th  
 */

//extends java for GUI 
public class QuizPanel extends JPanel{
  /**array lists to hold questions*/
   ArrayList<QuestionInfo>fileData = new ArrayList<QuestionInfo>();  
  private ArrayList<QuestionInfo>oneData = new ArrayList<QuestionInfo>(); // reads easy questions
  private ArrayList<QuestionInfo>twoData = new ArrayList<QuestionInfo>(); // reads harder questions
 
  /**image icons been converted into JLabels*/
  private ImageIcon happy = new ImageIcon("Quiz/images/happy.png");
  private JLabel happyImage = new JLabel(happy);   
  private ImageIcon unHappy = new ImageIcon("Quiz/images/unhappy.png");
  private JLabel unHappyImage = new JLabel(unHappy);
  
  /**Buttons clicked on*/
  private JButton submitButton;
  private JButton nextButton;
  private JButton levelOneButton;
  private JButton levelTwoButton;
  private JButton quitButton;
  
  /**Jlabels display information*/
  private JLabel welcome = new JLabel("Welcome to the quiz game, please enter your name and select your level!");
  private JLabel question;
  private JLabel correctLabel = new JLabel("");
  private JLabel correctAnswer = new JLabel("");
  private JLabel ended = new JLabel("");
  private JLabel responce = new JLabel("");
  private JLabel name = new JLabel("Enter Name");
 
  /**JRadioButtons to choose answer*/
 private JRadioButton [] options = { new JRadioButton (""), new JRadioButton (""), new JRadioButton (""), new JRadioButton (""),};
         ButtonGroup optionsGroup = new ButtonGroup ();
 
 /**JTextField to insert name*/
 private JTextField enterName = new JTextField("",8); 

 /**questionNumber starts at 0*/
private int questionNumber = 0;
/**score starts at 0*/
private int score = 0;

/**Border Layout Panels*/
  private JPanel northPanel = new JPanel();
  private JPanel eastPanel = new JPanel();
  private JPanel southPanel = new JPanel();
  private JPanel westPanel = new JPanel();
  private JPanel centerPanel = new JPanel();
  
  //inside border layout
  private JPanel inerCenter = new JPanel();
  
 
  /** concatenates parameters to two different arrayLists
    * stores Event Listener and the fileData
    * @param fileData array list
   */
  /**constructor*/
  public QuizPanel(){
    //arry list for question to be put into
    ArrayList<QuestionInfo>fileData = new ArrayList<QuestionInfo>();
    
    EventListener listener = new EventListener();//step 3
    this.fileData = fileData;
    
    question = new JLabel();
    
    
    //activates buttons with a name
    submitButton = new JButton("Check Answer");
    submitButton.addActionListener(listener);//step 4
    
    nextButton = new JButton("Next Question");
    nextButton.addActionListener(listener);
    
    levelOneButton = new JButton("Level One");
    levelOneButton.addActionListener(listener);
    
    levelTwoButton = new JButton("Level Two");
    levelTwoButton.addActionListener(listener);
    
    quitButton = new JButton("Quit Quiz");
    quitButton.addActionListener(listener);
    
    //make radio buttons work and adds each of them into GUI
    for (JRadioButton each:options){
    optionsGroup.add(each);
    each.addActionListener(listener);
    inerCenter.add(each);
    }
    
    
    /** sets up the JFrame (window) attibutes:
      * sets the location of the window (JFrame) on the screen
      * the size of the window and makes visibale
      * uses graphics methods to set style to window
      * @param g Graphics object from java.awt
     */
    
    //Border Layout been used
    setLayout(new BorderLayout());
    
    //North
    northPanel.setPreferredSize(new Dimension(400,65));
    northPanel.setBackground(Color.black);
   
    northPanel.add(question);
    question.setFont(new Font("Calibri",Font.BOLD,20));
    question.setForeground(Color.white);
   
    northPanel.add(welcome);
    welcome.setFont(new Font("Calibri",Font.BOLD,20));
    welcome.setForeground(Color.white);
     
    add(northPanel,BorderLayout.NORTH);
    
    //East
     eastPanel.setPreferredSize(new Dimension(100,200));
     eastPanel.setBackground(Color.green);
    
     eastPanel.add(submitButton);
     eastPanel.add(nextButton);
     
     nextButton.setVisible(false);
     submitButton.setVisible(false);
     add(eastPanel,BorderLayout.EAST);
    
    //South
     southPanel.setPreferredSize(new Dimension(400,65));
     southPanel.setBackground(Color.black);
    
     correctLabel.setFont(new Font("Calibri",Font.BOLD,30));
     correctLabel.setForeground(Color.white);
     southPanel.add(correctLabel);
     correctLabel.setVisible(false);
     
     southPanel.add(happyImage);
     happyImage.setVisible(false);
     southPanel.add(unHappyImage); 
     unHappyImage.setVisible(false);     
     add(southPanel,BorderLayout.SOUTH);
    
    //West
    westPanel.setBackground(Color.green);
    westPanel.setPreferredSize(new Dimension(100,200));
      
    westPanel.add(name);
    name.setFont(new Font("Calibri",Font.BOLD,16));
    westPanel.add(enterName);
   
    westPanel.add(quitButton);
    quitButton.setVisible(false);
         
    westPanel.add(levelOneButton);
    westPanel.add(levelTwoButton);
    add(westPanel,BorderLayout.WEST);
    
    //Center
     centerPanel.setBackground(Color.green);
     centerPanel.add(responce);
     responce.setFont(new Font("Calibri",Font.BOLD,20));
     responce.setForeground(Color.black);
     responce.setVisible(false);
     
     centerPanel.add(ended);
     ended.setFont(new Font("Calibri",Font.BOLD,20));
     ended.setForeground(Color.black);
     ended.setVisible(false);
     
     inerCenter.setBackground(Color.green);
     inerCenter.setVisible(false);
     centerPanel.add(inerCenter,BorderLayout.CENTER);
     
     add(centerPanel,BorderLayout.CENTER);
     
     
    
    /**set up outer panel colour and size*/
    setPreferredSize(new Dimension(700,350));
    setBackground(Color.green);

  }
  
  /**restart method*/ 
    public void restart(){
     score = 0;
     questionNumber = 0;
     responce.setVisible(false); 
     question.setVisible(true);
     ended.setVisible(false);
     optionsGroup.clearSelection();  
    }
    
    
  /**method for showing Questions*/
     public void showQuestion(int questionNumber,ArrayList<QuestionInfo> fileData) {
    
   //set text for question
      question.setText(fileData.get(questionNumber).getQuestion());
     
     //array for radio buttons which is been set  
      String[] answerList = fileData.get(questionNumber).getAnswers();
      for(int i = 0; i < options.length; i++) {
        options[i].setText(answerList[i]);
      }
      
      //gets the correct answer for the question number
      correctAnswer.setText(fileData.get(questionNumber).getRightAnswer());
      
    }
    
    

  
    

    /**step 2 write an inner class*/
 private class EventListener implements ActionListener{
   //arrayList for adding data into
   ArrayList<QuestionInfo>fileData= new ArrayList<QuestionInfo>();
   public void actionPerformed(ActionEvent e){        
 
        int clicked = 0;
        boolean answered = false;
 
// if level one button pressed
     if(e.getSource() == levelOneButton){
      questionNumber = 0; // start question at 0
      restart(); // restarts window when level button is clicked
      
      String levelOne = "Quiz/levelOne.txt"; // read in txt file
      readFile(levelOne, oneData); // reading levelOne and puting into oneData array
      fileData = oneData; // fileData equals the information inside oneData. Been converted into one array
      
//sets buttons and labels to visible and non visible
      quitButton.setVisible(true);
      inerCenter.setVisible(true);
      welcome.setVisible(false);
      name.setVisible(false);
      enterName.setVisible(false);
      submitButton.setVisible(true);
      levelOneButton.setVisible(false);
       
      //showing first question, from arrayList oneData
      showQuestion(questionNumber,oneData); 
    
      // else if level two button pressed
    } else if (e.getSource() == levelTwoButton){
      restart(); //restart the window screen
      questionNumber = 0; // start from question 0 in array
      
       String levelTwo = "Quiz/levelTwo.txt"; // read in txt file levelTwo
       readFile(levelTwo, twoData); //reading levelTwo and putting into twoData array
       fileData = twoData; // fileData equals twoData
       
       // sets buttons and labels to visible and non visible
       quitButton.setVisible(true);
       inerCenter.setVisible(true);
       levelOneButton.setVisible(false);
       name.setVisible(false);
       enterName.setVisible(false);
       welcome.setVisible(false);
       submitButton.setVisible(true);
       levelTwoButton.setVisible(false);
          
      //showing first question, from arrayList twoData    
       showQuestion(questionNumber,twoData);
     }
    
    //if quitButton is pressed window will close
 if(e.getSource() == quitButton){
 System.exit(0);
 }  
    //if submitButton pressed
     if(e.getSource() == submitButton){
       for(int i = 0; i < options.length; i++){
         if(options[i].isSelected()){ //radio button selected
           clicked = i; //clicked
           answered = true; //answer equals true
       }
     }
       
       if(answered){ //gets awsered from above
         //if correct answer equals the option clicked it will get correctLabel
         if(correctAnswer.getText().equals(options[clicked].getText())){
           //corect message
           correctLabel.setText("Correct");
           // visible and non visible
           nextButton.setVisible(true);
           correctLabel.setVisible(true);
           submitButton.setVisible(false);
           happyImage.setVisible(true);
           score++;
         }else{ // else do this
           // visible and non visible
           submitButton.setVisible(false);
           correctLabel.setVisible(true);
           nextButton.setVisible(true);
           unHappyImage.setVisible(true);
           // incoreect message
           correctLabel.setText("Incorrect correct answer is, " + fileData.get(questionNumber).getRightAnswer());          
     }  
    } 
       //else if nextButton pressed
     }else if (e.getSource() == nextButton){
        //set visible and non visible panels
       submitButton.setVisible(true);
       nextButton.setVisible(false);
       correctLabel.setVisible(false);
       happyImage.setVisible(false);
       unHappyImage.setVisible(false);
       
         if(questionNumber < fileData.size() - 1){ //next question 
         questionNumber++; //next question
         optionsGroup.clearSelection(); //clear radio button
         correctAnswer.setText(""); //set correctlabel to empty again
         showQuestion(questionNumber, fileData); //show questionNumber from fileData for next question
       
       }else{ // else
         //set visible and non visible panels
         submitButton.setVisible(false);
         nextButton.setVisible(false);
         question.setVisible(false);
         inerCenter.setVisible(false);
         ended.setVisible(true);
         //get users name with their score
         ended.setText(enterName.getText() + " scored " + score + "/3");
         responce.setVisible(true);
         //thank you message
         responce.setText("Thank you for taking the quiz, Your score is below.");
         levelOneButton.setVisible(false);
         
         }             
       }
     }
   }
      
     
 

     //read data from file into ArrayList
    public static void readFile(String filename, ArrayList<QuestionInfo>fileData){

      File questionFile = new File(filename);
      //File questionFileTwo = new File(filename);
      try {
        Scanner fileScan = new Scanner(questionFile);
        //while there is another line, read the next line into the array list
        while (fileScan.hasNextLine()){
          //split into tokens 
          String [] eachItem = fileScan.nextLine().split("/");
          String quest = eachItem[0];
          String ans1= eachItem[1];
          String ans2 = eachItem[2];
          String ans3 = eachItem[3];
          String ans4 = eachItem[4];
          String rghtAns = eachItem[5];
          String [] answrs ={ans1, ans2, ans3, ans4};
         //add into array list
          fileData.add(new QuestionInfo (quest, answrs, rghtAns));
          
      }
  
      } catch(FileNotFoundException e) {
        System.out.println("File not Found");
        System.exit(1);   //exit from program if file not found
      }
  
     
    }
    }
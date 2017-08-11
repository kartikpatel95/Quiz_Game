/*Kartik Patel
 * 12.11.2013
 * Support class for structure of the question and answer
 */
package Quiz;

/**stores, edits & displays the question, creates a array and displays the correct answer
  * @author Sandy Garner
  * Quiz November 12th
  */
public class QuestionInfo{
  /**quiz questions*/
  private String question;
  /**answer options*/
  private String [] answerList;
  /**correct answer*/
  private String rightAnswer;
  
/**concatenates first 2 parameters to one String
  * stores question, answerlist and correct answer
  * @param question quiz question
  * @param answerList quiz answer options
  * @param right answer quiz correct answer
  */
  public QuestionInfo (String question, String [] answerList, String rightAnswer) {
  this.question = question;
  this.answerList= answerList;
  this.rightAnswer = rightAnswer;
  }
  
  /** returns a description of this object
    * @return question
    */
  public String getQuestion() {
    return question;
  }
  
  /** returns a description of this object
    * @return answer options
    */
  public String [] getAnswers() {
    return answerList;
  }
  
  /** returns a description of this object
    * @return correct answer
    */
  public String getRightAnswer() {
    return rightAnswer;
  }
  
}
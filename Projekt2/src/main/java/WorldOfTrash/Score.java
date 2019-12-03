/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WorldOfTrash;

/**
 *
 * @author athiksawmy
 */
public class Score {

    // attribute for score with the type of integer
    private int score;

    // constructor - assigning score to a default value of 0
    public void Score() {
        this.score = 0;
    }
    
    // method - returning the score value
    public int getScore() {
        return score;
    }
    
    // Method - a getter method that can increase the score value
    public void scorePositive(int positiveScore) {
        score += positiveScore;
    }

    // Method - a getter method that can decrease the score value
    public void scoreNegative(int negativeScore) {
        score -= negativeScore;
    }

}

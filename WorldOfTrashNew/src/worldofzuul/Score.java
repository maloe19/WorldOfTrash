/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package worldofzuul;

/**
 *
 * @author athiksawmy
 */
public class Score {
    private int score; 
    
    public void Score(){
        this.score = 0;
    }
    
public int getScore() {
    return score;
}
public void scorePositive(int positiveScore) {
    score += positiveScore;
}
public void scoreNegative(int negativeScore) {
    score -= negativeScore;
}

}

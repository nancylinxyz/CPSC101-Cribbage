/* 2 behavoirs:
 * 1. addScore(int): add to score
 * 2. getScore: return score
 * @author: Nancy Lin
 */

class Score{

    private int score;

    public Score(){
        score = 0;
    }

    public void addScore(int i){
        score = score + i;
    }

    public int getScore(){
        return score;
    }
}
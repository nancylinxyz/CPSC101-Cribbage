/**
 *
 * @author mac
 */
import java.util.Arrays ;

public class Scorer {

    

    
    public void peggingScore(Cards c)//all possible combos for score (runs, pairs, 15), run each turn
    {
        //RAN INTO ISSUE WITH CHECKING RUNS, SHOULD I ALSO CALL ON PLAYEDHAND  
        pScore = pScore + c.v;
        if (pScore == 15) {
            score = score + 2;
        }
        if (pScore == 31) {
            score = score + 2;
            pScore = 0;
            //end subround
        }

    }

    public void resetPeggingScore() {
        pscore = 0;
    }

    public int is15(card card1, card card2, card card3, card card4, card cutCard)//could take all in at once, could have 4 methods for pair, triple etc.
    {
        int num15 = 0;//number of instances of 15's
        card[] cardArray = new card[]{card1, card2, card3, card4, cutCard};
        /**
         * cardArray[0] = card1; cardArray[1] = card2; cardArray[2] = card3;
         * cardArray[3] = card4; cardArray[4] = cutCard;
         */
        int k, j, i, totalVal;
        for (j = 0; j < 5; j++) {
            for (i = 0; (i + j) < 6; i++) {
                totalVal = Cards[j].val + Cards[i + j].val;
                if (totalVal == 15) {
                    num15++;
                }
            }
        }
        for (k = 0; k < 4; k++) {
            for (j = 0; (k + j) < 5; j++) {
                for (i = 0; (i + j + k) < 6; i++) {
                    totalVal = Cards[k].val + Cards[k + j].val + Cards[k + j + i].val;
                    if (totalVal == 15) {
                        num15++;
                    }

                }
            }
        }
        for (l = 0; l < 3; l++) {
            for (k = 0; k < 4; k++) {
                for (j = 0; (k + j) < 5; j++) {
                    for (i = 0; (i + j + k) < 6; i++) {
                        totalVal = Cards[l].val + Cards[l + k].val + card[l + k + j].val + card[l + k + j + i];
                        if (totalVal == 15) {
                            num15++;
                        }
                    }
                }
            }
        }
        totalVal = card[0].val + card[1].val + card[2].val + card[3].val + card[4].val;
        if (totalVal == 15) {
            num15++;
        }
        return num15;
    }

    public boolean isPair(card card1, card card2) {
        if (card1.v == card2.v) {
            score = score + 2;
            return true;
        } else {
            return false;
        }
    }

    public boolean isThreeKind(card card1, card card2, card card3) {
        if (card1.v == card2.v && card1.v == card3.v) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isFourkind(card card1, card card2, card card3, card card4)//can get rid of
    {
        if (card1.v == card2.v && card1.v == card3.v && card1.v == card4.v) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isFlush(card card1, card card2, card card3, card card4, card cutCard)// change cards 1-4 into Hand arraylist
    {
        if (card1.s == card2.s && card1.s == card3.s && card1.s == card4.s && card1.s == cutCard.s) {
            return true;
        } else {
            return false;
        }
    }

    public void countHand(card card1, card card2, card card3, card card4, card cutCard)//reverse order, countCrib is exact same method but different card 1-4
    {
        //is15
        //isrun
        isFourKind(card1, card2, card3, card4);
        isThreeKind(card1, card2, card3);
        isThreeKind(card1, card2, card4);
        isThreeKind(card1, card3, card4);
        isThreeKind(card2, card3, card4);
        isPair(card1, card2);
        isPair(card1, card3);
        isPair(card1, card4);
        isPair(card2, card3);
        isPair(card2, card4);
        isPair(card3, card4);
        isFlush(card1, card2, card3, card4, cutCard);
        is15(card1, card2, card3, card4, cutCard);
    }

    public void cutCardScore(card cutCard, card card1, card card2, card card3, card card4)//Checks for nibs, jack points
    {
        int i;
        card[] cardArray = new card[]{card1, card2, card3, card4, cutCard};
        if (cutCard.v == Jack) {
            score = score + 2;
        }

        for (i = 0; i < 4; i++) {
            if (card[i].v == Jack && card[i].s == cutCard.s) {
                score = score + 1;
                break;
            }
        }
    }

    public int isRun(Card[] a)//ONLY WORKS FOR RUNS OF 5 AND 4 SO FAR
    {
        int runSize = 0;//SCORE OF RUNS
        sortArray(a);
        if ((a[4].v - a[3].v) == 1 && (a[3].v - a[2].v) == 1 && (a[2].v - a[1].v) == 1 && (a[0].v - a[1].v) == 1) {
            runSize = 5;
            break;

        }
        for (int i = 0; i < (a.length - 3); i++) {
            if ((a[i + 1].v - a[i].v) == 1 && (a[i + 2].v - a[i + 1].v) == 1 && (a[i + 3].v - a[i + 2].v) == 1) {
                runSize = 4;
                if (isPair(a[i + 1], a[i]) || isPair(a[i + 2], a[i + 1]) || isPair(a[i + 3], a[i + 2])) {
                    runSize = 8;
                    break;

                }
            }
        }
        for (int i = 0; i < (a.length - 2); i++)//NEED TO FIX TO ACCOUNT FOR MULTIPLE RUNS OF 3
        {
            if ((a[i + 1].v - a[i].v) == 1 && (a[i + 2].v - a[i + 1].v) == 1) {
                runSize = 3;
                break;

            }
        }

        return runSize;
    }

    public array sortArray(Card[] a) {
        int i, j;
        Card tempCard;
        for (int i = 1; i < array.length; i++) {
            for (int j = i; j > 0; j--) {
                if (a[j.v] < a[(j - 1).v]) {
                    tempCard = a[j];
                    a[j] = a[j - 1];
                    a[j - 1] = tempCard;
                }
            }
        }
        return a;

    }
}

/**  *
 * is15(card1, card2, card3, card4, cutCard)//can just do val check for pegging
 * if( (card1.v + card2.v) == 15) { score = score + 2; } if( (card1.v + card3.v)
 * == 15) { score = score + 2; } if( (card1.v + card4.v) == 15) { score = score
 * + 2; } if( (card2.v + card3.v) == 15) { score = score + 2; } if( (card2.v +
 * card4.v) == 15) { score = score + 2; } if( (card3.v + card4.v) == 15) { score
 * = score + 2; }
 *
 * isLastCard()//counter each time card is played, when hits 8 breaks out of
 * pegging portion. add 1 to score
 *
 * enum SUIT s, VALUE v
 *
 * deck is arraylist //make arraylist, enhanced for loop to track value
 *
 * peggingScore(card)//all possible combos for score (runs, pairs, 15) int
 * pScore = 0; pScore = pScore + card.v; if(pScore == 15) { score = score + 2; }
 * if (pScore == 31) { score = score + 2; //end subround
 *
 * }
 *
 * countHand(card1, card2, card3, card4, cutCard)//reverse order
 *
 * isPair(card1, card2); isPair(card1, card3); isPair(card1, card4);
 * isPair(card2, card3); isPair(card2, card4); isPair(card3, card4);
 * isThreeKind(card1, card2, card3); isThreeKind(card1, card2, card4);
 * isThreeKind(card1, card3, card4); isThreeKind(card2, card3, card4);
 * isFourKind(card1, card2, card3, card4);
 *
 * cutCardScore(cutCard, card1, card2, card3, card4) if (cutCard.v == Jack) {
 * score = score + 2; }
 *
 * for(i == 0; i < 4; i++) if (card i.v == Jack && card i.s == cutCard.s) {
 * score = score + 1; break; } countCrib //involves cut card too same code as
 * countHand
 *
 * isPair(card1, card2) if (card1.v == card2.v) { score = score + 2; return
 * true; } else return false;
 *
 * isThreeKind(card1, card2, card3)//can get rid of if (card1.v == card2.v &&
 * card1.v == card3.v) { return true; } else return false;
 *
 * is4kind(card1, card2, card3, card4)//can get rid of if (card1.v == card2.v &&
 * card1.v == card3.v && card1.v == card4.v) { return true; } else return false;
 * isFlush(card1, card2, card3, card4, cutCard)// change cards 1-4 into Hand
 * arraylist if(card1.s == card2.s && card1.s == card3.s && card1.s == card4.s
 * && card1.s == cutCard.s) { return true; } else return false; isRun(card1,
 * card2, card3, card4, cutCard)// chuck cards into arraylist, sort by size,
 * then check card1 < card2 by 1 etc
 *
 * combonation()//work isPair method into it,//case 0, 1 , 3, 6 isPair(card1,
 * card2); isPair(card1, card3); isPair(card1, card4); isPair(card1, cutCard);
 * isPair(card2, card3); isPair(card2, card4); isPair(card2, cutCard);
 * isPair(card3, card4); isPair(card3, cutCard); isPair(card4, cutCard); //pass
 * integer for counter, check array of cards, i = i-1;  *
 */

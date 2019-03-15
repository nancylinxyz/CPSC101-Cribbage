import java.util.Arrays;

public class Scorer
{
//    public static void main(String[] args)
//    {
//        int cardNum = 0, currentPeggingScore = 0, minVal = 14, maxVal = 0, runCount = 0, pegCardNum = 0;
//        Cards tempCard = null, tempCard2 = null;
//        Cards[] peggingArray = new Cards[];
//    }
//
    private int currentPeggingScore = 0;
    private int cardNum = 0;
    private int minVal = 14, maxVal = 0;
    private int runCount = 0, pegCardNum = 0;
    private Cards tempCard = null, tempCard2 = null;
    private Cards[] peggingArray = new Cards[];
    private Cards[] runArray = new Cards[];



    public int peggingScore(Cards c)//all possible combos for score (runs, pairs, 15), run each turn
    {
        peggingArray[pegCardNum] = c;
        currentPeggingScore += c.valueFinder();
        pegCardNum++;
        if(currentPeggingScore == 15)
        {
            return 2;
        }
        if (currentPeggingScore == 31)
        {
            return 2;
            currentPeggingScore = 0;
            //end subround
        }
        if(pegCardNum > 1){
            if(isPair(peggingArray[pegCardNum] , peggingArray[pegCardNum - 1]))
            {
               return 2;
            }
        }
        if(pegCardNum > 4){
            if(peggingArray[pegCardNum].getSuit() == peggingArray[pegCardNum - 1].getSuit() && peggingArray[pegCardNum].getSuit() == peggingArray[pegCardNum - 2].s && peggingArray[pegCardNum].s == peggingArray[pegCardNum - 3].s && peggingArray[pegCardNum].s == peggingArray[pegCardNum - 4].s)
            {
                return 5;
            }
        }
        if(pegCardNum > 2)
        {

        }
    }

    public void resetPeggingScore()
    {
        currentPeggingScore = 0;
    }

    public int is15(Cards[] playedHand, Cards cutCard)//could take all in at once, could have 4 methods for pair, triple etc.
    {
        int num15 = 0;//number of instances of 15's
        /** card[] cardArray = new card[]{card1, card2, card3, card4, cutCard}; old code, might revert back to if issues
         cardArray[0] = card1;
         cardArray[1] = card2;
         cardArray[2] = card3;
         cardArray[3] = card4;
         cardArray[4] = cutCard; */
        int k, j, i, totalVal;
        for(j=0;j<5;j++)
        {
            for(i=0;(i+j)<6;i++)
            {
                totalVal = playedHand[j].cardValue() + playedHand[i+j].cardValue();
                if (totalVal == 15)
                {
                    num15++;
                }
            }
        }
        for(k=0;k<4;k++)
        {
            for(j=0;(k+j)<5;j++)
            {
                for(i=0;(i+j+k)<6;i++)
                {
                    totalVal= playedHand[k].v + playedHand[k+j].v + playedHand[k + j + i].v;
                    if (totalVal == 15)
                    {
                        num15++;
                    }

                }
            }
        }
        for(l=0;l<3;l++)
        {
            for(k=0;k<4;k++)
            {
                for(j=0;(k+j)<5;j++)
                {
                    for(i=0;(i+j+k)<6;i++)
                    {
                        totalVal= playedHand[l].v + playedHand[l+k].v + playedHand[l + k + j].v + playedHand[l+k+j+i].v;
                        if (totalVal == 15)
                        {
                            num15++;
                        }
                    }
                }
            }
        }
        totalVal= playedHand[0].v + playedHand[1].v + playedHand[2].v + playedHand[3].v + playedHand[4].v;
        if (totalVal == 15)
        {
            num15++;
        }
        return num15;
    }
    public boolean isPair(Cards card1, Cards card2)
    {
        if (card1.v == card2.v)
        {
            return true;
        }
        else return false;
    }
    public boolean isThreeKind(Cards card1, Cards card2, Cards card3)
    {
        if (card1.v == card2.v && card1.v == card3.v)
        {
            return true;
        }
        else return false;
    }
    public boolean isFourkind(Cards card1,Cards card2,Cards card3,Cards card4)//can get rid of
    {
        if (card1.v == card2.v && card1.v == card3.v && card1.v == card4.v)
        {
            return true;
        }
        else return false;
    }
    public boolean cribIsFlush(Cards[] playedHand, Cards cutCard)// change cards 1-4 into Hand arraylist
    {
        if(playedHand[0].s == playedHand[1].s && playedHand[0].s == playedHand[2].s && playedHand[0].s == playedHand[3].s && playedHand[0].s == cutCard.s)
        {
            return true;
        }
        else return false;
    }
    public boolean isFlush(Cards[] playedHand)// change cards 1-4 into Hand arraylist
    {
        if(card1.s == card2.s && card1.s == card3.s && card1.s == card4.s )
        {
            return true;
        }
        else return false;
    }
    public int countHand(Cards[] playedHand, Cards cutCard)//reverse order, countCrib is exact same method but different card 1-4
    {
        int handScore = 0;
        //is15
        //isrun
        if(isFourKind(playedHand[0], playedHand[1], playedHand[2], playedHand[3])){handScore = handScore + 16;}
        else{
            if(isFourKind(playedHand[0], playedHand[1], playedHand[2], cutCard)){handScore = handScore + 16;}
            else{
                if(isFourKind(playedHand[0], playedHand[1], playedHand[3], cutCard)){handScore = handScore + 16;}
                else{
                    if(isFourKind(playedHand[0], playedHand[2], playedHand[3], cutCard)){handScore = handScore + 16;}
                    else{
                        if(isFourKind(playedHand[1], playedHand[2], playedHand[3], cutCard)){handScore = handScore + 16;}
                        else{

                            if(isThreeKind(playedHand[0], playedHand[1], playedHand[2])){handScore = handScore + 6;}
                            else{
                                if(isThreeKind(playedHand[0], playedHand[1], playedHand[3])){handScore = handScore + 6;}
                                else{
                                    if(isThreeKind(playedHand[0], playedHand[1], cutCard)){handScore = handScore + 6;}
                                    else{
                                        if(isThreeKind(playedHand[0], playedHand[2], playedHand[3])){handScore = handScore + 6;}
                                        else{
                                            if(isThreeKind(playedHand[0], playedHand[2], cutCard)){handScore = handScore + 6;}
                                            else{
                                                if(isThreeKind(playedHand[0], playedHand[3], cutCard)){handScore = handScore + 6;}
                                                else{
                                                    if(isThreeKind(playedHand[1], playedHand[2], playedHand[3])){handScore = handScore + 6;}
                                                    else{
                                                        if(isThreeKind(playedHand[1], playedHand[2], cutCard)){handScore = handScore + 6;}
                                                        else{
                                                            if(isThreeKind(playedHand[1], playedHand[3], cutCard)){handScore = handScore + 6;}
                                                            else{
                                                                if(isThreeKind(playedHand[2], playedHand[3], cutCard)){handScore = handScore + 6;}
                                                                else{

                                                                    if(isPair(playedHand[0], playedHand[1])){handScore = handScore + 2;}
                                                                    else{
                                                                        if(isPair(playedHand[0], playedHand[2])){handScore = handScore + 2;}
                                                                        else{
                                                                            if(isPair(playedHand[0], playedHand[3])){handScore = handScore + 2;}
                                                                            else{
                                                                                if(isPair(playedHand[0], cutCard)){handScore = handScore + 2;}
                                                                                else{
                                                                                    if(isPair(playedHand[1], playedHand[2])){handScore = handScore + 2;}
                                                                                    else{
                                                                                        if(isPair(playedHand[1], playedHand[3])){handScore = handScore + 2;}
                                                                                        else{
                                                                                            if(isPair(playedHand[1], cutCard)){handScore = handScore + 2;}
                                                                                            else{
                                                                                                if(isPair(playedHand[2], playedHand[3])){handScore = handScore + 2;}
                                                                                                else{
                                                                                                    if(isPair(playedHand[2], cutCard)){handScore = handScore + 2;}
                                                                                                    else{
                                                                                                        if(isPair(playedHand[3], cutCard)){handScore = handScore + 2;}

                                                                                                    }}}}}}}}}}}}}}}}}}}}}}}}

        if(isCrib)
        {
            if(isCribFlush(playedHand[], cutCard)){handScore = handScore + 5;}
        }
        else
        {
            if(isFlush(playedHand[], cutCard)){handScore = handScore + 4;}
        }

        is15(playedHand[], cutCard);
    }

    public int cutCardScore(Cards cutCard, Cards[] cardArray)//Checks for nibs, jack points
    {
        if (cutCard.v == Jack)
        {
            return 2;
        }

        for(i = 0; i < 4; i++)
        {
            if (cardArray[i].v == Jack && cardArray[i].s == cutCard.s)
            {
                return 1;
            }
        }
    }

    public int isRunPeg(Cards[] a)
    {
        public int isRunPeg(Cards[] runArray)
        {


            runCount = runArray.length;
            Card[]sortedRunArray = new Card[runArray.length];
            if(runCount > 2)
            {
                for(i=0;i<runCount;i++)
                {
                    sortedRunArray[i] = runArray[runCount - i];//sorts right to left to the needed length
                }

                sortedRunArray = sortArray(sortedRunArray);
                if(runCount > 6)
                {
                    if(runArray[runCount].v == 7 && runArray[runCount - 1].v == 6 && runArray[runCount - 2].v == 5 && runArray[runCount - 3].v == 4 & runArray[runCount - 4].v == 3 && runArray[runCount - 5].v == 2 && runArray[runCount - 6].v == 1))
                    {
                        return 7;
                    }
                }

                if(runCount > 5){
                    if((runArray[runCount].v - runArray[runCount - 3].v)== (runArray[runCount - 1].v - runArray[runCount - 4].v) && (runArray[runCount].v - runArray[runCount - 3].v) == (runArray[runCount - 2].v - runArray[runCount - 5].v))
                    {
                        return 6;
                    }}

                if(runCount > 4){
                    if((runArray[4].v - runArray[3].v)== 1 && (runArray[3].v - runArray[2].v)== 1 && (runArray[2].v - runArray[1].v)== 1 && (runArray[1].v - runArray[0].v)== 1)
                    {
                        return 5;
                    }}
                if(runCount > 3){
                    if((runArray[runCount].v - runArray[runCount - 2].v)== (runArray[runCount - 1].v - runArray[runCount - 3].v))
                    {
                        return 4;
                    }}
                if((runArray[runCount].v - runArray[runCount-1].v)== 1 && (runArray[runCount-1].v - runArray[runCount-2].v)== 1)
                {
                    return 3;
                }
            }

        }

    }
    public int isRun(Cards[] a)//ONLY WORKS FOR RUNS OF 5 AND 4 SO FAR
    {

        int i, j, k, runScore = 0;
        Cards[][] runArray = new int[13][2];

        for(i=0;i<13,i++)
        {
            runArray [i][0] = i;
            for(j=0;j<4;j++;)
            {
                if(playedHand[j].v == (i+1))
                {
                    runArray[i][1]++;
                    k++;
                }
            }

            if(cutCard.v == i)
            {
                runArray[i][1]++;
                k++;
            }
            if(k == 5)
            {
                break;
            }
            if(runArray[i][1] != 0 && runArray[i-1][1] != 0 && runArray[i-2][1] != 0)
            {
                runScore = 3 * runArray[i][1] * runArray[i-1][1] * runArray[i-2][1];
            }
            if(runArray[i][1] != 0 && runArray[i-1][1] != 0 && runArray[i-2][1] != 0 && runArray[i-3][1] != 0)
            {
                runScore = 4 * runArray[i][1] * runArray[i-1][1] * runArray[i-2][1] * runArray[i-3][1];
            }
            if(runArray[i][1] != 0 && runArray[i-1][1] != 0 && runArray[i-2][1] != 0 && runArray[i-3][1] != 0 && runArray[i-4][1] != 0)
            {
                return 5;
            }
        }
        return runScore;
    }
    public array sortArray(Cards[] a)
    {
        int i, j;
        for (int i = 1; i < array.length; i++)
        {
            for (int j = i; j > 0; j--)
            {
                if (a[j.v] < a[(j - 1).v])
                {
                    tempCard = a[j];
                    a[j] = a[j - 1];
                    a[j - 1] = tempCard;
                }
            }
        }
        tempCard = null;
        return a;

    }
}
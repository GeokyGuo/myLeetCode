package secondRound.Week3.第10课_贪心算法;

public class L860_Lemonade_Change {
    public boolean lemonadeChange(int[] bills) {
        int five = 0; int ten = 0; int twenty = 0;
        int i = 0;
        while(i < bills.length){
            if(bills[i] == 5) five++;
            if(bills[i] == 10){
                if(five > 0){
                    five--;
                    ten++;
                }else{
                    return false;
                }
            }
            if(bills[i] == 20){
                if(ten > 0 && five > 0){
                    ten--;
                    five--;
                    twenty++;
                }else if(five > 2){
                    five -= 3;
                    twenty++;
                }else{
                    return false;
                }
            }
            i++;
        }
        return true;
    }
}
//因为美元10只能给账单20找零，而美元5可以给账单10和账单20找零，美元5更万能！
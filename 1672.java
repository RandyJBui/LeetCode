/* misread the prompt and did extra work to make printouts gramatically correct when it was not necessary.
You are given an m x n integer grid accounts where accounts[i][j] is the amount of money the i​​​​​​​​​​​th​​​​ customer has in the j​​​​​​​​​​​th​​​​ bank. Return the wealth that the richest customer has.

A customer's wealth is the amount of money they have in all their bank accounts. The richest customer is the customer that has the maximum wealth.

 

Example 1:

Input: accounts = [[1,2,3],[3,2,1]]
Output: 6
Explanation:
1st customer has wealth = 1 + 2 + 3 = 6
2nd customer has wealth = 3 + 2 + 1 = 6
Both customers are considered the richest with a wealth of 6 each, so return 6.
Example 2:

Input: accounts = [[1,5],[7,3],[3,5]]
Output: 10
Explanation: 
1st customer has wealth = 6
2nd customer has wealth = 10 
3rd customer has wealth = 8
The 2nd customer is the richest with a wealth of 10.
Example 3:

Input: accounts = [[2,8,7],[7,1,3],[1,9,5]]
Output: 17
 

Constraints:

m == accounts.length
n == accounts[i].length
1 <= m, n <= 50
1 <= accounts[i][j] <= 100
*/
//====================================================================================================================================================
class Solution {
    public int maximumWealth(int[][] accounts) {
        int[] accountTotals = new int[accounts.length];
        for(int i = 0; i < accounts.length; i++){
            for(int j=0; j < accounts[0].length; j++){
                
              accountTotals[i] += accounts[i][j];
                
            }
        }
        int count=0;
        int intercept =0;
    int test =0;
        String tempString ="";
        String suffix= "";
     
        for(int prints: accountTotals){
                 tempString = Integer.toString(count+1);
        if (tempString.substring(tempString.length()-1, tempString.length()).equals("1")){
            suffix = "st";
        }else if(tempString.substring(tempString.length()-1, tempString.length()).equals("3")){
            suffix = "rd";
        }else if (tempString.substring(tempString.length()-1, tempString.length()).equals("2")){
            suffix = "nd";
        }else{
            suffix = "th";
        }
            count++;
            System.out.println(count  + suffix +" customer has wealth = " + prints); 
          
        }
    
             for(int i = 0; i < accountTotals.length; i++){
            for(int j=0; j < accountTotals.length; j++){
                
                if(accountTotals[i] < accountTotals[j]){
                    if(accountTotals[intercept] < accountTotals[j]){
                    intercept = j;
                    }
                }
            }
                  tempString = Integer.toString(count+1);
        if (tempString.substring(tempString.length()-1, tempString.length()).equals("1")){
            suffix = "st";
            try{
                if(tempString.substring(tempString.length()-2, tempString.length()-1).equals("1")){
                    suffix = "th";
                }
            }catch(Exception e){
                
            }
        }else if(tempString.substring(tempString.length()-1, tempString.length()).equals("3")){
            suffix = "rd";
             try{
                if(tempString.substring(tempString.length()-2, tempString.length()-1).equals("1")){
                    suffix = "th";
                }
            }catch(Exception e){
                
            }
        }else if (tempString.substring(tempString.length()-1, tempString.length()).equals("2")){
            suffix = "nd";
             try{
                if(tempString.substring(tempString.length()-2, tempString.length()-1).equals("1")){
                    suffix = "th";
                }
            }catch(Exception e){
                
            }
        }else{
            suffix = "th";
        }
             }
        System.out.println("The " + (intercept) + suffix + " customer is the richest with a wealth of " + accountTotals[intercept]);
         return accountTotals[intercept];
    
  
}
}

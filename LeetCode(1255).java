/*Given a list of words, list of  single letters (might be repeating) and score of every character.
Return the maximum score of any valid set of words formed by using the given letters (words[i] cannot be used two or more times).
It is not necessary to use all characters in letters and each letter can only be used once. Score of letters 'a', 'b', 'c', ... ,'z' is given by score[0], score[1], 
... , score[25] respectively.

Example 1:

Input: words = ["dog","cat","dad","good"], letters = ["a","a","c","d","d","d","g","o","o"], score = [1,0,9,5,0,0,3,0,0,0,0,0,0,0,2,0,0,0,0,0,0,0,0,0,0,0]
Output: 23
Explanation:
Score  a=1, c=9, d=5, g=3, o=2
Given letters, we can form the words "dad" (5+1+5) and "good" (3+2+2+5) with a score of 23.
Words "dad" and "dog" only get a score of 21.*/

class Solution 
{
    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        int [] frequency = new int[26];
        for(int i = 0;i<letters.length;i++)
        {
            frequency[letters[i]-'a']++;
        }
        int result = backtrack(words,frequency,score,0);
        return result;
        
        
    }
    public static int backtrack(String[] words, int[] frr, int[] score,int idx)
    {
        if(idx == words.length)
        {
            return 0;
        }
        int scoreOfaWord =0;
        int no = backtrack(words,frr,score,idx+1);
        boolean isValid = true;
        for(int i =0;i<words[idx].length();i++)
        {
            char ch = words[idx].charAt(i);
            if(frr[ch-'a']<=0)
            {
                isValid = false;
            }
            frr[ch-'a']--;
            scoreOfaWord += score[ch-'a'];
            
        }
        int yes =0;
        if(isValid)
        {
            yes = scoreOfaWord + backtrack(words,frr,score,idx+1);
        }
        for(int i =0;i<words[idx].length();i++)
        {
            frr[words[idx].charAt(i)-'a']++;
        }
        return Math.max(no,yes);
        
    }
}
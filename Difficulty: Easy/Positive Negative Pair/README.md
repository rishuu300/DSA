<h2><a href="https://www.geeksforgeeks.org/problems/positive-negative-pair5209/1?track=P100-Hashing%2520%2520%2520&batchId=197">Positive Negative Pair</a></h2><h3>Difficulty Level : Difficulty: Easy</h3><hr><div class="problems_problem_content__Xm_eO"><p><span style="font-size: 14pt;">Given an array of integers, find all the pairs having both negative and positive values of a number in the array.</span></p>
<p><span style="font-size: 14pt;"><strong>Note: </strong>The pair that appears first(i.e. second element of the pair appears first) in arr[] should appear first in the returning list and within the pair, the negative integer should appear before the positive integer. Return an empty integer list if no such pair exists.</span></p>
<p><span style="font-size: 14pt;"><strong>Examples:</strong></span></p>
<pre><span style="font-size: 14pt;"><strong style="font-size: 14pt;">Input: </strong><span style="font-size: 14pt;">n = 8, arr[] = [1, 3, 6, -2, -1, -3, 2, 7]
</span><strong style="font-size: 14pt;">Output: </strong><span style="font-size: 14pt;">[-1, 1, -3, 3, -2, 2]</span><strong style="font-size: 14pt;">
Explanation: </strong><span style="font-size: 14pt;">1, 3 and 2 are present pairwise positive and negative. 6 and 7 have no pair.</span>
</span></pre>
<pre><strong style="font-size: 18.6667px;">Input:</strong><span style="font-size: 18.6667px;"> n = 7, arr[] = [1, -10, -2, 8, -8, -8, -1]<br><strong>Output:</strong> [-8, 8, -8, 8, -1, 1]<br></span><span style="font-size: 18.6667px;"><strong>Explanation:</strong> 8 and 1 are present pairwise positive and negative. 10 and 2 have no pair.</span></pre>
<pre><span style="font-size: 14pt;"><strong>Input: </strong>n = 3, arr[] = [3, 2, 1]
<strong>Output: </strong>0<strong>
Explanation: </strong>No such pair exists.</span></pre>
<p><span style="font-size: 14pt;"><strong>Constraints:</strong><br>1 &lt;= n &lt;= 10<sup>5</sup><br>-10<sup>6</sup> &lt;= arr[i] &lt;= 10<sup>5</sup></span></p></div><p><span style=font-size:18px><strong>Company Tags : </strong><br><code>Amazon</code>&nbsp;<br><p><span style=font-size:18px><strong>Topic Tags : </strong><br><code>Hash</code>&nbsp;<code>Data Structures</code>&nbsp;
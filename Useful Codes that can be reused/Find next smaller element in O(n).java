package leetcode;

import java.util.Arrays;

public class Solution {

  public static void main(String[] args) {
    Solution so = new Solution();
    int[] d = new int[20];
    for (int i = 0; i < 10; i++) {
      d[i] = i+1;
      d[20-i-1] = i+1;
    }
    System.out.println(Arrays.toString(d));
    System.out.println(Arrays.toString(nextSmallerElementIndex(d)));
  }

  public static int[] nextSmallerElementIndex(int[] digits) {

    int[] closest = new int[digits.length];
    Arrays.fill(closest, -1);
    int count = 0;
    for (int i = digits.length - 2; i >= 0; i--) {
      int j = i + 1;
      count++;
      while (j != -1 && digits[i] <= digits[j]) {
        j = closest[j];
        count++;
      }
      closest[i] = j;
    }
    System.out.println(count);
    return closest;
  }

}

/*
Problem: Sort Temperature Readings using Bubble Sort

Description:
Ryan collects temperature readings which can be positive
or negative. The task is to sort them in ascending order
using Bubble Sort.

Approach:
1. Read number of readings.
2. Store them in an array.
3. Use Bubble Sort to repeatedly swap adjacent elements.
4. Print sorted values.

Bubble Sort Logic:
Compare adjacent elements and swap if they are in the wrong order.
After each pass the largest element moves to the end.

Example:
Input:
5 -2 0 12 -7

Output:
-7 -2 0 5 12

Time Complexity:
Worst Case: O(N²)
Average Case: O(N²)
Best Case: O(N) (if optimized with swap flag)

Space Complexity:
O(1) – in-place sorting
*/

import java.util.*;

class Solution {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] a = new int[n];

        for (int i = 0; i < n; i++)
            a[i] = sc.nextInt();

        for (int i = 0; i < n - 1; i++) {

            for (int j = 0; j < n - i - 1; j++) {

                if (a[j] > a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }

            }
        }

        for (int i = 0; i < n; i++)
            System.out.print(a[i] + " ");
    }
}

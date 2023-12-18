package org.startsteps.week15;

import java.util.Arrays;

public class Test2 {

        public static void main(String[] args)
        {
            // Define an array of integers.
            //int nums[] = {6, 7, 9, 16, 25, 12, 30, 40, 7, 9, 16, 25, 12, 30, 40, 7, 9, 16, 25, 12, 30, 40, 7, 9, 16, 25, 12, 30, 40, 7, 9, 16, 25, 12, 30, 40, 7, 9, 16, 25, 12, 30, 40, 7, 9, 16, 25, 12, 30, 40, 7, 9, 16, 25, 12, 30, 40, 7, 9, 16, 25, 12, 30, 40, 7, 9, 16, 25, 12, 30, 40, 7, 9, 16, 25, 12, 30, 40, 7, 9, 16, 25, 12, 30, 40, 7, 9, 16, 25, 12, 30, 40, 7, 9, 16, 25, 12, 30, 40, 7, 9, 16, 25, 12, 30, 40, 7, 9, 16, 25, 12, 30, 40, 7, 9, 16, 25, 12, 30, 40, 7, 9, 16, 25, 12, 30, 40, 7, 9, 16, 25, 12, 30, 40, 7, 9, 16, 25, 12, 30, 40, 7, 9, 16, 25, 12, 30, 40, 7, 9, 16, 25, 12, 30, 40, 7, 9, 16, 25, 12, 30, 40, 7, 9, 16, 25, 12, 30, 40, 7, 9, 16, 25, 12, 30, 40, 7, 9, 16, 25, 12, 30, 40, 7, 9, 16, 25, 12, 30, 40, 7, 9, 16, 25, 12, 30, 40, 7, 9, 16, 25, 12, 30, 40, 7, 9, 16, 25, 12, 30, 40, 7, 9, 16, 25, 12, 30, 40, 7, 9, 16, 25, 12, 30, 40, 7, 9, 16, 25, 12, 30, 40, 7, 9, 16, 25, 12, 30, 40, 7, 9, 16, 25, 12, 30, 40, 7, 9, 16, 25, 12, 30, 40, 7, 9, 16, 25, 12, 30, 40, 7, 9, 16, 25, 12, 30, 40};
            int[] nums = new int[10000];
            for (int i = 0; i < 10000; i++) {
                nums[i] = i;
            }
            System.out.println("Original Array : " + Arrays.toString(nums));

            // Sort the array elements in non-decreasing order.
            Arrays.sort(nums);

            // Initialize count of triangles.
            int ctr = 0;

            // Iterate through the array elements to count the number of triangles.
            for (int i = 0; i < nums.length - 2; ++i)
            {
                int x = i + 2;

                for (int j = i + 1; j < nums.length; ++j)
                {
                    while (x < nums.length && nums[i] + nums[j] > nums[x])
                        ++x;
                    ctr += x - j - 1;
                }
            }

            System.out.println("Total number of triangles: " + ctr);
        }
    }

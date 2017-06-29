package com.test.web;

/**
 * 
 * @author Administrator
 * 二分查找法
 */
public class Binarysearch {
	static int bsearchWithoutRecursion(int array[], int low, int high, int target)
	{
	    while(low <= high)
	    {
	        int mid = low + ((high-low)>>1);
	        if (array[mid] > target)
	            high = mid - 1;
	        else if (array[mid] < target)
	            low = mid + 1;
	        else //find the target
	            return mid;
	    }
	    //the array does not contain the target
	    System.out.println(low+"--"+high);
	    return -1;
	}
	public static void main(String[] args) {
		int[] arr = {1,3,5,7,9,11,13,15,17}; 
		int target = 15;
		int result = bsearchWithoutRecursion(arr,0,arr.length-1,target);
		System.out.println(result);
	}
}

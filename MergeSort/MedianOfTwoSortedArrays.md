## Question
```
There are two sorted arrays nums1 and nums2 of size m and n respectively.

Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).

You may assume nums1 and nums2 cannot be both empty.

Example 1:

nums1 = [1, 3]
nums2 = [2]

The median is 2.0
Example 2:

nums1 = [1, 2]
nums2 = [3, 4]

The median is (2 + 3)/2 = 2.5
```
## Code

JAVA:
```java
class Solution {
    /**
    x, y is size of 2 array
    P1 + P2 = (x+y+1)/2
    P1 = (start + end + 1)/2
    P2 = (x+y+1)/2-P1, from formula 2
    each array left part start from P1 - 1 or P2 -1, right part from P1, P2
    
    if(nums1 is shortest array){
        x [0, nums1.length]
        y [0, nums2.length]
    }
    
    
    define 1 true, 2 left, 3 right
    
    
    **/
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int start = 0;
        if(nums1.length > nums2.length){
            int end = nums2.length-1;
            return findMedian(nums2, nums1, start, end);
        }else{
            int end = nums1.length-1;
            return findMedian(nums1, nums2, start, end);   
        }
    }
    
    private double findMedian(int[] nums1, int[] nums2, int start, int end){
        int x = (start + end)/2;
        int y = (nums1.length + nums2.length + 1)/2 -  x;
        if(ALeftLessB(nums1, nums2, x, y)){
            if(BLeftLessA(nums1, nums2, x, y)){
                if((nums1.length + nums2.length) % 2 == 1){
                    return findLeftMax(nums1, nums2, x, y);
                }
                return (findLeftMax(nums1, nums2, x, y) + findRightMin(nums1, nums2, x, y))/2.0;
            }else{
                if(x+1 > end){return findMedian(nums1, nums2, x+1, end+1);}
                return findMedian(nums1, nums2, x+1, end);   
            }
        }
        // move left
        return findMedian(nums1, nums2, start, x-1);
        
    }
    
    
    private boolean ALeftLessB(int nums1[], int nums2[], int a, int b){
        if(a == 0 || b == nums2.length){
            return true;
        }else{
            if(nums1[a - 1] <= nums2[b]){return true;}
            return false;
        }
    }
    
    private boolean BLeftLessA(int nums1[], int nums2[], int a, int b){
        if(b == 0 || a == nums1.length){
            return true;
        }else{
            if(nums1[a] >= nums2[b-1]){return true;}
            return false;
        }
    }
    
    private double findLeftMax(int nums1[], int nums2[], int a, int b){
        if(a > 0){
            if(b > 0){
                if(nums1[a-1] > nums2[b-1]){return nums1[a-1];}
                else{return nums2[b-1];}
            }
            return nums1[a-1];
        }
        return nums2[b-1];
    }
    
    private double findRightMin(int nums1[], int nums2[], int a, int b){
        if(a < nums1.length){
            if(b < nums2.length){
                if(nums1[a] > nums2[b]){return nums2[b];}
                else{return nums1[a];}
            }
            return nums1[a];
        }
        return nums2[b];
    }    
}
```

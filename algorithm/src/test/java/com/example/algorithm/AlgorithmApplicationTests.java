package com.example.algorithm;

import com.example.algorithm.model.ListNode;
import com.example.algorithm.service.*;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@Slf4j
class AlgorithmApplicationTests {

    @Autowired
    private HashService hashService;
    @Autowired
    private TwoPointService twoPointService;
    @Autowired
    private SliderWindowService sliderWindowService;
    @Autowired
    private SubStringService subStringService;
    @Autowired
    private NormalArrService normalArrService;
    @Autowired
    private MatrixService matrixService;
    @Autowired
    private ArrayListService arrayListService;

    @Test
    void twosum() {
        int nums[] ={2,7,11,15};
        int target = 9;
        int res [] = hashService.twoSum(nums,target);
        log.info("结果：{}",res);

    }

    @Test
    void groupAnagrams() {
       String [] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> res = hashService.groupAnagrams(strs);
        log.info("结果：{}", res);

    }

    @Test
    void longestConsecutive() {
        int nums[] ={0,3,7,2,5,8,4,6,0,1};
        int  res = hashService.longestConsecutive(nums);
        log.info("结果：{}", res);

    }
    @Test
    void moveZeroes() {
        int nums[] ={0,1,0,3,12};
         twoPointService.moveZeroes(nums);
        log.info("结果：{}", nums);

    }
    @Test
    void maxArea() {
        int nums[] ={1,8,6,2,5,4,8,3,7};
         int res =twoPointService.maxArea(nums);
        log.info("结果：{}", res);

    }
    @Test
    void threeSum() {
        int nums[] ={-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6};
        List<List<Integer>> res =twoPointService.threeSum(nums);
        log.info("结果：{}", res);

    }
    @Test
    void trap() {
        int nums[] ={0,1,0,2,1,0,1,3,2,1,2,1};
        int res =twoPointService.trap(nums);
        log.info("结果：{}", res);

    }
    @Test
    void lengthOfLongestSubstring() {
        String s ="abcabcbb";
        int res =sliderWindowService.lengthOfLongestSubstring(s);
        log.info("结果：{}", res);

    }
    @Test
    void findAnagrams() {
        String  s = "abab", p = "ab";
        List<Integer> res =sliderWindowService.findAnagrams(s,p);
        log.info("结果：{}", res);

    }
    @Test
    void subarraySum() {
        int [] s = {2,2,2};
        int p = 2;
         int res =subStringService.subarraySum(s,p);
        log.info("结果：{}", res);

    }
    @Test
    void maxSlidingWindow() {
        int [] s = {1,3,-1,-3,5,3,6,7};
        int p = 3;
        int[] res =subStringService.maxSlidingWindow(s,p);
        log.info("结果：{}", res);

    }
    @Test
    void minWindow() {
        String s = "ADOBECODEBANC", t = "ABC";
        String res =subStringService.minWindow(s,t);
        log.info("结果：{}", res);

    }
    @Test
    void maxSubArray() {
        int[] s = {-1};
        int res =normalArrService.maxSubArray(s);
        log.info("结果：{}", res);

    }

    @Test
    void merge() {
        int[] []intervals = {{1,3},{2,6},{8,10},{15,18}};
        int [] []res =normalArrService.merge(intervals);
        log.info("结果：{}", res);

    }
    @Test
    void rotate() {
        int [] s = {1,2,3,4,5,6,7};
        int p = 3;
        normalArrService.rotate(s,p);
        log.info("结果：{}", s);

    }
    @Test
    void productExceptSelf() {
        int [] s = {1,2,3,4};
       int []res =normalArrService.productExceptSelf(s);
        log.info("结果：{}", res);

    }
    @Test
    void firstMissingPositive() {
        int [] s = {1};
        int res =normalArrService.firstMissingPositive(s);
        log.info("结果：{}", res);

    }
    @Test
    void setZeroes() {
        int [][] matrix = {{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        matrixService.setZeroes(matrix);
        log.info("结果：{}", matrix);

    }
    @Test
    void spiralOrder() {
        int [][] matrix = {{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        List<Integer> res = matrixService.spiralOrder(matrix);
        log.info("结果：{}", res);

    }
    @Test
    void rotateMatrix() {
        int [][] matrix = {{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        matrixService.rotate(matrix);
        log.info("结果：{}", matrix);

    }
    @Test
    void searchMatrix() {
        int [][] matrix = {{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        int target=6;
        boolean res = matrixService.searchMatrix(matrix,target);
        log.info("结果：{}", res);

    }

    @Test
    void getIntersectionNode() {
        ListNode headA = new ListNode(4);
        int[] arrA={1,8,4,5};
        for(int num:arrA){
            headA.add(headA,num);
        }
        ListNode headB = new ListNode(5);
        int[] arrB={6,1,8,4,5};
        for(int num:arrB){
            headB.add(headB,num);
        }
        ListNode res = arrayListService.getIntersectionNode(headA,headB);
        log.info("结果：{}", res);

    }



}

package com.example.algorithm.service.impl;

import com.example.algorithm.service.TwoPointService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @auth Administrator
 * @create @2024/7/20@14:02
 * @decription
 **/
@Slf4j
@Service
public class TwoPointServiceImpl implements TwoPointService {

    /**
     * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
     *
     * 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
     * @param nums
     */

    @Override
    public void moveZeroes(int[] nums) {
        int j=0;
       for(int i=0;i<nums.length;i++){
           if(nums[i]!=0){
               int temp =  nums[i];
               nums[i] = nums[j];
               nums[j]= temp;
               j++;
           }
       }

    }


    /**
     *
     给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。

     找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
     *
     * @param height
     * @return
     */
    @Override
    public int maxArea(int[] height) {
        int length = height.length;
        int left = 0;
        int right = length-1;
        int maxArea = 0;
         while (left <right){
             int area = (right-left)*(Math.min(height[right],height[left]));
             log.info("left:{},right:{},area:{}",left,right,area);
             maxArea = Math.max(maxArea,area);
             if(height[left]<height[right]){
                 left++;
             }else{
                 right--;
             }
         }
        return maxArea;
    }

    /**
     * 给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。请
     *
     * 你返回所有和为 0 且不重复的三元组。
     *
     * 注意：答案中不可以包含重复的三元组。
     * @param nums
     * @return
     */
    @Override
    public List<List<Integer>> threeSum(int[] nums) {
        int i=0;
        int left=0;
        int right=0;
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for(i=0;i<nums.length;i++){
            //去重
            if(i!=0&&nums[i]==nums[i-1]){
                continue;
            }
            left = i+1;
            right = nums.length-1;
            while(left<right){
             if(nums[i]+nums[left]+nums[right]==0){
                 List<Integer> temp = new ArrayList<>();
                 temp.add(nums[i]);
                 temp.add(nums[left]);
                 temp.add(nums[right]);
                 res.add(temp);
                 left++;
                 right--;
                 while (nums[left]==nums[left -1]&& left<right){
                     left ++;
                 }
                 while (nums[right]==nums[right+1]&& left<right){
                     right--;
                 }

             }else if(nums[i]+nums[left]+nums[right]<0){
                 left++;
             }
             else{
                 right--;
             }
            }
        }



        return res;
    }

    /**
     * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
     * @param height
     * @return
     */
    @Override
    public int trap(int[] height) {
        int length = height.length;
        int left = 0;
        int right = length-1;
        int maxArea = 0;
        int leftMax =0;
        int rightMax =0;
        while (left <=right){
            leftMax = Math.max(leftMax,height[left]);
            rightMax = Math.max(rightMax,height[right]);
            if(leftMax>rightMax){
                maxArea+=rightMax -height[right];
                --right;
            }else{
                maxArea+= leftMax-height[left];
                ++left;
            }
        }
        return maxArea;
    }
}

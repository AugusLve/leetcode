package com.example.algorithm.service.impl;

import com.example.algorithm.service.NormalArrService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @auth Administrator
 * @create @2024/7/21@9:29
 * @decription
 **/
@Service
public class NormalArrServiceImpl implements NormalArrService {
    /**
     * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
     *
     * 子数组
     * 是数组中的一个连续部分。
     * @param nums
     * @return
     */
    @Override
    public int maxSubArray(int[] nums) {
      int start=0;
      int end=nums.length-1;
      int maxValue=nums[0];
      int sum =0;
      while (start<=end&&end< nums.length){
          if(sum+nums[start]>=nums[start]){
              sum +=nums[start];

          }else{
               sum =nums[start];
          }
          maxValue = Math.max(maxValue,sum);
          start++;
      }
        return maxValue;
    }

    /**
     * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。
     * @param intervals
     * @return
     */
    @Override
    public int[][] merge(int[][] intervals) {
        //排序
        Arrays.sort(intervals, Comparator.comparingInt(interval -> interval[0]));

        List<int[]> res = new ArrayList<>();
        int left =0;

        while(left <intervals.length){
            int start = intervals[left][0];
            int end = intervals[left][1];
            int right = left +1;
            while (right<intervals.length&&intervals[right][0]<=end){
                end = Math.max(end,intervals[right++][1]);
            }
            res.add(new int[]{start,end});
            left = right;

        }
        return res.toArray(new int[res.size()][]);
    }

    /**
     * 给定一个整数数组 nums，将数组中的元素向右轮转 k 个位置，其中 k 是非负数。
     *
     *
     * @param nums
     * @param k
     */
    @Override
    public void rotate(int[] nums, int k) {
        int length = nums.length;
         k%=length;
        int[] arr = new int[length << 1];
        System.arraycopy(nums, 0, arr, 0, length);
        System.arraycopy(nums, 0, arr, length, length);
        System.arraycopy(arr, length - k, nums, 0, length);


    }

    /**
     * 给你一个整数数组 nums，返回 数组 answer ，其中 answer[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积 。
     *
     * 题目数据 保证 数组 nums之中任意元素的全部前缀元素和后缀的乘积都在  32 位 整数范围内。
     *
     * 请 不要使用除法，且在 O(n) 时间复杂度内完成此题。
     * @param nums
     * @return
     */
    @Override
    public int[] productExceptSelf(int[] nums) {
        int sum = 1;
        int[] res = new int[nums.length];
        for(int i=0;i<nums.length;i++){
            res[i] = sum;
            sum*=nums[i];
        }
        int sumTwo = 1;
        for(int i=nums.length-1;i>=0;i--){
            res[i]*=sumTwo;
            sumTwo*=nums[i];
        }
        return res;
    }

    /**
     * 给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。
     * @param nums
     * @return
     */
    @Override
    public int firstMissingPositive(int[] nums) {
        Arrays.sort(nums);
        int start =0;
        int minValue =1;
        while (start<nums.length){
           if(nums[start]==minValue){
               minValue++;
           }
         start++;
        }
        return  minValue;
    }
}

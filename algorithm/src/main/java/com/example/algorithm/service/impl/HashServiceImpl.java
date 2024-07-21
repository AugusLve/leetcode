package com.example.algorithm.service.impl;

import com.example.algorithm.service.HashService;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @auth Administrator
 * @create @2024/7/20@9:28
 * @decription
 **/
@Service
public class HashServiceImpl implements HashService {

    /**
     * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
     *
     * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
     * @param nums
     * @param target
     * @return
     */
    @Override
    public int[] twoSum(int[] nums, int target) {

        Map<Integer ,Integer> temp = new HashMap();
        for(int i=0;i<nums.length;i++){
            int release = target- nums[i];
            if(temp.containsKey(release)){
                return new int[] {temp.get(release),i,};
            }else{
                temp.put(nums[i],i);
            }

        }
        return new int[0];

    }

    /**
     * 给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
     *
     * 字母异位词 是由重新排列源单词的所有字母得到的一个新单词。
     * @param strs
     * @return
     */

    @Override
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> res = new HashMap<>();
        for(String str :strs){
            char arr[] = str.toCharArray();
            Arrays.sort(arr);
            res.computeIfAbsent(String.valueOf(arr),key->new ArrayList<>()).add(str);
        }

        return res.values().stream().collect(Collectors.toList());
    }

    /**
     * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
     *
     * 请你设计并实现时间复杂度为 O(n) 的算法解决此问题。
     * @param nums
     * @return
     */
    @Override
    public int longestConsecutive(int[] nums) {
        /**
         * 去重
         */
        HashSet<Integer> temp = new HashSet<>();
        for(int num :nums){
            temp.add(num);
        }
        int maxLenth=0;
        for(int num :temp){
            if(!temp.contains(num-1)){
                int length = 1;
                int cur = num;
                while (temp.contains(cur+1)){
                    length=length+1;
                    cur = cur +1;
                }
                maxLenth= Math.max(maxLenth,length);
            }


        }
        return maxLenth;
    }
}

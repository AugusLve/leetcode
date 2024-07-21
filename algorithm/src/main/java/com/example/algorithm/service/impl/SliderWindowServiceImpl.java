package com.example.algorithm.service.impl;

import com.example.algorithm.service.SliderWindowService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @auth Administrator
 * @create @2024/7/20@16:16
 * @decription
 **/
@Service
public class SliderWindowServiceImpl implements SliderWindowService {
    /**
     * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长
     * 子串
     *  的长度。
     * @param s
     * @return
     */
    @Override
    public int lengthOfLongestSubstring(String s) {
        int [] last = new int[128];
        Arrays.fill(last,-1);
        int end = 0;
        int start =0;
        for(int i=0;i<s.length();i++){
            int index = s.charAt(i);
            start = Math.max(start,last[index]+1);
            end = Math.max(end ,i-start +1);
            last[index]=i;

        }
        return end;
    }

    /**
     * 给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
     *
     * 异位词 指由相同字母重排列形成的字符串（包括相同的字符串）。
     * @param s
     * @param p
     * @return
     */
    @Override
    public List<Integer> findAnagrams(String s, String p) {
        int pLen = p.length();
        int sLen = s.length();
        char [] pStr = p.toCharArray();
        Arrays.sort(pStr);
        int start =0;
        int end =pLen;
        List<Integer> resList = new ArrayList<>();
        while (end<=sLen){
            String temp = s.substring(start,end);
            char [] tp = temp.toCharArray();
            Arrays.sort(tp);
            if(Arrays.equals(pStr,tp)){
                resList.add(start);
            }
            start++;
            end++;
        }
        return resList;
    }


}

package com.example.algorithm.service.impl;

import com.example.algorithm.service.SubStringService;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @auth Administrator
 * @create @2024/7/20@18:28
 * @decription
 **/
@Service
public class SubStringServiceImpl implements SubStringService {
    /**
     *
     * 给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的子数组的个数 。
     *
     * 子数组是数组中元素的连续非空序列。
     * @param nums
     * @param k
     * @return
     */
    @Override
    public int subarraySum(int[] nums, int k) {
        int count =0;
        for(int start=0;start<nums.length;++start){
            int sum=0;
            for(int end =start;end>=0;--end){
                sum +=nums[end];
                if(sum ==k){
                    count++;
                }
            }
        }
        return count;
    }


    /**
     * 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
     * @param nums
     * @param k
     * @return
     */
    @Override
    public int[] maxSlidingWindow(int[] nums, int k) {
/*        int start=0;
        List<Integer> res = new ArrayList<>();
        int i=0;
        while (start<=nums.length-k){
            int [] temp = new int[k];
            System.arraycopy(nums, start, temp, 0, k);
            res.add(Arrays.stream(temp).max().getAsInt());
            start++;
        }
        return res.stream().mapToInt(Integer::intValue).toArray();*/
        int n = nums.length;
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>() {
            @Override
            public int compare(int[] pair1, int[] pair2) {
                return pair1[0] != pair2[0] ? pair2[0] - pair1[0] : pair2[1] - pair1[1];
            }
        });
        for (int i = 0; i < k; ++i) {
            pq.offer(new int[]{nums[i], i});
        }
        int[] ans = new int[n - k + 1];
        ans[0] = pq.peek()[0];
        for (int i = k; i < n; ++i) {
            pq.offer(new int[]{nums[i], i});
            while (pq.peek()[1] <= i - k) {
                pq.poll();
            }
            ans[i - k + 1] = pq.peek()[0];
        }
        return ans;
    }

    /**
     * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
     * @param s
     * @param t
     * @return
     */

    @Override
    public String minWindow(String s, String t) {
        int[] cnt = new int[128];
        for (int i = 0; i < t.length(); i++) {
            cnt[t.charAt(i)]++;
        }

        int l = 0, r = 0, ansL = 0, ansR = 0, ans = Integer.MAX_VALUE, cntT = t.length();
        while (r < s.length()) {
            if (cnt[s.charAt(r++)]-- > 0){
                cntT--;
            }
            while (cntT == 0) {
                if (r - l < ans) {
                    ans = r - l;
                    ansL = l;
                    ansR = r;
                }
                if (cnt[s.charAt(l++)]++ == 0){
                    cntT++;
                }
            }
        }
        return ans == Integer.MAX_VALUE ? "" : s.substring(ansL, ansR);

    }




}

package com.example.algorithm.service;

import java.util.List;

/**
 * @auth Administrator
 * @create @2024/7/21@13:47
 * @decription
 **/
public interface MatrixService {

    public void setZeroes(int[][] matrix);

    public List<Integer> spiralOrder(int[][] matrix);

    public void rotate(int[][] matrix);

    public boolean searchMatrix(int[][] matrix, int target);
}

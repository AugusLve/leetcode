package com.example.algorithm.service.impl;

import com.example.algorithm.service.MatrixService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @auth Administrator
 * @create @2024/7/21@13:47
 * @decription
 **/
@Service
public class MatrixServiceImpl implements MatrixService {
    /**
     * 给定一个 m x n 的矩阵，如果一个元素为 0 ，则将其所在行和列的所有元素都设为 0 。请使用 原地 算法。
     *
     * @param matrix
     */
    @Override
    public void setZeroes(int[][] matrix) {
        int xRayLength = matrix.length;
        int yRayLength = matrix[0].length;
        boolean row[] = new boolean[xRayLength];
        boolean col[] = new boolean[yRayLength];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = true;
                    col[j] = true;
                }
            }
        }
        for (int i = 0; i < xRayLength; i++) {
            if (row[i]) {
                Arrays.fill(matrix[i], 0);
            }
        }
        for (int i = 0; i < yRayLength; i++) {
            if (col[i]) {
                for (int j = 0; j < xRayLength; j++) {
                    matrix[j][i] = 0;
                }
            }
        }
    }

    /**
     * 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
     *
     * @param matrix
     * @return
     */
    @Override
    public List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> res = new ArrayList<>();
        //若数组为空，直接返回答案
        if (matrix.length == 0) {
            return res;
        }
        int up = 0; //赋值上下左右边界
        int down = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;
        while (true) {
            for (int i = left; i <= right; ++i){
                res.add(matrix[up][i]); //向右移动直到最右
            }
            if (++up > down){
                break; //重新设定上边界，若上边界大于下边界，则遍历遍历完成，下同
            }
            for (int i = up; i <= down; ++i) {
                res.add(matrix[i][right]);  //向下
            }
            if (--right < left) {
                break; //重新设定有边界
            }
            for (int i = right; i >= left; --i){
                res.add(matrix[down][i]); //向左
            }
            if (--down < up){
                break; //重新设定下边界
            }
            for (int i = down; i >= up; --i){
                res.add(matrix[i][left]);//向上
            }
            if (++left > right){
                break; //重新设定左边界
            }
        }
        return res;
    }

    /**
     * 给定一个 n × n 的二维矩阵 matrix 表示一个图像。请你将图像顺时针旋转 90 度。
     *
     * 你必须在 原地 旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要 使用另一个矩阵来旋转图像。
     * @param matrix
     */
    @Override
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int temp = 0;

        // 矩阵转置
        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n; j++){
                temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // 左右对称的两列互换
        for(int j = 0; j < n / 2; j++){
            for(int i = 0; i < n; i++){
                temp = matrix[i][j];
                matrix[i][j] = matrix[i][n - j - 1];
                matrix[i][n - j - 1] = temp;
            }
        }

    }

    /**
     *编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target 。该矩阵具有以下特性：
     *
     * 每行的元素从左到右升序排列。
     * 每列的元素从上到下升序排列。
     * @param matrix
     * @param target
     * @return
     */
    @Override
    public boolean searchMatrix(int[][] matrix, int target) {
        int xRayLength = matrix.length;
        int yRayLength = matrix[0].length;
        int xRay=xRayLength-1;
        int yRay=0;
        while (xRay>=0&&yRay<yRayLength){
            if(matrix[xRay][yRay]==target){
                return true;
            }else if(matrix[xRay][yRay]>target){
                xRay--;
            }else if(matrix[xRay][yRay]<target){
                yRay++;
            }
        }
        return false;
    }
}

import org.junit.Test;

import java.io.*;
import java.util.*;

public class Exercises {


    /**
     * 编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target。该矩阵具有以下特性：
     *
     * 每行的元素从左到右升序排列。
     * 每列的元素从上到下升序排列。
     * 示例:
     *
     * 现有矩阵 matrix 如下：
     *
     * [
     *   [1,   4,  7, 11, 15],
     *   [2,   5,  8, 12, 19],
     *   [3,   6,  9, 16, 22],
     *   [10, 13, 14, 17, 24],
     *   [18, 21, 23, 26, 30]
     * ]
     * 给定 target = 5，返回 true。
     *
     * 给定 target = 20，返回 false。
     *
     * 思路：二分法可知从中间取值效率最高，左下角和右上角是最接近矩阵中数值中间的值，所以可以从左下角至右上角循环，也可以从
     *      右上角至左下角循环，此处选择第一种。
     *      row：当前选中的行，初始为总行数-1
     *      column：当前选中的列，初始为0
     *
     *      如果当前行列对应的值小于目标值，说明该列中一定没有对应的值，所以colmn++；
     *      如果当前行列对应的值大于目标值，说明该行中一定没有对应的值，所以row--；
     *      如果当前行列对应的值等于目标值，则直接返回true。
     *
     *      注：因为情况最多的就是大于或者小于，所以条件：等于，放在最后一个else
     */
    public boolean searchMatrix1(int[][] matrix, int target) {
        int row = matrix.length-1;
        int column = 0;
        while(row>0 && column<matrix[0].length){
            if(matrix[row][column]>target){
                column++;
            }else if(matrix[row][column]<target){
                row--;
            }else{
                return true;
            }
        }
        return false;
    }
    /**
     * 编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target。该矩阵具有以下特性：
     * <p>
     * 每行中的整数从左到右按升序排列。
     * 每行的第一个整数大于前一行的最后一个整数。
     * 示例:
     * <p>
     * 现有矩阵 matrix 如下：
     * <p>
     * [
     *   [1,   3,  5,  7],
     *   [10, 11, 16, 20],
     *   [23, 30, 34, 50]
     * ]
     * 给定 target = 5，返回 true。
     * <p>
     * 给定 target = 21，返回 false。
     *
     * 思路：使用二分查找法。第一次while先获取目标对应的行，第二次while再从该行寻找对应的目标值。
     *      left:最左边数索引，初始值为0
     *      right:最右边数索引，初始值为行数-1
     *      middle：中间的数的索引，如果right-left为奇数，则为中间的数；如果为偶数，则取中间靠左的数。
     *
     *      如果middle值大于目标值，则right=middle-1
     *      如果middle值小于目标值，则middle=left+1
     *      如果middle值等于目标值，返回true
     */

    @Test
    public void test4() {
        int[][] matrix = {
                {1,3,5,7},
                {10,11,16,20},
                {23,30,34,50},
        };
        boolean result = searchMatrix2(matrix, 5);
        System.out.println(result);
    }

    public boolean searchMatrix2(int[][] matrix, int target) {
        int left = 0;
        int right = matrix.length - 1;
        int middle = 0;
        while (left <= right) {
            middle = (left + right) >> 1;//位运算，右移一位
            if (matrix[middle][0] > target) {
                right = middle - 1;
            } else if (matrix[middle][0] < target) {
                left = middle + 1;
            } else {
                return true;
            }
        }
        int row = left-1;
        left = 0;
        right = matrix[0].length-1;
        while (left <= right) {
            middle = (left + right) >>1;
            if (matrix[row][middle] > target) {
                right = middle - 1;
            } else if (matrix[row][middle] < target) {
                left = middle + 1;
            } else {
                return true;
            }
        }
        return false;
    }

    /**
     * 给定一个大小为 n 的数组，找到其中的众数。众数是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
     * <p>
     * 你可以假设数组是非空的，并且给定的数组总是存在众数。
     * <p>
     * 示例 1:
     * <p>
     * 输入: [3,2,3]
     * 输出: 3
     * 示例 2:
     * <p>
     * 输入: [2,2,1,1,1,2,2]
     * 输出: 2
     */
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer value = hashMap.get(nums[i]);
            if (value != null) {
                if (value + 1 > nums.length / 2) {
                    return nums[i];
                }
                hashMap.put(nums[i], value + 1);
            } else {
                hashMap.put(nums[i], 1);
            }
        }
        return 0;
    }

    //摩尔投票法，两个不同的数字相互抵消，count--，相同数字count++，count为0时，说明已经抵消，然后众数为第一个数，count=1，继续循环。
    //摩尔投票法只适用于前提是存在众数的数组中，不适用于直接求众数。比如[1,2,3,4,5]，只会得到结果5，但5并不是众数。
    public int majorityElement2(int[] nums) {
        int maj = 0; //代表众数
        int count = 0; //代表当前还未被抵消的数的数量
        for (int i = 0; i < nums.length; i++) {
            if (count == 0) {
                maj = nums[i];
                count = 1;
            } else {
                if (maj == nums[i]) {
                    count++;
                } else {
                    count--;
                }
            }
        }
        if (count >= 1) {
            return maj;
        } else {
            return 0;
        }
    }

    @Test
    public void main() {
        int[] nums = {3, 2, 3};
        int num = majorityElement(nums);
        System.out.println(num);
    }

    /**
     * 有一个字符串，其中包含中文字符、英文字符和数字字符，请统计和打印出
     * 各个字符的个数。
     */
    @Test
    public void test1() {
        String content = "中国 aadf 的111萨 bbb 菲的 zz 萨菲";
        char[] chars = content.toCharArray();
        int digitCount = 0;
        int englishCount = 0;
        int chineseCount = 0;
        for (char c : chars) {
            if ((c >= '0') && (c <= '9')) {
                digitCount++;
            } else if (((c >= 'a') && (c <= 'z')) || ((c >= 'A') && (c <= 'Z'))) {
                englishCount++;
            } else {
                chineseCount++;
            }
        }
    }

    /**
     * 从类似如下的文本文件中读取出所有的姓名，并打印出重复的姓名和重复的
     * 次数，并按重复次数排序：
     * 1,张三,28
     * 2,李四,35
     * 3,张三,28
     * 4,王五,35
     * 5,张三,28
     * 6,李四,35
     * 7,赵六,28
     * 8,田七,35
     */
    @Test
    public void sort() throws IOException {
        File file = new File("D:\\Code\\JavaLearn\\练习题\\sort");
        BufferedReader reader = null;
        reader = new BufferedReader(new FileReader(file));
        String tempString = null;
        HashMap<String, Integer> hm = new HashMap<>();
        while ((tempString = reader.readLine()) != null) {
            String[] split = tempString.split(",");
            Integer count = hm.get(split[1]);
            if (count == null) {
                hm.put(split[1], 0);
            } else {
                hm.put(split[1], count + 1);
            }
        }
        reader.close();

        Iterator<Map.Entry<String, Integer>> iterator = hm.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Integer> next = iterator.next();
            System.out.println(next.getKey() + next.getValue());
        }

    }

    /**
     * 排序
     */
    @Test
    public void sortNumber() {
        int[] arr = {2, 34, 1, 6, 4};
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        for (int i : arr) {
            System.out.println(i);
        }
    }

    /**
     * 冒泡排序-递增，时间复杂度O（n^2）
     */
    @Test
    public void sortNumber2() {
        int[] arr = null;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    /**
     * 选择排序-递增，时间复杂度O（n^2）
     */
    @Test
    public void sortNumber3() {
        int[] arr = null;
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = 0;
            for (int j = i + 1; j < arr.length - 1; j++) {
                if (arr[j + 1] < arr[j]) {
                    minIndex = j + 1;
                } else {
                    minIndex = j;
                }
            }
            if (arr[minIndex] < arr[i]) {
                int temp = arr[minIndex];
                arr[minIndex] = arr[i];
                arr[i] = temp;
            }
        }
    }

    /**
     * 给你一个只由字母'A'和'B'组成的字符串s，找一个最长的子串，要求这个子串里面'A'和'B'的数目相等，输出该子串的长度
     */
    @Test
    public void getAns() {
        String s = "ABAABABbABABAABBBBAAABABAbAABABABABBBBAABABBBBAAAAABAABAbABAAABBAAABBBBBAABBBBAABBBABBBA";
        int aNumber = 0;
        int bNumber = 0;
        int maxLength = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == 'A') {
                aNumber++;
            } else {
                bNumber++;
            }
        }
        maxLength = aNumber < bNumber ? aNumber * 2 : bNumber * 2;

        while (maxLength >= 2) {
            //按照maxLength取出最长的符合条件的字符串
            for (int i = 0; i < s.length(); i++) {
                String realS = s.substring(i, maxLength);
                char[] chars1 = realS.toCharArray();
                int aRealNumber = 0;
                int bRealNumber = 0;
                for (int j = 0; j < chars1.length; j++) {
                    if (chars1[j] == 'A') {
                        aRealNumber++;
                    } else {
                        bRealNumber++;
                    }
                }
                if (aRealNumber == bRealNumber) {
                    System.out.println(realS);
                    return;
                }
            }
            maxLength--;
        }

    }

    @Test
    public void test11() {
        int result = getAns("ABABBBAABABBBBABAB");
        System.out.println(result);

    }

    /**
     * 上个题的标准解法，没看懂
     *
     * @param s
     * @return
     */
    public int getAns(String s) {
        // write your code here
        int len = s.length();
        int dp[] = new int[len + 1];
        dp[1] = (s.charAt(0) - 'A') == 1 ? 1 : -1;
        for (int i = 2; i <= len; i++) {
            dp[i] = (s.charAt(i - 1) - 'A') == 1 ? 1 : -1;
            dp[i] += dp[i - 1];
        }
        int max = 0, begin;
        Map<Integer, Integer> m = new HashMap<>();
        for (int i = 1; i <= len; i++) {
            begin = m.getOrDefault(dp[i], 0);
            if (begin == 0 && dp[i] != 0) {
                m.put(dp[i], i);
            } else {
                if (i - begin > max) {
                    max = i - begin;
                }
            }
        }
        return max;
    }

    /**
     * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
     * <p>
     * 说明：
     * <p>
     * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
     */
    @Test
    public void test2() {
        int[] nums = {1, 2, 3, 1, 3};
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer value = hashMap.get(nums[i]);
            if (value == null) {
                hashMap.put(nums[i], 1);
            } else {
                hashMap.put(nums[i], 2);
            }
        }
        for (Map.Entry<Integer, Integer> map : hashMap.entrySet()) {
            if (map.getValue() == 1) {
                System.out.println(map.getKey());
                break;
            }
        }
    }

    /**
     * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
     * <p>
     * 说明：
     * <p>
     * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
     */
    @Test
    public void test3() {
        int[] nums = {1, 2, 3, 1, 3};
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i = i + 2) {
            if (i == nums.length - 1) {
                System.out.println(nums[i]);
                break;
            }
            if (nums[i] != nums[i + 1]) {
                System.out.println(nums[i]);
                break;
            }
        }

    }

}

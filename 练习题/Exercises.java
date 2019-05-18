import org.junit.Test;

import java.io.*;
import java.util.*;

public class Exercises {

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
    public void sortNumber2(){
        int[] arr = null;
        for (int i = 0 ;i<arr.length-1;i++){
            for (int j = 0;j<arr.length-1-i;j++){
                if (arr[i]>arr[j]){
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
    public void sortNumber3(){
        int[] arr = null;
        for (int i = 0 ;i<arr.length-1;i++){
            int minIndex = 0;
            for(int j = i+1;j<arr.length-1;j++){
                if (arr[j+1]<arr[j]){
                    minIndex = j+1;
                }else{
                    minIndex = j;
                }
            }
            if(arr[minIndex]<arr[i]){
                int temp = arr[minIndex];
                arr[minIndex] = arr[i];
                arr[i] = temp;
            }
        }
    }

    /**
     *  给你一个只由字母'A'和'B'组成的字符串s，找一个最长的子串，要求这个子串里面'A'和'B'的数目相等，输出该子串的长度
     */
    @Test
    public void getAns() {
        String s = "ABAABABbABABAABBBBAAABABAbAABABABABBBBAABABBBBAAAAABAABAbABAAABBAAABBBBBAABBBBAABBBABBBA";
        int aNumber = 0;
        int bNumber = 0;
        int maxLength = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if(chars[i]=='A'){
                aNumber ++;
            }else{
                bNumber ++;
            }
        }
        maxLength = aNumber<bNumber ? aNumber*2 : bNumber*2;

        while (maxLength>=2){
            //按照maxLength取出最长的符合条件的字符串
            for (int i = 0; i < s.length(); i++) {
                String realS = s.substring(i,maxLength);
                char[] chars1 = realS.toCharArray();
                int aRealNumber = 0;
                int bRealNumber = 0;
                for (int j = 0; j < chars1.length; j++) {
                    if(chars1[j]=='A'){
                        aRealNumber ++;
                    }else{
                        bRealNumber ++;
                    }
                }
                if(aRealNumber==bRealNumber){
                    System.out.println(realS);
                    return;
                }
            }
            maxLength--;
        }

    }

    @Test
    public void test11(){
        int result = getAns("ABABBBAABABBBBABAB");
        System.out.println(result);

    }

    /**
     * 上个题的标准解法，没看懂
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
     *
     * 说明：
     *
     * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
     */
    @Test
    public void test2(){
        int[] nums = {1,2,3,1,3};
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        for(int i =0;i<nums.length;i++){
            Integer value = hashMap.get(nums[i]);
            if(value==null){
                hashMap.put(nums[i],1);
            }else{
                hashMap.put(nums[i],2);
            }
        }
        for(Map.Entry<Integer,Integer> map : hashMap.entrySet()){
            if(map.getValue()==1){
                System.out.println(map.getKey());
                break;
            }
        }
    }

    /**
     * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
     *
     * 说明：
     *
     * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
     */
    @Test
    public void test3(){
        int[] nums = {1,2,3,1,3};
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i=i+2) {
            if(i==nums.length-1){
                System.out.println(nums[i]);
                break;
            }
            if(nums[i] != nums[i+1]){
                System.out.println(nums[i]);
                break;
            }
        }

    }

}

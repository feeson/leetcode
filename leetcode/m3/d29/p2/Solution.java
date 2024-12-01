package y24.m3.d29.p2;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int subarraySum(int[] nums, int k) {
        int len = nums.length;
        int[] sum = new int[len + 1];
        Map<Integer,Integer> map = new HashMap<>();
        int res =0;
        for (int i = 1;i <= len;++i){
            sum[i] = sum[i - 1]+nums[i - 1];
            Integer orDefault = map.getOrDefault(sum[i], 0);
            map.put(sum[i],orDefault + 1);
            int find = nums[i] - k;
            res += map.getOrDefault(find,0);
        }
        return res;
    }
}
class Main{
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        Field valueField = String.class.getDeclaredField("value");

        // 允许访问和修改私有和final字段
        valueField.setAccessible(true);

        // 获取Field类的modifiers字段
        Field modifiersField = Field.class.getDeclaredField("modifiers");

        // 允许访问和修改私有和final字段
        modifiersField.setAccessible(true);

        // 移除value字段的final修饰符
        modifiersField.setInt(valueField, valueField.getModifiers() & ~Modifier.FINAL);

        // 创建一个String对象
        String str = "Hello, World!";

        // 修改value字段的值
        valueField.set(str, "Hello, GitHub Copilot!".toCharArray());

        // 输出修改后的String对象
        System.out.println(str);
    }
}
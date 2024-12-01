package y23.m4.d8;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class main {
    public static void main(String[] args) {
        Solution solution=new Solution();
        String []arr1=new String[]{"java","nodejs","reactjs"};
        List<List<String>> arr2=new ArrayList<>();
        List<String> arr21=new ArrayList<>();
        arr21.add("java");
        arr2.add(arr21);
        List<String> arr22=new ArrayList<>();
        arr22.add("nodejs");
        arr2.add(arr22);
        List<String> arr23=new ArrayList<>();
        arr23.add("nodejs");
        arr23.add("reactjs");
        arr2.add(arr23);
        List<String> arr24=new ArrayList<>();
        arr24.add("nodejs");
        arr24.add("reactjs");
        arr2.add(arr24);
        Arrays.stream(solution.smallestSufficientTeam(arr1, arr2)).forEach(value -> System.out.print(value));
    }



}

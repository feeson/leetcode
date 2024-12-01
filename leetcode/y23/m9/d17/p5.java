package y23.m9.d17;

import java.util.List;

class Solutionp5 {
    public int maxNumberOfAlloys(int n, int k, int budget, List<List<Integer>> composition, List<Integer> stock, List<Integer> cost) {
        for (List<Integer> machine:composition){
            Integer[] array = machine.toArray(new Integer[0]);
            Integer[] stockArray = stock.toArray(new Integer[0]);
            int times=0;
            int cef=0;
            for (int i=0;i<n;++i){
                cef+=array[i]*cost.get(i);
            }
            times+=budget/cef;


        }
        return 0;
    }
}
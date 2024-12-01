package y23.m8.d26;

/**
 * 给定一个数组 coordinates ，其中 coordinates[i] = [x, y] ， [x, y] 表示横坐标为 x、纵坐标为 y 的点。请你来判断，这些点是否在该坐标系中属于同一条直线上。
 *
 * https://leetcode.cn/problems/check-if-it-is-a-straight-line/
 */
class Solutionp2 {
    public boolean checkStraightLine(int[][] coordinates) {
        // y-y1=k(x-x1) y=kx-kx1+y1  y=kx+c
        int x=coordinates[0][0];
        int y=coordinates[0][1];
        double k=(double) (coordinates[1][1]-y)/(double) (coordinates[1][0]-x);
        double c=-k*coordinates[0][0]+coordinates[0][1];
        int len=coordinates.length;
        if (!Double.isFinite(k)){
            for (int i=2;i<len;++i){
                if (coordinates[i][0]!=coordinates[0][0])
                    return false;
            }
            return true;
        }
        for (int i=2;i<len;++i ){
            if (coordinates[i][1]!=k*coordinates[i][0]+c)
                return false;
        }
        return true;
    }
}
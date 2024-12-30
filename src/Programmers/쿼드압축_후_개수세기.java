package Programmers;

import java.util.*;

public class 쿼드압축_후_개수세기 {
    public static void main(String[] args) {
        // 테스트할 배열들
        int[][] arr1 = {
                {1, 1, 0, 0},
                {1, 0, 0, 0},
                {1, 0, 0, 1},
                {1, 1, 1, 1}
        };

        int[][] arr2 = {
                {1, 1, 1, 1, 1, 1, 1, 1},
                {0, 1, 1, 1, 1, 1, 1, 1},
                {0, 0, 0, 0, 1, 1, 1, 1},
                {0, 1, 0, 0, 1, 1, 1, 1},
                {0, 0, 0, 0, 0, 0, 1, 1},
                {0, 0, 0, 0, 0, 0, 0, 1},
                {0, 0, 0, 0, 1, 0, 0, 1},
                {0, 0, 0, 0, 1, 1, 1, 1}
        };

        // Solution 클래스 생성
        Solution solution = new Solution();

        // 첫 번째 테스트 실행
        int[] result1 = solution.solution(arr1);
        System.out.println("Result for arr1: " + Arrays.toString(result1));

        // 두 번째 테스트 실행
        int[] result2 = solution.solution(arr2);
        System.out.println("Result for arr2: " + Arrays.toString(result2));
    }
}

class Solution {
    int[][] arr;
    HashMap<Integer,Integer> m = new HashMap<>();
    public int[] solution(int[][] arr) {
        m.put(0,0);
        m.put(1,0);
        this.arr = arr;
        int length = arr.length;

        if(bQuad(0,0,length)){
            m.put(arr[0][0],m.get(arr[0][0])+1);
            return new int[]{m.get(0),m.get(1)};
        }

        rpt(0,0,length);

        return new int[]{m.get(0),m.get(1)};
    }

    public void rpt(int R, int C,int length){
        if(length==1)
            m.put(arr[R][C],m.get(arr[R][C])+1);

        int[] dR = {R, R+length/2, R, R+length/2};
        int[] dC = {C, C, C+length/2, C+length/2};

        for(int i=0;i<4;i++){
            if(bQuad(dR[i],dC[i],length/2)) m.put(arr[dR[i]][dC[i]],m.get(arr[dR[i]][dC[i]])+1);
            else rpt(dR[i],dC[i],length/2);
        }
    }

    public boolean bQuad(int x, int y, int len){
        for(int i=x;i<x+len;i++){
            for(int j=y;j<y+len;j++){
                if(arr[x][y]!=arr[i][j])
                    return false;
            }
        }

        return true;
    }
}

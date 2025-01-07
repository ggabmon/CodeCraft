package Programmers.level2;

import java.util.Arrays;
import java.util.Collections;

public class 최솟값_만들기 {

    public int solution1(int []A, int []B)
    {
        Arrays.sort(A);
        Arrays.sort(B);

        int answer = 0;

        for(int i=0;i<A.length;i++){
            answer += A[i]*B[A.length-i-1];
        }

        return answer;
    }

    //원시타입과 참조타입의 차이를 구별하지 못한 아래와같은경우 시간초과 발생

    public int solution2(int []A, int []B)
    {
        Integer[] AObj = Arrays.stream(A).boxed().toArray(Integer[]::new);
        Integer[] BObj = Arrays.stream(B).boxed().toArray(Integer[]::new);

        Arrays.sort(AObj);
        Arrays.sort(BObj, Collections.reverseOrder());

        int answer = 0;

        for(int i=0;i<AObj.length;i++){
            answer += AObj[i]*BObj[i];
        }

        return answer;
    }
}

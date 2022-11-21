package 테스트;

class JGenClass{
    static <T>T take(T s[], int index) {
        if (index > s.length) {
            System.out.println("인덱스가 범위를 벗어났습니다.");
            return null;
        }
        return s[index];
    }
}

public class CheckList {
    public static void main(String[] args) {
        String arr[] = {"1번째", "2번째", "3번째", "4번째"};

        System.out.println(JGenClass.take(arr, 2));
    }
}

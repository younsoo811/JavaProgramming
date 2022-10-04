package javaStudy;

import java.util.Scanner;

public class RectCollision {

    public static void main(String[] args) {
        int X1 = 100, Y1 = 100;
        int X2 = 200, Y2 = 200;

        System.out.print("직사각형을 구성하는 두 점을 입력해주세요: ");
        Scanner scanner = new Scanner(System.in);

        int x1 = scanner.nextInt();
        int y1 = scanner.nextInt();
        int x2 = scanner.nextInt();
        int y2 = scanner.nextInt();

        if (inRect(x1, y1, X1, Y1, X2, Y2)) {
            System.out.println("두 직사각형은 충돌합니다.");
        }
        else if (inRect(x2, y2, X1, Y1, X2, Y2)){
            System.out.println("두 직사각형은 충돌합니다.");
        }
        else
            System.out.println("두 직사각형은 충돌하지 않습니다.");
    }

    public static boolean inRect(int x, int y, int rectx1, int recty1, int rectx2, int recty2) {

        if ((x >= rectx1 && x <= rectx2) && (y >= recty1 && y <= recty2))
            return true;
        else return false;
    }
}

package javaStudy;

import java.util.InputMismatchException;
import java.util.Scanner;

public class RockScPaper {
    public static void main(String[] args) {
        String str[] = {"가위", "바위", "보"};
        String user;

        Scanner scanner = new Scanner(System.in);

        System.out.println("컴퓨터와 가위 바위 보 게임을 합니다");

        while (true) {
            System.out.print("가위 바위 보!>>");

            try {
                user = scanner.next();
            }
            catch (InputMismatchException e) {
                System.out.println("잘못 입력하였습니다. 가위 바위 보 중 하나를 선택해 입력하세요.");
                scanner.next();
                continue;
            }
            int n = (int)(Math.random()*3);

            if (user.equals("그만")){
                System.out.println("게임을 종료합니다...");
                break;
            }

            if (str[n].equals("가위")) {
                if (user.equals("가위")){
                    System.out.println("사용자 = " + user + ", 컴퓨터 = " + str[n] + ", 비겼습니다.");
                }
                else if (user.equals("바위")){
                    System.out.println("사용자 = " + user + ", 컴퓨터 = " + str[n] + ", 사용자가 이겼습니다.");
                }
                else if (user.equals("보")){
                    System.out.println("사용자 = " + user + ", 컴퓨터 = " + str[n] + ", 컴퓨터가 이겼습니다.");
                }
                else{
                    System.out.println("잘못 입력하였습니다. 가위 바위 보 중 하나를 선택해 입력하세요.");
                    continue;
                }
            }
            else if (str[n].equals("바위")) {
                if (user.equals("바위")){
                    System.out.println("사용자 = " + user + ", 컴퓨터 = " + str[n] + ", 비겼습니다.");
                }
                else if (user.equals("보")){
                    System.out.println("사용자 = " + user + ", 컴퓨터 = " + str[n] + ", 사용자가 이겼습니다.");
                }
                else if (user.equals("가위")){
                    System.out.println("사용자 = " + user + ", 컴퓨터 = " + str[n] + ", 컴퓨터가 이겼습니다.");
                }
                else{
                    System.out.println("잘못 입력하였습니다. 가위 바위 보 중 하나를 선택해 입력하세요.");
                    continue;
                }
            }
            else{
                if (user.equals("보")){
                    System.out.println("사용자 = " + user + ", 컴퓨터 = " + str[n] + ", 비겼습니다.");
                }
                else if (user.equals("가위")){
                    System.out.println("사용자 = " + user + ", 컴퓨터 = " + str[n] + ", 사용자가 이겼습니다.");
                }
                else if (user.equals("바위")){
                    System.out.println("사용자 = " + user + ", 컴퓨터 = " + str[n] + ", 컴퓨터가 이겼습니다.");
                }
                else{
                    System.out.println("잘못 입력하였습니다. 가위 바위 보 중 하나를 선택해 입력하세요.");
                    continue;
                }
            }
        }
        scanner.close();
    }
}

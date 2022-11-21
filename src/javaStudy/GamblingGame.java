package javaStudy;

import java.util.InputMismatchException;
import java.util.Scanner;

class Game {
    String playerName;
    static int playerNumber;
    public Game next;
    public Game() { next = null;}
    public Game(int playerNumber) { this.playerNumber = playerNumber;}
    public void setNumber(){}
    public boolean equals(){return true;}
}

class SetPlayer extends Game {
    private int num[] = new int[3];
    public SetPlayer(String playerName) {
        super.playerName = playerName;
    }
    @Override
    public void setNumber(){
        // 1~3 까지의 랜덤한 수 3개 얻기
        for (int i=0; i<3; i++){
            num[i] = (int)(Math.random()*3+1);
            System.out.print("\t"+num[i]);
        }
    }
    @Override
    public boolean equals(){
        // 랜덤한 수 3개가 서로 일치하는지 확인하기
        if (num[0] == num[1] && num[1] == num[2])
            return true;
        else
            return false;
    }
}

public class GamblingGame {
    public static void main(String[] args){
        int total = 0;
        boolean check = true;
        Game start, last = null, obj;
        Scanner scanner = new Scanner(System.in);

        System.out.print("갬블링 게임에 참여할 선수 숫자>>");
        try {
            total = scanner.nextInt();
        }
        catch (InputMismatchException e) {
            System.out.println("오류!! 참여 인원을 정수형으로 입력해주세요!!");
        }
        start = new Game(total);  // 게임이 시작되면서 플레이어 수 저장

        // 선수 이름 객체로 등록
        for (int i = 0; i<total; i++){
            System.out.print((i+1)+"번째 선수 이름>>");
            if(i==0) {
                start = new SetPlayer(scanner.next());
                last = start;
            }
            else {
                obj = new SetPlayer(scanner.next());
                last.next = obj;
                last = obj;
            }
        }

        while(check){
            Game g = start; //업캐스팅
            while(g != null) {
                Scanner sc = new Scanner(System.in);
                System.out.print("["+g.playerName+"]:<Enter>");
                if (sc.nextLine()=="") {
                    g.setNumber();
                    if(g.equals()) {
                        System.out.println("\t" + g.playerName + "님이 이겼습니다!");
                        check = false;
                        break;
                    }
                    else
                        System.out.println("\t아쉽군요!");
                }
                g = g.next;
            }
        }
    }
}

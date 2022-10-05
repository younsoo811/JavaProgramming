package javaStudy;

import java.util.InputMismatchException;
import java.util.Scanner;

class Reservation {
    public int menuNum, seatNum, subnum;
    private String name;
    private static String[] listS = {"---", "---", "---", "---", "---", "---", "---", "---", "---", "---"};
    private static String[] listA = {"---", "---", "---", "---", "---", "---", "---", "---", "---", "---"};
    private static String[] listB = {"---", "---", "---", "---", "---", "---", "---", "---", "---", "---"};

    //기본 생성자
    public Reservation() { }

    //메뉴 선택 함수
    public void input(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("예약:1, 조회:2, 취소:3, 끝내기:4>>");
        try{
            menuNum = scanner.nextInt();
        }
        catch(InputMismatchException e){
            System.out.println("메뉴를 잘못 선택했습니다. 다시 선택해주세요!");
            input();
        }

        if(menuNum == 1){
            reservar();
        }
        else if(menuNum == 2){
            search();
        }
        else if(menuNum == 3){
            cancel();
        }
        else if(menuNum == 4){
        }
        else{
            System.out.println("메뉴를 잘못 선택했습니다. 1~4번 중 다시 선택해주세요!");
            input();
        }

        scanner.close();
    }

    //예약 받는 함수
    public void reservar(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("좌석구분 S(1), A(2), B(3)>>");
        try{
            seatNum = scanner.nextInt();
        }
        catch(InputMismatchException e){
            System.out.println("좌석 번호를 잘못 입력했습니다. 다시 선택해주세요!");
            reservar();
        }
        if(seatNum == 1 || seatNum == 2 || seatNum == 3) {
            seatprint();
        }
       else {
            System.out.println("좌석 번호를 잘못 입력했습니다. 다시 선택해주세요!");
            reservar();
        }

        System.out.print("이름>>");
        name = scanner.next();

        System.out.print("번호>>");
        try{
            subnum = scanner.nextInt();
        }
        catch(InputMismatchException e){
            System.out.println("좌석 번호를 잘못 입력했습니다. 다시 선택해주세요!");
            reservar();
        }

        if(seatNum == 1){
            if(listS[subnum-1] == "---"){
                listS[subnum-1] = name;
                input();
            }
            else{
                System.out.println("이미 예약되어있는 자리입니다. 다시 선택해주세요!");
                scanner.next();
                reservar();
            }
        }
        else if(seatNum == 2){
            if(listA[subnum-1] == "---"){
                listA[subnum-1] = name;
                input();
            }
            else{
                System.out.println("이미 예약되어있는 자리입니다. 다시 선택해주세요!");
                scanner.next();
                reservar();
            }
        }
        else if(seatNum == 3){
            if(listB[subnum-1] == "---"){
                listB[subnum-1] = name;
                input();
            }
            else{
                System.out.println("이미 예약되어있는 자리입니다. 다시 선택해주세요!");
                scanner.next();
                reservar();
            }
        }

        scanner.close();
    }

    //예약 조회하면 출력해주는 함수
    public void search() {
        System.out.print("S>>");
        for (String s : listS){
            System.out.print(" " + s);
        }
        System.out.println();

        System.out.print("A>>");
        for (String s : listA){
            System.out.print(" " + s);
        }
        System.out.println();

        System.out.print("B>>");
        for (String s : listB){
            System.out.print(" " + s);
        }
        System.out.println();

        System.out.println("<<<조회를 완료하였습니다.>>>");
        input();
    }

    //예약 취소하는 함수
    public void cancel(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("좌석 S:1, A:2, B:3>>");
        try{
            seatNum = scanner.nextInt();
        }
        catch (InputMismatchException e){
            System.out.println("좌석 번호를 잘못 입력했습니다. 다시 선택해주세요!");
            cancel();
        }

        if(seatNum == 1 || seatNum == 2 || seatNum == 3) {
            seatprint();
        }
        else {
            System.out.println("좌석 번호를 잘못 입력했습니다. 다시 선택해주세요!");
            cancel();
        }

        while(true){
            System.out.print("이름>>");
            name = scanner.next();

            int check = 1;

            if(seatNum == 1){
                for (int i=0; i< listS.length; i++){
                    if (listS[i].equals(name)){
                        listS[i] = "---";
                        check = 1;
                        break;
                    }
                    else check = 0;
                }
            }
            else if(seatNum == 2){
                for (int i=0; i< listA.length; i++){
                    if (listA[i].equals(name)){
                        listA[i] = "---";
                        check = 1;
                        break;
                    }
                    else check = 0;
                }
            }
            else if(seatNum == 3){
                for (int i=0; i< listB.length; i++){
                    if (listB[i].equals(name)){
                        listB[i] = "---";
                        check = 1;
                        break;
                    }
                    else check = 0;
                }
            }
            if(check == 0){
                System.out.println("이름을 찾을수 없습니다. 다시 입력해주세요!");
                continue;
            }
            else
                break;
        }

        input();
        scanner.close();
    }

    //해당하는 좌석만 출력하는 메소드
    public void seatprint(){
        if(seatNum == 1){
            System.out.print("S>>");
            for (String s : listS){
                System.out.print(" " + s);
            }
            System.out.println();
        }
        else if(seatNum == 2){
            System.out.print("A>>");
            for (String s : listA){
                System.out.print(" " + s);
            }
            System.out.println();
        }
        else if(seatNum == 3){
            System.out.print("B>>");
            for (String s : listB){
                System.out.print(" " + s);
            }
            System.out.println();
        }
    }
}

public class ReservationSystem {
    public static void main(String args[]) {
        Reservation Rsystem = new Reservation();
        System.out.println("명품콘서트홀 예약 시스템입니다.");

        Rsystem.input();
    }
}

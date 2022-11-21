package javaStudy;

import java.util.InputMismatchException;
import java.util.Scanner;

abstract class Shape {
    private Shape next;
    public Shape() { next = null;}
    public void setNext(Shape obj) { next = obj; }
    public Shape getNext() { return next; }
    public abstract void draw();
}

class Line extends Shape {
    @Override
    public void draw(){
        System.out.println("Line");
    }
}

class Rect extends Shape {
    @Override
    public void draw(){
        System.out.println("Rect");
    }
}

class Circle extends Shape {
    @Override
    public void draw(){
        System.out.println("Circle");
    }
}

class GraphicEditor {
    Shape start, last;
    int menuNum=0, insertNum, deleteNum;
    Scanner scanner = new Scanner(System.in);
    public void setMenu() {

        while (menuNum != 4){
            System.out.print("삽입(1), 삭제(2), 모두 보기(3), 종료(4)>>");
            try{
                menuNum = scanner.nextInt();
            }
            catch(InputMismatchException e){
                System.out.println("잘못된 메뉴 번호 입니다. 다시 입력해주세요!");
            }
            switch(menuNum){
                case 1:
                    setInsertNum();
                    break;
                case 2:
                    setDeleteNum();
                    break;
                case 3:
                    showAll();
                    break;
                case 4:
                    System.out.println("beauty을 종료합니다.");
                    break;
                default:
                    System.out.println("잘못된 메뉴 번호 입니다. 1~3번 중 선택해주세요!");
            }
        }
    }

    public void setInsertNum(){
        Shape i;

        System.out.print("Line(1), Rect(2), Circle(3)>>");
        try{
            insertNum = scanner.nextInt();
        }
        catch(InputMismatchException e){
            System.out.println("잘못된 메뉴 번호 입니다. 다시 입력해주세요!");
        }
        switch(insertNum){
            case 1:
                i = new Line(); //Line 객체 연결
                if (start == null){
                    start = i;
                    last = i;
                }
                else{
                    last.setNext(i);
                    last = i;
                }
                break;
            case 2:
                i = new Rect(); //Rect 객체 연결
                if (start == null){
                    start = i;
                    last = i;
                }
                else{
                    last.setNext(i);
                    last = i;
                }
                break;
            case 3:
                i = new Circle(); //Circle 객체 연결
                if (start == null){
                    start = i;
                    last = i;
                }
                else{
                    last.setNext(i);
                    last = i;
                }
                break;
            default:
                System.out.println("잘못된 메뉴 번호 입니다. 1~3번 중 선택해주세요!");
                setInsertNum();
        }
    }
    public void setDeleteNum(){
        Shape obj = start;
        Shape temp = start;

        System.out.print("삭제할 도형의 위치>>");
        try{
            deleteNum = scanner.nextInt();
        }
        catch(InputMismatchException e){
            System.out.println("잘못된 메뉴 번호 입니다. 다시 입력해주세요!");
        }

        if (deleteNum==1){
            if (start==last) {
                last=start=null;
            }
            else{
                start=start.getNext();
            }
        }
        else{
            for (int i=1; i<deleteNum; i++){
                temp = obj;
                obj=obj.getNext();
            }
            if(obj == null){
                System.out.println("삭제할 수 없습니다.");
            }
            else{
                if (obj==last){
                    last=temp;
                    last.setNext(null);
                }
                else{
                    temp.setNext(obj.getNext());
                }
            }
        }
    }

    public void showAll(){
        Shape p = start;
        while(p != null){
            p.draw();
            p = p.getNext();
        }
    }
}

public class GraphicEdit {
    public static void main(String[] args){
        System.out.println("그래픽 에디터 beauty을 실행합니다.");
        GraphicEditor g = new GraphicEditor();
        g.setMenu();
    }
}

package com.ohgiraffers.section01.delete;

import java.util.Scanner;

public class Application {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("삭제할 메뉴의 이름을 입력하세요 : ");
        String menuName = sc.nextLine();

        MenuDeleteService menuDeleteService = new MenuDeleteService();
        if(menuDeleteService.deleteMenu(menuName)) {
            System.out.println("메뉴 삭제에 성공하셨습니다!");
        } else{
            System.out.println("메뉴 삭제에 실패하셨습니다.");
        }
    }
}

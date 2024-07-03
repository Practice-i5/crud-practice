package com.ohgiraffers.section01.update;

import com.ohgiraffers.model.dto.MenuDTO;

import java.util.Scanner;

public class Application {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("수정할 메뉴 코드 값을 입력하세요: ");
        int menuCode = sc.nextInt();  // int로 받도록 수정
        sc.nextLine();  // 엔터 키 제거

        System.out.println("수정할 메뉴의 이름을 수정하세요: ");
        String menuName = sc.nextLine();
        System.out.println("메뉴의 가격을 수정하세요: ");
        int menuPrice = sc.nextInt();
        System.out.println("카테고리 코드를 수정하세요: ");
        int categoryCode = sc.nextInt();
        sc.nextLine();
        System.out.println("판매 상태를 수정하세요(Y/N): ");
        String orderableStatus = sc.nextLine();

        MenuDTO menu = new MenuDTO();
        menu.setMenuCode(menuCode);
        menu.setMenuName(menuName);
        menu.setMenuPrice(menuPrice);
        menu.setCategoryCode(categoryCode);
        menu.setOrderableStatus(orderableStatus);

        MenuUpdateService menuUpdateService = new MenuUpdateService();
        if(menuUpdateService.updateMenu(menu)){
            System.out.println("메뉴 수정에 성공하셨습니다!");
        }else{
            System.out.println("메뉴 수정에 실패하셨습니다.");
        }
    }
}

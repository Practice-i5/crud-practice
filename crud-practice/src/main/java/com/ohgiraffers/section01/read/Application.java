package com.ohgiraffers.section01.read;

import com.ohgiraffers.model.dto.MenuDTO;

import java.util.Scanner;

/*
 *   Application.java
 *   Author : syamcat
 *   Created : 24. 7. 3.
 **/
public class Application {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("검색할 메뉴의 이름을 입력하세요: ");
//        sc.nextLine();
        String menuName = sc.nextLine();
//        System.out.println("메뉴의 가격을 입력하세요: ");
//        int menuPrice = sc.nextInt();
//        System.out.println("카테고리 코드를 입력하세요:");
//        int categoryCode = sc.nextInt();
//        sc.nextLine();
//        System.out.println("판매상태를 입력하세요 (Y/N): ");
//        String orderableStatus = sc.nextLine();

        MenuDTO menu = new MenuDTO();
        menu.setMenuName(menuName);
//        menu.setMenuPrice(menuPrice);
//        menu.setCategoryCode(categoryCode);
//        menu.setOrderableStatus(orderableStatus);

        MenuSelService menuSelService = new MenuSelService();
        if (menuSelService.selectMenu(menu)) {
            System.out.println("메뉴 검색에 성공하셨습니다!");
        } else {
            System.out.println("메뉴 검색에 실패하셨습니다.");
        }
    }
}

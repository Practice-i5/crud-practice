package com.ohgiraffers.section01.read;

import com.ohgiraffers.model.dto.MenuDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.ohgiraffers.common.Template.close;

/*
 *   MenuDelDAO.java
 *   Author : syamcat
 *   Created : 24. 7. 3.
 **/
public class MenuSelDAO {

    public int readMenu(Connection con, MenuDTO menu) {

        PreparedStatement pstmt = null;
        ResultSet rset = null;
        List<MenuDTO> menuList = null;
        int result = 0;

        String query = "SELECT * FROM TBL_MENU WHERE MENU_NAME = ?";

        try {
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, menu.getMenuName());
//            pstmt.setInt(2, menu.getMenuPrice());
//            pstmt.setInt(3, menu.getCategoryCode());
//            pstmt.setString(4, menu.getOrderableStatus());
            rset = pstmt.executeQuery();

            menuList = new ArrayList<>();
            while (rset.next()) {
                MenuDTO menuDTO = new MenuDTO();
                menuDTO.setMenuCode(rset.getInt("MENU_CODE"));
                menuDTO.setMenuName(rset.getString("MENU_NAME"));
                menuDTO.setMenuPrice(rset.getInt("MENU_PRICE"));
                menuDTO.setCategoryCode(rset.getInt("CATEGORY_CODE"));
                menuDTO.setOrderableStatus(rset.getString("ORDERABLE_STATUS"));
                menuList.add(menuDTO);

            }
            if (menuList.size() > 0) {
                result = 1;
            }
            menuList.forEach(System.out::println);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(pstmt);
        }

        return result;
    }
}

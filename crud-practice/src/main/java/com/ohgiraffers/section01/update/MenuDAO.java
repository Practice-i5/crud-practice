package com.ohgiraffers.section01.update;

import com.ohgiraffers.model.dto.MenuDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static com.ohgiraffers.common.Template.close;

public class MenuDAO {

    public int updateMenu(Connection con, MenuDTO menu){

        PreparedStatement pstmt = null;
        int result = 0;

        String query = "UPDATE TBL_MENU SET MENU_NAME = ?, MENU_PRICE = ?, CATEGORY_CODE = ?, ORDERABLE_STATUS = ? WHERE MENU_CODE = ?";

        try {
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, menu.getMenuName());
            pstmt.setInt(2, menu.getMenuPrice());
            pstmt.setInt(3, menu.getCategoryCode());
            pstmt.setString(4, menu.getOrderableStatus());
            pstmt.setInt(5, menu.getMenuCode());  // WHERE 절에 사용할 menuCode 설정


            result = pstmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally{
            close(pstmt);
        }

        return result;
    }
}
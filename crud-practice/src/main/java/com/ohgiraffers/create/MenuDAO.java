package com.ohgiraffers.create;

import com.ohgiraffers.model.dto.MenuDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static com.ohgiraffers.common.Template.close;

// 데이터베이스에 요청하고 결과를 받는 메서드
public class MenuDAO {
    public int createMenu(Connection con, MenuDTO menu) {

        // 요청문 전송하는 객체생성
        PreparedStatement pstmt = null;
        int result = 0;

        // query 문 작성

        String query = "INSERT INTO TBL_MENU(MENU_NAME, MENU_PRICE, CATEGORY_CODE, ORDERABLE_STATUS) "
                + "VALUES(?,?,?,?)";

        try {
            pstmt = con.prepareStatement(query);

            pstmt.setString(1, menu.getMenuName());
            pstmt.setDouble(2, menu.getMenuPrice());
            pstmt.setInt(3, menu.getCategoryCode());
            pstmt.setString(4, menu.getOrderableStatus());

            result = pstmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            close(pstmt);
        }

        return result;
    }

}

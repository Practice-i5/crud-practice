package com.ohgiraffers.section01.delete;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static com.ohgiraffers.common.Template.close;

public class MenuDAO {

    // 마이바티스 스타일 (crud 기능임을 알아볼 수 있게)
    public int deleteMenuByName(Connection con, String menuName) {

        PreparedStatement pstmt = null;
        int result=0;

        String query = "DELETE FROM TBL_MENU WHERE MENU_NAME = ?";

        try {
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, menuName);
            
            result = pstmt.executeUpdate();
            
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(pstmt);
        }
        return result;
    }
}

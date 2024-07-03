package com.ohgiraffers.create;

import com.ohgiraffers.model.dto.MenuDTO;

import java.sql.Connection;

import static com.ohgiraffers.common.Template.*;

// 어떤 서비스를 이용하는 적는 메서드
public class MenuCreateService {
    public boolean createMenu(MenuDTO menu) {

        Connection con = getConnection();

        MenuDAO menuDAO = new MenuDAO();
        int result = menuDAO.createMenu(con, menu);


        if (result > 0) {
            commit(con);
        } else {
            rollback(con);
        }

        close(con);

        return result > 0;
    }
}

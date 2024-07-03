package com.ohgiraffers.section01.update;

import com.ohgiraffers.model.dto.MenuDTO;

import java.sql.Connection;

import static com.ohgiraffers.common.Template.*;

public class MenuUpdateService {

    public boolean updateMenu(MenuDTO menu) {

        Connection con = getConnection();

        MenuDAO menuDAO = new MenuDAO();
        int result = menuDAO.updateMenu(con, menu);

        if(result > 0){
            commit(con);
        }else{
            rollback(con);
        }
        close(con);

        return result > 0;

    }
}

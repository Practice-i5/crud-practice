package com.ohgiraffers.section01.read;

import com.ohgiraffers.model.dto.MenuDTO;

import java.sql.Connection;

import static com.ohgiraffers.common.Template.*;

/*
 *   MenuDelService.java
 *   Author : syamcat
 *   Created : 24. 7. 3.
 **/
public class MenuSelService {

    public boolean selectMenu(MenuDTO menu) {
        Connection con = getConnection();

        MenuSelDAO menuSelDAO = new MenuSelDAO();

        int result = menuSelDAO.readMenu(con, menu);

        if (result > 0) {
            commit(con);
        } else {
            rollback(con);
        }

        close(con);
        return result > 0;
    }
}

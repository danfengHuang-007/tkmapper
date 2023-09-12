package com.qfedu.tkmapperdemo.dao;

import com.qfedu.tkmapperdemo.beans.User;
import com.qfedu.tkmapperdemo.general.GeneralDAO;

public interface UserDAO   extends GeneralDAO<User> {
    public User selectByUsername(String username);
}

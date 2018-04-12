package com.dao.server;

import com.dao.Area;

public interface AreaDAO {
    int insert(Area record);

    int insertSelective(Area record);
}
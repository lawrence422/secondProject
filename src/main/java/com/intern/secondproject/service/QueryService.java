package com.intern.secondproject.service;

import com.intern.secondproject.dao.pojo.Atype;
import com.intern.secondproject.dao.pojo.Btype;
import com.intern.secondproject.dao.pojo.JsonResult;

@SuppressWarnings("rawtypes")
public interface QueryService {




    JsonResult delete(String table, String pk);

    JsonResult importData(String username, String password, String dbName,  String filePath);

    JsonResult exportData(String username, String password, String dbName, String tableName, String filePath);

    JsonResult query(String table, String keyWord);

    JsonResult deleteByClick(String keyWord);

    JsonResult updateA(Atype type);

    JsonResult updateB(Btype type);

    JsonResult insertA(Atype type);

    JsonResult insertB(Btype type);

    JsonResult calculateC(String keyWord);
}

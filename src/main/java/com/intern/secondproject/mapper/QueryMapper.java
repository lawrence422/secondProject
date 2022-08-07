package com.intern.secondproject.mapper;

import com.intern.secondproject.dao.pojo.Atype;
import com.intern.secondproject.dao.pojo.Btype;
import com.intern.secondproject.dao.pojo.Ctype;
import com.intern.secondproject.mapper.sql.QueryMapperSql;
import org.apache.ibatis.annotations.*;

@Mapper
public interface QueryMapper {
    @InsertProvider(type = QueryMapperSql.class,method = "insertBSql")
    int insertB(Btype type);

    @InsertProvider(type = QueryMapperSql.class,method = "insertASql")
    int insertA(Atype type);

    @UpdateProvider(type = QueryMapperSql.class,method = "updateBSql")
    int updateB(Btype type);

    @UpdateProvider(type = QueryMapperSql.class,method = "updateASql")
    int updateA(Atype type);

    @DeleteProvider(type = QueryMapperSql.class,method = "deleteByClickSql")
    int deleteByClick(String keyWord);

    @SelectProvider(type = QueryMapperSql.class,method = "queryASql")
    Atype queryA(String keyWord);

    @SelectProvider(type = QueryMapperSql.class,method = "queryBSql")
    Btype queryB(String keyWord);

    @SelectProvider(type = QueryMapperSql.class,method = "queryCSql")
    Ctype queryC(String keyWord);

    @SelectProvider(type = QueryMapperSql.class,method = "calculateCSql")
    int calculateC(String keyWord);

    @DeleteProvider(type = QueryMapperSql.class,method = "deleteBSql")
    int deleteB(String pk);

    @DeleteProvider(type = QueryMapperSql.class,method = "deleteASql")
    int deleteA(String pk);


}

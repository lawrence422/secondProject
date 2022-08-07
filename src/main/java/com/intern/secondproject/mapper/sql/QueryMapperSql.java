package com.intern.secondproject.mapper.sql;

import com.intern.secondproject.dao.pojo.Atype;
import com.intern.secondproject.dao.pojo.Btype;
import org.apache.ibatis.jdbc.AbstractSQL;
import org.apache.ibatis.jdbc.SQL;

public class QueryMapperSql {
    public String insertBSql(Btype type) {
        return new SQL() {{
            INSERT_INTO("B");
            VALUES("B_A,B_B,B_C,B_D,B_E,B_F,B_aa,B_bb,B_cc,B_dd,B_ee",
                    "#{B_A},#{B_B},#{B_C},#{B_D},#{B_E},#{B_F},#{B_aa},#{B_bb},#{B_cc},#{B_dd},#{B_ee}");
        }}.toString();
    }

    public String insertASql(Atype type) {
        return new SQL() {{
            INSERT_INTO("A");
            VALUES("A_A,A_B,A_C,A_D,A_E,A_F,A_aa,A_bb,A_cc,A_dd,A_ee",
                    "#{A_A},#{A_B},#{A_C},#{A_D},#{A_E},#{A_F},#{A_aa},#{A_bb},#{A_cc},#{A_dd},#{A_ee}");

        }}.toString();
    }

    public String updateBSql(Btype type) {
        return new SQL() {{
            UPDATE("B");
            SET("B_B=#{B_B},B_C=#{B_C},B_D=#{B_D},B_E=#{B_E},B_F=#{B_F},B_aa=#{B_aa},B_bb=#{B_bb},B_cc=#{B_cc},B_dd=#{B_dd},B_ee=#{B_ee}");
            WHERE("B_A=#{B_A}");
        }}.toString();
    }

    public String updateASql(Atype type) {
        return new SQL() {{
            UPDATE("A");
            SET("A_B=#{A_B},A_C=#{A_C},A_D=#{A_D},A_E=#{A_E},A_F=#{A_F},A_aa=#{A_aa},A_bb=#{A_bb},A_cc=#{A_cc},A_dd=#{A_dd},A_ee=#{A_ee}");
            WHERE("A_A=#{A_A}");
        }}.toString();
    }

    public String deleteByClickSql(String keyWord) {
        return new SQL() {{
            DELETE_FROM("B");
            WHERE("B_A IN (SELECT * FROM (SELECT DISTINCT B_C FROM B WHERE (B_C LIKE '%${keyWord}%')) AS TEMP)");
        }}.toString();
    }

    public String queryASql(String keyWord) {
        return new SQL() {{
            SELECT("*");
            FROM("A");
            WHERE("A_A LIKE '%${keyWord}%'");
        }}.toString();
    }

    public String queryBSql(String keyWord) {
        return new SQL() {{
            SELECT("*");
            FROM("B");
            WHERE("B_A LIKE '%${keyWord}%'");
        }}.toString();
    }

    public String queryCSql(String keyWord) {
        return new SQL() {{
            SELECT("*");
            FROM("C");
            WHERE("C_B LIKE '%${keyWord}%'");
        }}.toString();
    }

    public String calculateCSql() {
        return new SQL() {{
            SET("SQL_SAFE_UPDATES=0");
            SELECT("CALCULATE_C()");
        }}.toString();
    }

    public String deleteBSql(String pk) {
        return new SQL() {{
            DELETE_FROM("B");
            WHERE("B_A=#{pk}");
        }}.toString();
    }

    public String deleteASql(String pk) {
        return new SQL() {{
            DELETE_FROM("A");
            WHERE("A_A=#{pk}");
        }}.toString();
    }


}

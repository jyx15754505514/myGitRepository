package com.ccicnavi.bims;

import org.n3r.eql.Eql;

import java.sql.*;

/**
 * @Auther: CongZhiYuan
 * @Date: 2018/11/22 15:54
 * @Description: Eql格式文本生成器,只需输入表名即可自动生成eql
 */
public class EqlPrint {
    static String table = "";
    static String dbColumns = "";
    static String dbPrimaryKeys = "";
    static String[] dbcols=null,beans=null;
    static String[] dbpks=null,pks=null;
    public static void main(String[] args){
        initDB("sys_user_authdata");
        getEntifyCols();
        //-------下方为可选区域--------------
//        insertEqlPrint();
//        updateEqlPrint();
//        selectEqlPrint();
        deleteEqlPrint();
    }
    public static void initDB(String tableName){
        table = tableName;
        Connection conn = null;
        DatabaseMetaData dbmd = null;
        ResultSet columnrs = null;
        ResultSet pkrs = null;
        try {
            conn = new Eql().getConnection();
            dbmd = conn.getMetaData();
            columnrs = dbmd.getColumns(null, null, table, null);
            pkrs = dbmd.getPrimaryKeys(null, null, table);
            while(columnrs.next()){
                dbColumns+=columnrs.getString(4)+",";
            }
            while(pkrs.next()){
                dbPrimaryKeys+=pkrs.getString(4)+",";
            }
            dbColumns = dbColumns.substring(0, dbColumns.length()-1);
            if(dbPrimaryKeys.length()>1){
                dbPrimaryKeys = dbPrimaryKeys.substring(0, dbPrimaryKeys.length()-1);
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }finally {
            try {
                pkrs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                columnrs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public static void getEntifyCols(){
        dbcols = dbColumns.split(",");
        beans = new String[dbcols.length];
        String[] dbColsArr = dbColumns.split(",");
        for(int i=0;i<dbColsArr.length;i++){
            String dbcolumn = dbColsArr[i];
            String[] items = dbcolumn.split("_");
            if(items!=null&&items.length==1){//不包含下划线
                beans[i] = items[0];
            }else if(items!=null&&items.length>1){
                StringBuffer sb = new StringBuffer("");
                for(int k=0;k<items.length;k++){
                    if(k!=0){
                        sb.append(items[k].replaceFirst(items[k].substring(0,1), items[k].substring(0,1).toUpperCase()));
                    }else{
                        sb.append(items[k]);
                    }
                }
                beans[i] = sb.toString();
            }
        }
        if(dbPrimaryKeys.length()>0){
            dbpks = dbPrimaryKeys.split(",");
            pks = new String[dbpks.length];
            dbColsArr = dbPrimaryKeys.split(",");
            for(int i=0;i<dbColsArr.length;i++){
                String dbcolumn = dbColsArr[i];
                String[] items = dbcolumn.split("_");
                if(items!=null&&items.length==1){//不包含下划线
                    pks[i] = items[0];
                }else if(items!=null&&items.length>1){
                    StringBuffer sb = new StringBuffer("");
                    for(int k=0;k<items.length;k++){
                        if(k!=0){
                            sb.append(items[k].replaceFirst(items[k].substring(0,1), items[k].substring(0,1).toUpperCase()));
                        }else{
                            sb.append(items[k]);
                        }
                    }
                    pks[i] = sb.toString();
                }
            }
        }
    }
    public static void selectEqlPrint(){
        StringBuffer sql = new StringBuffer("SELECT").append("\n");
        for(int i=0;i<dbcols.length;i++){
            sql.append("\t"+dbcols[i]+" "+beans[i]+"");
            if(i!=dbcols.length-1){
                sql.append(",");
            }
            sql.append("\n");
        }

        sql.append("from ").append(table).append("\n");
        sql.append("where 1=1\n");
        System.out.println(sql.toString());
    }
    public static void insertEqlPrint(){
        StringBuffer sql = new StringBuffer("insert into ").append(table).append("\n");
        sql.append("-- trim prefix=( suffix=) suffixOverrides=,").append("\n");
        for(int i=0;i<dbcols.length;i++){
            sql.append("\t-- if "+beans[i]+" != null and "+beans[i]+" !=''").append("\n");
            sql.append("\t\t"+dbcols[i]+",\n");
            sql.append("\t-- end\n");
        }
        sql.append("-- end\n");
        sql.append("-- trim prefix=values( suffix=) suffixOverrides=,").append("\n");
        for(int i=0;i<dbcols.length;i++){
            sql.append("\t-- if "+beans[i]+" != null and "+beans[i]+" !=''").append("\n");
            sql.append("\t\t'#"+beans[i]+"#',\n");
            sql.append("\t-- end\n");
        }
        sql.append("-- end").append("\n");
        System.out.println(sql.toString());
    }

    public static void updateEqlPrint(){
        StringBuffer sql = new StringBuffer("update ").append(table).append("\n");
        sql.append("-- trim prefix=SET suffixOverrides=,").append("\n");
        for(int i=0;i<dbcols.length;i++){
            sql.append("\t-- if "+beans[i]+" != null and "+beans[i]+" !=''").append("\n");
            sql.append("\t\t"+dbcols[i]+" = '#"+beans[i]+"#',").append("\n");
            sql.append("\t-- end\n");
        }
        sql.append("-- end\n");
        sql.append("where 1=1");
        System.out.println(sql.toString());
    }

    public static void deleteEqlPrint(){
        StringBuffer sql = new StringBuffer("UPDATE ").append(table).append("\n");
        sql.append("SET is_deleted = 'Y' \n");
        sql.append("where 1=1\n");
        for(int i=0;i<pks.length;i++){
            sql.append("\t-- if "+pks[i]+" != null and "+pks[i]+" !=''").append("\n");
            sql.append("\t\tand "+dbpks[i]+" = '#"+pks[i]+"#'").append("\n");
            sql.append("\t-- end\n");
        }
        System.out.println(sql.toString());
    }
}

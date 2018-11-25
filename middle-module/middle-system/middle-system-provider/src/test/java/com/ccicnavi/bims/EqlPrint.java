package com.ccicnavi.bims;

import org.n3r.eql.Eql;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: CongZhiYuan
 * @Date: 2018/11/22 15:54
 * @Description: Eql格式文本生成器
 */
public class EqlPrint {
    static String table = "";
    static String dbColumns = "";
    static String[] dbcols=null,beans=null;
    public static void main(String[] args){
        initDB("sys_serialnum");
        getEntifyCols();
        insertEqlPrint();
//        updateEqlPrint();
//        selectEqlPrint();
    }
    public static void initDB(String tableName){
        table = tableName;
        Connection conn = null;
        DatabaseMetaData dbmd = null;
        ResultSet columnrs = null;
        try {
            conn = new Eql().getConnection();
            dbmd = conn.getMetaData();
            columnrs = dbmd.getColumns(null, null, table, null);
            while(columnrs.next()){
                dbColumns+=columnrs.getString(4)+",";
            }
            dbColumns = dbColumns.substring(0, dbColumns.length()-1);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }finally {
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
//                System.out.println("数据库字段为："+dbcols[i]+",处理后实体字段为："+sb.toString());
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
}

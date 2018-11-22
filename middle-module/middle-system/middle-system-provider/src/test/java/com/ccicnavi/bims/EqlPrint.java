package com.ccicnavi.bims;

/**
 * @Auther: CongZhiYuan
 * @Date: 2018/11/22 15:54
 * @Description: Eql格式文本生成器
 */
public class EqlPrint {
    static String table = "t_user_info";
    static String dbColumns = "user_id,user_name,password,branch_no,tel,address,email";
    static String beansAttrs = "userId,userName,password,branchNo,tel,address,email";
    public static void main(String[] args){
//        insertEqlPrint();
//        updateEqlPrint();
        selectEqlPrint();
    }
    public static void selectEqlPrint(){
        String[] dbcols = dbColumns.split(",");
        String[] beans = beansAttrs.split(",");
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
        String[] dbcols = dbColumns.split(",");
        String[] beans = beansAttrs.split(",");
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
        String[] dbcols = dbColumns.split(",");
        String[] beans = beansAttrs.split(",");
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

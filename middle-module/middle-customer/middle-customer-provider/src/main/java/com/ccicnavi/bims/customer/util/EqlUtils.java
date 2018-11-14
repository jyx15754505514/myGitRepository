package com.ccicnavi.bims.customer.util;

import org.n3r.eql.Eql;

/**
 * @Auther: husky
 * @Date: 2018/11/13 22:36
 * @Version 0.1
 * @Description:
 */
public class EqlUtils {
    private static Eql eql = null;

    private EqlUtils() {

    }

    public static Eql getInstance(String connectionName) {
        if (null == eql) {
            eql = new Eql(connectionName);
            return eql;
        }
        return eql;
    }


    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++) {
             String listRole = getInstance("druid").limit(1).execute("select 'X' from dual");
        }
    }
}

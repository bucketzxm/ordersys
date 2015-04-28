package com.sh.weiyue.ordersys.web.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.aspectj.lang.reflect.FieldSignature;

public class Dao {
    private static String user = "root";
    private static String password = "123456";
    private static String url = "jdbc:mysql://localhost:8388/order_sys";
    private static String driver = "com.mysql.jdbc.Driver";
    private static Connection con = null;
    private static Statement stmt = null;
    private static ResultSet rs=null;
    private static String sqlString=null;


    private Dao(){

    }

    public static void init(){
            if(con==null){
                try {
                    Class.forName(driver);
                    con = DriverManager.getConnection(url, user,
                            password);
                    stmt = con.createStatement();
                } catch (Exception ee) {
                    ee.printStackTrace();
                }
            }
    }

    // 登录点击后，将客人的花费写入
    public static void setOrderPay(String tableNo,String total){
        if(null==con){
            init();
        }
        sqlString="update "+FieldsName.ORDER_TABLE+" set "+
                FieldsName.ORDER_Pay+"="+total+" where "+
                FieldsName.ORDER_Desk+"="+tableNo+" and "+
                FieldsName.ORDER_State+"=0";
        try {
            stmt.executeUpdate(sqlString);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

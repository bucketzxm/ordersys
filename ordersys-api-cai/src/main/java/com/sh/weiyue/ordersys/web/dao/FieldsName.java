package com.sh.weiyue.ordersys.web.dao;


import org.json.JSONObject;

import com.sh.weiyue.ordersys.web.controller.AliPayController;

public class FieldsName {

    // public data
    public static final String PreFix="D:/DishOrder/ordersys/src/main/webapp/";
    
    //private data
    private static final String orderUrl ="http://218.244.136.120:8080/alfred-mobile-api/order/addOrder";
    
    
    // category 名字
    public static final String[] Categories={"新品","扒类","比萨","咖啡",
        "沙拉","汤类","甜品","小吃","意饭","意面","饮料"
    };
    
    
    public static void getCategories(){
    	
    	JSONObject jo = new JSONObject();
    	jo.put("restaurantId", "19");
    	String str = AliPayController.strPost(orderUrl , jo.toString());
    	
    	System.out.println(str);
    
    }


    // food
    public static final String FOOD_TABLE="order_sys.food";
    public static final String FOOD_name = "food_name";
    public static final String FOOD_price = "food_price";
    public static final String FOOD_id = "food_id";
    public static final String FOOD_picture = "food_picture";
    public static final String FOOD_description = "food_description";


    //menuitem
    public static final String MENUITEM_TABLE="order_sys.menuitem";
    public static final String MENUITEM_Id="menuitem_id";
    public static final String MENUITEM_Bigsale="menuitem_bigsale";
    public static final String MENUITEM_Status="menuitem_status";
    public static final String MENUITEM_Food="menuitem_food";
    public static final String MENUITEM_Category="menuitem_category";


    //category
    public static final String CATEGORY_TABLE="order_sys.category";
    public static final String CATEGORY_Id="category_id";
    public static final String CATEGORY_Name="category_name";

    // special
    public static final String SPECIAL_TABLE="order_sys.special";
    public static final String SPECIAL_Id="special_id";
    public static final String SPECIAL_Price="special_price";
    public static final String SPECIAL_Remain="special_remain";
    public static final String SPECIAL_Quota="special_quota";
    public static final String SPECIAL_Food="special_food";


    // order
    public static final String ORDER_TABLE="order_sys.order";
    public static final String ORDER_Id="order_id";
    public static final String OUT_TRADE_NUM = "out_trade_no";
    public static final String ORDER_Generatedate="order_generatedate";
    public static final String ORDER_State="order_state";
    public static final String ORDER_Desk="order_deskId";
    public static final String ORDER_Pay="order_pay";
    public static final String ORDER_Mermoney="order_mermoney";
    public static final String ORDER_Commoney="order_commoney";
    public static final String ORDER_Finishdate="order_finishdate";


    // agent
    public static final String AGENT_Id="agent_id";
    public static final String AGENT_Money="agent_money";
    public static final String AGENT_Order="agent_order";
    public static final String AGENT_MoneyCopy="agent_moneyCopy";
    public static final String AGENT_TABLE="order_sys.agent";



}

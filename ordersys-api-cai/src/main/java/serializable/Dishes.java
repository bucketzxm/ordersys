package serializable;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Dishes implements Serializable{

    /**
     *
     */
    private static final long serialVersionUID = 8888L;

    private List<Dish> dishes=new ArrayList<Dish>();
    private String total;
	private String orderId;

    public List<Dish> getDishes(){
        return dishes;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

	public void setOrderId(String orderId) {
        this.orderId=orderId;
    }

    public String getOrderId(String orderId) {
        return orderId;
    }

}



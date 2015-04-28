package serializable;

import java.io.Serializable;

public class Dish implements Serializable{
    /**
     *
     */
    private static final long serialVersionUID = 888L;

    private String name;
    private String amount;
    private String price;
    private String total;


    public Dish(String name,String amount,String price,String total) {
        this.name=name;
        this.amount=amount;
        this.price=price;
        this.total=total;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }
}

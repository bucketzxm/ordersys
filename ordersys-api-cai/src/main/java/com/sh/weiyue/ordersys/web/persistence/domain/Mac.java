package com.sh.weiyue.ordersys.web.persistence.domain;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;

import javax.persistence.*;

import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Entity
@NamedQuery(name="Mac.findAll", query="SELECT m FROM Mac m")
public class Mac implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="mac_id")
	private Integer macId;

	@Column(name="mac_address")
	private String macAddress;
	
	@Column(name="mac_time")
	private String macTime;
	
//	@Column(name="mac_order")
//	private int macOrderId;

	@OneToOne
	@JoinColumn(name="mac_order")
	private Order order;
	
	public Mac() {
	}
	public Mac(String macAddress, Order order) {
		this.macAddress = macAddress;
		this.order = order ;
		this.macTime = new Date().toLocaleString();
	}

	public Integer getMacId() {
		return macId;
	}
	
	public String getMacAddress() {
		return macAddress;
	}

	public void setMacAddress(String macAddress) {
		this.macAddress = macAddress;
	}

	public String getMacTime() {
		return macTime;
	}

	public void setMacTime(String macTime) {
		this.macTime = macTime;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}
	
	@Override
	public String toString() {
		return "Mac[macId=" + macId + ", macAddress=" + macAddress
				+ ",macTime=" + macTime + ", order=" + order.getOrderId() + "]";
	}
	
	 static public String GetMacAddress(String strIp)throws IOException
	   {
		   String command = "arp -a "+strIp;
	       Process p = Runtime.getRuntime().exec(command);
	       BufferedReader inn = new BufferedReader(new InputStreamReader(p.getInputStream()));
	       Pattern pattern = Pattern.compile(".*([0-9A-Fa-f][0-9A-Fa-f]-[0-9A-Fa-f][0-9A-Fa-f]-[0-9A-Fa-f][0-9A-Fa-f]-[0-9A-Fa-f][0-9A-Fa-f]-[0-9A-Fa-f][0-9A-Fa-f]-[0-9A-Fa-f][0-9A-Fa-f]).*");
	        while (true) {
	            String line = inn.readLine();
	 
			    if (line == null)
			        break;

			    Matcher mm = pattern.matcher(line);
			    if (mm.matches()) {
			        return mm.group(1);
			    }
		   }
	       return null;
	   }
}

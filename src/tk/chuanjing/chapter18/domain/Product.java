package tk.chuanjing.chapter18.domain;

import java.util.Date;

/**
 * 商品的实体对象
 * @author admin
 *create table `product` (
	`pid` varchar (96),
	`pname` varchar (150),
	`market_price` double ,
	`shop_price` double ,
	`pimage` varchar (600),
	`pdate` date ,
	`is_hot` double ,
	`pdesc` varchar (765),
	`pflag` double ,
	`cid` varchar (96)
); 
 */
public class Product {
	private String pid;
	private String pname;
	private Double market_price;
	private Double shop_price;
	private String pimage;
	private Date pdate;
	private Double is_hot;
	private String pdesc;
	private Double pflag;
	private String cid;
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public Double getMarket_price() {
		return market_price;
	}
	public void setMarket_price(Double market_price) {
		this.market_price = market_price;
	}
	public Double getShop_price() {
		return shop_price;
	}
	public void setShop_price(Double shop_price) {
		this.shop_price = shop_price;
	}
	public String getPimage() {
		return pimage;
	}
	public void setPimage(String pimage) {
		this.pimage = pimage;
	}
	public Date getPdate() {
		return pdate;
	}
	public void setPdate(Date pdate) {
		this.pdate = pdate;
	}
	public Double getIs_hot() {
		return is_hot;
	}
	public void setIs_hot(Double is_hot) {
		this.is_hot = is_hot;
	}
	public String getPdesc() {
		return pdesc;
	}
	public void setPdesc(String pdesc) {
		this.pdesc = pdesc;
	}
	public Double getPflag() {
		return pflag;
	}
	public void setPflag(Double pflag) {
		this.pflag = pflag;
	}
	public String getCid() {
		return cid;
	}
	public void setCid(String cid) {
		this.cid = cid;
	}
	
}

/**
*
*
* author : ME
*/

package tw.com.example.imsoft.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
//import org.springframework.data.annotation.Id;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="SHOPCAR")
public class PlayEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String orderNo;
	
	@Column(name="ORDER_TIME")
	private String orderTime;
	
	@Column(name="ORDER_TOTAL_AMT")
	private String orderTotalAmt;
	
	@Column(name="ORDER_STATUS")
	private String orderStatus;
	
	@Column(name="ORDER_USER")
	private String orderUser;
	
	@Column(name="REMARK")
	private String remark;
	
	@Column(name="IS_DEL")
	private String isDel;

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public String getOrderTime() {
		return orderTime;
	}

	public void setOrderTime(String orderTime) {
		this.orderTime = orderTime;
	}

	public String getOrderTotalAmt() {
		return orderTotalAmt;
	}

	public void setOrderTotalAmt(String orderTotalAmt) {
		this.orderTotalAmt = orderTotalAmt;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public String getOrderUser() {
		return orderUser;
	}

	public void setOrderUser(String orderUser) {
		this.orderUser = orderUser;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getIsDel() {
		return isDel;
	}

	public void setIsDel(String isDel) {
		this.isDel = isDel;
	}
}

package DBDataToObject;

import java.io.Serializable;
import java.util.Date;

/**
 * The persistent class for the ORGANIZATION database table.
 * 
 * @author lijh
 */
public class Organization implements Serializable {

	private long id;

	private String code;

	private String name;
	
	private String contactperson;

	private String contactphone;

	private long createby;

	private Date createtime;

	private String describe;


	private String serversaddress;

	private String ticketserversaddress;

	private String type;

	private long updateby;

	private Date updatetime;

	private String opertype;

	private String address;

	private boolean islocal;

	private boolean isactive;

	private String synccode;

	private Integer connectcosttime;

	private boolean isonline;

	public Organization() {
	}

	public void setSynccode(String synccode) {
		this.synccode = synccode;
	}

	public String getSynccode() {
		return synccode;
	}

	public String getOpertype() {
		return opertype;
	}

	public void setOpertype(String opertype) {
		this.opertype = opertype;
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getContactperson() {
		return this.contactperson;
	}

	public void setContactperson(String contactperson) {
		this.contactperson = contactperson;
	}

	public String getContactphone() {
		return contactphone;
	}

	public void setContactphone(String contactphone) {
		this.contactphone = contactphone;
	}

	public long getCreateby() {
		return this.createby;
	}

	public void setCreateby(long createby) {
		this.createby = createby;
	}

	public Date getCreatetime() {
		return this.createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public String getDescribe() {
		return this.describe;
	}

	public void setDescribe(String describe) {
		this.describe = describe;
	}

	public String getName() {
		return this.name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public long getUpdateby() {
		return updateby;
	}

	public void setUpdateby(long updateby) {
		this.updateby = updateby;
	}

	public Date getUpdatetime() {
		return updatetime;
	}

	public void setUpdatetime(Date updatetime) {
		this.updatetime = updatetime;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public boolean isIslocal() {
		return islocal;
	}

	public void setIslocal(boolean islocal) {
		this.islocal = islocal;
	}

	public boolean isIsactive() {
		return isactive;
	}

	public void setIsactive(boolean isactive) {
		this.isactive = isactive;
	}

	public Integer getConnectcosttime() {
		return connectcosttime;
	}

	public void setConnectcosttime(Integer connectcosttime) {
		this.connectcosttime = connectcosttime;
	}

	public boolean isIsonline() {
		return isonline;
	}

	public void setIsonline(boolean isonline) {
		this.isonline = isonline;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getServersaddress() {
		return this.serversaddress;
	}

	public void setServersaddress(String serversaddress) {
		this.serversaddress = serversaddress;
	}

	public String getTicketserversaddress() {
		return this.ticketserversaddress;
	}

	public void setTicketserversaddress(String ticketserversaddress) {
		this.ticketserversaddress = ticketserversaddress;
	}

}
package Eportal.servlet;

public class FileUploadInfoCarrier {
	
	int UID;
	String Cname;
	String Fpath;
	int Cid;
	String desc;
	String imgurl;
	String status;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getImgurl() {
		return imgurl;
	}

	public void setImgurl(String imgurl) {
		this.imgurl = imgurl;
	}

	public int getCid() {
		return Cid;
	}

	public void setCid(int cid) {
		Cid = cid;
	}

	public String getFpath() {
		return Fpath;
	}

	public void setFpath(String fpath) {
		Fpath = fpath;
	}

	public FileUploadInfoCarrier()
	{
		
	}
	
	public int getUID() {
		return UID;
	}
	public void setUID(int uID) {
		UID = uID;
	}
	public String getCname() {
		return Cname;
	}
	public void setCname(String cname) {
		Cname = cname;
	}
	
	

}

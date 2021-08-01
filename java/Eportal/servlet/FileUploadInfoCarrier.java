package Eportal.servlet;

public class FileUploadInfoCarrier {
	
	int UID;
	String Cname;
	String Fpath;
	int Cid;
	
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

	FileUploadInfoCarrier()
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

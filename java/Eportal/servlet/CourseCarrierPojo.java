package Eportal.servlet;

import java.util.LinkedList;

public class CourseCarrierPojo
{
	LinkedList <String> cname = new LinkedList <String> ();
	LinkedList <String> desc = new LinkedList <String> ();
	LinkedList <String> img = new LinkedList <String> ();
	LinkedList <String> jspfile = new LinkedList <String> ();
	
	public CourseCarrierPojo()
	{
		
	}
	
	
	
	public LinkedList<String> getJspfile() {
		return jspfile;
	}



	public void setJspfile(LinkedList<String> jspfile) {
		this.jspfile = jspfile;
	}



	public LinkedList<String> getCname() {
		return cname;
	}
	public void setCname(LinkedList<String> cname) {
		this.cname = cname;
	}
	public LinkedList<String> getDesc() {
		return desc;
	}
	public void setDesc(LinkedList<String> desc) {
		this.desc = desc;
	}
	public LinkedList<String> getImg() {
		return img;
	}
	public void setImg(LinkedList<String> img) {
		this.img = img;
	}
}

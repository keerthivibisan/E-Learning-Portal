package Eportal.servlet;

import java.util.LinkedList;

public class CoursePagePojo
{
	LinkedList <Integer> id = new LinkedList <Integer>();
	LinkedList <String> img = new LinkedList <String>();
	LinkedList <String> Cname = new LinkedList <String>();
	LinkedList <String> desc = new LinkedList <String>();
	LinkedList <String> jsp = new LinkedList <String>();
	LinkedList <String> status = new LinkedList <String>();
	
	public LinkedList<String> getStatus() {
		return status;
	}

	public void setStatus(LinkedList<String> status) {
		this.status = status;
	}

	public CoursePagePojo()
	{
		
	}
	
	public LinkedList<Integer> getId() {
		return id;
	}
	
	public void setId(LinkedList<Integer> id) {
		this.id = id;
	}
	
	public LinkedList<String> getImg() {
		return img;
	}
	
	public void setImg(LinkedList<String> img) {
		this.img = img;
	}
	
	public LinkedList<String> getCname() {
		return Cname;
	}
	
	public void setCname(LinkedList<String> cname) {
		Cname = cname;
	}
	
	public LinkedList<String> getDesc() {
		return desc;
	}
	
	public void setDesc(LinkedList<String> desc) {
		this.desc = desc;
	}
	
	public LinkedList<String> getJsp() {
		return jsp;
	}
	
	public void setJsp(LinkedList<String> jsp) {
		this.jsp = jsp;
	}
}

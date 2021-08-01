package Eportal.servlet;

import java.util.LinkedList;

public class TmyUploadsCarrier {
	
	LinkedList <Integer> CId = new LinkedList <Integer> ();
	LinkedList <String> Cname = new LinkedList <String> ();
	LinkedList <String> Cpath = new LinkedList <String> ();
	
	LinkedList <Integer> SId = new LinkedList <Integer> ();
	LinkedList <String> Sname = new LinkedList <String> ();
	LinkedList <String> Semail = new LinkedList <String> ();
	LinkedList <String> Scontact = new LinkedList <String> ();
	
	public LinkedList<Integer> getSId() {
		return SId;
	}

	public void setSId(LinkedList<Integer> sId) {
		SId = sId;
	}

	public LinkedList<String> getSname() {
		return Sname;
	}

	public void setSname(LinkedList<String> sname) {
		Sname = sname;
	}

	public LinkedList<String> getSemail() {
		return Semail;
	}

	public void setSemail(LinkedList<String> semail) {
		Semail = semail;
	}

	public LinkedList<String> getScontact() {
		return Scontact;
	}

	public void setScontact(LinkedList<String> scontact) {
		Scontact = scontact;
	}

	public TmyUploadsCarrier()
	{
		
	}
	
	public LinkedList<Integer> getCId() {
		return CId;
	}
	public void setCId(LinkedList<Integer> cId) {
		CId = cId;
	}
	public LinkedList<String> getCname() {
		return Cname;
	}
	public void setCname(LinkedList<String> cname) {
		Cname = cname;
	}
	public LinkedList<String> getCpath() {
		return Cpath;
	}
	public void setCpath(LinkedList<String> cpath) {
		Cpath = cpath;
	}
	
	

}

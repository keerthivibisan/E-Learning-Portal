package com.admin;

import java.util.LinkedList;

public class AllStudentInfoCarrier {

	LinkedList <String> name = new LinkedList <String> ();
	LinkedList <Integer> Sno = new LinkedList <Integer> ();
	LinkedList <String> Contact = new LinkedList <String> ();
	LinkedList <String> Email = new LinkedList <String> ();
	LinkedList <String> date = new LinkedList <String> ();
	
	LinkedList <String> filepath = new LinkedList <String> ();
	LinkedList <String> status = new LinkedList <String> ();
	LinkedList <Integer> CourseId = new LinkedList <Integer> ();
	LinkedList <String> jsp = new LinkedList <String> ();
	
	LinkedList <String> img = new LinkedList <String> ();
	LinkedList <String> desc = new LinkedList <String> ();
	
	public LinkedList<String> getImg() {
		return img;
	}

	public void setImg(LinkedList<String> img) {
		this.img = img;
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

	LinkedList <Integer> extraId = new LinkedList <Integer> (); 
	LinkedList <String> extraStr = new LinkedList <String> ();
	
	public LinkedList<String> getExtraStr() {
		return extraStr;
	}

	public void setExtraStr(LinkedList<String> extraStr) {
		this.extraStr = extraStr;
	}

	public LinkedList<Integer> getExtraId() {
		return extraId;
	}

	public void setExtraId(LinkedList<Integer> extraId) {
		this.extraId = extraId;
	}

	public LinkedList<String> getFilepath() {
		return filepath;
	}

	public void setFilepath(LinkedList<String> filepath) {
		this.filepath = filepath;
	}

	public LinkedList<String> getStatus() {
		return status;
	}

	public void setStatus(LinkedList<String> status) {
		this.status = status;
	}

	public LinkedList<Integer> getCourseId() {
		return CourseId;
	}

	public void setCourseId(LinkedList<Integer> courseId) {
		CourseId = courseId;
	}

	public LinkedList<String> getDate() {
		return date;
	}

	public void setDate(LinkedList<String> date) {
		this.date = date;
	}

	public AllStudentInfoCarrier()
	{
		
	}

	public LinkedList<String> getName() {
		return name;
	}

	public void setName(LinkedList<String> name) {
		this.name = name;
	}

	public LinkedList<Integer> getSno() {
		return Sno;
	}

	public void setSno(LinkedList<Integer> sno) {
		Sno = sno;
	}

	public LinkedList<String> getContact() {
		return Contact;
	}

	public void setContact(LinkedList<String> contact) {
		Contact = contact;
	}

	public LinkedList<String> getEmail() {
		return Email;
	}

	public void setEmail(LinkedList<String> email) {
		Email = email;
	}

	
	
}

package model;

public class Flight {
	private String hour;
	private String airline;
	private String id;
	private String destination;
	private char terminal;
	private int gate;
	private String remark;
	private Flight prev;
	private Flight next;
	
	public Flight(String h, String a, String i, String d, char t, int g, String r) {
		hour = h;
		airline = a;
		id = i;
		destination = d;
		terminal = t;
		gate = g;
		remark = r;
	}
	public String toString() { 
		return hour+" "+airline+" "+id+" "+destination+" "+terminal+" "+gate+" "+remark;
	}
	public Flight getNext() {
		return next;
	}
	public void setNext(Flight next) {
		this.next = next;
	}
	public Flight getPrev() {
		return prev;
	}
	public void setPrev(Flight prev) {
		this.prev = prev;
	}
	public String getId() {
		return id;
	}
}

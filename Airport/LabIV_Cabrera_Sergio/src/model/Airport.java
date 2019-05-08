package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Airport {
	public final static String PATH_CITIES="data/cities.txt";
	public final static String PATH_AIRLINES="data/airlines.txt";
	
	private Flight first;
	private List<String> cities;
	private List<String> airlines;
	
	private Random r = new Random();
	
	public void addFlight(String h, String a,String i, String d, char t, int g, String r) {
		Flight newFlight = new Flight(h, a, i, d, t, g, r);
		if(first==null) {
			first= newFlight;
			first.setNext(first);
			first.setPrev(first);
		}else {
			first.getPrev().setNext(newFlight);
			first.getPrev().getNext().setPrev(first.getPrev());
			first.getPrev().getNext().setNext(first);
			first.setPrev(newFlight);
		}
	}
	public Airport() {
		cities = new ArrayList<String>();
		airlines = new ArrayList<String>();
		load(PATH_AIRLINES);
		load(PATH_CITIES);
	}
	public void load(String path) {
		try{
			BufferedReader br = new BufferedReader(new FileReader(path));
			String line= br.readLine();
			
			while (line!= null ){
				if(path.equals(PATH_AIRLINES)) {
					airlines.add(line);
				}else if(path.equals(PATH_CITIES)) {
					cities.add(line);
				}
				line = br.readLine();
			}
			br.close();
		}catch (Exception e){
			//String r= "Error reading the file";
		}
	}
	public String randomHour() {
		int h = r.nextInt(12);
		h++;
		int m = r.nextInt(60);
		String hour = h<10?"0"+h:""+h;
		String minute=m<10?"0"+m:""+m;
		String s = r.nextBoolean()?"AM":"PM";
		String msg = String.format("%s:%s %s", hour, minute, s);
		return msg;
	}
	public String randomAirline() {
		return airlines.get(r.nextInt(airlines.size()));
	}
	public String randomId() {
		int n=0;
		if(first!=null) {
			n = Integer.parseInt(first.getPrev().getId());
		}
			return  ""+(1+n);
	}
	public String randomCities() {
		return cities.get(r.nextInt(airlines.size()));
	}
	public char randomTerminal() {
		return (char) (65+r.nextInt(90-64));
	}
	public int randomGate() {
		return r.nextInt(100);
	}
	public String randomRemark() {
		String remarks[] = {"CANCELLED", "ON TIME", "BOARDING", "DELAYED"};
		return remarks[r.nextInt(remarks.length)];
	}
	public void createSimulation(int numberOfFlights) {
		if(numberOfFlights>0) {
			addFlight(randomHour(), randomAirline(), randomId(), randomCities(), randomTerminal(), randomGate(), randomRemark());
			createSimulation(numberOfFlights--);
		}
	}
	public void orderByAirline() {
		
	}
	public void orderByDestination() {
		// TODO Auto-generated method stub
		
	}
	public void orderByFlight() {
		// TODO Auto-generated method stub
		
	}
	public void orderByGate() {
		// TODO Auto-generated method stub
		
	}
	public void orderByHour() {
		// TODO Auto-generated method stub
		
	}
	public void orderByRemark() {
		// TODO Auto-generated method stub
		
	}
	public void orderByTerminal() {
		// TODO Auto-generated method stub
		
	}
}
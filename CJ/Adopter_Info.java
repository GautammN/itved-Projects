package pro_06_19_project;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Adopter_Info implements IDetails {
	private int id;
	private String name;
	private int orphan_id;
	private String date_of_adoption;

	public Adopter_Info() {}
	
	public Adopter_Info(int id, String name, int orphan_id, String date_of_adoption) {
		super();
		this.id = id;
		this.name = name;
		this.orphan_id = orphan_id;
		this.date_of_adoption = date_of_adoption;
	}

	@Override
	public void getDetails() {
		System.out.println("Id: " + id);
		System.out.println("Name: " + name);
		System.out.println("Orphan Id: " + orphan_id);
		System.out.println("Date of adoption: " + date_of_adoption);		
	}

	@Override
	public void getDetails(int id, int orphan_id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setDetails() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setDetails(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setDetails(int id, int orphan_id) {
		Scanner sc = new Scanner(System.in);
		this.id = id;
		this.orphan_id = orphan_id;
		
		System.out.println("Enter name: ");
		name = sc.nextLine();
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();
	  	date_of_adoption = dtf.format(now);		
	}

	@Override
	public void setDetails(int id, String name, int adopterId) {
		// TODO Auto-generated method stub
		
	}
}
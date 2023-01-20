package pro_06_19_project;

import java.util.Scanner;

public class Adopter_Background_Info extends Adopter_Info implements IDetails{
	private String gender;
	private String maritalStatus;
	private int income;
	
	public Adopter_Background_Info() {}
	
	public Adopter_Background_Info(int id, String name, int orphan_id, String date_of_adoption, String maritalStatus, String gender, int income) {
		super(id, name, orphan_id, date_of_adoption);
		this.gender = gender;
		this.maritalStatus = maritalStatus;
		this.income = income;
	}

	@Override
	public void getDetails() {
		super.getDetails();
		System.out.println("Gender: " + gender);
		System.out.println("Marital Status: " + maritalStatus);
		System.out.println("Annual Income: " + income);
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
		super.setDetails(id, orphan_id);
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Gender (Male/Female/Other): ");
		gender = sc.next();
		System.out.println("Enter Marital Status (Single/Married): ");
		maritalStatus = sc.next();
		System.out.println("Enter Annual Income: ");
		income = sc.nextInt();
	}

	@Override
	public void setDetails(int id, String name, int adopterId) {
		// TODO Auto-generated method stub
		
	}
}
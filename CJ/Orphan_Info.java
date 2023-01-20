package pro_06_19_project;

import java.util.Scanner;

public class Orphan_Info  implements IDetails{
	private int id;
	private String name;
	private int adopterId;
	
	Orphan_Info(){}
	
	Orphan_Info(int id, String name, int adopterId)
	{
		this.id = id;
		this.name = name;
		this.adopterId = adopterId;
	}
	
	int getId()
	{
		return id;
	}

	void setAdopted(int adopterId)
	{
		this.adopterId = adopterId;
	}

	boolean checkIfOrphanAdopted()
	{
		return adopterId != 0 ? true : false ;
	}

	@Override
	public void getDetails() {
		System.out.println("Id: " + id);
		System.out.println("Name: " + name);
		System.out.println("Adopter Id: " + adopterId);
		System.out.println();		
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
		Scanner sc = new Scanner(System.in);
		this.id = id;
		this.adopterId = 0;
		System.out.println("Enter name: ");
		name = sc.nextLine();
		
		Orphanage.dbRepository.setOrphanInfo(this.id, name, this.adopterId);
	}

	@Override
	public void setDetails(int id, int orphan_id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setDetails(int id, String name, int adopterId) {
		this.id = id;
		this.name = name;
		this.adopterId = adopterId;
	}
}
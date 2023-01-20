package pro_06_19_project;

import java.util.ArrayList;
import java.util.Scanner;

public class Orphanage {
	ArrayList<LoginModel> login_array = new ArrayList<LoginModel>();
	ArrayList<Orphan_Info> orphan_array = new ArrayList<Orphan_Info>();
	ArrayList<Adopter_Background_Info> adopter_array = new ArrayList<Adopter_Background_Info>();
	public static Db_Repository dbRepository = new Db_Repository();
	
	static String userType = "";

	void SetInitialOrphanData()
	{
		orphan_array.addAll(dbRepository.getOrphanInfo());
	}
	
	void SetInitialAdopterData()
	{
		adopter_array.addAll(dbRepository.getAdopterInfo());
	}
	
	boolean checkIfOrphanIdExists(int id)
	{
		return id <= orphan_array.size();
	}

	void SetUserLoginData()
	{
		login_array.addAll(dbRepository.getLoginInfo());
	}
	
	void PrintOptionsForUsers()
	{
		System.out.println("\n*************************************************************************");
		System.out.println("1. Adopter Registration");
		System.out.println("2. Orphan Details");
		System.out.println("3. Logout");
		System.out.println("Enter choice...");
	}
	
	void PrintOptionsForAdmin()
	{
		System.out.println("\n*************************************************************************");
		System.out.println("1. Orphan Registration");
		System.out.println("2. Adopter Registration");
		System.out.println("3. Orphan Details");
		System.out.println("4. Adopter Details");
		System.out.println("5. Logout");
		System.out.println("Enter choice...");		
	}
	
	void LoginUsernameValidation(Scanner sc, int choice)
	{
		boolean exit = false;
		
		do
		{
			userType = "";
			
			System.out.println("\n*************************Orphanage Portal*********************************");
			System.out.println("1. User Login");
			System.out.println("2. Admin Login");
			System.out.println("3. Exit");
			System.out.println("\n*************************************************************************");
			choice = sc.nextInt();
			if(choice == 1)
			{
				userType = "user";
				exit = true;
			}
			else if(choice == 2)
			{
				userType = "admin";
				exit = true;
			}
			else if(choice == 3)
			{
				userType = "";
				return;
			}
			else
			{
				System.out.println("Invalid choice! Try again.");
				continue;
			}
		}
		while(!exit);
		
		exit = false;
		do 
		{
			System.out.println("Enter Username: ");
			String username = sc.next();
			
			for (int i = 0; i < this.login_array.size(); i++) {
				if(this.login_array.get(i).username.equals(username))
				{
					if(this.login_array.get(i).userType.equals(userType))
					{
						LoginPasswordValidation(sc, i);
						exit = true;
						break;
					}
				}
			}

			if(!exit)
			{
				System.out.println("No such user exists! Please retry.");
			}
		}
		while(!exit);
	}
	
	void LoginPasswordValidation(Scanner sc, int index)
	{
		boolean exit = false;
		
		do
		{
			System.out.println("Enter Password: ");
			String password = sc.next();
			
			if(this.login_array.get(index).password.equals(password))
			{
				System.out.println("Successfully logged in.");
				exit = true;
			}
			else
			{
				System.out.println("Incorrect password!");
			}			
		}
		while(!exit);
	}
	
	void ShowUserInterface(Scanner sc, int choice)
	{
		boolean exit = false;
		do
		{
			System.out.println("\n**********************************WELCOME USER***************************************");
			System.out.println("1. Adopter Registration");
			System.out.println("2. Orphan Details");
			System.out.println("3. Logout");
			System.out.println("Enter choice...");
			
			choice = sc.nextInt();
			switch(choice)
			{
				case 1:
					System.out.println("Enter Orphan Id of child to be adopted: ");
					int o_id = sc.nextInt();
					
					if(this.checkIfOrphanIdExists(o_id))
					{
						if(!this.orphan_array.get(o_id-1).checkIfOrphanAdopted())
						{
							Adopter_Background_Info adopter = new Adopter_Background_Info();
							int newAdopterId = this.adopter_array.size()+1;
							adopter.setDetails(newAdopterId, o_id);
							this.orphan_array.get(o_id-1).setAdopted(newAdopterId);
							this.adopter_array.add(adopter);
						}
						else
						{
							System.out.println("Child is already adopted!");
						}
					}
					else
					{
						System.out.println("Entered orphan id does not exist! Try again.");
					}
					break;
					
				case 2:
					for (int i = 0; i < this.orphan_array.size(); i++) {
						if(this.orphan_array.get(i) == null)
						{
							break;
						}
						this.orphan_array.get(i).getDetails();							
					}
					break;
					
				case 3:
					exit = true;
					break;
					
				default:
					System.out.println("Invalid input!");
					break;
			}
		}
		while(!exit);
	}
	
	void ShowAdminInterface(Scanner sc, int choice)
	{
		boolean exit = false;
		do
		{
			System.out.println("\n******************************WELCOME ADMIN*******************************************");
			System.out.println("1. Orphan Registration");
			System.out.println("2. Adopter Registration");
			System.out.println("3. Orphan Details");
			System.out.println("4. Adopter Details");
			System.out.println("5. Logout");
			System.out.println("Enter choice...");
			
			choice = sc.nextInt();
			switch(choice)
			{
				case 1:
					Orphan_Info orp = new Orphan_Info();
					orp.setDetails(this.orphan_array.size()+1);
					this.orphan_array.add(orp);
					break;
					
				case 2:
					System.out.println("Enter Orphan Id of child to be adopted: ");
					int o_id = sc.nextInt();

					if(this.checkIfOrphanIdExists(o_id))
					{
						if(!this.orphan_array.get(o_id-1).checkIfOrphanAdopted())
						{
							Adopter_Background_Info adopter = new Adopter_Background_Info();
							int newAdopterId = this.adopter_array.size()+1;
							adopter.setDetails(newAdopterId, o_id);
							this.orphan_array.get(o_id-1).setAdopted(newAdopterId);
							this.adopter_array.add(adopter);
						}
						else
						{
							System.out.println("Child is already adopted!");
						}
					}
					else
					{
						System.out.println("Entered orphan id does not exist! Try again.");
					}
					break;
					
				case 3:
					this.orphan_array.forEach(o -> o.getDetails());
					break;
					
				case 4:
					this.adopter_array.forEach(a -> a.getDetails());
					break;
					
				case 5:
					exit = true;
					break;
					
				default:
					System.out.println("Invalid input!");
					break;
			}
		}
		while(!exit);
	}
	

	public static void main(String[] args) {
		int choice = 0;
		boolean exit = false;
		boolean loggedIn = false;
		Orphanage o = new Orphanage();
		Scanner sc = new Scanner(System.in);
		
		o.SetInitialOrphanData();
		o.SetInitialAdopterData();
		o.SetUserLoginData();
		
		do 
		{
			o.LoginUsernameValidation(sc, choice);
			
			if(userType.equals("user"))
			{
				o.ShowUserInterface(sc, choice);
			}
			
			if(userType.equals("admin"))
			{
				o.ShowAdminInterface(sc, choice);
			}
			
			if(userType.equals(""))
			{
				exit = true;
			}
		}
		while(!exit);
	}
}

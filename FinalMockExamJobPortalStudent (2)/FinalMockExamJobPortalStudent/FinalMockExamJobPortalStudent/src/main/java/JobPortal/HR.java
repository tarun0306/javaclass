package JobPortal;

import java.util.List;
import java.util.Scanner;

public class HR extends People{
	public List<String> keyword;

	public HR(String id, Data d) {
		
		super(id, d);
	}
	
	
	
	public void createJob() {
		Scanner sc = new Scanner(System.in);
			System.out.print("Please Enter the Job title : ");
				String jobTitle = sc.nextLine();
				if(super.getD().keySearch(jobTitle)) {
					System.out.println( jobTitle + " is already in the list");
				}
				else {
					super.getD().insertJob(jobTitle);
				}
	}
	
	public void reviewJob() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Please Enter applicant name : ");
		String applicant = sc.nextLine();
		System.out.print("Please Enter Job title : ");
		String job = sc.nextLine();
		System.out.print("Please Enter the Decision : ");
		String res = sc.nextLine();
		
		super.getD().review(applicant,res,job);
		
		System.out.println("Details changed");
		
	}
	
	 
}

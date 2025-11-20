package JobPortal;

import java.util.Scanner;

public class JobPortal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Data d = new Hibernate();
		Scanner input = new Scanner(System.in);
		String selection = "";

		while (!selection.equals("x")) // while not x, keep displaying the menu
		{
			// display the menu
			System.out.println();
			System.out.println("Please make your selection");
			System.out.println("L: login");
			System.out.println("X: Leave");
			System.out.println();

			// get the selection from the user
			// In this program, please use nextLine() for getting all input.
			selection = input.nextLine();
			System.out.println();

			if (selection.equals("L")) {
				System.out.println("Please enter your id: ");
				String id = input.nextLine();

				if (id.equals("hr")) {
					// this is a hr login, continue with your source code for hr operations, no
					// password needed
					// you may create a hr object to continue
					HR h = new HR(id, d);
					System.out.println("Please make your selection");
					System.out.println("c: Create Job ");
					System.out.println("r: Review Job");
					String sel = input.nextLine();
					if(sel.equals("c")) {
						
						h.createJob();
					}
					else {
						//Review the application
						h.reviewJob();
					}
				} else {
					// this is a user login, continue with your source code for applicant
					// operations, no password needed
					// you may create an applicant object to continue
					Applicant a = new Applicant(id, d);

					System.out.println();
					System.out.println("Please make your selection");
					System.out.println("a: Apply Job");
					System.out.println("c: Check My Applications");
					System.out.println();

					String sel = input.nextLine();

					if (sel.equals("a")) {
						System.out.print("Please Enter the job : ");
						String jobTitle = input.nextLine();
						a.apply(jobTitle);
					}

					if (sel.equals("c")) {
						a.checkstatus(id);
					}

				}
			}
		}

	}

}

package JobPortal;

import java.util.List;
import java.util.Scanner;

public class Applicant extends People {
	Scanner sc = new Scanner(System.in);

	public Applicant(String id, Data d) {
		super(id, d);
	}
	public void apply(String job) {

		
		if (super.getD().keySearch(job)) {
			super.getD().apply(job, super.getId());
		} else {
			System.out.println("Hey " + super.getId() + " sorry job not found");
		}
	}
	public void checkstatus(String id) {

		List<Application> appli = super.getD().checkApplication(super.getId());

		for (Application app : appli) {
			System.out.println("Hey " + app.getApplicant() + "The");
			System.out.println(app.getJob() + " --------------> " + app.getStatus());
		}
	}
}

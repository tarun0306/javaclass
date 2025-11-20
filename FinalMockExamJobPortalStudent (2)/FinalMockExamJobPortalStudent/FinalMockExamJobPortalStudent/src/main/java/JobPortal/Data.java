package JobPortal;

import java.util.List;

public interface Data {
	
	public void insertJob(String job);
	public void apply(String job, String id);
	public List<Application> checkApplication(String name);
	
	public boolean keySearch(String jobTitle);
	public void review(String applicant,String res,String jobTitle);

}

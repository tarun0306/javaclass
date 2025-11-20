package JobPortal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Job {
	
	@Id
	@Column(name="JobTitle")
	private String jobTitle;
	
	@Column(name="status")
	private String status;

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Job(String jobTitle, String status) {
		super();
		this.jobTitle = jobTitle;
		this.status = status;
	}

	public Job() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}

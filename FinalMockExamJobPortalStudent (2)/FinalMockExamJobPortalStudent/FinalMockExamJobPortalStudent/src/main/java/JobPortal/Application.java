package JobPortal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Application {
	
	@Id
	@Column(name="id")
	private int appId;
	
	@Column(name="job")
	private String job;
	
	private String applicant;
	
	private String status;

	public int getAppId() {
		return appId;
	}

	public void setAppId(int appId) {
		this.appId = appId;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public String getApplicant() {
		return applicant;
	}

	public void setApplicant(String applicant) {
		this.applicant = applicant;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Application(String job, String applicant, String status) {
		super();
		
		this.job = job;
		this.applicant = applicant;
		this.status = status;
	}

	public Application() {
		super();
	}
	
}

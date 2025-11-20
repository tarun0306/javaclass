package JobPortal;

import java.util.List;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;

 
public class Hibernate implements Data{

	protected SessionFactory sessionFactory;
	
	
	public void setup()
	{
		final StandardServiceRegistry reg = new StandardServiceRegistryBuilder().configure().build();
		try
		{
			sessionFactory = new MetadataSources(reg).buildMetadata().buildSessionFactory();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			StandardServiceRegistryBuilder.destroy(reg);
		}
	}
	
	public void exit()
	{
		sessionFactory.close();
	}

	public void insertJob(String job) {

		setup();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Job j = new Job(job,"open");
		session.save(j);
		session.getTransaction().commit();
		session.close();
		exit();
	}

	public void apply(String job, String id) {
	
			setup();
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			Job j = session.get(Job.class, job);
			if(j==null) {
				System.out.println("The job title" + job + "not listed");
			}
			else if(j.getStatus().equals("open")) {
				Application application = new Application(job,id,"recevied");
				session.save(application);
				session.getTransaction().commit();
				session.close();
				exit();
			}
			else {
				System.out.println("Positions has been Filled");
			}
		
	}
	
	 
	public List<Application> checkApplication(String name) {
		setup();
		String hql = "from Application where applicant =:name";
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Query<Application> query= session.createQuery(hql,Application.class);
		query.setParameter("name",name);
		List<Application> appli = query.getResultList();
		session.getTransaction().commit();
		session.close();
		exit();
		return appli;
	}


	public boolean keySearch(String jobTitle) {
		setup();
		String status = "open";
		String hql = "from Job where JobTitle =: jobTitle and status=:status";
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Query<Job> query = session.createQuery(hql, Job.class);
		query.setParameter("jobTitle",jobTitle);
		query.setParameter("status",status);
		List<Job> jobs = query.getResultList();
		session.getTransaction().commit();
		session.close();
		exit();
		if(jobs.size()>0) {
			return true;
		}
		return false;
	}
	
	public void review(String applicant,String res, String jobTitle) {
		setup();
		String status = "recevied";
		
		String hql = "from Application where status =: status and job=:jobTitle";
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Query<Application> query = session.createQuery(hql,Application.class);
		query.setParameter("status", status);
		query.setParameter("job",jobTitle);
		List<Application> applications = query.getResultList();
		for(Application app : applications) {
			if(app.getApplicant().equals(applicant)) {
				app.setStatus(res);
				session.save(app);
				session.getTransaction().commit();
				session.close();
				exit();
			}
			else {
				session.close();
				exit();
			}
		}
	} 

}

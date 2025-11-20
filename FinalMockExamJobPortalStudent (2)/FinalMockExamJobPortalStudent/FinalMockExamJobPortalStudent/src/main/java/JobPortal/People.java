package JobPortal;

public abstract class People {
	
	private String id;
	private Data d;
	
	public People(String i, Data d)
	{
		id = i;
		this.d = d;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Data getD() {
		return d;
	}

	public void setD(Data d) {
		this.d = d;
	}
	
	

	
}

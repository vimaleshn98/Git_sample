package MavenJdbc.JDBCMavens.entity;

public class Watches extends WatchTypes {
	private int id;
	private int tid;
	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
	private String modelnmae;
	private String name;
	private float price; 
	public Watches(String name,int tid) {
		// TODO Auto-generated constructor stub
		super(tid,name);
	}
	public int getId() {
		return id;
	}
	public String getModelnmae() {
		return modelnmae;
	}
	public float getPrice() {
		return price;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setModelnmae(String modelnmae) {
		this.modelnmae = modelnmae;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return String.format("Watches [id=%s, modelnmae=%s, price=%s, getWatchtype()=%s]", id, modelnmae, price,
				getWatchtype());
	}
	
}

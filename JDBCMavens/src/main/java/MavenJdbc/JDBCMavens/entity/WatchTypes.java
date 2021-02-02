package MavenJdbc.JDBCMavens.entity;

public class WatchTypes {
	private String watchtype;
	private int id;
	public WatchTypes() {
		// TODO Auto-generated constructor stub
	}
	public WatchTypes(int tid,String name) {
		// TODO Auto-generated constructor stub
		 watchtype=name;
		 id=tid;
	}
	public String getWatchtype() {
		return watchtype;
	}
	public int getId() {
		return id;
	}
	public void setWatchtype(String watchtype) {
		this.watchtype = watchtype;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return String.format("WatchTypes [watchtype=%s, id=%s]", watchtype, id);
	}
	
}

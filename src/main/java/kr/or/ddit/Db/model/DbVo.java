package kr.or.ddit.Db.model;

public class DbVo {

	private String uri;
	private String className;
	
	public DbVo() {

	}

	public DbVo(String uri, String className) {
		super();
		this.uri = uri;
		this.className = className;
	}

	@Override
	public String toString() {
		return "DbVo [uri=" + uri + ", className=" + className + "]";
	}
	
	public String getUri() {
		return uri;
	}
	public void setUri(String uri) {
		this.uri = uri;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	
}

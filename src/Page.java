public class Page {
	private int data;
	private final String id;

	public Page(String id) {
		this.id = id;
	}

	public void setData(int data) {
		this.data = data;
	}

	public int getData() {
		return data;
	}

	public String getId() {
		return id;
	}
}

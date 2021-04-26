public class Page {
	private int data;
	private final String id;
	private boolean dirty;

	public Page(String id) {
		this.id = id;
		this.dirty = false;
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

	public void setDirty(boolean dirty) {
		this.dirty = dirty;
	}
}

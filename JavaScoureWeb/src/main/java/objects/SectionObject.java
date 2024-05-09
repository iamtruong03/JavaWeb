package objects;

public class SectionObject {
	private short section_id;
	private String section_name;
	private String section_created_date;
	private String section_author_created;
	private String section_last_modified;
	private int section_manager_id;
	private String section_author_modified;
	private String section_images;
	private String section_notes;
	private boolean section_enable;
	private boolean section_delete;
	private boolean section_locked;
	
	public SectionObject() {
		
	}

	public SectionObject(short section_id, String section_name, String section_created_date,
			String section_author_created, String section_last_modified, int section_manager_id,
			String section_author_modified, String section_images, String section_notes, boolean section_enable,
			boolean section_delete, boolean section_locked) {
		super();
		this.section_id = section_id;
		this.section_name = section_name;
		this.section_created_date = section_created_date;
		this.section_author_created = section_author_created;
		this.section_last_modified = section_last_modified;
		this.section_manager_id = section_manager_id;
		this.section_author_modified = section_author_modified;
		this.section_images = section_images;
		this.section_notes = section_notes;
		this.section_enable = section_enable;
		this.section_delete = section_delete;
		this.section_locked = section_locked;
	}

	public short getSection_id() {
		return section_id;
	}

	public void setSection_id(short section_id) {
		this.section_id = section_id;
	}

	public String getSection_name() {
		return section_name;
	}

	public void setSection_name(String section_name) {
		this.section_name = section_name;
	}

	public String getSection_created_date() {
		return section_created_date;
	}

	public void setSection_created_date(String section_created_date) {
		this.section_created_date = section_created_date;
	}

	public String getSection_author_created() {
		return section_author_created;
	}

	public void setSection_author_created(String section_author_created) {
		this.section_author_created = section_author_created;
	}

	public String getSection_last_modified() {
		return section_last_modified;
	}

	public void setSection_last_modified(String section_last_modified) {
		this.section_last_modified = section_last_modified;
	}

	public int getSection_manager_id() {
		return section_manager_id;
	}

	public void setSection_manager_id(int section_manager_id) {
		this.section_manager_id = section_manager_id;
	}

	public String getSection_author_modified() {
		return section_author_modified;
	}

	public void setSection_author_modified(String section_author_modified) {
		this.section_author_modified = section_author_modified;
	}

	public String getSection_images() {
		return section_images;
	}

	public void setSection_images(String section_images) {
		this.section_images = section_images;
	}

	public String getSection_notes() {
		return section_notes;
	}

	public void setSection_notes(String section_notes) {
		this.section_notes = section_notes;
	}

	public boolean isSection_enable() {
		return section_enable;
	}

	public void setSection_enable(boolean section_enable) {
		this.section_enable = section_enable;
	}

	public boolean isSection_delete() {
		return section_delete;
	}

	public void setSection_delete(boolean section_delete) {
		this.section_delete = section_delete;
	}

	public boolean isSection_locked() {
		return section_locked;
	}

	public void setSection_locked(boolean section_locked) {
		this.section_locked = section_locked;
	}

	@Override
	public String toString() {
		return "SectionObject [section_id=" + section_id + ", section_name=" + section_name + ", section_created_date="
				+ section_created_date + ", section_author_created=" + section_author_created
				+ ", section_last_modified=" + section_last_modified + ", section_manager_id=" + section_manager_id
				+ ", section_author_modified=" + section_author_modified + ", section_images=" + section_images
				+ ", section_notes=" + section_notes + ", section_enable=" + section_enable + ", section_delete="
				+ section_delete + ", section_locked=" + section_locked + "]";
	}
	
	
}

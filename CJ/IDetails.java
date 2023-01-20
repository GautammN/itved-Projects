package pro_06_19_project;

public interface IDetails {
	void getDetails();
	void getDetails(int id, int orphan_id);
	void setDetails();
	void setDetails(int id);
	void setDetails(int id, int orphan_id);
	void setDetails(int id, String name, int adopterId);
}

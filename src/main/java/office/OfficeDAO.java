package office;

public interface OfficeDao {
	public OfficeDataBean getOffice(String user_id);
	public int modifyOffice(OfficeDataBean dto);
}

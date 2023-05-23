package office;

public interface OfficeDAO {
	public OfficeDataBean getOffice(String user_id);
	public int modifyOffice(OfficeDataBean dto);
}

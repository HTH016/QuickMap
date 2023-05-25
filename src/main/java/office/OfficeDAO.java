package office;

public interface OfficeDAO {
	public OfficeDataBean getOffice(String user_id);
	public OfficeAdRequestDataBean getOfficeAd(String user_id);
	public OfficeRegisterDataBean getOfficeById(int office_id);
	public int gradeRequest(OfficeDataBean dto);
	public int modifyOffice(OfficeDataBean dto);
	public int registerOffice(OfficeRegisterDataBean dto);
	public int requestAd(OfficeAdRequestDataBean dto);
}

package office;

import java.util.Map;

public interface OfficeDAO {
	public OfficeDataBean getOfficeInfo(String user_id);
	public OfficeDataBean getOfficeInfo(int office_id);
	public OfficeRegisterDataBean getOfficeReg(int office_id);
	public OfficeAdRequestDataBean getOfficeAd(String user_id);
	public String getOfficeName(int office_id);
	public int gradeRequest(OfficeDataBean dto);
	public int modifyOffice(OfficeDataBean dto);
	public int registerOffice(OfficeRegisterDataBean dto);
	public int requestAd(OfficeAdRequestDataBean dto);
	public int updateReviewInfo(Map<String, Object> param);
}

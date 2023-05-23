package handler.map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import handler.CommandHandler;
import map.MapDao;
import map.MapOfficeDetailDTO;

@Controller
public class MapSearchHandler implements CommandHandler {
	@Resource(name="mapDao")
	private MapDao mapDao;

	@RequestMapping("/map_do_search")
	@Override
	public ModelAndView process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.setCharacterEncoding("utf-8");

		String[]	arrayWords	= request.getParameter("searchWord").split("\\s");

		for(int i=0 ; i<arrayWords.length ; i++) {
			String	word	= arrayWords[i];
			
			if(word.length() == 1) {
				arrayWords[i] = arrayWords[i] + "이";
			} else if(word.length() > 2) {
				arrayWords[i] = word.substring(0, 2);
			}

			System.out.println("wordlist : " + arrayWords[i]);
		}
		
		List<String>	serviceIds		= mapDao.searchServiceIdList(arrayWords);
//		Set<String>		serviceIdSet	= Set.copyOf(serviceIds);
		
		System.out.println("serviceIds   : " + serviceIds);
//		System.out.println("serviceIdSet : " + serviceIdSet);
		
		if(serviceIds.size() > 0) {
			String strLatiSouth	= request.getParameter("latiSouth");
			String strLatiNorth	= request.getParameter("latiNorth");
			String strLongWest	= request.getParameter("longWest");
			String strlongEast	= request.getParameter("longEast");
			String strMapLevel	= request.getParameter("mapLevel");
			String strOfficeClass	= request.getParameter("officeClass");
			
			double	latiSouth	= Double.parseDouble(strLatiSouth);
			double	latiNorth	= Double.parseDouble(strLatiNorth);
			double	longWest	= Double.parseDouble(strLongWest);
			double	longEast	= Double.parseDouble(strlongEast);
			int		mapLevel	= Integer.parseInt(strMapLevel);
			int		officeClass	= Integer.parseInt(strOfficeClass);
			
			System.out.println("latiSouth  : " + latiSouth + " / latiNorth : " + latiNorth);
			System.out.println("longWest   : " + longWest  + " / longEast  : " + longEast);
			System.out.println("mapLevel   : " + mapLevel);
			
			Map<String, Object> param	= new HashMap<>();

			param.put("latiSouth", latiSouth);
			param.put("latiNorth", latiNorth);
			param.put("longWest", longWest);
			param.put("longEast", longEast);
			param.put("mapLevel", mapLevel);
			param.put("officeClass", officeClass);
			param.put("serviceIds", serviceIds);
			
			List<MapOfficeDetailDTO> officeList	= new ArrayList<>();
			List<MapOfficeDetailDTO> dtosAd		= mapDao.searchOfficeList(param, true);

			for(MapOfficeDetailDTO dto : dtosAd) {
				System.out.println("[dtosAd] office_id : " + dto.getOffice_id() + " / service_id : " + dto.getService_id());
				dto.setOffice_ad_state("1");
			}

			List<MapOfficeDetailDTO> dtosNormal	= mapDao.searchOfficeList(param, false);
			
			for(MapOfficeDetailDTO dto : dtosNormal) {
				System.out.println("[dtosNo] office_id : " + dto.getOffice_id() + " / service_id : " + dto.getService_id());
			}
			
			officeList.addAll(dtosAd);
			officeList.addAll(dtosNormal);
			

			for(MapOfficeDetailDTO dto : officeList) {
				System.out.println("[office] office_id : " + dto.getOffice_id() + " / service_id : " + dto.getService_id());
			}
			
			request.setAttribute("dtos", officeList);
		}

		return new ModelAndView("map/map");
	}

}

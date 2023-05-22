package handler.map;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
			
			if(word.length() > 2) {
				arrayWords[i] = word.substring(0, 2);
			}

			System.out.println("wordlist : " + arrayWords[i]);
		}
		
		List<String>	serviceIds		= mapDao.searchServiceIdList(arrayWords);
//		Set<String>		serviceIdSet	= Set.copyOf(serviceIds);
		
		System.out.println("serviceIds   : " + serviceIds);
//		System.out.println("serviceIdSet : " + serviceIdSet);
		
		double	latiSouth	= Double.parseDouble(request.getParameter("latiSouth"));
		double	latiNorth	= Double.parseDouble(request.getParameter("latiNorth"));
		double	longWest	= Double.parseDouble(request.getParameter("longWest"));
		double	longEast	= Double.parseDouble(request.getParameter("longEast"));
		int		mapLevel	= Integer.parseInt(request.getParameter("mapLevel"));
		int		officeClass	= Integer.parseInt(request.getParameter("officeClass"));
		
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
		List<MapOfficeDetailDTO> dtosNormal	= mapDao.searchOfficeList(param, false);
		
		officeList.addAll(dtosAd);
		officeList.addAll(dtosNormal);
		
		for(MapOfficeDetailDTO dto : dtosAd) {
			System.out.println("[dtosAd] office_id : " + dto.getOffice_id() + " / service_id : " + dto.getService_id());
		}

		for(MapOfficeDetailDTO dto : dtosNormal) {
			System.out.println("[dtosNo] office_id : " + dto.getOffice_id() + " / service_id : " + dto.getService_id());
		}
		
		for(MapOfficeDetailDTO dto : officeList) {
			System.out.println("[office] office_id : " + dto.getOffice_id() + " / service_id : " + dto.getService_id());
		}
		
		request.setAttribute("dtos", officeList);

		return new ModelAndView("map/map_search_result");
	}

}

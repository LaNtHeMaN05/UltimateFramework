package apiResources;

import java.util.ArrayList;
import java.util.List;

import pojo.PostAddress;
import pojo.location;

public class ApiDataBuilds {
	
	public PostAddress addPlacePayload(String name, String language, String address) {
		PostAddress pa=new PostAddress();
		pa.setAccuracy(50);
		pa.setAddress(address);
		pa.setName(name);
		pa.setPhone_number("1231231");
		pa.setWebsite("www.ltmhouse.com");
		pa.setLanguage(language);
		
		List<String> myList=new ArrayList<>();
		myList.add("Ferrari");
		myList.add("Bugati");
		pa.setTypes(myList);
		
		location l=new location();
		l.setLat(123123);
		l.setLng(1231221);
		
		pa.setLocation(l);
		
		return pa;
	}

}

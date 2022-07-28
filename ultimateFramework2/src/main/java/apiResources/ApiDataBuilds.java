package apiResources;

import java.util.ArrayList;
import java.util.List;

import pojo.PostAddress;
import pojo.location;

public class ApiDataBuilds {
	
	public PostAddress addPlacePayload() {
		PostAddress pa=new PostAddress();
		pa.setAccuracy(50);
		pa.setAddress("LONDON");
		pa.setName("LTM House in London");
		pa.setPhone_number("1231231");
		pa.setWebsite("www.ltmhouse.com");
		pa.setLanguage("English");
		
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

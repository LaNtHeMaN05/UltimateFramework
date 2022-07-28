package apiResources;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class apiUtils {
	RequestSpecification reqSpec;
	ResponseSpecification resSpec;
	public static PrintStream log;
	public String directoryPath2 = System.getProperty("user.dir");
	
	
	
	public RequestSpecification requestSpecification()  {
		FileInputStream fis2 = null;
		try {
			fis2 = new FileInputStream(directoryPath2+"\\src\\main\\java\\data.properties");
		} catch (FileNotFoundException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		Properties prop2=new Properties();
		try {
			prop2.load(fis2);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String apiUri=prop2.getProperty("apiUri");
		try {
			log = new PrintStream(new FileOutputStream("apiLogs.txt"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		reqSpec = new RequestSpecBuilder().setBaseUri(apiUri).setContentType(ContentType.JSON)
				.addQueryParam("key", "qaclick123")
				.addFilter(RequestLoggingFilter.logRequestTo(log))
				.addFilter(ResponseLoggingFilter.logResponseTo(log)).build();

		return reqSpec;

	}

	public ResponseSpecification responseSpecification() {

		resSpec = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();

		return resSpec;
	}

}

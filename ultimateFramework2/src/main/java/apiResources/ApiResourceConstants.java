package apiResources;

public enum ApiResourceConstants {
	
	
	
	AddPlaceApi("/maps/api/place/add/json"),
	GetPlaceApi("/maps/api/place/get/json");
	
	private String resourceApi;

	ApiResourceConstants(String resourceApi) {
		
		this.resourceApi=resourceApi;
		
	}
	
	public String getResourceApi() {
		return resourceApi;
	}
	
}

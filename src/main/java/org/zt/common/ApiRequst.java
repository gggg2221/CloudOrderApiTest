package org.zt.common;

import com.jayway.restassured.response.Response;

import static com.jayway.restassured.RestAssured.given;

public class ApiRequst {

	// 订单api
	public static Response OrderApiPost(String url, String json) {
		Response response = given().contentType("application/json;charset=UTF-8").body(json).post(url);
		return response;
	}

    // 验签反查api
    public static Response SignApiPost(String url,String value1,String value2) {
        Response response = given().contentType("application/x-www-form-urlencoded;charset=UTF-8").param("key",value1).param("sign",value2).post(url);
        return response;
    }

//    // 老验签
//    public static Response SignOldPost(String url,String value) {
//        Response response = given().contentType("application/x-www-form-urlencoded;charset=UTF-8").param("key",value).post(url);
//        return response;
//    }

	// public static String getAppToken(){
	// RestAssured.baseURI = "http://localhost:4567";
	// RestAssured.basePath = "/app/login";
	// String body="{\n" +
	// " \tusername:\"admin\",\n" +
	// " \tpassword:\"admin\"\n" +
	// "}";
	// Response response = given()
	// .body(body)
	// .when().log().all().post();
	// int responseCode = response.statusCode();
	// System.out.println("响应状态码："+String.valueOf(responseCode));
	// String token = response.getHeader("token");
	// return token;
	// }
	//
	// public static String getWebCookie(){
	// RestAssured.baseURI = "http://localhost:4567";
	// RestAssured.basePath = "/web/login";
	// String body="{\n" +
	// " \tusername:\"admin\",\n" +
	// " \tpassword:\"admin\"\n" +
	// "}";
	// Response response = given()
	// .body(body)
	// .when().log().all().post();
	// int responseCode = response.statusCode();
	// System.out.println("响应状态码："+String.valueOf(responseCode));
	// String cookie = response.getCookie("JSESSIONID");
	// return cookie;
	// }
	//
	// public static Response appGet(String url){
	// String token = ApiTool.getAppToken();
	// Response response = given()
	// .header("token",token)
	// .when().log().all().get(url);
	// return response;
	// }
	//
	// public static Response webGet(String url){
	// String cookie = ApiTool.getWebCookie();
	// Response response = given()
	// .cookie("JSESSIONID",cookie)
	// .when().log().all().get(url);
	// return response;
	// }
}

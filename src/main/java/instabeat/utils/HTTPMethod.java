package instabeat.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

public class HTTPMethod {
	
	public static JSONObject AppLogin(String value) throws Exception {
		CloseableHttpClient httpclient = HttpClients.createDefault();

		/* GET method */
		/*
		 * String contentGet = Request.Get("http://user.instabeat.me/user")
		 * .connectTimeout(1000) .socketTimeout(1000)
		 * .execute().returnContent().asString();
		 * System.out.println(contentGet);
		 */

		/* POST method Login */
		/*
		 * String contentPost =
		 * Request.Post("http://ibeat.pub.globallogic.com/user/login")
		 * .bodyForm(Form.form().add("email",
		 * "testusergl+3@ukr.net").add("password", "123456").build())
		 * .execute().returnContent().asString();
		 * System.out.println(contentPost);
		 */

//		HttpPost httpPost = new HttpPost("http://app.instabeat.me/login");
//		HttpPost httpPost = new HttpPost("http://ibeat.pub.globallogic.com/get-token");
		HttpPost httpPost = new HttpPost("http://staging-application-1234195952.us-west-2.elb.amazonaws.com/login");

		httpPost.addHeader("User-Agent",
				"instabeat-desktop/MAJOR.MINOR.{osx, win32, win64}.OSRELATED");
		httpPost.addHeader("Content-Type",
				"application/x-www-form-urlencoded; charset=UTF-8");
		httpPost.addHeader("instabeat-api-id",
				"fa7686b57cf116d0a2102ad531356005");
		httpPost.addHeader("Connection", "Keep-Alive");
		httpPost.addHeader("Accept-Encoding", "gzip, deflate");
		httpPost.addHeader("Accept-Language", "en-US,*");

		List<NameValuePair> credentials = new ArrayList<NameValuePair>();

		credentials.add(new BasicNameValuePair("user[email]", value));
//		System.out.println("username is " + value);
		Utils.Log.info("|username is " + value);
		credentials.add(new BasicNameValuePair("user[password]", "123456"));
//		credentials.add(new BasicNameValuePair("user[device-id]",
//				"2d10323430333135003b0036")); //25 symbols
		httpPost.setEntity(new UrlEncodedFormEntity(credentials));

		CloseableHttpResponse response2 = httpclient.execute(httpPost);

		BufferedReader br = new BufferedReader(new InputStreamReader(
				(response2.getEntity().getContent())));

		String output;
		String buffer = "";
//		System.out.println("Output from Server .... \n");
		Utils.Log.info("|Output from Server...");
		while ((output = br.readLine()) != null) {
			buffer += output;
		}

//		System.out.println(buffer);
		Utils.Log.info("|"+buffer);
		
		JSONObject jObject = new JSONObject(buffer);
		JSONObject data = jObject.getJSONObject("user");
		String username = data.getString("user");
		String usertoken = data.getString("token");

//		System.out.println(username);
		Utils.Log.info("|UserID is: "+username);
//		System.out.println(usertoken);
		Utils.Log.info("|User token is: "+usertoken);
		
		response2.close();
		httpclient.close();

		return data;

	}
	
	public static void PostSession () throws Exception{
		 
		JSONObject response = AppLogin("fortestgl+1@gmail.com");
		String username = response.getString("user");
		String usertoken = response.getString("token");
		
		CloseableHttpClient httpclient = HttpClients.createDefault();
	        try {
	        	
//	        	HttpPost httppost = new HttpPost("http://user.instabeat.me/user/unpack");
	        	HttpPost httppost = new HttpPost("http://staging-web-664817575.us-west-2.elb.amazonaws.com/user/unpack");
	        	
	            httppost.addHeader("User-Agent", "instabeat-desktop/MAJOR.MINOR.{osx, win32, win64}.OSRELATED");
	            httppost.addHeader("MIME-Version", "1.0");
	            httppost.addHeader("Connection", "Keep-Alive");
	            httppost.addHeader("Accept-Encoding", "gzip, deflate");
	            httppost.addHeader("Accept-Language", "en-US,*");
	                       
	            FileBody bin = new FileBody(new File("D:\\Java\\Projects\\session.bin"));
	            
	            HttpEntity reqEntity = MultipartEntityBuilder.create()
	            		.addTextBody("user[userId]", username)
	            		.addTextBody("user[token]", usertoken)
	            		.addTextBody("user[deviceId]", "0d47323430333135003d003a")
	            		.addPart("sessions", bin).build();
            
	            httppost.setEntity(reqEntity);

	            Utils.Log.info("|Executing request: " + httppost.getRequestLine());
	            CloseableHttpResponse response2 = httpclient.execute(httppost);
	            try {
	            	Utils.Log.info("|Status of request is: " + response2.getStatusLine());
	            	Utils.Log.info("|Response is: " + response2.toString());
	                HttpEntity resEntity = response2.getEntity();
	                if (resEntity != null) {
	                	Utils.Log.info("|Response content length: " + resEntity.getContentLength());
	                }
	                EntityUtils.consume(resEntity);
	            } finally {
	                response2.close();
	            }
	        } finally {
	            httpclient.close();
	        }
	    }
}

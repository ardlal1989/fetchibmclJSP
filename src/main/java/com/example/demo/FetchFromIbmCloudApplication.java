package com.example.demo;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import org.springframework.ui.Model;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.GetObjectRequest;

@SpringBootApplication
@Controller
public class FetchFromIbmCloudApplication {

	public static void main(String[] args) {
		SpringApplication.run(FetchFromIbmCloudApplication.class, args);
	}
	@GetMapping({"/", "/getObjPvtInp"})
    public String getObjPvtInp()
	{
		return "getObjPvtInp";
	}

	@RequestMapping("getObject")
	public String getObjPvt(Model model,@RequestParam("endpoint") String endpoint,@RequestParam("bucketName") String bucketName,@RequestParam("objectName") String objectName,@RequestParam("accessKey") String accessKey,@RequestParam("secretKey") String secretKey)
	{
		
		
		BasicAWSCredentials credentials = new BasicAWSCredentials(accessKey, secretKey); // declare a new set of basic credentials that includes the Access Key ID and the Secret Access Key
		AmazonS3 cos = new AmazonS3Client(credentials); // create a constructor for the client by using the declared credentials.
		cos.setEndpoint(endpoint); // set the desired endpoint
		GetObjectRequest request = new // create a new request to get an object
				GetObjectRequest( // request the new object by identifying
						bucketName, // the name of the bucket
						objectName // the name of the object
				);

				cos.getObject( // write the contents of the object
				request, // using the request that was just created
				new File(objectName) // to write to a new file
				);
				DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
				Date date = new Date();
				Calendar c = Calendar.getInstance();
		        c.setTime(date);
		        c.add(Calendar.DATE, 1);
		        Date currentDatePlusOne = c.getTime();
				System.out.println(dateFormat.format(currentDatePlusOne));
				String url=cos.generatePresignedUrl(bucketName, objectName, currentDatePlusOne).toString();
				System.out.println("Path"+url);
				model.addAttribute("path",url);
				
				return "getObject";
	}

}

package com.tech.maxSatis.restController;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tech.maxSatis.bean.SatisfactionDataObj;

import io.swagger.annotations.Api;

@RestController
@RequestMapping (value = "/techolution")
@Api
public class MaxSatisRestController {

	@RequestMapping (value = "/getMaxSatisfation/{time}", method = RequestMethod.GET)
    public ResponseEntity<String> getMaxSatisfaction(@PathVariable ("time") String time) throws IOException {
        
		System.out.println("time = " + time);
		
		String line;
		double satisVal = 0L;

		try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("G:\\Development\\Redis\\TecholutionAssignment\\src\\main\\resources\\static\\data\\data2.txt"), Charset.forName("UTF-8")))) {
			List<SatisfactionDataObj> satisfactionDataObjList = new ArrayList<>();
		    while ((line = br.readLine()) != null) {
		    	
		    	System.out.println("Line = " + line);
		    	String[] lineArray = line.split(" ");
		    	SatisfactionDataObj satisfactionDataObj = new SatisfactionDataObj();
		    	satisfactionDataObj.setSatisAmount(Integer.parseInt(lineArray[0]));
		    	satisfactionDataObj.setTimeTaken(Integer.parseInt(lineArray[1]));
		    	satisfactionDataObj.setSatisByTime(Double.parseDouble(lineArray[0]) / Double.parseDouble(lineArray[1]));
		    	satisfactionDataObjList.add(satisfactionDataObj);
		    	
		    }
		    
		    Collections.sort(satisfactionDataObjList);
		    System.out.println(satisfactionDataObjList.get(0).getSatisByTime());
		    
		    satisVal = getMaximumSatisfaction(satisfactionDataObjList, Integer.parseInt(time));
		    System.out.println("satisVal = " + satisVal);
		}
        return ResponseEntity.ok("Maximum satisfaction on the given time " + time + " is : " + satisVal);
    }
	
	public static double getMaximumSatisfaction (List<SatisfactionDataObj> satisfactionDataObjList, int time) {
		
		double totalValue = 0d; 
		for(SatisfactionDataObj i: satisfactionDataObjList){ 
			  
            int curTime = (int) i.getTimeTaken(); 
            int curSatisAmt = (int) i.getSatisAmount(); 
  
            if (time - curTime >= 0){//this weight can be picked while 
            	time = time-curTime; 
                totalValue += curSatisAmt; 
  
            }else{//item cant be picked whole 
  
                double fraction = ((double)time/(double)curTime); 
                totalValue += (curSatisAmt*fraction); 
                time = (int)(time - (curTime*fraction)); 
                break; 
            } 
  
        } 
  
        return totalValue; 
	}
}

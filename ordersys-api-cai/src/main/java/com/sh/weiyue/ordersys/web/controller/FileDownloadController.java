package com.sh.weiyue.ordersys.web.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
 


import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
 
@Controller
public class FileDownloadController {
    private static final int BUFFER_SIZE = 4096;
             
    
    @RequestMapping(value="download", method = RequestMethod.GET)
    public void download( @RequestParam String deviceType, HttpServletRequest request, HttpServletResponse response ) throws IOException
    {
    	if( deviceType.equals( "ios" ) )
    	{
    		System.out.println( "将要下载ios的apk" );
    		String filePath = "/downloads/WeiyueOrder.apk";      	
        	doDownload( request,  response, filePath );
    	}
    	else if( deviceType.equals( "android" ) )
    	{
    		System.out.println( "将要下载android的apk" );
    		String filePath = "/downloads/WeiyueOrder.apk";      	
        	doDownload( request,  response, filePath );
    	}
    	
    }
    
    
    
    public void doDownload(HttpServletRequest request, HttpServletResponse response, String filePath ) throws IOException { 
        ServletContext context = request.getServletContext();
        String appPath = context.getRealPath("");
        System.out.println("appPath = " + appPath);
 
        String fullPath = appPath + filePath;      
        File downloadFile = new File(fullPath);
        FileInputStream inputStream = new FileInputStream(downloadFile);
         
        String mimeType = context.getMimeType(fullPath);
        if (mimeType == null) {
            mimeType = "application/octet-stream";
        }
        System.out.println("MIME type: " + mimeType);
 
        response.setContentType(mimeType);
        response.setContentLength((int) downloadFile.length());
 
        String headerKey = "Content-Disposition";
        String headerValue = String.format("attachment; filename=\"%s\"",
                downloadFile.getName());
        response.setHeader(headerKey, headerValue);
 
        OutputStream outStream = response.getOutputStream();
 
        byte[] buffer = new byte[BUFFER_SIZE];
        int bytesRead = -1;
 
        while ((bytesRead = inputStream.read(buffer)) != -1)
        {
            outStream.write(buffer, 0, bytesRead);
        }
 
        inputStream.close();
        outStream.close();
 
    }   
}


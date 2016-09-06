/*
 *@filename ImageController.java
 *@author Sakhuraah
 *@date 6 sept. 2016
*/

package fr.imie.appformusic.controller;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import fr.imie.appformusic.responses.ImageResponse;
import fr.imie.appformusic.responses.Response;
import fr.imie.appformusic.utils.ImageUtils;


@Controller
public class ImageController {

	private static final Logger log = Logger.getLogger(ImageController.class);
	
	@RequestMapping(value="/uploadimage", method=RequestMethod.POST)
	@ResponseBody
	public ImageResponse imageUpload(@RequestParam("image_upload") CommonsMultipartFile multipart) throws IOException{
		System.out.println("printimagecontroller");
		log.debug("logimagecontroller");
		InputStream input = multipart.getInputStream();
		int placeid = 1;
		ImageUtils.storeImage(input, placeid);
		
		ImageResponse response = new ImageResponse();
		response.setPath("/img/image");
		return response;
		
	}
	
	@RequestMapping(value="/img/image", produces="image/jpeg")
	@ResponseBody
	public byte[] image(HttpServletRequest request,@RequestParam(value="reload", required=false)boolean reload) throws IOException{
		log.debug("image");
		Integer placeid = 1;
		return ImageUtils.getPlaceImage(placeid);
	}
	
	@ExceptionHandler(Throwable.class)
	public Response exceptionhandler(Throwable t){
		log.error(t.getMessage(), t);
		return new Response(false);
	}
}

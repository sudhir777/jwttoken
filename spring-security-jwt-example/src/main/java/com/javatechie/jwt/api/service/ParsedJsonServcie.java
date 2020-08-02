package com.javatechie.jwt.api.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.javatechie.jwt.api.entity.Category;
import com.javatechie.jwt.api.entity.JsonResponseDTO;
import com.javatechie.jwt.api.entity.Test;
import com.javatechie.jwt.api.entity.Video;
import com.javatechie.jwt.api.excetion.ServiceException;
import com.javatechie.jwt.api.repository.ParsedJsonRepostiory;

@Service
public class ParsedJsonServcie {

	@Autowired 
    private RestTemplate resttemplate;
    @Value("${rest.url}")
    private String url;
    @Value("${token.url}")
    private String tokenurl;
    @Autowired
    ParsedJsonRepostiory parsedJsonRepostiory;
	public List<JsonResponseDTO> parsedJsonRequest() throws ServiceException
	{
		
		Test result;
		//JsonResponseDTO jsonResponseDTO=new JsonResponseDTO();
		List<JsonResponseDTO> jsonList=new ArrayList<JsonResponseDTO>();
    	try {
    		System.out.println("its reached in side try");
    		RestTemplate  restTemplate = new RestTemplate();

    		List<HttpMessageConverter<?>> messageConverters = new ArrayList<HttpMessageConverter<?>>();
    		MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
    		converter.setSupportedMediaTypes(Collections.singletonList(MediaType.ALL));         
    		messageConverters.add(converter);  
    		restTemplate.setMessageConverters(messageConverters); 
    		 result=restTemplate.getForObject(url, Test.class);
    		 for(Category ca:result.getCategories())
    		 {
    			 System.out.println(ca.getVideos().size());
    			 
    			 
    			 for(Video video:ca.getVideos())
    			 {
    			 System.out.println("Movie Discrption: "+video.getDescription());
    			 System.out.println("Movie subtitle: "+video.getSubtitle());
    			 System.out.println("Movie thumb: "+video.getThumb());
    			 System.out.println("Movie Title: "+video.getTitle());
    			 System.out.println("Movie Source: "+video.getSources());
    			 JsonResponseDTO jsonResponseDTO=new JsonResponseDTO();
    			 jsonResponseDTO.setDescription(video.getDescription());
    			 jsonResponseDTO.setSubtitle(video.getSubtitle());
    			 jsonResponseDTO.setThumb(video.getThumb());
    			 jsonResponseDTO.setTitle(video.getTitle());
    			 jsonResponseDTO.setSources(video.getSources().get(0));
    			 jsonList.add(jsonResponseDTO);
    			 }
    			 
    		 }
    	System.out.println(result.toString());
    	}
    	catch(Exception e)
    	{
    		throw new ServiceException(e.getMessage());
    	}
    	System.out.println("its reached here");
    	
    	parsedJsonRepostiory.saveAll(jsonList);
    	for(JsonResponseDTO dto:parsedJsonRepostiory.findAll())
        	System.out.println("helloooo------------"+dto.getSources());
        return jsonList;
	}

}

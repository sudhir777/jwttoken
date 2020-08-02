package com.javatechie.jwt.api.controller;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.javatechie.jwt.api.entity.JsonResponseDTO;
import com.javatechie.jwt.api.excetion.ServiceException;
import com.javatechie.jwt.api.repository.ParsedJsonRepostiory;
import com.javatechie.jwt.api.service.ParsedJsonServcie;
//import com.javatechie.jwt.api.util.JwtUtil;

@RestController
public class WelcomeController {

	Logger  log=LoggerFactory.getLogger(WelcomeController.class);
//    @Autowired
//    private JwtUtil jwtUtil;
   /* @Autowired
    private AuthenticationManager authenticationManager;*/
    @Autowired 
    private RestTemplate resttemplate;
    @Value("${rest.url}")
    private String url;
    @Value("${token.url}")
    private String tokenurl;
@Autowired
private ParsedJsonServcie jsonService;
    
@GetMapping("/home/{name}")
    public String welcome(@PathVariable String name) {
	
	    log.debug("Request {}",name);
	    if(name.equalsIgnoreCase("test"))
	    {
	    	throw new RuntimeException("wrong parameter");
	    }
	    String response="Welcome to javatechie !!"+name;
	    log.debug("Response {}",response);
        return response;
    }
@Autowired
ParsedJsonRepostiory parsedJsonRepostiory;
    @GetMapping("/api/v1/getmediadata")
    public List<JsonResponseDTO> getmediadata() throws ServiceException  {
    	/*JSONObject resp=new JSONObject();
    	JSONArray catgeories= resp.getJSONArray("categories");
    	catgeories.getJSONArray(0);*/
    	String username="sudhir";
    	String password="Secure@345";
    	HttpHeaders headers=new HttpHeaders();
    	headers.setBasicAuth(username, password);
    	
    	HttpEntity<String> request=new HttpEntity<>(headers);
    	ResponseEntity<String> response=resttemplate.exchange(url, HttpMethod.GET, request, String.class);
    	//List<JsonResponseDTO> jsonList=new ArrayList();
    	//JsonResponseDTO str=jsonService.parsedJsonRequest();
        return jsonService.parsedJsonRequest();
    	
        
    }


    /*private String generateTokens()  {
		
    	
    	JSONObject jsonrequest=new JSONObject();
    	ResponseEntity<JSONObject> response=null;
    	
			//jsonrequest.put("userName", "sudhir");
			//jsonrequest.put("password", "Secure@345");
	    	HttpHeaders headers=new HttpHeaders();
	    	HttpEntity<String> request=new HttpEntity<>(headers);
	    	 response=resttemplate.postForEntity(tokenurl, jsonrequest, JSONObject.class);
	    	
	    	System.out.println(response.getBody().get("Bearer"));;
		
		return response.getBody().get("Bearer").toString();
	}*/
	/*@PostMapping("/authenticate")
    public String generateToken(@RequestBody AuthRequest authRequest) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getUserName(), authRequest.getPassword())
            );
        } catch (Exception ex) {
            throw new Exception("inavalid username/password");
        }
        return jwtUtil.generateToken(authRequest.getUserName());
    }*/
}

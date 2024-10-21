package com.example.demo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody ;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.model.Member;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.example.data.* ; 

import org.springframework.beans.factory.annotation.Autowired;

//Annotation
@Controller
@RequestMapping("/members")
public class DemoController 
{

    @Autowired
    private MemberRepository repo1;


    //@GetMapping("/id/{id1:\\d+}")
    //@GetMapping("/id/{param}")
    @GetMapping("/{param}")
    //@GetMapping("/id")
    @ResponseBody
    public Member lookupMemberById(  @PathVariable("param") String param )
    //public Member lookupMemberById(  )
    {
    	
        Member member1 = repo1.findById(new Long(1)) ;
        		
        //if (member == null) {
        //    throw new WebApplicationException(Response.Status.NOT_FOUND);
       // }
       // return member;
    	String arr1[] = param.split( ":" )  ;
    	System.out.println( "id:" + param   ) ;
    	return null ; 
    }

    
    
    @RequestMapping("/listallmembers")
    @ResponseBody

    public String listAllMembers()
    {
    	String resultStr = "" ;
        try
        {
        // Print statement
    	System.out.println("----------------------------------") ;
    	//MemberRepository repo1 = new MemberRepository() ; 
    
    	List<Member> result = repo1.findAllOrderedByName() ;
    	
    	
    	if ( result != null )
    	{
         	for( Member mem1 : result )
         		resultStr =  resultStr + mem1.getName() ;
    	}
    		
    	System.out.println("resultStr:" + resultStr ) ;
    	ObjectMapper objectMapper = new ObjectMapper();
    	resultStr =  objectMapper.writeValueAsString(result)  ;
        }
        catch( Exception except )
        {
        	
        	resultStr = "Some exception occurred."  ;
        }
    	return resultStr ;
    }

	
	
	    @RequestMapping("/hello")
	    @ResponseBody
	 
	    // Method
	    public String helloWorld()
	    {
	 
	        // Print statement
	    	System.out.println("----------------------------------") ;
	        return "Hello World!";
	    }
	
}

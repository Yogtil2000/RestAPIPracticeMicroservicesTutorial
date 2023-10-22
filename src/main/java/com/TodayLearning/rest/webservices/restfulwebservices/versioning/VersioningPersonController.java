package com.TodayLearning.rest.webservices.restfulwebservices.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
/* 
Ways using which versioning can be achieved :
1) Using the URI/URL 
     by providing the different URLs for the same resource 
     
2) Using the request parameter 
     
3) 
4) 
 */
@RestController
public class VersioningPersonController 
{
         @GetMapping("/v1/person")
         public PersonV1 getFirstVersionOfPerson()
         {
        	 return new PersonV1("Bob Charlie");
         }
         
         
         @GetMapping("/v2/person")
         public PersonV2 getSecondVersionOfPerson()
         {
        	 return new PersonV2(new Name("Bob", "Charlie"));
         }
       //---------------------------------------------------------------------------------------------------------  
         // Examples of Implementing the versioning using the request parameters 
         
         @GetMapping(path="/person",params = "version=1")
         public PersonV1 getFirstVersionOfPersonRequestParameter()
         {
        	 return new PersonV1("Bob Charlie.");
         }
         
         @GetMapping(path="/person",params = "version=2")
         public PersonV2 getSecondVersionOfPersonRequestParameter()
         {
        	 return new PersonV2(new Name("Bob", "Charlie"));
         }
         
         
       //---------------------------------------------------------------------------------------------------------  
         // Examples of Implementing the versioning using the "Request Headers"
         
         @GetMapping(path="/person/header",headers = "X-API-VERSION=1")     // note: in the headers you can define any things like headers="version=1"
         public PersonV1 getFirstVersionOfPersonRequestHeaders()
         {
        	 return new PersonV1("Bob Charlie.");
         }
         //same URL just change in the request headers 
         @GetMapping(path="/person/header",headers ="X-API-VERSION=2")   //custom headers 
         public PersonV2 getSecondVersionOfPersonRequestHeaders()    
         {
        	 return new PersonV2(new Name("Bob", "Charlie"));
         }
         
         //---------------------------------------------------------------------------------------------------------
         // Examples of Implementing the versioning using the "Accept" headers , producers
         // this is also called as "content Negotioation" 
         
         @GetMapping(path="/person/accept", produces  = "application/vnd.company.app-v1+json")     // note: here the prodces=""  have some fixed kind of value you can't able to provide any stuff there 
         public PersonV1 getFirstVersionOfPersonAcceptHeaders()
         {
        	 return new PersonV1("Bob Charlie.");
         }
         
         @GetMapping(path="/person/accept",produces  ="application/vnd.company.app-v2+json")   //custom headers 
         public PersonV2 getSecondVersionOfPersonAcceptHeaders()    
         {
        	 return new PersonV2(new Name("Bob", "Charlie"));
         }
         
         
         
}

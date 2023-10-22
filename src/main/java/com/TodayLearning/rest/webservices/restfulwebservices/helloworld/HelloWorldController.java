package com.TodayLearning.rest.webservices.restfulwebservices.helloworld;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController 
{
	
	  private MessageSource messageSource;
	  
	
	  //constructor injection 
	   public HelloWorldController(MessageSource messageSource) {
		super();
		this.messageSource = messageSource;
	}

	@GetMapping(path="hello-world")
       public String helloWorld()
       {
    	   return "Started again Restarting....";
       }
	   
	   @GetMapping(path="/hello-world-bean")
       public HelloWorldBean helloWorldBean()
       {
    	   return new HelloWorldBean("I am hello World Bean....");
       }
	   
	   @GetMapping(path="/hello-world/path-variable/{name}")
       public HelloWorldBean helloWorldPathVariable(@PathVariable String name)
       {
    	   return new HelloWorldBean(String.format("Hello World, %s",name ));
       }
	   
	   @GetMapping(path="hello-world-internationalized")
       public String helloWorldInternationalization()
       {
		   Locale locale=LocaleContextHolder.getLocale();
		   return messageSource.getMessage("good.morning.message", null, "Default Message", locale);
		   
		   
		   
    	//   return "Started again Restarting....";
    	   
    	   /* 
    	    * Example 'en'-English (Good Mroning)
    	    * Example 'nl'-Dutch (Goedemorgen)
    	    * Example 'fr'-French (Bonjour)
    	    * 
    	    * 
    	    * 
    	    Step 1: define the values   ----> standard way for internalization --> define the values in messages.peoperties
    	    Step 2: Write the code to consume those values 
    	    */
       }
	   
	   
	   
}

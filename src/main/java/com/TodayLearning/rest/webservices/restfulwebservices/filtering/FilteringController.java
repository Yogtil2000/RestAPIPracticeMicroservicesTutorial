package com.TodayLearning.rest.webservices.restfulwebservices.filtering;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class FilteringController 
{
	@GetMapping("/filtering")
     public MappingJacksonValue filtering()   // want to return field1 and field3 
     {
		SomeBean someBean = new SomeBean("Value1","Value2","Value3");
		
		//MappingJacksonValue 
		MappingJacksonValue mappingJacksonValue=new MappingJacksonValue(someBean);
    	 
		SimpleBeanPropertyFilter filter=SimpleBeanPropertyFilter.filterOutAllExcept("field1","field3");
		FilterProvider filters= new SimpleFilterProvider().addFilter("SomeBeanFilter",filter);
		mappingJacksonValue.setFilters(filters);
		return mappingJacksonValue;
     }
	
	//field2 as we make the json ignore so its not even taken in the list 
	@GetMapping("/filtering-list")
    public  MappingJacksonValue filteringList()  // want to return field2 and field3 
    {
   	 List<SomeBean> asList = Arrays.asList(new SomeBean("Value1", "Value2", "Value3"),
				                new SomeBean("Value4", "Value5", "Value6"));
   	 
   	 MappingJacksonValue mappingJacksonValue=new MappingJacksonValue(asList);
   	 
   	 
   	SimpleBeanPropertyFilter filter=SimpleBeanPropertyFilter.filterOutAllExcept("field2","field3");
	FilterProvider filters=new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);
	mappingJacksonValue.setFilters(filters);
   	 
   	 return mappingJacksonValue;
    }
}

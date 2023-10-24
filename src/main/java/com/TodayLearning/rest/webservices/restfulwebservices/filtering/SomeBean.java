package com.TodayLearning.rest.webservices.restfulwebservices.filtering;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
//this is another annotation in optioal to @JsonIgnore , you can specify on class 
// @JsonIgnoreProperties("field1")                //you can define it at the class level , you can directly able to add the value here
// so you can either use @JsonIgnore OR use @JsonIgnoreProperties so achieve the "STATIC FILTERING...."
// if you want to specify multiple values in @JsonIgnoreProperties use {"field1","field2"}
// best option -> @JsonIgnore , as in future if the field name changes then also we doesn't need to worry there

@JsonFilter("SomeBeanFilter")
//@JsonFilter("SomeBeanFilterList") : You cannot do so , keep the filters names as same 
public class SomeBean 
{
     private String field1;
     
     //example of static filtering - suppose field2 is password 
     // NOTE: this "field2" not even taken in the list if we tried to add it in the list 
     //@JsonIgnore
     private String field2;
     
    // @JsonIgnore
     private String field3;
     
	public SomeBean(String field1, String field2, String field3) {
		super();
		this.field1 = field1;
		this.field2 = field2;
		this.field3 = field3;
	}

	public String getField1() {
		return field1;
	}

	public String getField2() {
		return field2;
	}

	public String getField3() {
		return field3;
	}

	@Override
	public String toString() {
		return "SomeBean [field1=" + field1 + ", field2=" + field2 + ", field3=" + field3 + "]";
	}
     
	
     
}

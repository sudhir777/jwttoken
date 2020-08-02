package com.javatechie.jwt.api.entity;

import java.io.Serializable;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"categories"
})
public class Test implements Serializable
{

@Override
	public String toString() {
		return "Test [categories=" + categories + "]";
	}

@JsonProperty("categories")
private List<Category> categories = null;
private final static long serialVersionUID = 7387849948925620227L;

@JsonProperty("categories")
public List<Category> getCategories() {
return categories;
}

@JsonProperty("categories")
public void setCategories(List<Category> categories) {
this.categories = categories;
}

}

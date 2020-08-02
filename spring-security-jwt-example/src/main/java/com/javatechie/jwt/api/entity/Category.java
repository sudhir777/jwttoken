
package com.javatechie.jwt.api.entity;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"name",
"videos"
})
public class Category implements Serializable
{

@JsonProperty("name")
private String name;
@JsonProperty("videos")
private List<Video> videos = null;
private final static long serialVersionUID = 5969166185877602767L;

@JsonProperty("name")
public String getName() {
return name;
}

@JsonProperty("name")
public void setName(String name) {
this.name = name;
}

@JsonProperty("videos")
public List<Video> getVideos() {
return videos;
}

@JsonProperty("videos")
public void setVideos(List<Video> videos) {
this.videos = videos;
}

@Override
public String toString() {
	return "Category [name=" + name + ", videos=" + videos + "]";
}

}
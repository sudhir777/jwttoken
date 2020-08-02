
package com.javatechie.jwt.api.entity;

import java.io.Serializable;
import java.util.List;


import java.io.Serializable;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"description",
"sources",
"subtitle",
"thumb",
"title"
})
public class Video implements Serializable
{

@JsonProperty("description")
private String description;
@JsonProperty("sources")
private List<String> sources = null;
@JsonProperty("subtitle")
private String subtitle;
@JsonProperty("thumb")
private String thumb;
@JsonProperty("title")
private String title;
private final static long serialVersionUID = -165785087356997446L;

@JsonProperty("description")
public String getDescription() {
return description;
}

@JsonProperty("description")
public void setDescription(String description) {
this.description = description;
}

@JsonProperty("sources")
public List<String> getSources() {
return sources;
}

@JsonProperty("sources")
public void setSources(List<String> sources) {
this.sources = sources;
}

@JsonProperty("subtitle")
public String getSubtitle() {
return subtitle;
}

@JsonProperty("subtitle")
public void setSubtitle(String subtitle) {
this.subtitle = subtitle;
}

@JsonProperty("thumb")
public String getThumb() {
return thumb;
}

@JsonProperty("thumb")
public void setThumb(String thumb) {
this.thumb = thumb;
}

@JsonProperty("title")
public String getTitle() {
return title;
}

@JsonProperty("title")
public void setTitle(String title) {
this.title = title;
}

@Override
public String toString() {
	return "Video [description=" + description + ", sources=" + sources + ", subtitle=" + subtitle + ", thumb=" + thumb
			+ ", title=" + title + "]";
}

}
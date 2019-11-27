package com.java.dto;

import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.java.dto.Reply;

import lombok.Builder;
import lombok.Builder.Default;
import lombok.Data;

@Entity
@Builder
@Data
public class Comment {
	
	
	@Id
	private int id;
	private int pid;
	@Default
	private String username ="user not found";
	@Default
	private double rating = 5.0;
	@Default
	private String text = "no comments yet";
	@ElementCollection
	@Embedded
	private List<Reply> replies;
	//private String imageUrl;
	
	@Override
	public String toString() {
		String result = "Rating: "+ rating + "\n" + username + ":    "+ text+"\n";
		if(this.getReplies() != null) {
			for (int i=0; i<replies.size();i++) {
				result += "\t" + replies.get(i) + "\n";
			}
		}else {	
		}
		return result;
	}
}

package models;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import utils.ExcludeFromJson;

import com.google.gson.annotations.Expose;

@Entity
public class ClientComment extends Comment {

	@ManyToOne
	@ExcludeFromJson
	public Client client;
	
}

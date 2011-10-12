package models;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class ClientComment extends Comment {

	@ManyToOne
	public Client client;
	
}

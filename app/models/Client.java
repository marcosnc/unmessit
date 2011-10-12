package models;

import java.util.Date;
import java.util.List;

import play.*;
import play.db.jpa.*;

import javax.persistence.*;

@Entity
public class Client extends Model {
    
	public Date   createdOn;

	public String name;
	public String surname;
	public String description;
	public Date   birthday;
	
	public String address;
	public String tels;
	public String emails;
	public String twitter;
	public String facebook;
	public String webs;
	
	public Blob   image;
	
	@OneToMany(mappedBy="client")
	public List<ClientComment> comments;
	
}

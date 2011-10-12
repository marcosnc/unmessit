package models;

import play.*;
import play.db.jpa.*;

import javax.persistence.*;
import java.util.*;

@MappedSuperclass
public abstract class Comment extends Model {
    public Date   addedOn;
    public String text;
}

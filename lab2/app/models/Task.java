package models;

import java.util.*;

import javax.persistence.Entity;
import javax.persistence.Id;

import play.data.validation.Constraints.*;
import play.db.ebean.Model;

@Entity
public class Task extends Model{
   
  @Id
  public Long id;
  @Required
  public String label;
  
  public static Finder<Long,Task> find = new Finder(Long.class, Task.class);
  
  public static List<Task> all() {
    return new ArrayList<Task>();
  }
  
  public static void create(Task task) {
	  task.save();
  }
  
  public static void delete(Long id) {
	  find.ref(id).delete();
  }
    
}

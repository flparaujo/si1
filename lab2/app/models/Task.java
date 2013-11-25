package models;

import java.util.*;

import play.db.ebean.*;
import play.data.validation.Constraints.*;

import javax.persistence.*;

@Entity
public class Task extends Model {

  @Id
  public Long id;
  
  @Required
  private String label;
  
  @Required
  private int prioridade;
  
  private String projetoAssociado;
  
  private boolean finished;
  
  public static Finder<Long,Task> find = new Finder(Long.class, Task.class);
  
  public static List<Task> all(String prioridade) {
	  return find.orderBy(prioridade).findList();
  }
  
  public static void create(Task task) {
	  task.save();
  }
  
  public static void delete(Long id) {
	  find.ref(id).delete();
  }
  
  public void setLabel(String label) {
	  this.label = label;
  }
  
  public String getLabel() {
	  return label;
  }
  
  public void finish(boolean finished) {
	  this.finished = finished;
	  update();
  }
  
  public boolean isFinished() {
	  return finished;
  }
  
  public void setPrioridade(int prioridade) {
	  this.prioridade = prioridade;
  }
  
  public int getPrioridade() {
	  return prioridade;
  }
  
  public void setProjetoAssociado(String projetoAssociado) {
	  this.projetoAssociado = projetoAssociado;
  }
  
  public String getProjetoAssociado() {
	  return projetoAssociado;
  }
    
}

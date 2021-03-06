package java01.exam10.vo;

import java.io.Serializable;

public class Task implements Serializable {
  private static final long serialVersionUID = 1L;
  
  public static final int READY = 0;
  public static final int COMPLETE = 1;
  public static final int CANCEL = 2;
  
	int 			no;
	String 	title;
	int			state;
	Member		worker;
	
	@Override
  public String toString() {
	  return "Task [no=" + no + ", title=" + title + ", state=" + state + "]";
  }
	
	@Override
  public int hashCode() {
	  final int prime = 31;
	  int result = 1;
	  result = prime * result + no;
	  result = prime * result + state;
	  result = prime * result + ((title == null) ? 0 : title.hashCode());
	  return result;
  }
	
	@Override
  public boolean equals(Object obj) {
	  if (this == obj)
		  return true;
	  if (obj == null)
		  return false;
	  if (getClass() != obj.getClass())
		  return false;
	  Task other = (Task) obj;
	  if (no != other.no)
		  return false;
	  if (state != other.state)
		  return false;
	  if (title == null) {
		  if (other.title != null)
			  return false;
	  } else if (!title.equals(other.title))
		  return false;
	  return true;
  }
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public Member getWorker() {
		return worker;
	}
	public void setWorker(Member worker) {
		this.worker = worker;
	}
	
	
}

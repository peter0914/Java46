package spms.controls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import spms.dao.TaskDao;
import spms.vo.Member;

@Controller
@RequestMapping("/task")
@SessionAttributes("loginUser")
public class TaskControl {
	@Autowired
	TaskDao taskDao;
	
	@RequestMapping("/myTasks")
	public String myTasks(	@ModelAttribute("loginUser") Member loginUser,
			Model model) throws Exception {
		model.addAttribute("tasks", 
				taskDao.selectMyTasks(loginUser.getNo()));
		
		return "task/myTasks";
	}
	
}







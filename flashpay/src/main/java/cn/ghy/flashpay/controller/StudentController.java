package cn.ghy.flashpay.controller;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.ghy.flashpay.model.card;
import cn.ghy.flashpay.model.student;
import cn.ghy.flashpay.service.StudentService;
import cn.ghy.flashpay.util.JSON;
import cn.ghy.flashpay.util.Message;

@Controller
@RequestMapping(value = "/student")
public class StudentController {

	private StudentService studentService = new StudentService();
	private Message msg = new Message();

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseBody
	public Message add(@RequestBody student stu) {        
		boolean result = studentService.addStu(stu);
		if(result){
			msg.setMsg("注册成功");
		}else{
			msg.setMsg("注册失败");
		}
		return msg;
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@ResponseBody
	public String add(@RequestBody String request){
		try {
			JSONObject jsonObject = new JSONObject(request);
			JSONObject returnJSON = new JSONObject();
			String stu_id = jsonObject.getString("id");
			String pwd = jsonObject.getString("pwd");
			student stu = studentService.login(stu_id, pwd);
			card card = studentService.isActive(stu_id);
			
			if(stu == null){
				returnJSON.put("student", "");
			}else{
				returnJSON.put("student", new JSON(stu).Object2JSON());
			}
			if(card == null){
				returnJSON.put("card", "");
			}else{
				card.setBegintime(null);//日期格式在json转object的时候有问题
				card.setEndtime(null);
				returnJSON.put("card", new JSON(card).Object2JSON());
			}
			
			return returnJSON.toString();
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@RequestMapping(value="/error", method = RequestMethod.GET)
	public void error(){
		
	}
}

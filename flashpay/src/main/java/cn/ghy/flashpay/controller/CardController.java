package cn.ghy.flashpay.controller;

import java.sql.Timestamp;
import java.util.Date;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.ghy.flashpay.model.card;
import cn.ghy.flashpay.service.CardService;
import cn.ghy.flashpay.service.StudentService;
import cn.ghy.flashpay.util.Message;

@Controller
@RequestMapping(value = "/card")
public class CardController {

	private CardService cardService = new CardService();
	private StudentService studentService = new StudentService();
	private Message msg = new Message();

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseBody
	public Message add(@RequestBody card entity) {
		
		entity.setBegintime(new Timestamp(new Date().getTime()));
		
		boolean result = cardService.addCard(entity);
		card card = studentService.isActive(entity.getStuId());
		if(result){
			msg.setMsg(card.getId().toString());
		}else{
			msg.setMsg("error");
		}
		return msg;
	}
	
	@RequestMapping(value = "/loss", method = RequestMethod.POST)
	@ResponseBody
	public Message loss(@RequestBody String request){
		try {
			JSONObject jsonObject = new JSONObject(request);
			if(cardService.lossCard(jsonObject.getString("stuId"))){
				msg.setMsg("success");
			}else{
				msg.setMsg("error");
			}
		} catch (JSONException e) {
			e.printStackTrace();
		}
		
		return msg;
	}
}

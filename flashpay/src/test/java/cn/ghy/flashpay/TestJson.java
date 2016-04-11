package cn.ghy.flashpay;

import cn.ghy.flashpay.service.CardService;

public class TestJson {

	public static void main(String args[]){
		CardService cardService = new CardService();
		System.out.println(cardService.lossCard("41211017"));
	}
}

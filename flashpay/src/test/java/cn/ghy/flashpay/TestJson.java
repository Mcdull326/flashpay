package cn.ghy.flashpay;

import cn.ghy.flashpay.model.admin;
import cn.ghy.flashpay.service.AdminService;

public class TestJson {

	public static void main(String args[]){
		AdminService adminService = new AdminService();
		admin admin = new admin();
		admin = adminService.getAll().get(0);
		
		System.out.println(admin.getName());
	}
}

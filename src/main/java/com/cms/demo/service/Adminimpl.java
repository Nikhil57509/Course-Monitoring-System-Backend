package com.cms.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cms.demo.model.Adminmodel;
import com.cms.demo.repo.Adminrepo;

@Service
public class Adminimpl implements Adminservice {
	@Autowired
	private Adminrepo adminrepo;

	public String admin(String uadminname, String password) {
		Adminmodel admin=adminrepo.findbyadmin(uadminname);
		if (admin != null && admin.getPassword().equals(password)) {
            return "success";
        } else {
            return "Invalid username or password";
        }
	}

}

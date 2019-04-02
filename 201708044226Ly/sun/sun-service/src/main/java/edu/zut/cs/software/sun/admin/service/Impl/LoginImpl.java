package edu.zut.cs.software.sun.admin.service.Impl;

import java.util.logging.Logger;

import edu.zut.cs.software.sun.admin.advice.LogAdvice;
import edu.zut.cs.software.sun.admin.service.Login;

public class LoginImpl implements Login {

	public void login() {
		Logger logger=Logger.getLogger(LogAdvice.class.getName());
		logger.info("==========π‹¿Ì‘±µ«¬º==========");	
	}

}

package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.FreePostDAO;
import model.FreePostVO;

public class UpdateFreePostFormController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		long no=Long.parseLong(request.getParameter("no"));

		
		return null;
	}

}

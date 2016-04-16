package com.weikun.service;

import java.util.List;

import com.weikun.dao.IMessageDAO;
import com.weikun.dao.MessageDAOImpl;
import com.weikun.vo.Message;

public class MessageServiceImpl implements IMessageService {
	private IMessageDAO dao=new MessageDAOImpl();
	@Override
	public boolean addMessage(Message message) {
		// TODO Auto-generated method stub
		return dao.addMessage(message);
	}
	@Override
	public List<Message> viewMessage() {
		// TODO Auto-generated method stub
		return dao.viewMessage();
	}
	@Override
	public boolean delMessage(int id) {
		// TODO Auto-generated method stub
		return dao.delMessage(id);
	}

}

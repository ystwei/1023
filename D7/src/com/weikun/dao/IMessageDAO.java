package com.weikun.dao;

import java.util.List;

import com.weikun.vo.Message;

public interface IMessageDAO {
	public boolean addMessage(Message message);
	public List<Message>  viewMessage();
	public boolean delMessage(int id);
}

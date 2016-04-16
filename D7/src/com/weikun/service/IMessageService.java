package com.weikun.service;

import java.util.List;

import com.weikun.vo.Message;

public interface IMessageService {
	public boolean addMessage(Message message) ;
	public List<Message> viewMessage() ;
	public boolean delMessage(int id) ;
}

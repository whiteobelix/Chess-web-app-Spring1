//TODO To delete
//TODO To delete
//TODO To delete
package com.capgemini.chess.service.impl;

import org.springframework.stereotype.Service;

import com.capgemini.chess.service.UserService;
import com.capgemini.chess.service.mapper.OpponentToListMapper;
import com.capgemini.chess.service.to.OpponentToListTO;
import com.capgemini.chess.service.to.UserProfileTO;

@Service
public class UserServiceImpl implements UserService {//dostaje ID a zwraca  UserProfileTO

	
	@Override
	public OpponentToListTO readUser(Long userID) {
		
		return OpponentToListTO();
	}
}

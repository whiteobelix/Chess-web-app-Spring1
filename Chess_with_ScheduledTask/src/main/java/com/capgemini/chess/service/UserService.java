package com.capgemini.chess.service;

import com.capgemini.chess.service.to.OpponentToListTO;

public interface UserService {//serwis
	
	public OpponentToListTO readUser(Long userID);
	
}

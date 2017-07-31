package com.capgemini.chess.dao;

import java.util.List;

public interface ExistingMatchDAO {
	
	List<Long> getIDOfPlayerWhosCreateMatch(Long userID);
	
	List<Long> getIDOfPlayerFromOpponentMatch(Long userID);
}

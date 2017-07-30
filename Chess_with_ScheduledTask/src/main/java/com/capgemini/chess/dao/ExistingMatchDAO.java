package com.capgemini.chess.dao;

import java.util.List;

public interface ExistingMatchDAO {
	// weź pary id : rzucającego i wyzwanego z meczów w ktorych uczestniczę (mecze, które załozył uzytkownik + mecze od innych graczy)
	List<Long> getIDOfPlayerWhosCreateMatch(Long userID);
	
	// mecze od innych graczy (ID innych graczy - twórców meczów)
	List<Long> getIDOfPlayerFromOpponentMatch(Long userID);
}

package com.capgemini.chess.dao;

import com.capgemini.chess.service.to.OpponentToListTO;

public interface UserPublicProfileDAO {
	
	OpponentToListTO showPublicProfile(Long opponentID);
}

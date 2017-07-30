package com.capgemini.chess.service;

import java.util.List;

import com.capgemini.chess.service.to.ActualUserIDTO;
import com.capgemini.chess.service.to.MatchTO;
import com.capgemini.chess.service.to.OpponentToListTO;

public interface UserFunctionsService {
	List<OpponentToListTO> getMatches(ActualUserIDTO actualUser); //ok
	OpponentToListTO showPublicProfile(Long opponentID); //ok
	MatchTO createNewMatch(Long playerID, Long opponentID); //TODO
	
}

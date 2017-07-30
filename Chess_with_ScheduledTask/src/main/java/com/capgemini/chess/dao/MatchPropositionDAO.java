package com.capgemini.chess.dao;

import java.util.List;

import com.capgemini.chess.service.to.OpponentToListTO;

public interface MatchPropositionDAO {
	
	List<OpponentToListTO> matchPropositions(Long max, Long min);
//	źle List<MatchTO> matchPropositions(Long userID);//pobierz graczy i sprawdź ID	potencjalne mecze	
	
	List<OpponentToListTO> opponentsByID(List <Long> opponentsID);
	
	
	
}

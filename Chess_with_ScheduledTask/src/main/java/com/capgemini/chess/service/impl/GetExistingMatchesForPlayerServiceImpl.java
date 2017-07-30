package com.capgemini.chess.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.chess.dao.ExistingMatchDAO;
import com.capgemini.chess.dao.MatchPropositionDAO;
import com.capgemini.chess.service.GetExistingMatchesForPlayerService;
import com.capgemini.chess.service.to.ActualUserIDTO;
import com.capgemini.chess.service.to.OpponentToListTO;

@Service
public class GetExistingMatchesForPlayerServiceImpl implements GetExistingMatchesForPlayerService{
	//////pobierz rekordy z dao meczów i z parsera osób;
	//////getMatchesForPlayer(userId)

	ExistingMatchDAO existingMatches;
	MatchPropositionDAO matchPropositions;
	
	@Autowired
	public GetExistingMatchesForPlayerServiceImpl (ExistingMatchDAO existingMatches, MatchPropositionDAO matchPropositions){
		this.existingMatches = existingMatches;
		this.matchPropositions = matchPropositions;
	}

	// metoda 1.: dla podanego ID pobierz mecze (DAO meczu) dla tego ID   NAPISAĆ DAO MECZU
	// metoda 2.: dla ID z podanych meczów pobierz infomacje o graczach   NAPISAC DAO GRACZA (BEZ HASŁA ITP)
	
	@Override
	public List<OpponentToListTO> getExistingMatchesForPlayer(ActualUserIDTO actualUser) {
		
		List <Long> usersID = existingMatches.getIDOfPlayerWhosCreateMatch(actualUser.getId());

		return matchPropositions.opponentsByID(usersID);
	}

}

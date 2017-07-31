package com.capgemini.chess.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.chess.dao.ExistingMatchDAO;
import com.capgemini.chess.dao.MatchPropositionDAO;
import com.capgemini.chess.service.GetExistingMatchesForPlayerService;
import com.capgemini.chess.service.to.ActualUserIDTO;
import com.capgemini.chess.service.to.OpponentToListTO;
/**
 * 
 * @author PMUNTOWS
 *
 */
@Service
public class GetExistingMatchesForPlayerServiceImpl implements GetExistingMatchesForPlayerService{

	ExistingMatchDAO existingMatches;
	MatchPropositionDAO matchPropositions;
	
	@Autowired
	public GetExistingMatchesForPlayerServiceImpl (ExistingMatchDAO existingMatches, MatchPropositionDAO matchPropositions){
		this.existingMatches = existingMatches;
		this.matchPropositions = matchPropositions;
	}
	/**
	 * Method for providing existing matches for actual user.
	 */
	@Override
	public List<OpponentToListTO> getExistingMatchesForPlayer(ActualUserIDTO actualUser) {
		
		List <Long> usersID = existingMatches.getIDOfPlayerWhosCreateMatch(actualUser.getId());

		return matchPropositions.opponentsByID(usersID);
	}

}

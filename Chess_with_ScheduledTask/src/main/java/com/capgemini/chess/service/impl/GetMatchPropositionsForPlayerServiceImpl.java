package com.capgemini.chess.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.chess.dao.ExistingMatchDAO;
import com.capgemini.chess.dao.MatchPropositionDAO;
import com.capgemini.chess.dao.UserPublicProfileDAO;
import com.capgemini.chess.service.GetMatchPropositionsForPlayerService;
import com.capgemini.chess.service.to.ActualUserIDTO;
import com.capgemini.chess.service.to.OpponentToListTO;
/**
 * Contains method for providing match propositions for actual user.
 * @author PMUNTOWS
 *
 */
@Service
public class GetMatchPropositionsForPlayerServiceImpl implements GetMatchPropositionsForPlayerService{

	ExistingMatchDAO existingMatchDAO = null;
	MatchPropositionDAO matchPropositionDAO = null;
	UserPublicProfileDAO userProfileDAO = null;
	
	@Autowired
	public GetMatchPropositionsForPlayerServiceImpl(ExistingMatchDAO existingMatchDAO, MatchPropositionDAO matchPropositionDAO, UserPublicProfileDAO userProfileDAO) {
		this.existingMatchDAO = existingMatchDAO;
		this.matchPropositionDAO = matchPropositionDAO;
		this.userProfileDAO = userProfileDAO;
	}
	/**
	 * Method for providing match propositions for actual user with some experience level.
	 */
	@Override
	public List<OpponentToListTO> getMatchPropositionsForPlayer(ActualUserIDTO actualUser) {
		Long propositionsLimit = 5L;
		OpponentToListTO user = userProfileDAO.showPublicProfile(actualUser.getId());
		Long userLevel = user.getLevel();
		Long min = 1L;
		Long max = userLevel + 2L;
		
		if(userLevel < 3){
			min = 1L;
		}else if(userLevel >= 3L){
			min = userLevel - 2L;
		}	
		List <OpponentToListTO> matchPropositions = matchPropositionDAO.matchPropositions(max, min);
		List <Long> opponentsIDFromExistingMatch = existingMatchDAO.getIDOfPlayerFromOpponentMatch(actualUser.getId());
		opponentsIDFromExistingMatch.addAll(existingMatchDAO.getIDOfPlayerWhosCreateMatch(actualUser.getId()));	
		
		return matchPropositions.stream().filter(o -> !opponentsIDFromExistingMatch.contains(o.getId())).limit(propositionsLimit).collect(Collectors.toList());
	}

}

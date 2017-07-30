package com.capgemini.chess.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.chess.dao.UserPublicProfileDAO;
import com.capgemini.chess.service.GetExistingMatchesForPlayerService;
import com.capgemini.chess.service.GetMatchPropositionsForPlayerService;
import com.capgemini.chess.service.to.MatchTO;
import com.capgemini.chess.service.UserFunctionsService;
import com.capgemini.chess.service.to.ActualUserIDTO;
import com.capgemini.chess.service.to.OpponentToListTO;

@Service
public class UserFunctionsServiceImpl implements UserFunctionsService{

	private GetExistingMatchesForPlayerService getExistingMatchesForPlayerService = null;
	private GetMatchPropositionsForPlayerService getMatchPropositionsForPlayerService = null;
	private UserPublicProfileDAO userPublicProfileDAO = null;

	@Autowired
	UserFunctionsServiceImpl(GetExistingMatchesForPlayerService getExistingMatchesForPlayerService, GetMatchPropositionsForPlayerService getMatchPropositionsForPlayerService, UserPublicProfileDAO userPublicProfileDAO){
		this.getExistingMatchesForPlayerService = getExistingMatchesForPlayerService;
		this.getMatchPropositionsForPlayerService = getMatchPropositionsForPlayerService;
		this.userPublicProfileDAO = userPublicProfileDAO;
	}
	
	@Override
	public List<OpponentToListTO> getMatches(ActualUserIDTO actualUser) {
		List<OpponentToListTO> matchesList = new ArrayList<>();
		matchesList.addAll(getExistingMatchesForPlayerService.getExistingMatchesForPlayer(actualUser));//najpierw na liście będą mecze istniejące
		matchesList.addAll(getMatchPropositionsForPlayerService.getMatchPropositionsForPlayer(actualUser));//później na liście będą propozycje 
		//łączy listy
	
		return matchesList;
	}	

	@Override
	public OpponentToListTO showPublicProfile(Long opponentID) {
		return userPublicProfileDAO.showPublicProfile(opponentID);
	}
	
	@Override
	public MatchTO createNewMatch(Long userID, Long opponentID) {
		// TODO Auto-generated method stub
		return null;
	}
	
}

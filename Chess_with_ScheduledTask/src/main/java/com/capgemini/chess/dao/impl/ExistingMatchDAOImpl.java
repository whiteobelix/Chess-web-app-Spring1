package com.capgemini.chess.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.capgemini.chess.dao.ExistingMatchDAO;
import com.capgemini.chess.dataaccess.entities.MatchEntity;

/**
 * Data Access Object gives IDs from existing match.
 * @author PMUNTOWS
 *
 */
@Repository
public class ExistingMatchDAOImpl implements ExistingMatchDAO{

	List<MatchEntity> existingMatches = new ArrayList<>();
	
	/**
	 * Method gives ID list of players whose creates some matches.
	 */
	@Override
	public List<Long> getIDOfPlayerWhosCreateMatch(Long loggedPlayerID){
		List<Long> id = existingMatches.stream().filter(me -> loggedPlayerID.equals(me.getOpponentForPlayerID()))
				.map(me -> me.getPlayerID()).collect(Collectors.toList());		
		return id;
	}

	/**
	 * Method gives ID list of opponents from existing matches.
	 */
	@Override
	public List<Long> getIDOfPlayerFromOpponentMatch(Long loggedPlayerID){
		
		List<Long> id = existingMatches.stream().filter(me -> loggedPlayerID.equals(me.getOpponentForPlayerID()))
				.map(me -> me.getPlayerID()).collect(Collectors.toList());
		
		return id;
		
	}
	
}


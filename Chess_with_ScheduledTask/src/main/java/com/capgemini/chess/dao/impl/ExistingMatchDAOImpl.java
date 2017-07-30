package com.capgemini.chess.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.capgemini.chess.dao.ExistingMatchDAO;
import com.capgemini.chess.dataaccess.entities.MatchEntity;


@Repository
public class ExistingMatchDAOImpl implements ExistingMatchDAO{

	List<MatchEntity> existingMatches = new ArrayList<>();
	
	@Override
	public List<Long> getIDOfPlayerWhosCreateMatch(Long loggedPlayerID){//wyzwania rzucone przez innych graczy
		//Zwraca listę id przeciwników z wyzwań które oni rzucili mi.
		//Wyciąłem zbieranie swojego ID z moich meczów
		List<Long> id = existingMatches.stream().filter(me -> loggedPlayerID.equals(me.getOpponentForPlayerID()))
				.map(me -> me.getPlayerID()).collect(Collectors.toList());		
		return id;
	}

	@Override
	public List<Long> getIDOfPlayerFromOpponentMatch(Long loggedPlayerID){//wyzwania rzucone przeze mnie
		
		//zwraca listę ID osób, które wyzwałem
		List<Long> id = existingMatches.stream().filter(me -> loggedPlayerID.equals(me.getOpponentForPlayerID()))
				.map(me -> me.getPlayerID()).collect(Collectors.toList());
		
		return id;
		
	}
	
}


package com.capgemini.chess.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.capgemini.chess.dao.MatchPropositionDAO;
import com.capgemini.chess.dataaccess.entities.UserEntity;
import com.capgemini.chess.service.to.OpponentToListTO;
import com.capgemini.chess.service.mapper.OpponentToListMapper;

@Repository
public class MatchPropositionDAOImpl implements MatchPropositionDAO{
	
	Map<Long, UserEntity> users = new HashMap<>();//ok
	
	@Override
	public	List<OpponentToListTO> opponentsByID(List <Long> opponentsID){//zwraca listę profili przeciwników po ich ID
		return users.values().stream().filter(users -> opponentsID.contains(users.getId())).map(me -> OpponentToListMapper.opponentToListMapper(me)).collect(Collectors.toList());		
	};
	
	@Override
	public List<OpponentToListTO> matchPropositions(Long max, Long min) {//zwraca listę profili przeciwników w zakresie danych poziomów
		
		return users.values().stream().filter(u -> u.getStats().getLevel() <= max && u.getStats().getLevel() >= min).map(user -> OpponentToListMapper.opponentToListMapper(user)).collect(Collectors.toList());		
	}
//najpierw ta druga metoda
}

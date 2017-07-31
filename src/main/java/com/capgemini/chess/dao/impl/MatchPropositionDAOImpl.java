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
/**
 * Data Access Object gives list of opponents Transport Objects
 * @author PMUNTOWS
 *
 */
@Repository
public class MatchPropositionDAOImpl implements MatchPropositionDAO{
	
	Map<Long, UserEntity> users = new HashMap<>();
	
	/**
	 * Gives list of opponents TO's for given ID's.
	 */
	@Override
	public	List<OpponentToListTO> opponentsByID(List <Long> opponentsID){
		return users.values().stream().filter(users -> opponentsID.contains(users.getId())).map(me -> OpponentToListMapper.opponentToListMapper(me)).collect(Collectors.toList());		
	};
	
	/**
	 * Gives list of opponent TO's for match propositions with given experince level range (from -2 to +2).
	 */
	@Override
	public List<OpponentToListTO> matchPropositions(Long max, Long min) {
		
		return users.values().stream().filter(u -> u.getStats().getLevel() <= max && u.getStats().getLevel() >= min).map(user -> OpponentToListMapper.opponentToListMapper(user)).collect(Collectors.toList());		
	}
}

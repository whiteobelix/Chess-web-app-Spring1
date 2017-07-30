package com.capgemini.chess.dao.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.capgemini.chess.dao.UserPublicProfileDAO;
import com.capgemini.chess.dataaccess.entities.UserEntity;
import com.capgemini.chess.service.mapper.OpponentToListMapper;
import com.capgemini.chess.service.to.OpponentToListTO;

@Repository
public class UserPublicProfileDAOImpl implements UserPublicProfileDAO{

	//UserEntity opponent = new UserEntity();
	Map<Long, UserEntity> opponentProfile = new HashMap<>();

	@Override
	public OpponentToListTO showPublicProfile(Long opponentID) {
		//opponent.setId(opponentID);
		//return OpponentToListMapper.opponentToListMapper(opponent);
		
		return opponentProfile.values().stream().filter(o -> opponentID.equals(o.getId())).map(o -> OpponentToListMapper.opponentToListMapper(o)).collect(Collectors.toList()).get(0);
		
		//return opponentProfile;
//				.stream().filter(player -> ids.contains(player.getId()))
//				.map(c -> OpponentMapper.opponentMapper(c))
//				.collect(Collectors.toList());
	
//	@Override
//	public List<OpponentToListTO> showPublicProfile(Long opponentID) {
//		UserEntity userEntity = opponentProfile.values().stream().filter(o -> o.getId().equals(opponentID).);
//		return opponentProfile.values().stream().filter(o -> opponentID.equals(o.getId())).map(o -> OpponentToListMapper.opponentToListMapper(o)).collect(Collectors.toList());
//		
	
	}
	
//	return players.values()
//			.stream().filter(player -> ids.contains(player.getId()))
//			.map(c -> OpponentMapper.opponentMapper(c))
//			.collect(Collectors.toList())
}

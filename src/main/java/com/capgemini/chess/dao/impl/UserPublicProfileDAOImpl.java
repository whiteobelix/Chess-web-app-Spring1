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

	Map<Long, UserEntity> opponentProfile = new HashMap<>();

	/**
	 * Gives opponent TO for given ID with public informations (excluding password and email). 
	 */
	@Override
	public OpponentToListTO showPublicProfile(Long opponentID) {
		
		return opponentProfile.values().stream().filter(o -> opponentID.equals(o.getId())).map(o -> OpponentToListMapper.opponentToListMapper(o)).collect(Collectors.toList()).get(0);		
	}
}

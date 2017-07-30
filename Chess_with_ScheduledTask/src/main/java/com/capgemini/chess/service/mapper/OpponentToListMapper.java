package com.capgemini.chess.service.mapper;

import com.capgemini.chess.dataaccess.entities.StatsEntity;
import com.capgemini.chess.dataaccess.entities.UserEntity;
import com.capgemini.chess.service.to.OpponentToListTO;

public class OpponentToListMapper {

	public static OpponentToListTO opponentToListMapper(UserEntity userEntity) {
		OpponentToListTO opponentToListTO = new OpponentToListTO();

		opponentToListTO.setId(userEntity.getId());
		opponentToListTO.setLogin(userEntity.getLogin());
		opponentToListTO.setName(userEntity.getName());
		opponentToListTO.setSurname(userEntity.getSurname());
		opponentToListTO.setLevel(userEntity.getStats().getLevel());
		opponentToListTO.setPoints(userEntity.getStats().getPoints());
		opponentToListTO.setPlayed(userEntity.getStats().getPlayed());
		opponentToListTO.setWon(userEntity.getStats().getWon());
		opponentToListTO.setDrawn(userEntity.getStats().getDrawn());
		opponentToListTO.setLoss(userEntity.getStats().getLoss());

		return opponentToListTO;
	}

	
	
	//TODO To delete
	//TODO To delete
	//TODO To delete
	public static UserEntity userEntityMapper(OpponentToListTO opponentToListTO) {
		UserEntity userEntity = new UserEntity();
		StatsEntity statsEntity = new StatsEntity();

		userEntity.setId(opponentToListTO.getId());
		userEntity.setLogin(opponentToListTO.getLogin());
		userEntity.setName(opponentToListTO.getName());
		userEntity.setSurname(opponentToListTO.getSurname());
		userEntity.setStats(statsEntity.setLevel(opponentToListTO.getLevel()));
		opponentToListTO.setPoints(userEntity.getPoints());
		opponentToListTO.setPlayed(userEntity.getStats().getPlayed());
		opponentToListTO.setWon(userEntity.getStats().getWon());
		opponentToListTO.setDrawn(userEntity.getStats().getDrawn());
		opponentToListTO.setLoss(userEntity.getStats().getLoss());

		return userEntity;
	}
}

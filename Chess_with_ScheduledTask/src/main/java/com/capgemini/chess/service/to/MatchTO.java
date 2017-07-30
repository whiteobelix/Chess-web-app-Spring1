package com.capgemini.chess.service.to;

import com.capgemini.chess.status.Status;

public class MatchTO {//transportuje info o ID graczy w istniejącym meczu i status tego meczu, ew. jeszcze ID meczu
	Long matchID;
	Long playerID;
	Long opponentForPlayerID;
	Status status;
	
	public Long getMatchID() {
		return matchID;
	}
	public void setMatchID(Long matchID) {
		this.matchID = matchID;
	}
	public Long getPlayerID() {
		return playerID;
	}
	public void setPlayerID(Long playerID) {
		this.playerID = playerID;
	}
	public Long getOpponentForPlayerID() {
		return opponentForPlayerID;
	}
	public void setOpponentForPlayerID(Long opponentForPlayerID) {
		this.opponentForPlayerID = opponentForPlayerID;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	

}

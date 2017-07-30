package com.capgemini.chess.dataaccess.entities;

import com.capgemini.chess.status.Status;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Entity;

@Entity
public class MatchEntity {

	@Id
	@GeneratedValue
	private Long matchID;
	@Column
	private Long playerID;
	@Column
	private Long opponentForPlayerID;
	@Column
	private Status status;
	
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

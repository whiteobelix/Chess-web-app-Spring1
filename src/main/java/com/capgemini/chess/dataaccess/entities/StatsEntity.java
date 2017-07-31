package com.capgemini.chess.dataaccess.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
/**
 * Entity of user statistics
 * @author PMUNTOWS
 *
 */
@Entity
public class StatsEntity {

	@Id
	private Long userID;
	@Column
	private Long level;
	@Column
	private Long points;
	private Long played;
	private Long won;
	private Long drawn;
	private Long loss;
	
	public Long getUserID() {
		return userID;
	}
	public void setUserID(Long userID) {
		this.userID = userID;
	}
	public Long getLevel() {
		return level;
	}
	public void setLevel(Long level) {
		this.level = level;
	}
	public Long getPoints() {
		return points;
	}
	public void setPoints(Long points) {
		this.points = points;
	}
	public Long getPlayed() {
		return played;
	}
	public void setPlayed(Long played) {
		this.played = played;
	}
	public Long getWon() {
		return won;
	}
	public void setWon(Long won) {
		this.won = won;
	}
	public Long getDrawn() {
		return drawn;
	}
	public void setDrawn(Long drawn) {
		this.drawn = drawn;
	}
	public Long getLoss() {
		return loss;
	}
	public void setLoss(Long loss) {
		this.loss = loss;
	}
	
}

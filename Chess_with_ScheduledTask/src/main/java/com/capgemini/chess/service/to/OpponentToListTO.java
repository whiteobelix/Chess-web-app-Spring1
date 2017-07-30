package com.capgemini.chess.service.to;

public class OpponentToListTO {//TO do pokazywania info o graczu na liście meczów
	private Long id; //id jakiegoś gracza
	private String login;
	private String Name;
	private String Surname;
	private Long level; //dodać w serwisie liczącym punkty
	private Long points;
	private Long played;
	private Long won;
	private Long drawn;
	private Long loss;
	
	public Long getId() {
		return id;		
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getSurname() {
		return Surname;
	}
	public void setSurname(String surname) {
		Surname = surname;
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

package com.capgemini.chess.status;

public enum Status {
	received, // otrzymane
	awaiting, // wysłane - oczekujące
	finished, // zakończone
	started; // w trkacie gry
}

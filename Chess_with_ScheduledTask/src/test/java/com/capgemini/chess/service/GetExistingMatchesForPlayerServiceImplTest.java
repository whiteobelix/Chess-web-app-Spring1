package com.capgemini.chess.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import com.capgemini.chess.dao.ExistingMatchDAO;
import com.capgemini.chess.dao.MatchPropositionDAO;
import com.capgemini.chess.service.impl.GetExistingMatchesForPlayerServiceImpl;
import com.capgemini.chess.service.to.ActualUserIDTO;
import com.capgemini.chess.service.to.OpponentToListTO;
import com.capgemini.chess.service.GetExistingMatchesForPlayerService;


@RunWith(MockitoJUnitRunner.class)
public class GetExistingMatchesForPlayerServiceImplTest {	

@Mock
ExistingMatchDAO existingMatches;

@Mock
MatchPropositionDAO matchPropositions;

@Test
public void shouldReturnTwoExistingMatchesForUser(){
	
	//given
	ActualUserIDTO actualUserIDTO = new ActualUserIDTO();
	actualUserIDTO.setId(1L);
	
	List<Long> usersIDs = addUsersIDs();
	List <OpponentToListTO> matches = addMatches();
	
	when(existingMatches.getIDOfPlayerFromOpponentMatch(actualUserIDTO.getId())).thenReturn(usersIDs);
	when(matchPropositions.opponentsByID(Matchers.anyListOf(Long.class))).thenReturn(matches);	
	
	GetExistingMatchesForPlayerService getExistingMatchesForPlayerService = new GetExistingMatchesForPlayerServiceImpl(existingMatches, matchPropositions);
	//when
	matches = getExistingMatchesForPlayerService.getExistingMatchesForPlayer(actualUserIDTO);
	
	//then
	assertEquals(2, matches.size());
	assertNotEquals(0, matches.size());
	}

@Test
public void shouldReturnExistingMatchesForUser(){
	
	//given
	ActualUserIDTO actualUserIDTO = new ActualUserIDTO();
	actualUserIDTO.setId(1L);
	
	List<Long> usersIDs = new ArrayList <>();
	List <OpponentToListTO> matches = new ArrayList<>();
	
	when(existingMatches.getIDOfPlayerFromOpponentMatch(actualUserIDTO.getId())).thenReturn(usersIDs);
	when(matchPropositions.opponentsByID(Matchers.anyListOf(Long.class))).thenReturn(matches);	
	
	GetExistingMatchesForPlayerService getExistingMatchesForPlayerService = new GetExistingMatchesForPlayerServiceImpl(existingMatches, matchPropositions);
	//when
	matches = getExistingMatchesForPlayerService.getExistingMatchesForPlayer(actualUserIDTO);
	
	//then
	assertEquals(0, matches.size());
	
	}





	List<Long> addUsersIDs(){
		List <Long> usersIDs = new ArrayList<>();
		usersIDs.add(11L);
		usersIDs.add(12L);
		return usersIDs;
	}

	List <OpponentToListTO> addMatches (){
	List<OpponentToListTO> matches = new ArrayList<>();
	
	OpponentToListTO someOpponent1 = new OpponentToListTO();
	someOpponent1.setId(11L);
	OpponentToListTO someOpponent2 = new OpponentToListTO();
	someOpponent2.setId(12L);
	matches.add(someOpponent1);
	matches.add(someOpponent2);
	return matches;
	}









}

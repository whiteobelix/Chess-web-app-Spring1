package com.capgemini.chess.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
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
public void shouldReturnTrueIfXXX(){
	
	//given
	ActualUserIDTO actualUserIDTO = new ActualUserIDTO();
	actualUserIDTO.setId(1L);
	
	List<Long> usersIDs = addUsersIDs();
	List <OpponentToListTO> matches = addMatches();
	
	
	when(existingMatches.getIDOfPlayerFromOpponentMatch(actualUserIDTO.getId())).thenReturn(usersIDs);
	when(matchPropositions.opponentsByID(usersIDs)).thenReturn(matches);	
	
	GetExistingMatchesForPlayerService getExistingMatchesForPlayerService = new GetExistingMatchesForPlayerServiceImpl(existingMatches, matchPropositions);
	
	//when
	matches = getExistingMatchesForPlayerService.getExistingMatchesForPlayer(actualUserIDTO);
	
	//then
	System.out.println(matches);
	assertEquals(2, matches.size());
	
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

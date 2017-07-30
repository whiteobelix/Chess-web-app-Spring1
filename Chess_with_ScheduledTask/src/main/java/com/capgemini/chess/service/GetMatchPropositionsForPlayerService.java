package com.capgemini.chess.service;

import java.util.List;

import com.capgemini.chess.service.to.ActualUserIDTO;
import com.capgemini.chess.service.to.OpponentToListTO;

public interface GetMatchPropositionsForPlayerService {

	List<OpponentToListTO> getMatchPropositionsForPlayer(ActualUserIDTO actualUser);

}

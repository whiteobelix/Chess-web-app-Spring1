package com.capgemini.chess.service;

import java.util.List;

import com.capgemini.chess.service.to.ActualUserIDTO;
import com.capgemini.chess.service.to.OpponentToListTO;

public interface GetExistingMatchesForPlayerService {
	//mecze wysłane
	//mecze otrzymane (wezwania od przeciwników)
	List<OpponentToListTO> getExistingMatchesForPlayer(ActualUserIDTO actualUser);
}

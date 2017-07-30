package com.capgemini.chess.service;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.hamcrest.Matchers.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.capgemini.chess.service.impl.UserServiceImpl;
import com.capgemini.chess.service.to.UserProfileTO;
import com.capgemini.chess.batch.*;
import com.capgemini.chess.dao.ExistingMatchDAO;
import com.capgemini.chess.dao.MatchPropositionDAO;
import com.capgemini.chess.dataaccess.*;
import com.capgemini.chess.dataaccess.entities.*;
import com.capgemini.chess.repository.*;
import com.capgemini.chess.service.*;
import com.capgemini.chess.service.impl.*;
import com.capgemini.chess.service.mapper.*;
import com.capgemini.chess.service.to.*;

@RunWith(MockitoJUnitRunner.class)
@ContextConfiguration

public class UserFunctionServiceImplTest {

		@Mock

		@Configuration
		static class RankServiceTestContextConfiguration {
			@Bean
			public UserService userService() {
				return new UserServiceImpl();
			}
			
		}

		@Test
		public void testReadUserSuccessful() throws Exception {

			// when
			UserProfileTO userTO = service.readUser(1L);
			
			//then
			assertNotNull(userTO);
		}

	}

	
	
}

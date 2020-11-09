
package gt.training;

import com.gt.training.model.request.RoundOneReq;
import com.gt.training.model.response.RoundOneResponse;
import com.gt.training.Application;
import com.gt.training.service.TrainingService;
import com.gt.training.service.impl.TrainingServiceImpl;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;


import static org.junit.Assert.assertThat;


/**
 * Created by WeiHang on 2020/02/22.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
@WebAppConfiguration
public class TrainingTest {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	MockMvc mvc;
	private RequestBuilder request;

	@Autowired
	WebApplicationContext webApplicationContext;

	@Autowired
	private TrainingService trainingService;

    @Autowired
    private TrainingServiceImpl trainingServiceImpl;

	@Before
	public void setUp() {
		mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}


    @Test
    public void testLocal() throws Exception {

        /**
         * 3,5,7,10 (12Fizz4BuzzFizzWhizz8FizzBuzz)
         */
        StringBuffer content = new StringBuffer();
        for (int i = 1; i <= 10; i++) {
            String name = trainingServiceImpl.getName(3,5,7,i);
            content.append(name);
        }
        logger.info("content===="+content);
        assertThat(content.toString(), Matchers.equalTo("12Fizz4BuzzFizzWhizz8FizzBuzz"));

        /**
         * 3,5,9,10 (12Fizz4BuzzFizz78FizzWhizzBuzz)
         */
        StringBuffer content2 = new StringBuffer();
        for (int i = 1; i <= 10; i++) {
            String name = trainingServiceImpl.getName(3,5,9,i);
            content2.append(name);
        }
        logger.info("content2===="+content2);
        assertThat(content2.toString(), Matchers.equalTo("12Fizz4BuzzFizz78FizzWhizzBuzz"));

    }

	@Test
    //@Ignore
	public void testService() throws Exception {

        /** 1.test digit is zero */
        //roundOneApi(3,5,7,0);
        //roundOneApi(0,5,7,10);

        /** 2.test special digit is not a single digit */
        //roundOneApi(11,5,7,10);

        /** 3.test normal digit */
        roundOneApi(3,5,7,10);
	}


    private void roundOneApi(int num1, int num2, int num3 ,int num) throws Exception {

        RoundOneReq roundOneReq = new RoundOneReq();
        roundOneReq.setSpecialNumberFirst(num1);
        roundOneReq.setSpecialNumberSecond(num2);
        roundOneReq.setSpecialNumberThird(num3);
        roundOneReq.setNumber(num);

        logger.info("request===="+roundOneReq);
        RoundOneResponse response = trainingService.roundOne(roundOneReq);
        logger.info("response===="+response);

        Assert.assertNotNull(response);
        assertThat(response.getMessage(), Matchers.containsString("success"));
        assertThat(response.getRespCode(),Matchers.containsString("200"));
        logger.info("file path===="+response.getResponseBody().getFilePath());
    }

}

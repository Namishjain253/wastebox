///**
// * 
// */
//package org.skillassure.wastebox.unittest.ewaste.qualitycheck;
//
//import static org.mockito.BDDMockito.given;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.skillassure.wastebox.unittest.ApplicationTestConfig;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.MediaType;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import org.springframework.test.context.web.WebAppConfiguration;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.skillassure.wastebox.businesslayer.ewaste.qualitycheckimpl.QualityCheckService;
//import com.skillassure.wastebox.model.ewaste.product.Product;
//import com.skillassure.wastebox.model.ewaste.qualitycheck.QualityCheck;
//import com.skillassure.wastebox.restapi.ewaste.qualitycheck.QualityCheckController;
//
//
//
///**
// * @author Raghavendra
// *
// */
//
//@SpringBootTest
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes = ApplicationTestConfig.class)
//@WebAppConfiguration
//public class QualityCheckControllerTest {
//
//	@Autowired
//	private QualityCheckController controller;
//	
//	@MockBean
//	private QualityCheckService service;
//	
//	private MockMvc mockMvc;
//
//	private List<QualityCheck> qualityChecks;
//	
//	/**
//	 * Befor test adding Mock data
//	 */
//	@Before
//	public void initQualityChecks(){
//		this.mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
//		qualityChecks = new ArrayList<QualityCheck>();
//		QualityCheck qualityCheck1 = new QualityCheck(1,"Mobile","Samsung","2013",true, true, false,2,2,true,"Good"); 
//		QualityCheck qualityCheck2 = new QualityCheck(2,"Mobile","iphone","2017",true, true, false,3,4,true,"Good");
//		qualityChecks.add(qualityCheck1);
//		qualityChecks.add(qualityCheck2);
//	}
//	
//	/**
//	 * Checks whether getting all qualityChecks from service or not.
//	 */
//	@Test
//	public void testQualityChecks() throws Exception{
//		given(this.service.getAllQualityChecks()).willReturn(qualityChecks);
//		this.mockMvc.perform(get("/api/ewaste/qualitycheck"))
//		.andExpect(status().isOk())
//        .andExpect(content().contentType("application/json"))
//        .andExpect(jsonPath("$.[0].productName").value("samsung"))
//        .andExpect(jsonPath("$.[0].modelYear").value("2013"))
//        .andExpect(jsonPath("$.[1].productName").value("iphone"))
//        .andExpect(jsonPath("$.[1].modelYear").value("2017"));
//	}
//
//	/**
//	 * checks whether not found exception will return or not if qualitycheck list empty.
//	 */
//	@Test
//	public void testQualityChecksNotFound() throws Exception{
//		qualityChecks.clear();
//    	given(this.service.getAllQualityChecks()).willReturn(qualityChecks);
//        this.mockMvc.perform(get("/api/ewaste/qualitycheck/")
//        	.accept(MediaType.APPLICATION_JSON))
//            .andExpect(status().isNotFound());
//	}
//	
//	/**
//	 *Checks whether qualityCheck is added successfully or not.
//	 */
//	@Test
//	public void testAddQualityCheck() throws Exception{
//		QualityCheck newQualityCheck = qualityChecks.get(0);
//		newQualityCheck.setId(3);
//		newQualityCheck.setProductName("nokia");
//    	System.out.println("QualityCheck object is:"+ newQualityCheck);
//    	ObjectMapper mapper = new ObjectMapper();
//    	String newQualityCheckAsJSON = mapper.writeValueAsString(newQualityCheck);
//    	System.out.println("QualityCheck json  is:"+newQualityCheckAsJSON);
//    	this.mockMvc.perform(post("/api/ewaste/qualitycheck")
//    		.content(newQualityCheckAsJSON).accept(MediaType.APPLICATION_JSON_VALUE).contentType(MediaType.APPLICATION_JSON_VALUE))
//    		.andExpect(status().isOk());
//    	for (QualityCheck qualityCheck : qualityChecks) {
//    		System.out.println(qualityCheck);
//		}
//	}
//}

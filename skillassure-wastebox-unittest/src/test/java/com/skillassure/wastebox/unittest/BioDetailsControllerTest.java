/*package com.skillassure.wastebox.unittest;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.skillassure.wastebox.businesslayer.biowaste.biodetails.BioDetailsService;
import com.skillassure.wastebox.model.biowaste.biodetails.BioDetails;
import com.skillassure.wastebox.restapi.biowaste.biodeatils.BioDetailsController;
/*
 * Class to perform JUnit testing
 */
//@SpringBootTest
//@RunWith(SpringRunner.class)
//@ContextConfiguration(classes = ApplicationTestConfig.class)
//@WebAppConfiguration
//@TestExecutionListeners()
//class BioDetailsControllerTest{
	
//	@Autowired
// private BioDetailsController bioDetailsController;
	
//	@MockBean
//	private BioDetailsService bioDetailsService;
//	
//	private MockMvc mockMvc;
//	
//	private List<BioDetails> bioDetails;
	/*
	 * Method to provide test details to run test cases
	 */
//	@Before
//	public void initProducts(){
//		this.mockMvc = MockMvcBuilders.standaloneSetup(bioDetailsController).build();
//		bioDetails= new ArrayList<BioDetails>();
//		BioDetails details1= new BioDetails(1,1212,"goa",12,12,13,1);
//		BioDetails details2= new BioDetails(2, 1313, "sup", 13, 19, 19, 17);
//		bioDetails.add(details1);
//		bioDetails.add(details2);	
//	}
	/*
	 * Method to get bag details
	 */
//	@Test
//	public void testGetBags() throws Exception{
//		given(this.bioDetailsService.getAllBags()).willReturn(bioDetails);
//		this.mockMvc.perform(get("/api/auth/getAllBags"))
//		 .andExpect(status().isOk())
//         .andExpect(content().contentType("application/json"))
//         .andExpect(jsonPath("$.[0].id").value(1))
//         .andExpect(jsonPath("$.[0].hospitalname").value("goa"))
//         .andExpect(jsonPath("$.[1].id").value(2))
//         .andExpect(jsonPath("$.[1].hospitalname").value("sup"));
//	}
	/*
	 * Method to handle exception if bag not found
	 */
//	@Test
//	public void testGetBagsNotFound() throws Exception{
//		bioDetails.clear();
//    	given(this.bioDetailsService.getAllBags()).willReturn(bioDetails);
//        this.mockMvc.perform(get("/api/auth/getAllBags")
//        	.accept(MediaType.APPLICATION_JSON))
//            .andExpect(status().isNotFound());
//	}
	/*
	 * Method to add details of the bag
	 */
//	@Test
//	public void testAddBag() throws Exception{
//		BioDetails newBioDetails = bioDetails.get(0);
//		newBioDetails.setId(3);
//		newBioDetails.setHospitalname("orange");
//    	System.out.println("Bag object is:"+newBioDetails);
//    	ObjectMapper mapper = new ObjectMapper();
//    	String newBagAsJSON = mapper.writeValueAsString(newBioDetails);
//    	System.out.println("Bag json  is:"+newBagAsJSON);
//    	this.mockMvc.perform(post("/api/auth/addBag")
//    		.content(newBagAsJSON).accept(MediaType.APPLICATION_JSON_VALUE).contentType(MediaType.APPLICATION_JSON_VALUE))
//    		.andExpect(status().isOk());
//    	for (BioDetails bioDetails : bioDetails) {
//    		System.out.println(bioDetails);
//		}
//	}
//}*/
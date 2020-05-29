///**
// * 
// */
//
//package org.skillassure.wastebox.unittest.ewaste.pickuppersondetails;
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
//import com.skillassure.wastebox.businesslayer.ewaste.pickuppersondetailsimpl.EPickUpPersonDetailsService;
//import com.skillassure.wastebox.model.ewaste.pickuppersondetails.EPickUpPersonDetails;
//import com.skillassure.wastebox.restapi.ewaste.pickuppersonetails.EPickUpPersonDetailsController;
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
//public class PickUpPersonDetailsControllerTest {
//	
//	@Autowired
//	private EPickUpPersonDetailsController controller;
//	
//	@MockBean
//	private EPickUpPersonDetailsService service;
//	
//	private MockMvc mockMvc;
//
//	private List<EPickUpPersonDetails> pickUpPersonDetails;
//	
//	/**
//	 * Befor test adding Mock data
//	 */
//	@Before
//	public void initPickUpPersonDetails(){
//		this.mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
//		pickUpPersonDetails = new ArrayList<EPickUpPersonDetails>();
//		EPickUpPersonDetails pickUpPersonDetails1 = new EPickUpPersonDetails(1,"Balaji","Koppala","balaji@gmail.com",24,"Telugu","9999999999","Good"); 
//		EPickUpPersonDetails pickUpPersonDetails2 = new EPickUpPersonDetails(2,"subbu","c","subbu@gmail.com",22,"English","77777777777","Good");
//		pickUpPersonDetails.add(pickUpPersonDetails1);
//		pickUpPersonDetails.add(pickUpPersonDetails2);
//	}
//	
//	/**
//	 * Checks whether getting all pickUpPersonDetails from service or not.
//	 */
//	@Test
//	public void testPickUpPersonDetails() throws Exception{
//		given(this.service.getAllPickUpPersonDetails()).willReturn(pickUpPersonDetails);
//		this.mockMvc.perform(get("/api/ewaste/pickuppersondetails"))
//		.andExpect(status().isOk())
//        .andExpect(content().contentType("application/json"))
//        .andExpect(jsonPath("$.[0].firstName").value("Balaji"))
//        .andExpect(jsonPath("$.[0].modelYear").value("Koppala"))
//        .andExpect(jsonPath("$.[1].firstName").value("subbu"))
//        .andExpect(jsonPath("$.[1].emailId").value("subbu@gmail.com"));
//	}
//
//	/**
//	 * checks whether not found exception will return or not if getAllPickUpPersonDetails list empty.
//	 */
//	@Test
//	public void testPickUpPersonDetailsNotFound() throws Exception{
//		pickUpPersonDetails.clear();
//    	given(this.service.getAllPickUpPersonDetails()).willReturn(pickUpPersonDetails);
//        this.mockMvc.perform(get("/api/ewaste/pickuppersondetails/")
//        	.accept(MediaType.APPLICATION_JSON))
//            .andExpect(status().isNotFound());
//	}
//	
//	/**
//	 *Checks whether PickUpPersonDetailss is added successfully or not.
//	 */
//	@Test
//	public void testAddPickUpPersonDetails() throws Exception{
//		EPickUpPersonDetails newPickUpPersonDetails = pickUpPersonDetails.get(0);
//		newPickUpPersonDetails.setId(3);
//		newPickUpPersonDetails.setFirstName("Raghu");
//    	System.out.println("Pick Up Person Details object is:"+ newPickUpPersonDetails);
//    	ObjectMapper mapper = new ObjectMapper();
//    	String newPickUpPersonDetailsAsJSON = mapper.writeValueAsString(newPickUpPersonDetails);
//    	System.out.println("Pick Up Person Details json  is:"+newPickUpPersonDetailsAsJSON);
//    	this.mockMvc.perform(post("/api/ewaste/pickuppersondetails")
//    		.content(newPickUpPersonDetailsAsJSON).accept(MediaType.APPLICATION_JSON_VALUE).contentType(MediaType.APPLICATION_JSON_VALUE))
//    		.andExpect(status().isOk());
//    	for (EPickUpPersonDetails pickUpPersonDetail : pickUpPersonDetails) {
//    		System.out.println(pickUpPersonDetail);
//		}
//	}
//}

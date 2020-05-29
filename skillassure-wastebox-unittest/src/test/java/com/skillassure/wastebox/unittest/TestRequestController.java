//package com.skillassure.wastebox.unittest;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
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
//import com.skillassure.wastebox.businesslayer.plasticwaste.plasticdetails.PlasticDetailsForRequestService;
//import com.skillassure.wastebox.model.plasticwaste.plasticdetails.PlasticDetailsForRequest;
//import com.skillassure.wastebox.restapi.plasticwaste.plasticdetails.PlasticDetails;
//import com.skillassure.wastebox.restapi.plasticwaste.plasticdetails.PlasticDetailsForRequestController;
//import static org.mockito.BDDMockito.given;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
//
//@SpringBootTest
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes = ApplicationTestConfig.class)
//@WebAppConfiguration
//public class TestRequestController {
//	
//	@Autowired
//	private PlasticDetailsForRequestController  requestController;
//	
//	@MockBean
//	private PlasticDetailsForRequestService requestService;
//	
//	private MockMvc mockMvc;
//	
//	private List<PlasticDetailsForRequest> requests;
//	
//	@Before
//	public void initRequests(){
//		this.mockMvc = MockMvcBuilders.standaloneSetup(requestController).build();
//    			
//    			
//		requests= new ArrayList<PlasticDetailsForRequest>();
//		PlasticDetailsForRequest request1= new PlasticDetailsForRequest(1, "Debadutta", "Banarji", "debadutta@gmail.com", 15, "I have 15 bottles and 2 hard plastic", "Bellandur", "Bangalore", "Karnataka", 560103, null, null);
//		PlasticDetailsForRequest request2= new PlasticDetailsForRequest(2, "Debadutta", "Pradhan", "debadutta96@gmail.com", 20, "I have 20 bottles", "Silk Board", "Bangalore", "Karnataka", 760008, null, null);
//		requests.add(request1);
//		requests.add(request2);	
//	}
//	
//	@Test
//	public void testGetRequests() throws Exception{
//		given(this.requestService.getAllPlasticRequest()).willReturn(requests);
//		this.mockMvc.perform(get("/api/plasticReq"))
//		 .andExpect(status().isOk())
//         .andExpect(content().contentType("application/json"))
//         .andExpect(jsonPath("$.[0].firstName").value("Debadutta"))
//         .andExpect(jsonPath("$.[0].pincode").value("560103"))
//         .andExpect(jsonPath("$.[1].firstName").value("Debadutta"))
//         .andExpect(jsonPath("$.[1].pincode").value("760008"));
//	}
//	
//	@Test
//	public void testGetRequestsNotFound() throws Exception{
//		requests.clear();
//    	given(this.requestService.getAllPlasticRequest()).willReturn(requests);
//        this.mockMvc.perform(get("/api/plasticReq")
//        	.accept(MediaType.APPLICATION_JSON))
//            .andExpect(status().isNotFound());
//	}
//
//	
//	/**
//	 *Checks whether Request is added successfully or not.
//	 */
//	@Test
//	public void testAddProduct() throws Exception{
//		PlasticDetailsForRequest newRequest = requests.get(0);
//		newRequest.setFirstName("Sharif");;
//		newRequest.setCity("Hydrabad");
//    	System.out.println("Request object is:" + newRequest);
//    	ObjectMapper mapper = new ObjectMapper();
//    	String newProductAsJSON = mapper.writeValueAsString(newRequest);
//    	System.out.println("Request json  is:"+newProductAsJSON);
//    	this.mockMvc.perform(post("/api/plasticReq")
//    		.content(newProductAsJSON).accept(MediaType.APPLICATION_JSON_VALUE).contentType(MediaType.APPLICATION_JSON_VALUE))
//    		.andExpect(status().isCreated());
//    	for (PlasticDetailsForRequest request : requests) {
//    		System.out.println(request);
//		}
//	}
//	
//
//}

package vttp2022b2.webapp.workshop13;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;

import vttp2022b2.webapp.workshop13.controller.AddressbookController;
import vttp2022b2.webapp.workshop13.model.Contact;
import vttp2022b2.webapp.workshop13.util.Contacts;

@SpringBootTest
@AutoConfigureMockMvc
class Workshop13ApplicationTests {

	@Autowired
	private MockMvc mvc;

	@InjectMocks
	private AddressbookController addressbkController;

	@BeforeEach
	public void setup() {
		mvc = MockMvcBuilders.standaloneSetup(addressbkController)
				.build();

	}

	@Test
	void contextLoads() {
	}

	@Test
	public void testContact() throws Exception {
		Contact c = new Contact();
		c.setEmail("a@a.com");
		c.setName("Kenneth");
		c.setPhoneNumber(422343);
		assertEquals(c.getEmail(), "a@a.com");
	}

	@Test
	public void testAddressbookController() {
		// when
		// MockHttpServletResponse response = mvc.perform(
		// 		get("/addressbook/ce1bca63")
		// 				.accept(MediaType.TEXT_HTML_VALUE))
		// 		.andReturn().getResponse();

	}

}

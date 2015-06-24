package jms.producer.controller;

import jms.producer.model.Vendor;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

import static org.junit.Assert.*;

public class ProducerControllerTest {

    private Vendor vendor;
    private Model model;
    private ProducerController producerController;
    private ApplicationContext applicationContext;

    @Before
    public void setUp() {
        applicationContext = new ClassPathXmlApplicationContext("spring/application-config.xml");
        producerController = (ProducerController)applicationContext.getBean("producerController");
        vendor = new Vendor();
        vendor.setVendorName("UPS");
        vendor.setFirstName("Tony");
        vendor.setLastName("Lee");
        vendor.setAddress("Main st");
        vendor.setCity("maintown");
        vendor.setState("iowa");
        vendor.setZipCode("12345");
        vendor.setEmail("tony@ups.com");
        vendor.setPhoneNumber("123-456-7890");
    }

    @After
    public void tearDown() {

    }

    @Test
    public void testRenderVendorPage() {

        System.out.println(producerController.renderVendorPage(vendor,model));
        assertEquals("vendorPage", producerController.renderVendorPage(vendor,model));
    }

    @Test
    public void testProcessRequest() {
        ModelAndView mv = producerController.processRequest(vendor, model);
        System.out.println(mv.getViewName());
        assertEquals("vendorPage", mv.getViewName());

    }
}

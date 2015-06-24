package jms.producer.controller;


import jms.producer.model.Vendor;
import jms.producer.service.MessageService;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.jms.MessageListener;

@Controller
@RequestMapping("/producerController")
public class ProducerController {

    private static Logger logger = LogManager.getLogger(ProducerController.class);

    @Autowired
    private MessageService messageService;

    @RequestMapping("/vendorPage")
    public String renderVendorPage(Vendor vendor, Model model) {
        logger.info("Enter renderVendorPage: ");
        return "vendorPage";
    }

    @RequestMapping(value="/vendor", method = RequestMethod.POST)
    public ModelAndView processRequest(@ModelAttribute("vendor") Vendor vendor, Model model) {
        logger.info("Enter process request");
        logger.info(vendor.toString());
        messageService.process(vendor);

        ModelAndView mv = new ModelAndView();
        mv.setViewName("vendorPage");
        mv.addObject("message", "Vendor Added Successfully");
        vendor = new Vendor();
        mv.addObject("vendor",vendor);
        return mv;
    }

}

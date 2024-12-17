package tn.spring.springboot.Controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.spring.springboot.Services.Interfaces.IServices;

@RestController
@RequestMapping("/Rest")
public class RestApiController {


    @Autowired
    IServices iServices;


}

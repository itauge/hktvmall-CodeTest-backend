package com.example.hktvmallcodetest.controller;

import com.example.hktvmallcodetest.entity.Holiday;
import com.example.hktvmallcodetest.services.HolidayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import java.io.IOException;
import java.math.BigInteger;
import java.util.List;


@RestController
@CrossOrigin(origins = "*",maxAge = 3600)
public class HolidayController {

    @Autowired
    private HolidayService holidayService;

    @GetMapping(value = "/alldata",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Holiday> getAllData(@Param("pagesize") BigInteger pagesize , @Param("pagenum") BigInteger pagenum ){
        return holidayService.getAll(pagesize,pagenum);
    }

    @GetMapping(value = "/getbydate")
    public List<Holiday> getByDate(@Param("dtstart") String dtstart, @Param("dtend") String dtend){
        return holidayService.getByDate(dtstart,dtend);
    }

    @GetMapping("/insertDb")
    public String insertDb() throws IOException {
        holidayService.insertData();
        return "Success";
    }

}

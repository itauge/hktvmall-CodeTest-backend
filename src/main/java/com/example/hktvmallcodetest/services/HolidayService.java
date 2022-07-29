package com.example.hktvmallcodetest.services;

import com.example.hktvmallcodetest.entity.Holiday;
import com.example.hktvmallcodetest.repository.HolidayRepository;
import org.json.simple.JSONArray;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.*;
import java.io.FileReader;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

@Service
public class HolidayService {

    @Autowired
    private HolidayRepository holidayRepository;

    public List<Holiday> getAll(BigInteger pagesize, BigInteger pagenum) {
        return holidayRepository.getAllHolidayData(pagesize,pagenum);
    }

    @Test
    public List<Holiday> getByDate(String dtstart, String dtend){
        return holidayRepository.getHolidayByDate(dtstart,dtend);
    }

    //Insert default JSON DATA
    @Test
    public void insertData() throws IOException {
        JSONParser jsonParser = new JSONParser();
        try {
            JSONObject jsonObject = (JSONObject) jsonParser.parse(new FileReader("src/main/resources/static/data.json"));

            JSONArray dataList = (JSONArray) jsonObject.get("vcalendar");

            JSONObject jsonObject1 = (JSONObject) dataList.get(0);

            JSONArray new_data = (JSONArray) jsonObject1.get("vevent");

            for (int i = 0; i < new_data.size(); i++) {
                JSONObject list = (JSONObject) new_data.toArray()[i];

                String summary = (String) list.get("summary");
                ArrayList dtstart = (ArrayList) list.get("dtstart");
                ArrayList dtend = (ArrayList) list.get("dtend");
                String transp = (String) list.get("transp");
                String uid = (String) list.get("uid");

                Holiday holiday = new Holiday();

                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");

                holiday.setDtend(dateFormat.parse((String) dtend.toArray()[0]));
                holiday.setDtstart(dateFormat.parse((String) dtstart.toArray()[0]));
                holiday.setUid(uid);
                holiday.setTransp(transp);
                holiday.setSummary(summary);

                //data insert
                holidayRepository.save(holiday);


            }


        } catch (ParseException | java.text.ParseException e) {
            e.printStackTrace();
        }


    }
}

package com.example.hktvmallcodetest.repository;

import com.example.hktvmallcodetest.entity.Holiday;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;

@Repository
public interface HolidayRepository extends JpaRepository<Holiday ,Integer> {
    @Query(value = "select * from holiday LIMIT ?1 OFFSET ?2 ", nativeQuery = true )
    List<Holiday> getAllHolidayData(BigInteger pagesize, BigInteger pagenum);

    @Query(value = "select * from holiday WHERE to_char(dtstart,'yyyy-MM-dd') >= ?1 and to_char(dtend,'yyyy-MM-dd') < ?2 ", nativeQuery = true)
    List<Holiday> getHolidayByDate(String dtstart, String dtend);




}

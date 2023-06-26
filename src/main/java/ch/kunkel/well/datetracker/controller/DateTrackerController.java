package ch.kunkel.well.datetracker.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@RestController
public class DateTrackerController {

    /**
     * @return the current Date in ISO Format ex. 2023-06-23
     */
    @GetMapping("/date")
    public String getDate(){
        return LocalDate.now().format(DateTimeFormatter.ISO_DATE);
    }
}

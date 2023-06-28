package ch.kunkel.well.datetracker.controller;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.assertj.core.api.Assertions.assertThat;

class DateTrackerControllerTest {

    DateTrackerController dateTrackerController = new DateTrackerController();

    @Test
    void getDate_success() {
        LocalDate ld = LocalDate.now();
        assertThat(dateTrackerController.getDate()).isEqualTo(ld.format(DateTimeFormatter.ISO_DATE));
    }

    @Test
    void getDate_fail() {
        LocalDate ld = LocalDate.now().plusDays(1);
        assertThat(dateTrackerController.getDate()).isNotEqualTo(ld.format(DateTimeFormatter.ISO_DATE));
    }
}
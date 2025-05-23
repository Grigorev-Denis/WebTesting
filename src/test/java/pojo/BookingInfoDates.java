package pojo;


import lombok.*;

import java.time.LocalDate;

@Builder
@Getter
@Setter

public class BookingInfoDates {

   private LocalDate checkin;
   private LocalDate checkout ;


    public BookingInfoDates(LocalDate checkin, LocalDate checkout) {
        this.checkin = checkin;
        this.checkout = checkout;
    }

    public BookingInfoDates() {
    }


    @Override
    public String toString() {
        return '{' +
                "checkin='" + checkin + '\'' +
                ", checkout='" + checkout + '\'' +
                '}';
    }
}

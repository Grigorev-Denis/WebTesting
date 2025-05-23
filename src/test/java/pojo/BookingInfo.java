package pojo;

import lombok.*;
@Builder
@Setter
@NoArgsConstructor
@AllArgsConstructor
@With
public class BookingInfo {
    private String firstname;
    private String lastname;
    private Integer totalprice;
    private boolean depositpaid;
    private BookingInfoDates bookingdates;
    private String additionalneeds;

    public BookingInfo(String firstname, String additionalneeds, BookingInfoDates bookingdates,
                       boolean depositpaid, Integer totalprice, String lastname) {

        this.firstname = firstname;
        this.additionalneeds = additionalneeds;
        this.bookingdates = bookingdates;
        this.depositpaid = depositpaid;
        this.totalprice = totalprice;
        this.lastname = lastname;
    }



    public String getFirstname() {
        return firstname;
    }

    public boolean isDepositpaid() {
        return depositpaid;
    }

    public Integer getTotalprice() {
        return totalprice;
    }

    public String getLastname() {
        return lastname;
    }

    public BookingInfoDates getBookingdates() {
        return bookingdates;
    }

    public String getAdditionalneeds() {
        return additionalneeds;
    }

    @Override
    public String toString() {
        return '{' +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", totalprice=" + totalprice +
                ", depositpaid=" + depositpaid +
                ", bookingdates=" + bookingdates +
                ", additionalneeds='" + additionalneeds + '\'' +
                '}';
    }
}

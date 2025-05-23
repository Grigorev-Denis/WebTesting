package pojo;

public class CreateBookingBodyResponse {
    private Integer bookingid;
    private BookingInfo booking;

    public CreateBookingBodyResponse(Integer bookingid, BookingInfo booking) {
        this.bookingid = bookingid;
        this.booking = booking;
    }

    public CreateBookingBodyResponse() {
    }

    public Integer getBookingid() {
        return bookingid;
    }

    public BookingInfo getBooking() {
        return booking;
    }

    @Override
    public String toString() {
        return '{' +
                "bookingid=" + bookingid +
                ", booking=" + booking +
                '}';
    }
}

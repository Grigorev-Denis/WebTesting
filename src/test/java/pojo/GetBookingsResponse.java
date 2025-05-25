package pojo;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
public class GetBookingsResponse {
    private Integer bookingid;

    public GetBookingsResponse(Integer bookingid) {
        this.bookingid = bookingid;
    }

    public GetBookingsResponse() {
    }
}

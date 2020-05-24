package requests;

import com.example.demo.models.TripType;
import com.example.demo.models.User;
import io.swagger.annotations.ApiModelProperty;

import java.util.UUID;

public class BookingRequest {
    @ApiModelProperty(hidden = true)
    UUID requestId;

    String user_uuid;
    TripType tripType;
    String Destination;

    public BookingRequest(String user_uuid, TripType tripType, String destination) {
        this.user_uuid = user_uuid;
        this.tripType = tripType;
        Destination = destination;
    }

    public String getUser_uuid() {
        return user_uuid;
    }

    public void setUser_uuid(String user_uuid) {
        this.user_uuid = user_uuid;
    }

    public TripType getTripType() {
        return tripType;
    }

    public void setTripType(TripType tripType) {
        this.tripType = tripType;
    }

    public String getDestination() {
        return Destination;
    }

    public void setDestination(String destination) {
        Destination = destination;
    }
}

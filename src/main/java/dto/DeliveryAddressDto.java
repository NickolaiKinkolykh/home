package dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

@JsonIgnoreProperties
public class DeliveryAddressDto {

    public String fullName;
    public String deliveryCountry;
    public String addressLine1;
    public String addressLine2;
    @JsonProperty("town/City")
    public String townCity;
    @JsonProperty("county/State")
    public String countryState;
    public String postcode;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DeliveryAddressDto that = (DeliveryAddressDto) o;
        return Objects.equals(fullName, that.fullName) && Objects.equals(deliveryCountry, that.deliveryCountry) && Objects.equals(addressLine1, that.addressLine1) && Objects.equals(addressLine2, that.addressLine2) && Objects.equals(townCity, that.townCity) && Objects.equals(countryState, that.countryState) && Objects.equals(postcode, that.postcode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fullName, deliveryCountry, addressLine1, addressLine2, townCity, countryState, postcode);
    }

    @Override
    public String toString() {
        return "DeliveryAddressDto{" +
                "fullName='" + fullName + '\'' +
                ", deliveryCountry='" + deliveryCountry + '\'' +
                ", addressLine1='" + addressLine1 + '\'' +
                ", addressLine2='" + addressLine2 + '\'' +
                ", townCity='" + townCity + '\'' +
                ", countryState='" + countryState + '\'' +
                ", postcode='" + postcode + '\'' +
                '}';
    }
}

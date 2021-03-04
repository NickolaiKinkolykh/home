package dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties
public class MiniBasketDto {

    @JsonProperty("sub-total")
    public String subTotal;
    public String delivery;
    @JsonProperty("vAT")
    public String vat;
    public String total;
}

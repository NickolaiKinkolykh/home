package dto;

import java.util.Objects;

public class BasketSummaryDto {

    public String deliveryCost;
    public String total;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BasketSummaryDto that = (BasketSummaryDto) o;
        return Objects.equals(deliveryCost, that.deliveryCost) && Objects.equals(total, that.total);
    }

    @Override
    public int hashCode() {
        return Objects.hash(deliveryCost, total);
    }

    @Override
    public String toString() {
        return "BasketSummaryDto{" +
                "deliveryCost='" + deliveryCost + '\'' +
                ", total='" + total + '\'' +
                '}';
    }
}

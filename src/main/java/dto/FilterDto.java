package dto;

import java.util.Objects;

public class FilterDto {

    public String searchKeyWord;
    public String priceRange;
    public String availability;
    public String language;
    public String format;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FilterDto filterDto = (FilterDto) o;
        return Objects.equals(searchKeyWord, filterDto.searchKeyWord)
                && Objects.equals(priceRange, filterDto.priceRange)
                && Objects.equals(availability, filterDto.availability)
                && Objects.equals(language, filterDto.language) && Objects.equals(format, filterDto.format);
    }

    @Override
    public int hashCode() {
        return Objects.hash(searchKeyWord, priceRange, availability, language, format);
    }

    @Override
    public String toString() {
        return "FilterDto{" +
                "searchKeyWord='" + searchKeyWord + '\'' +
                ", priceRange='" + priceRange + '\'' +
                ", availability='" + availability + '\'' +
                ", language='" + language + '\'' +
                ", format='" + format + '\'' +
                '}';
    }
}

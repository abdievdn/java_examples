package dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.opencsv.bean.CsvBindByPosition;
import lombok.Data;

@Data
public class StationDto {

    @JsonAlias({"name", "station_name"})
    @CsvBindByPosition(position = 0)
    private String key;

    @JsonAlias({"date", "depth", "station_date", "depth_meters"})
    @CsvBindByPosition(position = 1)
    private String value;
}

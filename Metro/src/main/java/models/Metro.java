package models;

import lombok.Data;

import java.util.List;

@Data
public class Metro {
    private List<Line> lines;
    private List<Station> stations;
}

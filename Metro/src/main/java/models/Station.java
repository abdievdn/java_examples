package models;

import lombok.Data;

@Data
public class Station {
    private String name;
    private String lineName;
    private String date;
    private String depth;
    private boolean hasConnection;
}

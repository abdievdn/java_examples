package parsers;

import com.opencsv.bean.CsvToBeanBuilder;
import dto.StationDto;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

public class CsvParser {

    public static List<StationDto> getStationsFromFile(File file) throws FileNotFoundException {
       return new CsvToBeanBuilder<StationDto>(new FileReader(file))
               .withType(StationDto.class)
               .build()
               .parse();
    }
}

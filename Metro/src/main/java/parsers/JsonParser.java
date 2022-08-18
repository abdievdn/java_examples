package parsers;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import dto.StationDto;
import models.Metro;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class JsonParser {

    private static final ObjectMapper mapper = new ObjectMapper();
    private static final ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());

    public static List<StationDto> getStationsFromFile(File file) throws IOException {
        return Arrays.asList(mapper.readValue(file, new TypeReference<>() {}));
    }

    public static void saveStationsToJsonFile(File file, Metro metro) throws IOException {
        writer.writeValue(file, metro);
    }
}

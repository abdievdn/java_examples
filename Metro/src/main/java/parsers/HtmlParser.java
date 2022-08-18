package parsers;

import lombok.Data;
import models.Line;
import models.Station;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.*;

@Data
public class HtmlParser {

    private String url;

    public List<Line> getLines() throws IOException {
        List<Line> lines = new ArrayList<>();
        Elements elements = getHtml(url).select(".js-metro-line");
        elements.forEach(l -> {
           Line line = new Line();
            line.setName(l.text());
            line.setNumber(l.attr("data-line"));
            lines.add(line);
        });
        return lines;
    }

    public List<Station> getStations(List<Line> lines) throws IOException {
        List<Station> stations = new ArrayList<>();
        Elements elements = getHtml(url).select(".js-metro-stations");

        elements.forEach(e -> {
            Elements singleStation = e.select(".single-station");
            singleStation.forEach(s -> {
                Station station = new Station();
                station.setName(s.select(".name").text());
                String line = getLineByNumber(lines, e.attr("data-line"));
                station.setLineName(line);
                if (!s.select(".t-icon-metroln").isEmpty()) {
                    station.setHasConnection(true);
                }
                stations.add(station);
            });
        });
        return stations;
    }

    private String getLineByNumber(List<Line> lines, String number) {
        for (Line l : lines) {
            if (l.getNumber().equals(number)) {
                return l.getName();
            }
        }
        return null;
    }

    private Document getHtml(String url) throws IOException {
        return Jsoup.connect(url).get();
    }
}

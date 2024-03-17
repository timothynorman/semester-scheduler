package ca.timnorman;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.File;
import java.io.IOException;

public class YamlController {
    public Semester readYamlSchedule(String filePath) {
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        Semester semester;

        mapper.findAndRegisterModules();

        try {
            semester = mapper.readValue(new File(filePath), Semester.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return semester;
    }
}

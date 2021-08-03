package eu.org.xmon.emojishortenurl.object;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;

@Data @AllArgsConstructor @RequiredArgsConstructor
public class Short implements Serializable {
    private String orginal$url;
    private String emoji$url;
}

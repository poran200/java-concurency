import com.google.common.collect.ImmutableList;
import com.google.gson.Gson;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class DemoTest {

    @Test
    void name() {
        // Create a new ordered map.
        Map<String,String> myLinkedHashMap = new LinkedHashMap<String, String>();

        // Add items, in-order, to the map.
        myLinkedHashMap.put("1", "first");
        myLinkedHashMap.put("2", "second");
        myLinkedHashMap.put("3", "third");

        // Instantiate a new Gson instance.
        Gson gson = new Gson();

        // Convert the ordered map into an ordered string.
        String json = gson.toJson(myLinkedHashMap, LinkedHashMap.class);

        // Print ordered string.
        System.out.println(json); // {"1":"first","2":"second","3":"third"}
    }
}

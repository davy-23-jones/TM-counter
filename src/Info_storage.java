import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Info_storage {
//    HashMap<String, ArrayList<String>> user_info = new HashMap<>(Map.of(
//            "User1", new ArrayList<>(Arrays.asList("0", "0"))
//    ));
HashMap<String, ArrayList<String>> user_info;
    int user_index;
    public Info_storage(){
        user_index = 0;
        user_info = new HashMap<>();
    }

}

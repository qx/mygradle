import com.example.myapp.Product;
import com.example.myapp.ProductList;
import org.json.JSONObject;
import org.junit.Test;

import java.util.List;

import static com.example.myapp.MyActivity.performSearch;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by ok on 14-4-28.
 */
public class Tester {

    @Test
    public void testperformSearch() {
        try {
            JSONObject jsonObject = new JSONObject("{\"result\":[{\"currentCnt\":1000,\"detail\":\"this is detail\",\n" +
                    "                    \"myObject\":{\"first\":\"myfirst ob\"},\"price\":5555.0,\"productId\":\"field1_str\",\"productImg\":\"field2_str\",\n" +
                    "                    \"productName\":\"field3_str\",\"totalCnt\":3000}],\"status\":\"success\"}"
            );


            assertThat(performSearch(),  is(ProductList.class));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

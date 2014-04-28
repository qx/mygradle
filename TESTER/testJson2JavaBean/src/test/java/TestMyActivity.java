import org.junit.Test;

import static com.example.myapp.MyActivity.performSearch;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Administrator on 2014/4/28.
 */
public class TestMyActivity {
    @Test
    public void testperformSearch() {
        try {
            assertThat(performSearch(), equalTo(null));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

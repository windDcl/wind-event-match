import co.elastic.clients.elasticsearch.ElasticsearchClient;
import com.test.cn.AApplication;
import com.testb.cn.utils.ESUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = AApplication.class)
public class ESUtilsTest {

    @Autowired
    private ESUtils esUtils;
    @Test
    public void test() throws Exception {
        ElasticsearchClient client = esUtils.getClient();
    }
}

import com.newer.domain.Task;
import com.newer.mapper.TaskMapper;
import com.newer.service.OrderService;
import com.newer.util.SqlSessionUtil;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class TestTask {
    @Test
    public void test(){
        OrderService orderService = new OrderService();
        orderService.getTaskList(4);
    }
}

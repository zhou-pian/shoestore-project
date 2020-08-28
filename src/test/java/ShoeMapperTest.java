import com.ssm.shoestoreproject.ShoestoreProjectApplication;
import com.ssm.shoestoreproject.domin.ShoeInfo;
import com.ssm.shoestoreproject.domin.ShoePlus;
import com.ssm.shoestoreproject.mapper.ShoeMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ShoestoreProjectApplication.class)
public class ShoeMapperTest {

    @Autowired
    private ShoeMapper shoeMapper;

    @Test
    public void insert(){
        ShoeInfo shoeInfo = new ShoeInfo("aaa","sss",25.0,2000,1,36,"男");
        shoeMapper.insertShoe(shoeInfo);
    }

    @Test
    public void showAll(){
        List<ShoePlus> shoes = shoeMapper.findAll();
        for(ShoeInfo shoe:shoes){
            System.out.println(shoe);
        }

    }
}

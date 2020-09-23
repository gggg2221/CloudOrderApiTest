package cloud.sign.oldsign;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.zt.ApplicationTest;
import org.zt.common.Assertion;
import org.zt.common.AssertionListener;
import org.zt.common.Parameters;

@Listeners({ AssertionListener.class })
@SpringBootTest(classes = { ApplicationTest.class })
public class test11111111 extends AbstractTestNGSpringContextTests {

    @Autowired
    Parameters pt;

    @Test
    public void sta(){

        String a=pt.getOrderurl();

        System.out.println(a);
        Assertion.verifyTrue(a!=null);
    }
}

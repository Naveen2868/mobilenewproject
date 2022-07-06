import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNGTest1 {

   /* @Test(priority=1)
    public void t1()
    {
        System.out.println("Running 1");
    }

    @Test(priority=2,dependsOnMethods={"t1"})
    public void t2()
    {
        System.out.println("Running 2");
    }

    @Test(priority=3,dependsOnMethods="t2")
    public void t3()
    {
        System.out.println("Running 3");
    }

    @Test(priority=4)
    public void t4()
    {
        System.out.println("Running 4");
    }*/

    @Test(priority=1)
    public void Login()
    {
        System.out.println("LogIn Test code.");
        //Assert.assertTrue(5>6, "Condition Is False.");
    }

    @Test(dependsOnMethods={"Login"})
    public void checkMail()
    {
        System.out.println("checkMail Test code.");
    }

    @Test(dependsOnMethods={"Login","checkMail"})
    public void LogOut()
    {
        System.out.println("LogOut Test code.");
    }
}

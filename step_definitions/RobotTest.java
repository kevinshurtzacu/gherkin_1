// Name: Kevin Shurtz
// Date: 09/06/2016

package step_definitions;

import cucumber.api.java.en.*;
import cucumber.api.PendingException;
import implementation.Robot;
import static org.junit.Assert.*;

public class RobotTest {
    
    @Given("^I am in a good mood$")
    public void iAmInAGoodMood() throws Throwable {
        // Check to see if the robot is in a good mood when appropriate.
        Robot robot = new Robot("happy", 9001);
        assertEquals(robot.isHappy(), true);
    }
    
    @When("^you tickle me$")
    public void youTickleMe() throws Throwable {
        // Check that the robot is tickled when appropriate.
        Robot robot = new Robot("happy", 9001);
        robot.setCondition("tickled");
        assertEquals(robot.isTickled(), true);
    }
    
    @Then("^I will giggle$")
    public void iWillGiggle() throws Throwable {
        // Check that the robot giggles after being tickled
        Robot robot = new Robot("happy", 9001);
        robot.setCondition("tickled");
        String response = robot.behave();
        assertEquals(response, "He he he... ");
    }
    
    @When("^you kick me in the shins$")
    public void youKickMeInTheShins() throws Throwable {
        Robot robot = new Robot("happy", 9001);
        robot.setCondition("kicked");
        assertEquals(robot.isKicked(), true);
    }
    
    @Then("^I will destroy the world$")
    public void iWillDestroyTheWorld() throws Throwable {
        Robot robot = new Robot("happy", 9001);
        robot.setCondition("kicked");
        String response = robot.behave();
        assertEquals(response, "You don't know the power of the Dark Side... ");
    }
}


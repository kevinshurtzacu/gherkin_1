// Name: Kevin Shurtz
// Date: 09/06/2016

package implementation;

// A class to represent a robot
public class Robot {
    // Strong typing for robot mood
    private enum Sentiment {
        HAPPY,
        SAD
    }

    private int strength;       // Strength of the robot
    private Sentiment mood;     // Mood of the robot
    private String condition;   // Condition of the robot
    
    // Construct robot
    public Robot(String robotMood, int robotStrength) {
        // Assign Robot strength
        strength = robotStrength;

        // Assign Robot mood
        if (robotMood.toLowerCase().equals("happy")) {
            mood = Sentiment.HAPPY;
        }
        else if (robotMood.toLowerCase().equals("sad")) {
            mood = Sentiment.SAD;
        }
        else {
            mood = Sentiment.SAD;
        }

        // Assign Robot condition
        condition = "normal";
    }

    // Returns true if the condition is 'tickled'
    public boolean isTickled() {
        if (condition.equals("tickled")) 
            return true;
        
        return false;
    }
    
    // Returns true if the condition is 'kicked'
    public boolean isKicked() {
        if (condition.equals("kicked"))
            return true;
        
        return false;
    }

    // Returns true if the condition is 'normal'
    public boolean isNormal() {
        if (condition.equals("normal"))
            return true;

        return false;
    }

    // Sets the robot condition (kicked/tickled/normal)
    public void setCondition(String action) {
        if (action.toLowerCase().equals("kicked"))
            condition = "kicked";
        else if (action.toLowerCase().equals("tickled"))
            condition = "tickled";
        else
            condition = "normal";
    }

    // Returns the robot condition (kicked/tickled/normal)
    public String getCondition() {
        return condition;
    }

    // Returns if the robot 'mood' is happy
    public boolean isHappy() {
        if (mood == Sentiment.HAPPY)
            return true;

        return false;
    }
    
    // Returns if the robot 'mood' is sad
    public boolean isSad() {
        if (mood == Sentiment.SAD)
            return true;

        return false;
    }
    
    // Return a playful behavior
    private String giggle() {
        return "He he he... ";
    }

    // Return an aggressive behavior
    private String destroy() {
        return "You don't know the power of the Dark Side... ";
    }

    // Return a normal behavior
    private String normal() {
        return "Nothing to see here... ";
    }

    public String behave() {
        // Being happy allows the robot to be playful
        if (isHappy()) {
            if (isKicked()) {
                // If attacked, become destructive
                return destroy();
            }
            else if (isTickled()) {
                // If happy and tickled, be playful
                return giggle();
            }
            else {
                // Otherwise, behave normally
                return normal();
            }
        }
        else if (isSad()) {
            if (isKicked()) {
                // If attacked, become destructive
                return destroy();
            }
            else {
                // Otherwise, behave normally
                return normal();
            }
        }
        
        // If there is no peculiar circumstances, return the normal behavior
        return normal();
    }
}


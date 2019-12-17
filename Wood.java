import java.awt.event.KeyEvent;
import java.awt.Robot;
import java.util.Scanner;
import java.awt.Color;
import java.awt.MouseInfo;
import java.awt.Point;

/**
 * Class Wood which runs LumberJack game
 */
public class Wood {

    static boolean start = false;

    /**
     * Start Function which starts only if input String 'Start' is given after the Score you desire
     */
    public static void Start(String str) {

        if (str.equals("Start")) {
            start = true;
        }
    }

    public static boolean isInt(String s) {
        try {
            int temp = Integer.parseInt(s);
            if (temp < 0) {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
        return true;
    }


    public static void main (String[] args) throws Exception{

        System.out.println("What Score do you want to hit? I'll do my best! Key in an Integer: ");
        Scanner sc = new Scanner(System.in);

        
        int score;
        String temp;

        // Only takes in a Positive Integer
        while (true) {
            
            temp = sc.nextLine();
            boolean IsInt = isInt(temp);
            if (IsInt) {
                score = Integer.parseInt(temp);
                break;
            } else {
                System.out.println("Positive Integer please! Try again: ");
            }
        }

        
        // Must insert enter 'Start' for programme to run
        System.out.println("Now enter 'Start' to begin!");
        while (!start) {
            String s = sc.nextLine();
            Start(s);
        }

        Robot robot = new Robot();

         
        // 6 Seconds of pause before activating Game
        robot.delay(6000);


        /* 
        Pixel coordinate of original Color to compare to (Branch Color) 
        For Mac use Screenshot to find coordinates of Pixel and key in the Coordinates to the function
        Color Branch_color = robot.getPixelColor(x ,y);
        For Simplicity purposes the Color of the Branch is hard-coded
        */
        
        int red = 143;
        int green = 96;
        int blue = 43;


        for (int i = 0; i < score/2 ; i++) {

            robot.delay(170); 


            /* 
            Pixel coordinate of left Pixel Color to compare to (Branch Color) 
            For Mac use Screenshot to find coordinates of Pixel
            */
            Color color_left = robot.getPixelColor(904,391);
            
            int blue_left = color_left.getBlue();
            int green_left =  color_left.getGreen();
            int red_left =  color_left.getRed();

            /* 
            Color Checker for left Pixel:
            System.out.println("left is " + red_left + ", " + green_left + ", " + blue_left);
            Use https://convertingcolors.com/rgb-color-143_96_43.html to check actual colors
            */
           
            

    
            
            /* 
            Pixel coordinate of left Pixel Color to compare to (Branch Color) 
            For Mac use Screenshot to find coordinates of Pixel
            */
            Color color_right = robot.getPixelColor(1020, 391);

            int blue_right = color_right.getBlue();
            int green_right =  color_right.getGreen();
            int red_right =  color_right.getRed();

            /* 
            Color Checker for right Pixel:
            System.out.println("left is " + red_left + ", " + green_left + ", " + blue_left);
            Use https://convertingcolors.com/rgb-color-143_96_43.html to check actual colors
            */
            


            /*
            If Color above LumberJack is the Color of the Branch, Shift leftwards. Otherwise Shift rightwards.
            We can do this because there is no case where there is both branches on left and right.
            */
            if (blue_right == blue && red_right == red && green_right == green){
                robot.keyPress(KeyEvent.VK_LEFT);
                robot.keyRelease(KeyEvent.VK_LEFT);
                robot.delay(15);
                robot.keyPress(KeyEvent.VK_LEFT);
                robot.keyRelease(KeyEvent.VK_LEFT);

            } else {
                robot.keyPress(KeyEvent.VK_RIGHT);
                robot.keyRelease(KeyEvent.VK_RIGHT);
                robot.delay(15);
                robot.keyPress(KeyEvent.VK_RIGHT);
                robot.keyRelease(KeyEvent.VK_RIGHT);
            }
        }
    }
}


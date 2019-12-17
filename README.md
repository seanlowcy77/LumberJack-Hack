# LumberJack Hack

A Hack using Java to cheat through the Telegram game: 

LumberJack

![The LumberJack game](https://telegramguides.com/wp-content/uploads/2018/07/lumberjack-telegram-game.png)

## How it works?

Sample running of the code:

![Algo running](https://github.com/seanlowcy77/LumberJack-Hack/blob/master/Sample%20running%20of%20code.png)

Basically we check if there is a branch above the LumberJack's head. If there is, we change sides and chop twice. We can do this by 
using the Robot Java API, where we can check for the colour of the pixel above the LumberJack's head. If it is the same colour as a branch,
we simply shift sides.


### Interesting Points 

The code below is the main part of the algorithm which causes the LumberJack to move right or left depending on the colour of the pixel above him.

```
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
```

Here it is important that we put a delay period as the movement of the branch downwards is not immediate and takes time. 
<br>The KeyEvent here is basically a Java API which allows you to perform / type keys on your keyboard. Check it out below:

https://docs.oracle.com/javase/7/docs/api/java/awt/event/KeyEvent.html#VK_KP_RIGHT



Another important part of the code is determining the colour of the pixel at both the right and left side. Here you need to find
the coordinate of the pixel yourself and key it into the algorithm.

```
Color color_left = robot.getPixelColor(x,y);
            
            int blue_left = color_left.getBlue();
            int green_left =  color_left.getGreen();
            int red_left =  color_left.getRed();
```

## How to check the position of the pixel?

These are the Right(Black) and Left(Red) pixel positions you should look for and enter into the code.

![Pixel Positions](https://github.com/seanlowcy77/LumberJack-Hack/blob/master/LumberJack%20Pixel%20Position.png)

For Mac Users simply use the Command-Shift-4 button - it will allow to check the coordinates of the pixels
<br>If not we can also use the MouseEvent API:

https://docs.oracle.com/javase/7/docs/api/java/awt/event/MouseEvent.html

using the getLocationonScreen() function which will return the Point where your mouse is.

## Warnings and Tips

For Mac Users, please allow your editor 'Acessibility' as well as 'Screen Recording'. If you do not allow 'Screen Recording', the colour from the Pixel coordinate will simply be taken from your default Desktop.

Also use
<br>https://convertingcolors.com/rgb-color-143_96_43.html 
to check the colours of your Pixels. Have fun!




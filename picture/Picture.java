/**
 * This class represents a simple picture. You can draw the picture using
 * the draw method. But wait, there's more: being an electronic picture, it
 * can be changed. You can set it to black-and-white display and back to
 * colors (only after it's been drawn, of course).
 *
 * This class was written as an early example for teaching Java with BlueJ.
 * 
 * @author  Michael Kolling and David J. Barnes
 * @version 2008.03.30
 */
public class Picture
{
    private Square wall;
    private Square window;
    private Triangle roof;
    private Square trunk1; //There needs to be two
    private Square trunk2;  //trunks to make a rectangle
    private Square leaves;
    private Square ground;
    private Circle sun;
    private Circle fruit;
    private boolean day =  true;
    private boolean fruitIsGrown = true;

    /**
     * Constructor for objects of class Picture
     */
    public Picture()
    {
        // nothing to do... instance variables are automatically set to null
    }

    /**
     * Draw this picture.
     */
    public void draw()
    {
        wall = new Square();
        wall.moveVertical(80);
        wall.changeSize(100);
        wall.makeVisible();
        
        window = new Square();
        window.changeColor("black");
        window.moveHorizontal(10);
        window.moveVertical(100);
        window.makeVisible();

        roof = new Triangle();  
        roof.changeSize(50, 140);
        roof.moveHorizontal(60);
        roof.moveVertical(70);
        roof.makeVisible();
        
        sun = new Circle();
        sun.changeColor("yellow");
        sun.moveHorizontal(180);
        sun.moveVertical(-10);
        sun.changeSize(60);
        sun.makeVisible();
        
        trunk1 = new Square();
        trunk1.moveVertical(150);
        trunk1.moveHorizontal(150);
        trunk1.changeColor("black");
        trunk1.makeVisible();
        trunk2 = new Square();
        trunk2.moveVertical(130);
        trunk2.moveHorizontal(150);
        trunk2.changeColor("black");
        trunk2.makeVisible();
        
        leaves = new Square();
        leaves.moveVertical(80);
        leaves.moveHorizontal(135);
        leaves.changeColor("green");
        leaves.changeSize(60);
        leaves.makeVisible();
        
        ground = new Square();
        ground.moveVertical(175);
        ground.moveHorizontal(-100);
        ground.changeSize(500);
        ground.changeColor("green");
        ground.makeVisible();
       
        fruit = new Circle();
        fruit.moveVertical(110);
        fruit.moveHorizontal(210);
        fruit.changeColor("red");
        fruit.changeSize(10);
        fruit.makeVisible();
    }

    /**
     * Change this picture to black/white display
     */
    public void setBlackAndWhite()
    {
        if(wall != null)   // only if it's painted already...
        {
            wall.changeColor("black");
            window.changeColor("white");
            roof.changeColor("black");
            sun.changeColor("black");
        }
    }

    /**
     * Change this picture to use color display
     */
    public void setColor()
    {
        if(wall != null)   // only if it's painted already...
        {
            wall.changeColor("red");
            window.changeColor("black");
            roof.changeColor("green");
            sun.changeColor("yellow");
        }
    }
    
    public void sunset()
    {
        if (day == true){
            sun.slowMoveVertical(250);
            dropFruit();
            day = false;
        }
    }
    
    public void sunrise()
    {
        if (day == false){
            sun.slowMoveVertical(-250);
            growFruit();
            day = true;
        }
    }
    
    public void dropFruit(){
        if (fruitIsGrown == true){
            fruit.slowMoveVertical(65);
            fruitIsGrown = false;
        }
    }
    
    public void growFruit(){
        if (fruitIsGrown == false){
            fruit.moveVertical(-65);
            fruitIsGrown = true;
        }
    }
    
    public void movePicture(int amount){
        wall.moveHorizontal(amount);
        window.moveHorizontal(amount);
        roof.moveHorizontal(amount);
        trunk1.moveHorizontal(amount);
        trunk2.moveHorizontal(amount);
        leaves.moveHorizontal(amount);
        ground.moveHorizontal(amount);
        fruit.moveHorizontal(amount);
    }
   
}

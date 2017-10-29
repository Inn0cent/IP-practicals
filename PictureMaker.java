import java.awt.Color;

public class PictureMaker
{
    private TurtleWorld world;
    private Turtle fred;
    private Polygon hexagon;
    private Polygon triangle;
    
    public PictureMaker()
    {
        world = new TurtleWorld(500, 500, "Picture Maker");
        fred = new Turtle();
    }
    
    public void display() {
        world.display();
    }
    
    public void erase() {
        world.removeTraces();
        world.removeTurtles();
    }
 
    public void drawInitials() 
    {
        world.dropIn(fred);
        
        fred.penUp();
        fred.left(90);
        fred.forward(25);
        fred.left(90);
        fred.forward(200);
        fred.right(90);
        
        fred.penDown();
        fred.forward(175);
        fred.right(90);
        fred.forward(350);
        fred.right(90);
        fred.forward(175);
        fred.penUp();
        
        fred.forward(50);
        fred.penDown();
        fred.right(90);
        fred.forward(350);
        fred.right(180);
        fred.forward(175);
        fred.right(40);
        fred.forward(250);
        fred.forward(-250);
        fred.right(100);
        fred.forward(250);
        
        world.removeTurtle(fred);
    }
    
    public void drawFlower()
    {
        world.dropIn(fred);
        
        fred.penUp();
        fred.left(180);
        fred.forward(100);
        fred.right(90);
        fred.penDown();
        
        for (int i=1; i<7; i++){
            fred.setColor(Color.blue);
            fred.forward(100);
            fred.left(90);
            triangle = new Polygon(3,50);
            triangle.setColor(Color.red);
            triangle.traceWith(fred);
            fred.right(150);
        }
    }
    
    public void drawNest()
    {
        Color[] colorlist ={Color.red, Color.blue, Color.green, Color.yellow};
        Polygon shapes;
        world.dropIn(fred);

        for (int i=3; i<=6; i++){
            shapes = new Polygon(i, 100);
            shapes.setColor(colorlist[i-3]);
            shapes.traceWith(fred);
        }
    }
    
    public void drawPentagon(){
        world.dropIn(fred);
        Polygon pentagon = new Polygon(5, 50);
        pentagon.traceWith(fred);
    }
    
    public void drawHexagon(){
        world.dropIn(fred);
        Polygon hexagon = new Polygon(6, 50);
        hexagon.traceWith(fred);
    }
    
    public void changeColor(Color c){
        fred.setColor(c);
    }
}


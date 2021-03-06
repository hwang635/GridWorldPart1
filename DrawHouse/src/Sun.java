import processing.core.PApplet;

//was meant to be used for line method, changed idea
//current use: just draws a yellow elipse
public class Sun {
	
	private int x, y, width, height;
	private int r, g, b;
	
	public Sun() {
		x = 50;
		y = 50;
		width = 50;
		height = 50;
		
		r = 254;
		g = 249;
		b = 27;
	}
	
	public void draw(PApplet drawer) {
		drawer.stroke(255,165,0);
		drawer.fill(r, g, b);
		drawer.ellipse(x, y, width, height);
		 
	}
	
	//not used
	public void change(int n) {
		if(n==1)
			x = (int) (Math.random()*500.0);
		else if(n == 2)
			y = (int) (Math.random()*500.0);
		else if(n == 3) {
			y = (int) (Math.random()*500.0);
			x = (int) (Math.random()*500.0);
		}
		else {
			r = (int) (Math.random()*256);
			g = (int) (Math.random()*256);
			b = (int) (Math.random()*256);
		}
			
	}
}

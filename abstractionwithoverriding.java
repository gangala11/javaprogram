package Java1;
interface vehicle
{
	void changegear(int a);
	void speedup(int a);
	void applybreaks(int a);
}
class bicycle implements vehicle
{
	int speed,gear;
	@Override
	public void changegear(int newgear)
	{
		gear=newgear;
	}
	@Override
	public void speedup(int increment)
	{
		speed=speed+increment;
	}
	@Override
	public void applybreaks(int decrement)
	{
		speed=speed-decrement;
	}
	public void print()
	{
		System.out.println("speed"+speed +"gear"+gear);
	}
}
class bike implements vehicle
{
	int speed,gear;
	@Override
	public void changegear(int newgear)
	{
		gear=newgear;
	}
	@Override
	public void speedup(int increment)
	{
		speed=speed+increment;
	}
	@Override
	public void applybreaks(int decrement)
	{
		speed=speed-decrement;
	}
	public void print()
	{
		System.out.println("speed"+speed+"gear"+gear);
	}
	
}
public class abstractionwithoverriding {

	public static void main(String[] args) {
		//creating instance of bicycle
		bicycle bicycle=new bicycle();
		bicycle.changegear(3);;
		bicycle.speedup(4);
		bicycle.applybreaks(2);
		bicycle.print();
		
		bike bike=new bike();
		bike.changegear(3);
		bike.speedup(5);
		bike.applybreaks(3);
		bike.print();
	}

}

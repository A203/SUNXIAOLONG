package day03;


public class ArmyTest {
	
	public static void main(String[] args){
		
		Army a = new Army(3);
		a.addWeapon(new Tank());
		a.addWeapon(new Flighter());
		a.addWeapon(new WarShip());
		
		
		a.moveAll();
		a.attackAll();
		
		
		
		
		
		
	}

}

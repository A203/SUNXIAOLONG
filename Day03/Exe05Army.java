package day03;

public class Army {
      Weapon[] w  = null;
      int size = 0;
     
     public Army(){}
     public Army(int max ){
     
      w = new  Weapon[max];
     }
  public void addWeapon(Weapon wa){
	if (size>=w.length){
		System.out.println("武器已饱和，不需要更多");
		return ;
	}  
	else{
		w[size] = wa;
		size++;
	}      
  }
  public void attackAll(){
	  for(int i = 0;i<w.length;i++){
		  Weapon wea = w[i];
		  if(wea!=null){
			  wea.attack();
			  
		  }
	  }
  }
  public void moveAll(){
	  for(int i = 0;i<w.length;i++){
		  Weapon wa = w[i];
		  if(wa!=null){
			  wa.move();
		  }
	  }
  }
}

package kr.co.jhta.app;

public class WeaponImple implements Weapon{

	String type;
	
	@Override
	public void tire() {
		// TODO Auto-generated method stub
		System.out.println("파이어");
	}

	@Override
	public void reload() {
		// TODO Auto-generated method stub
		System.out.println("리로드");
	}

}

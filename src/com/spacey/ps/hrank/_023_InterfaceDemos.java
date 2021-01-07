package com.spacey.ps.hrank;

interface Syrupable{
	void getSuragy();
}

abstract class Pancake implements Syrupable{
	
}

//class BlueBerryPancake implements Pancake{
//	public void getSugary() {
//		
//	}
//}
//
//class BOB extends BlueBerryPancake{
//	
//}

interface BaseI {void method();}

class BaseC {
	public void method() {
		System.out.println("Inside BaseC");
	}
}


class ImplC extends BaseC implements BaseI{
	public static void main(String[] args) {
		(new ImplC()).method();
	}
}

public class _023_InterfaceDemos {

}

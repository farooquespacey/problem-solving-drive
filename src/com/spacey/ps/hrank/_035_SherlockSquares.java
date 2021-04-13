package com.spacey.ps.hrank;

public class _035_SherlockSquares {

    // Complete the squares function below.
    static int squares(int a, int b) {
    	int total = 0;
    	int lowest = (int) Math.sqrt(a);
    	if(lowest*lowest == a) {
    		total++;
    	}
    	while((++lowest*lowest) <= b) total++;
    	return total;
    }
    
    static int squares2(int a, int b) {
    	int total = 0;
        int x = (int)Math.ceil(Math.sqrt(a));
        int y = (int)Math.floor(Math.sqrt(b));
        int square_count = y - x + 1;
        System.out.println(square_count);
    	return total;
    }
	
	public static void main(String[] args) {
		System.out.println(squares(4, 25));
	}

}

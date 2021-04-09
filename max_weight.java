// Problem To find Max Weights , such that no two elements are adjacent .
public class max_weight {
	public static void main(String[] args) {
	    int ar[]= {5, 5, 10, 100, 10, 5};
	    int tab[]=new int[ar.length];
		System.out.println(SelectBalls(ar,tab));
	}
	public static int SelectBalls(int ar[],int tab[]) {
		tab[0]=ar[0];
		tab[1]=Math.max(0, ar[0]);
		int i;
		for(i=2;i<ar.length;++i) {
			tab[i]=Math.max(tab[i-1], tab[i-2]+ar[i-1]);
		}
		return tab[i-1];
	}
}








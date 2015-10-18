//Two-dimensional array representation of an image can also be represented by a one-dimensional array of W*H size,
//where W represent row and H represent column size and each cell represent pixel value of that image. 
//You are also given a threshold X. 
//For edge detection, you have to compute difference of a pixel value with each of it's adjacent pixel 
//and find maximum of all differences. And finally compare if that maximum differenceis greater than threshold X. 
//if so, then that pixel is a edge pixel and have to display it.

public class edgeDetection{
	public static void main(String[] args){
		int[] image = {
				1,1,1,1,1,
				1,9,1,1,1,
				1,1,1,1,1,
				1,1,1,1,1,
				1,1,1,1,1,};
		detect(image, 5, 2);
	}

	public static void detect(int[] image, int W, int X){
		if(image == null || W < 1 || image.length < W || image.length%W != 0){
			System.out.println("Wrong input!");
			return;
		}
		int[] output = new int[image.length];
		int m = image.length/W;
		int n = W;
		int xlim=0, ylim=0, xmax=0, ymax=0;
		for(int i=0;i<m;i++){
			for(int j=0;j<n;j++){
				int pos = image[i*W+j];
				xlim = i==0?0:i-1;
				xmax = i==n-1?n-1:i+1;
				ylim = j==0?0:j-1;
				ymax = j==m-1?m-1:j+1;
				if(meetsThreshold(image,xlim,xmax,ylim,ymax,pos,X,W)){
					output[i*W+j] = pos;
				}
			}
		}
		for(int i=0;i<m;i++){
			for(int j=0;j<n;j++){
				System.out.print(output[i*W+j]+" ");
			}
			System.out.println();
		}
	}

	public static boolean meetsThreshold(int[] image, int xlim, int xmax, int ylim, int ymax, int pos, int X, int W){
		int count = 0;
		for(int i=xlim; i<=xmax;i++){
			for(int j=ylim;j<=ymax;j++){
				count = Math.max(Math.abs(image[i*W+j]-pos),count);
			}
		}
		if(count>X){
			return true;
		}else{
			return false;
		}
	}
}
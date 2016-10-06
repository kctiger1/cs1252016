
/* A class to implement the various pixel effects.
 *
 * Todo: Put your netid (i.e. username) in the line below
 * 
 * @author kevinc3
 */
public class PixelEffects {

	/** Copies the source image to a new 2D integer image */
	public static int[][] copy(int[][] source) {
		// Create a NEW 2D integer array and copy the colors across
		// See redeye code below
		int[][]copy = new int [source.length][];
		for (int i=0;i<source.length;i++){
			int[]aSource = source[i];
			int aLength = aSource.length;
			copy[i] = new int [aLength];
			System.arraycopy(aSource,0,copy[i],0,aLength);
		}
		return copy;
	}
	/**
	 * Resize the array image to the new width and height
	 * You are going to need to figure out how to map between a pixel
	 * in the destination image to a pixel in the source image
	 * @param source
	 * @param newWidth
	 * @param newHeight
	 * @return
	 */
	public static int[][] resize(int[][] source, int newWidth, int newHeight) {
		int sourceWidth=source.length;
		int sourceHeight=source[0].length;
		int[][] resize=new int[newWidth][newHeight];
		
		for(int width = 0;width<newWidth;width++){
			for (int height= 0; height<newHeight;height++){
				int resizeHeight = (int)((height/(double)newHeight)*sourceHeight);
				int resizeWidth = (int)((width/(double)newWidth)*sourceWidth);
				resize[width][height]=source[resizeWidth][resizeHeight];
			}
		}
		return resize; 
		// Hints: Use two nested for loops between 0... newWidth-1 and 0.. newHeight-1 inclusive.
		// Hint: You can just use relative proportion to calculate the x (or y coordinate)  in the original image.
		// For example if you're setting a pixel halfway across the image, you should be reading half way across the original image too.
	}

	/**
	 * Half the size of the image. This method should be just one line! Just
	 * delegate the work to resize()!
	 */
	public static int[][] half(int[][] source) {
		return resize(source,(int) Math.floor(source.length*0.5),(int) Math.floor(source[0].length*0.5));
	}
	
	/**
	 * Create a new image array that is the same dimesions of the reference
	 * array. The array may be larger or smaller than the source. Hint -
	 * this methods should be just one line - delegate the work to resize()!
	 * 
	 * @param source
	 *            the source image
	 * @param reference
	 * @return the resized image
	 */
	public static int[][] resize(int[][] source, int[][] reference) {
		return resize(source, reference.length, reference[0].length); // Fix Me
	}

	/** Flip the image vertically */
	public static int[][] flip(int[][] source) {
		int [][] flippedImage=new int[source.length][source[0].length];
		for (int width = 0;width<flippedImage.length;width++){
			for(int height = 0;height<flippedImage[0].length;height++){
				flippedImage[width][height]=source[width][(flippedImage[0].length-1-height)];
			}
		}
		return flippedImage;
	}

	/** Reverse the image horizontally */
	public static int[][] mirror(int[][] source) {
		int [][] mirrorImage = new int[source.length][source[0].length];
		for (int width = 0; width<mirrorImage.length;width++){
			for(int height = 0;height<mirrorImage[0].length;height++){
				mirrorImage[width][height]=source[(mirrorImage.length-1-width)][height];
			}
		}
		return mirrorImage;
	}

	/** Rotate the image */
	public static int[][] rotateLeft(int[][] source) {
		int[][] rotatedPic = new int [source[0].length][source.length];
		for(int width = 0;width<rotatedPic.length;width++){
			for(int height = 0;height<rotatedPic[0].length;height++){
				int newWidth= rotatedPic[0].length-1-height;
				int newHeight=width;
				rotatedPic[width][height] = source[newWidth][newHeight];
			}
		}
		return rotatedPic;
	}

	/** Merge the red,blue,green components from two images */
	public static int[][] merge(int[][] sourceA, int[][] sourceB) {
		// The output should be the same size as the input. Scale (x,y) values
		// when reading the background
		// (e.g. so the far right pixel of the source is merged with the
		// far-right pixel of the background).
		sourceB = resize(sourceB,sourceA.length,sourceA[0].length);
		int[][] mergedPic = new int [sourceA.length][sourceA[0].length];
		for(int bWidth=0;bWidth<sourceB.length;bWidth++){
			for(int bHeight=0;bHeight<sourceB[0].length;bHeight++){
				int redAPixel = RGBUtilities.toRed(sourceA[bWidth][bHeight]);
				int greenAPixel = RGBUtilities.toGreen(sourceA[bWidth][bHeight]);
				int blueAPixel = RGBUtilities.toBlue(sourceA[bWidth][bHeight]);
				
				int redBPixel = RGBUtilities.toRed(sourceB[bWidth][bHeight]);
				int greenBPixel = RGBUtilities.toGreen(sourceB[bWidth][bHeight]);
				int blueBPixel = RGBUtilities.toBlue(sourceB[bWidth][bHeight]);
				
				int newRedPixel = (int)(((redAPixel)+(redBPixel))/2);
				int newGreenPixel = (int)(((greenAPixel)+(greenBPixel))/2);
				int newBluePixel = (int)(((blueAPixel)+(blueBPixel))/2);
				
				mergedPic[bWidth][bHeight]=RGBUtilities.toRGB(newRedPixel,newGreenPixel,newBluePixel);
				
			}
		}
		return mergedPic;
	}

	/**
	 * Replace the green areas of the foreground image with parts of the back
	 * image
	 */
	public static int[][] chromaKey(int[][] foreImage, int[][] backImage) {
		foreImage = resize(foreImage,backImage.length,backImage[0].length);
		int[][] newPic = new int [backImage.length][backImage[0].length];
		for (int width = 0; width < newPic.length; width++){
			for(int height = 0; height < newPic[0].length; height++){
				int newRed = RGBUtilities.toRed(foreImage[width][height]);
				int newGreen = RGBUtilities.toGreen(foreImage[width][height]);
				int newBlue = RGBUtilities.toBlue(foreImage[width][height]);
				
				if((newGreen > newRed) && (newGreen > newBlue)){
					newPic[width][height] = backImage[width][height];
				}
				else {
					newPic[width][height] = foreImage[width][height];
				}
			}
		}
		// If the image has a different size than the background use the
		// resize() method
		// create an image the same as the background size.
		return newPic;
	}

	/** Removes "redeye" caused by a camera flash. sourceB is not used */
	public static int[][] redeye(int[][] source, int[][] sourceB) {

		int width = source.length, height = source[0].length;
		int[][] result = new int[width][height];
		for (int i = 0; i < width; i++)
			for (int j = 0; j < height; j++) {
				int rgb = source[i][j];
				int red = RGBUtilities.toRed(rgb);
				int green = RGBUtilities.toGreen(rgb);
				int blue = RGBUtilities.toBlue(rgb);
				if (red > 4 * Math.max(green, blue) && red > 64)
					red = green = blue = 0;
				result[i][j] = RGBUtilities.toRGB(red, green, blue);
			}

		return result;
	}

	/* Upto you! do something fun to the image */
	public static int[][] funky(int[][] source, int[][] sourceB) {
		// You need to invent your own image effect
		// Minimum boring requirements to pass autograder:
		
		// Does not ask for any user input and returns a new 2D array
		// Todo: remove this return null
		sourceB = chromaKey(source, sourceB);
		return sourceB;
	}
}

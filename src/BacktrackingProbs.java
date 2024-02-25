import java.util.*;

public class BacktrackingProbs {

	public BacktrackingProbs() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		//4
		System.out.print("printBinary(3) >>> ");
		printBinary(3);
		System.out.println();
		System.out.println();

		//5
		System.out.println("climbStairs(4): ");
		climbStairs(4);
		System.out.println();

		//7
		System.out.println("campsite(2, 1): ");
		campsite(2, 1);
		System.out.println();
		
		//8
		System.out.print("getMax(Arrays.asList(7, 30, 8, 22, 6, 1, 14), 19): ");
		System.out.println(getMax(Arrays.asList(7, 30, 8, 22, 6, 1, 14), 19));
	}
	
	//4
	public static void printBinary(int digits) {
		printBinaryHelper(digits, "");
	}
	
	//3
	private static void printBinaryHelper(int digits, String soFar) {
		if (soFar.length() == digits) {
			System.out.print(soFar + " ");
		} else {
			printBinaryHelper(digits, soFar + 0);
			printBinaryHelper(digits, soFar + 1);
		}
	}

	//5
	public static void climbStairs(int steps) {
		climbStairsHelper(steps, "");
	}

	private static void climbStairsHelper(int steps, String soFar) {
		if (steps <= 0) {
			String ret = soFar.substring(0, soFar.length() - 2);
			System.out.println(ret);
		} else {
			climbStairsHelper(steps - 1, soFar + "1, ");
			if (steps >= 2) {
				climbStairsHelper(steps - 2, soFar + "2, ");	
			}
		}
	}
	
	//7
	public static void campsite(int x, int y) {
		campsiteHelper(x, y, 0, 0, "");
	}
	
	public static void campsiteHelper(int x, int y, int xCurr, int yCurr, String soFar) {
		if (xCurr == x && yCurr == y) {
			System.out.println(soFar);
		} else {
			if (xCurr < x) {
                campsiteHelper(x, y, xCurr + 1, yCurr, soFar + "E ");
            }
            if (yCurr < y) {
                campsiteHelper(x, y, xCurr, yCurr + 1, soFar + "N ");
            }
            if (xCurr < x && yCurr < y) {
                campsiteHelper(x, y, xCurr + 1, yCurr + 1, soFar + "NE ");
            }
		}
	}

	//8
	public static int getMax(List<Integer> nums, int limit) {
		return getMaxHelper(nums, limit, 0, 0);
	}

	public static int getMaxHelper(List<Integer> nums, int limit, int total, int count) {
		if (total > limit) {
            return 0;
        } else if (count >= nums.size()) {
            return total;
        } else {
			int newSum = getMaxHelper(nums, limit, total + nums.get(count), count + 1);
            int oldSum = getMaxHelper(nums, limit, total, count + 1);
 
            if (newSum > oldSum) {
            	return newSum;
            } else {
            	return oldSum;
            }
        }
	}
}

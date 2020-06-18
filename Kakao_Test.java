
public class Kakao_Test {

	public static void main(String[] args) {
		int[][] key = {{0, 0, 0}, 
    		    	   {1, 0, 0}, 
    		    	   {0, 1, 1}};
		int[][] lock = {{1, 1, 1}, 
						{1, 1, 0}, 
						{1, 0, 1}};

	System.out.println(solution(key,lock));
	}

	public static boolean solution(int[][] key, int[][] lock) {
		boolean answer = false;
		for(int i=0; i<4; i++) {
			if(match(key,lock))
				return true;
			key = rotate(key);// arr 변수에 key 대입
		}		
		return answer;
	}
	
	public static int[][] rotate(int[][] arr){
		int[][] temp = new int[arr.length][arr.length];
		for(int i = 0; i<arr.length; i++) {
			for(int j = 0; j<arr.length; j++) {
				temp[i][j] = arr[2-j][i];
			}
		}
		return temp; //키 돌리고 match함수에다가 temp를 줌
	}

	public static boolean match(int[][]key,int[][]lock) {
		for(int i = (1-key.length); i<lock.length; i++) {
			for(int j = (1-key.length); j<lock.length; j++) {
				int[][] temp = move(key,lock.length,i,j);
				if(isUnlock(temp,lock)) {
					return true;
				}
			}
		}
		return false;
	}
	
	public static int[][] move(int[][]key, int length, int row, int col){
		int[][] temp = new int[length][length];
		for(int i = 0; i<key.length; i++) {
			for(int j = 0; j<key.length; j++) {
				if((i + row >= 0 ) && (i + row < length) && (j + col >= 0) && (j + col < length)) {
					temp[i+row][j+col] = key[i][j];
				}
			}
		}
		return temp;
	}

	public static boolean isUnlock(int[][] key, int[][] lock) {
		for(int i=0; i<lock.length; i++) {
			for(int j=0; j<lock.length; j++) {
				if((key[i][j] + lock[i][i] != 1)) {
					return false;
				}
			}
		}
		return true;
	}
}



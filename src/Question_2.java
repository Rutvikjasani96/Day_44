public class Question_2 {
//    Given N cows & M stalls, all M stalls are on x-axis at different locations.
//    Place all N cows such a way that minimum distance between only 2 cows is maximized.
//    In a stall only 1 cow can be Present.
//    All cows have to be placed.
    public static void main(String[] args) {
        int[] array = {3, 8, 12, 18, 25, 30, 35, 41, 49};
        int cows = 3;
        System.out.println("ans : "+findMinDest(array,cows));
    }
    static int findMinDest(int[] array,int cows){
        int l=Integer.MAX_VALUE,h=array[array.length-1];
        for(int i=0;i< array.length-1;i++){
            l = Math.min(l,Math.abs(array[i]-array[i+1]));
        }
        int ans = l;
        while(l<=h){
            int mid = (l+h)/2;
            if(check(array,cows,mid)){
                ans = mid;
                h = mid-1;
            }else{
                l = mid+1;
            }
        }
        return ans;
    }
    static boolean check(int[] array,int cows,int dist){
        int c = 0;
        int last_cow = array[0];
        for(int i=0;i<array.length;i++){
            if(array[i] - last_cow  >= dist){
                last_cow = array[i];
                c++;
                if(c==cows){
                    return true;
                }
            }
        }
        return false;
    }
}

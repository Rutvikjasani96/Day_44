public class Question_1 {
//    Given n tasks, K workers & time taken for each task, find min time in which we can complete all tasks.
//    -> A Single worker can only do continuous set of tasks.
//    -> All Workers Start Their assigned tasks at same time.
//    -> A task can only be assigned to a Single Person.
    public static void main(String[] args) {
        int[] array = {3, 5, 1, 7, 8, 2, 5, 3, 10, 1, 4, 7, 5, 4, 6};
        int k=4;
        System.out.println(findMinTime(array,k));
    }
    static int findMinTime(int[] array,int k){
        int l = 0,h = 0,ans=0;
        for(int i=0;i< array.length;i++){
            l = Math.max(l,array[i]);
            h += array[i];
        }
        while(l<=h){
            int mid = (l+h)/2;
            if(check(array,mid,k)){
                ans = mid;
                h = mid-1;
            }else{
                l = mid+1;
            }
        }
        return ans;
    }
    static boolean check(int[] array,int time,int k){
        int worker_cnt=0;
        int work = 0;
        for(int i=0;i<array.length;i++){
            work += array[i];
            if(work>time){
                work = array[i];
                worker_cnt++;
            }
        }
        if(work!=0){
            worker_cnt++;
        }
        if(worker_cnt<=k){
            return true;
        }
        return false;
    }
}

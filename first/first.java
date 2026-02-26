class Solution {
    
    int power(int mid , int n , int m){
        long result = 1;
        
        for(int i = 0; i < n; i++){
            result *= mid;
            
            if(result > m) return 2;   // greater than m
        }
        
        if(result == m) return 1;     // equal
        return 0;                     // less than m
    }
    
    public int nthRoot(int n, int m) {
        
        int low = 1;
        int high = m;
        
        while(low <= high){
            int mid = low + (high - low)/2;
            
            int ans = power(mid, n, m);
            
            if(ans == 1){
                return mid;
            }
            else if(ans == 0){     // mid^n < m
                low = mid + 1;
            }
            else{                  // mid^n > m
                high = mid - 1;
            }
        }
        
        return -1;
    }
}
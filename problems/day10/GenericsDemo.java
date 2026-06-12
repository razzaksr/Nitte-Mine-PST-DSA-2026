// A generic Account class that can hold different types of IDs
class Account<T> {
    private T accountId;

    public Account(T accountId) {
        this.accountId = accountId;
    }

    public T getAccountId() {
        return accountId;
    }
}

class Alpha<T>{
    T[] pack;
    void ternary(T data){
        int start = 0, end = pack.length;
        while(start<end){
            int mid1 = start+(end-start)/3;
            int mid2 = end - (end-start)/3;
            if(pack[mid1].equals(data)) {
                System.out.println(mid1);
                return;
            }
            if(pack[mid2].equals(data)) {
                System.out.println(mid2);
                return;
            }
            String mOne = String.valueOf(pack[mid1]);
            String mTwo = String.valueOf(pack[mid2]);
            String dest = String.valueOf(data);
            if(dest.compareTo(mOne)<0)
                end = mid1-1;
            else if(dest.compareTo(mTwo)>0)
                start = mid2+1;
            else start=mid1+1;end=mid2-1;
        }
    }
}

public class GenericsDemo {
    public static void main(String[] args) {
        Alpha<Double> doub = new Alpha();
        doub.pack = new Double[]{1.3,2.5,3.6,4.8,9.2};
        doub.ternary(9.2);
        Alpha<String> strs = new Alpha();
        strs.pack = new String[]{"a","b","c","d"};
        strs.ternary("d");
        // Account<Integer> acc1 = new Account<>(101);   // account ID as Integer
        // Account<String> acc2 = new Account<>("ACC202"); // account ID as String

        // System.out.println(acc1.getAccountId()); // 101
        // System.out.println(acc2.getAccountId()); // ACC202
    }
}

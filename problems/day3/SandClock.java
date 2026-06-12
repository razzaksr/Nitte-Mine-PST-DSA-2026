package problems.day3;

public class SandClock {
    public static void main(String[] args) {
        String name = "Razak";
        int size = name.length();
        for(int row=size/2;row>0;row--){
            for(int space=size-1;space>row;space--)
                System.out.print(" ");
            for(int col=0;col<=row*2;col++)
                System.out.print(name.charAt(col));
            System.out.println();
        }
        for(int row=0;row<=size/2;row++){
            for(int space=size-1;space>row;space--)
                System.out.print(" ");
            for(int col=0;col<=row*2;col++)
                System.out.print(name.charAt(col));
            System.out.println();
        }
    }
}

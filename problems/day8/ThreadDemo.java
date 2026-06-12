package problems.day8;

class Account {
    int balance = 100;
    synchronized void withdraw(String name, int amount){
        if(balance >= amount){
            System.out.println(name + " withdrawing " + amount);
            balance -= amount;
            System.out.println("Balance left: " + balance);
        } else {
            System.out.println(name + " cannot withdraw, insufficient funds!");
        }
    }
}

class User implements Runnable {
    Account acc; String name;
    User(Account a, String n){ acc=a; name=n; }
    public void run(){ acc.withdraw(name, 70); }
}

public class ThreadDemo {
    public static void main(String[] args){
        Account acc = new Account();
        Thread t1 = new Thread(new User(acc,"Husband"));
        Thread t2 = new Thread(new User(acc,"Wife"));
        t1.start(); t2.start();
    }
}

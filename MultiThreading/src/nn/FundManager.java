package nn;

public class FundManager {
    
    private int fund = 10000;

    public void transct(String name)
    {
        int amt = 100;
        fund += amt;
        fund -= amt;
    }

    public void showFund()
    {
        System.out.println("Fund is rs " + fund);
    }

    public  void doTransaction()
    {
        for(int i = 0 ; i < 10 ; i++)
        {
            Thread th = new Thread(new Runner(String.valueOf((char)('A' + i))));
            th.start();
        }
    }

    public void doFundChecking()
    {
        Thread th = new Thread(new Runnable() {

            @Override
            public void run() {
                while(true)
                {
                    showFund();
                }
            }
            
        });
        th.start();
    }

    public static void main(String[] args) {
        FundManager fm = new FundManager();
        fm.doTransaction();
        fm.doFundChecking();
    }

    public class Runner implements Runnable{

        private String name;
        public Runner(String name)
        {
            this.name = name;
        }

        @Override
        public void run() {
            while (true) { 
                transct(name);
            }
        }
    }
}

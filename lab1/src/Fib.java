

public class Fib {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println( "Please enter command line arguments." );
            System.out.println( "e.g. java Year 2000" );
        }
        for (int i = 0; i < args.length; i++) {
            try {
                int n = Integer.parseInt( args[i] );
                fib( n );
                System.out.println( "第"+n+"个数是" + fib( n ) );
            } catch (NumberFormatException e) {
                System.out.printf( "%s is not a valid number.\n",args[i] );
            }

//        int n = 9;
//        fib( n );
//
//
//        if(n==0||n==1){
//            System.out.println("第"+n+"个数是"+n);
//        }else{
//            System.out.println("第"+n+"个数是"+fib( n ));
//        }


        }
    }
        public static int fib ( int n){
            int[] fib = new int[n];

            fib[0] = 0;
            fib[1] = 1;


            for (int a = 2; a < n; a++) {
                fib[a] = fib[a - 2] + fib[a - 1];

            }

            return fib[n - 1];
        }
    }

    
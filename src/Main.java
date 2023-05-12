import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        //int a, b, x;
        double c;
        int i = 0, n = 1;

//        while (i < 5) {
//            a = (int) (100 - 200 * Math.random());
//            b = (int) (100 - 200 * Math.random());
//            x = (int) (100 * Math.random());
//            c = a + b * x;
//            //System.out.println("a=" + a + " b=" + b + " x=" + x);
//            //System.out.println("c=" + c + "  (int)c=" + (int)c);
//            if (c == (int)c && c <= 100 && c > 0 && (a * b * (int)c * x)!= 0 ) {
//                System.out.println("a=" + a + " b=" + b + " x=" + x + " c=" + c);
//                i++;
//                System.out.println(a + (b * x >= 0 ? "+":"-") + Math.abs(b) + "*" + Math.abs(x) + "=" + c);
//            }
//        }
//        System.out.println("Итерация " + n++ + "  i=" + i);

        try (FileWriter writer = new FileWriter("out.txt", false)) {

            for (int a = -99; a < 100; a++) {
                for (int b = -99; b < 100; b++) {
                    for (int x = 1; x < 100; x++) {
                        c = a + b * x;
                        if (c == (int) c && c <= 100 && c > 0 && (a * b * (int) c * x) != 0 && (a > 0 || b*x > 0)) {
                            System.out.println(i++);
                            writer.write(i + "\n");

                            System.out.println("a=" + a + " b=" + b + " x=" + x + " c=" + c);
                            writer.write("a=" + a + " b=" + b + " x=" + x + " c=" + c + "\n");

                            String stroka;
                            if (a > 0) {stroka = a + (b * x >= 0 ? "+" : "-") + Math.abs(b) + "*" + Math.abs(x) + "=" + c;}
                            else {stroka = b + "*" + x + a + "=" + c;}
                            System.out.println(stroka);
                            writer.write(stroka);
                            //System.out.println(a + (b * x >= 0 ? "+" : "-") + Math.abs(b) + "*" + Math.abs(x) + "=" + c);
                            //writer.write(a + (b * x >= 0 ? "+" : "-") + Math.abs(b) + "*" + Math.abs(x) + "=" + c + "\n");

                            System.out.println("");
                            writer.write( "\n");

                        }
                    }
                }
            }
            System.out.println("Количество решений - " + (i - 1));
            writer.write("Количество решений - " + (i - 1));
            writer.flush();
        }
        catch (IOException ex){
            ex.getMessage();
        }
    }
}
package DGV;

import java.sql.SQLException;

public class Util {

    public static void del(){
        try {
            Thread.sleep(100); // 단위 ms
        } catch (InterruptedException ie) {
            Thread.currentThread().interrupt();
        }
    }

    public static void del2() {

        try {
            Thread.sleep(1000); // 단위 ms
        } catch (InterruptedException ie) {
            Thread.currentThread().interrupt();
        }

    }

    public static void Logo() {
        System.out.println("⠀\u001B[31m⠀⠀⠀\n");
        System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀");
        del();
        System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀");
        del();
        System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀");
        del();
        System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀          ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢠⣪⠂⠀⠀⠀⠀⠀⠀⠀⠀");
        del();
        System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀          ⠀⠀⠀⠀⢀⡠⣄⡀⣃⡡⡤⣀⠀⠀⠀⠀⠀⠀⠀");
        del();
        System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀           ⠀⡸⡵⣝⢮⡺⣪⢮⡫⡮⠁⠀⠀⠀⠀⠀⠀");
        del();
        System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀           ⠀⢯⡺⣜⢞⣎⢗⡵⣝⠆⠀⠀⠀⠀⠀⠀⠀");
        del();
        System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀          ⠀⠀⠀⠀⢱⠽⣜⢵⢕⣗⢽⢜⣝⢤⠀⠀⠀⠀⠀⠀");
        del();
        System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀           ⠀⠀⠫⡮⡳⡳⣕⢗⡳⡵⠁⠀⠀⠀⠀⠀⠀");
        del();
        System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣀⣀⣀⣀⣀⡀⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀           ⠀⠈⠉⠀⠀⠁⠉⠀⠀⠀⠀⠀⠀⠀⠀");
        del();
        System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣝⢽⡹⣝⢝⣝⣝⣝⣝⣝⣕⢧⡳⡲⡤⣀⡀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣠⣢⡳⣝⢵⣓⢮⡲⣕⢮⡺⣪⡳⣝⢝⣝⣝⣝⢝⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀            ⠀⣞⢽⡹⣝⢝⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀");
        del();
        System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣎⢧⡳⣳⡹⡜⡖⡵⡪⡖⡵⣳⡹⣚⢮⡳⣹⡢⡄⠀⠀⠀⠀⢀⣖⡳⣕⢮⡺⡪⡧⡳⠣⠯⠮⠳⢝⢮⡺⣪⡳⣕⢵⣪⡳⡥⠀⠀⠀⠀⠀⠀⠀⠀⠀           ⠀⡸⣜⢵⢝⡼⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀");
        del();
        System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡎⣗⢽⢜⡎⠀⠀⠀⠀⠀⠀⠈⠘⠕⣗⡝⡮⢮⡫⡦⠀⠀⣔⢯⡲⣝⢎⡗⠍⠁⠀⠀⠀⠀⠀⠀   ⠀⠀⠈⠘⠂⢸⠵⣕⢗⢽⡀⠀⠀⠀⠀⠀  ⠀⠀       ⠀⢠⢳⢕⣏⢧⡃⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀");
        del();
        System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡝⣎⢗⡵⡝⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢯⢺⢵⢝⢮⡣⣜⢮⡣⡯⣪⠇⠀⠀⠀  ⠀⠀⠀⠀⠀⠀⠀ ⠀  ⠀⠀⠀⠀⠯⣎⢯⣣⡳⡀⠀⠀⠀⠀⠀⠀        ⠀⡼⡕⡯⣪⡳⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀");
        del();
        System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡝⣎⢗⣝⢮⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠯⡮⡳⣝⢮⢮⢳⡹⣚⠎⠀⠀⠀⠀⠀⠀⠀  ⠀⠀⠀⠀⠀  ⠀⠀  ⠀⠀⠘⣎⢧⢧⡳⡅⠀⠀⠀⠀⠀     ⠀   ⢰⡳⣝⢮⡣⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀");
        del();
        System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡝⡮⡳⣕⢧⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢹⢪⣫⡺⣪⢞⢵⢝⢮⠁⠀⠀⠀⠀  ⠀⢰⡰⣔⢴⡰⣔⢴⡰ ⣔⢴⠄  ⠀⠸⣕⢗⣝⢮⠄⠀⠀⠀     ⠀ ⢀⢗⡵⡳⡵⠍⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀");
        del();
        System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡳⣹⢕⣗⡕⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⢕⢧⡫⡮⣫⢳⢝⡵⠀⠀⠀⠀⠀⠀    ⠰⣝⢎⡧⣫⢮⢳⡹⣜⢮⡃⠀⠀  ⢳⣣⡳⣝⢕⠀⠀⠀     ⠀⣜⢵⢝⢞⠎⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀");
        del();
        System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡝⡮⣣⢧⡫⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣎⢗⡗⣝⢞⢮⡳⣝⢮⡃⠀⠀⠀⠀⠀    ⠈⠈⠁⠉⠈⠪⡳⡝⣎⢧⡃⠀   ⠀⠈⣖⣝⢎⢯⡂⠀⠀   ⢰⢕⣏⢗⡝⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀");
        del();
        System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡳⣝⢮⡺⡪⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡔⣗⡳⡝⡮⡓⡗⡵⡳⣕⢗⡀⠀⠀⠀⠀⠀⠀⠀  ⠀⠀   ⢨⢳⢝⢮⡳⡅⠀⠀⠀   ⠸⣜⢭⡳⡝⡄   ⢀⢗⢧⡳⣝⠌⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀");
        del();
        System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢧⢳⡣⣏⢗⠀⠀⠀⠀⠀⠀⠀⢀⢠⢮⡺⣪⢮⡫⠎⠀⠸⣹⣚⢮⢳⢳⢄⡀⠀⠀⠀⠀⠀⠀⠀   ⠰⣝⢭⢧⡳⡅⠀⠀⠀⠀     ⢱⡳⡝⡞⣆  ⢸⣪⢳⡹⡌⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀");
        del();
        System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡳⡝⡞⣎⢗⢤⢤⢤⢤⢔⢴⢜⢮⡳⡵⡝⡮⡣⠃⠀⠀⠀⠐⠵⣝⣕⢯⢳⢝⡖⡦⣔⢤⢔⢤⡲⣜⢮⢳⢵⢝⠆⠀⠀⠀        ⠐⣝⢮⣫⡺⣜⢮⢳⢝⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀");
        del();
        System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡳⣝⢽⢜⣝⢵⢝⢮⡳⣝⢵⢝⣕⢗⠕⠏⠈⠀⠀⠀⠀⠀⠀⠀⠈⠚⢮⢳⢳⢝⢞⡼⢵⢝⣕⢗⡵⣝⢵⢳⠹⠁⠀⠀⠀         ⠀⠘⡮⣪⢞⡎⣗⣝⠂⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀");
        del();
        System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠑⠑⠑⠑⠑⠉⠃⠃⠋⠈⠑⠉⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠁⠉⠃⠋⠓⠃⠓⠑⠉⠈⠀⠀⠀⠀⠀⠀⠀⠀ ⠀           ⠀⠙⠈⠃⠙⠘⠐⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀");
        del();
        System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀");
        del();
        System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀");
        del();
        System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀");

        System.out.println("\u001B[0m");

        del2();


    }

}

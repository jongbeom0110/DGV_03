package DGV;
public class Calendar {
    public static final String red = "\u001B[31m";
    public static final String blue = "\u001B[34m";
    public static final String exit = "\u001B[0m";

    public static void calender(){

        System.out.println("┌─────────────────────────────────────────┐");
        System.out.println("│               2024 - 03                 │");
        System.out.println("├─────┬─────┬─────┬─────┬─────┬─────┬─────┤");
        System.out.println("│ "+red+"SUN"+exit+" │ MON │ TUE │ WED │ THU │ FRI │ "+blue+"SAT"+exit+" │");
        System.out.println("├─────┼─────┼─────┼─────┼─────┼─────┼─────┤");
        System.out.println("│     │     │     │     │     │  01 │  "+blue+"02"+exit+" │");
        System.out.println("│  "+red+"03"+exit+" │  08 │  09 │  10 │  11 │  12 │  "+blue+"09"+exit+" │");
        System.out.println("│  "+red+"10"+exit+" │  11 │  12 │  13 │  14 │  15 │  "+blue+"16"+exit+" │");
        System.out.println("│  "+red+"17"+exit+" │  22 │  23 │  24 │  25 │  26 │  "+blue+"23"+exit+" │");
        System.out.println("│  "+red+"24"+exit+" │  25 │  26 │  27 │  28 │  29 │  "+blue+"30"+exit+" │");
        System.out.println("│  "+red+"31"+exit+" │     │     │     │     │     │     │");
        System.out.println("└─────┴─────┴─────┴─────┴─────┴─────┴─────┘");
    }

}
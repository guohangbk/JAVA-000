package jvm;

/**
 * @Author guohang
 * @Date 2020/10/17 16:00
 */
public class Hello {
    public static void main(String[] args) {
        int r = 0;
        for (int i = 1; i <= 10; i++) {
            if (i == 5){
                continue;
            }
            r += i;
        }
        System.out.println(r);
    }
}

/*
编译出来的字节码

Compiled from "Hello.java"
public class jvm.Hello {
  public jvm.Hello();
    Code:
       0: aload_0
       1: invokespecial #1                  // Method java/lang/Object."<init>":()V
       4: return

  public static void main(java.lang.String[]);
    Code:
       0: iconst_0
       1: istore_1
       2: iconst_1
       3: istore_2
       4: iload_2
       5: bipush        10
       7: if_icmpgt     28
      10: iload_2
      11: iconst_5
      12: if_icmpne     18
      15: goto          22
      18: iload_1
      19: iload_2
      20: iadd
      21: istore_1
      22: iinc          2, 1
      25: goto          4
      28: getstatic     #2                  // Field java/lang/System.out:Ljava/io/PrintStream;
      31: iload_1
      32: invokevirtual #3                  // Method java/io/PrintStream.println:(I)V
      35: return
}


*/


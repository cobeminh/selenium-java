package testing.vn.practiceb1;

import java.util.Scanner;

public class ex1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //kiem tra ki tu nhap vao co phai la nguyen am hay k?

        System.out.println("Nhap 1 ki tu:");
        String str = scanner.nextLine();

        if (str.length() != 1) throw new IllegalArgumentException("input a letter only");
        //IllegalArgumentException(N) Tham so k hop le
        System.out.println(vowelCheck(str));
/*
tim so luong nguyen am trong mot chuoi cho truoc "Learn with Japanese Sachdeva"
int count=0
duyet tung ki tu bang vong for(string=>char)
neu la nguyen am +1
 */
        System.out.println("Nhap chuoi:");
        String sentence = scanner.nextLine();
        int count = 0;
        for (int i = 0; i < sentence.length(); i++) {
            char c = sentence.charAt(i);
            if (vowelCheck(c + "")) {
                System.out.print(sentence.charAt(i) + " ");
                count++;
            }
        }
        System.out.println("\nSo luong nguyen am trong chuoi la " + count);
    }

    public static boolean vowelCheck(String str) {
        String s = "" + str;
        if (s.matches("[aoeuiAOEUI]+")) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean vowelCheck2(String str) {

        if (str.equalsIgnoreCase("u") || //equalsIgnoreCase k phan biet hoa thuong
                str.equalsIgnoreCase("e") ||
                str.equalsIgnoreCase("o") ||
                str.equalsIgnoreCase("a") ||
                str.equalsIgnoreCase("i")) {
            return true;
        } else{
            return false;
        }
    }


}

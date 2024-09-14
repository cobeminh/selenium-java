package testing.vn.practiceb1;

public class ex2 {
    public static void main(String[] args) {
    /*
    viet mot chuong trinh kiem tra mot password co hop le hay k?
    -nhieu hon 8 ki tu
    -co chu thuong chu hoa
    -co so
    -co kitu dac biet
     */
        String password="Minh2604$";
        String password1="Minh2604";
        String password2="Nam2*";
        System.out.println(passwordCheck(password));
        System.out.println(passwordCheck(password1));
        System.out.println(passwordCheck(password2));
        //khong nen dung cach 2 do ton tgian, nma thay k hieu cach 1 nen thay huong dan cach 2 va cach 1 lâu
        System.out.println(passwordCheck2(password));
        System.out.println(passwordCheck2(password1));
        System.out.println(passwordCheck2(password2));


    }
    //cach1
    public static boolean passwordCheck(String password){
        if (password.length()>=8                              //=isLengthCheck()
                &&password.matches(".*[a-z].*")        //=isUpperCaseCheck()
                && password.matches(".*[A-Z].*")        //=isLowerCaseCheck()
                && password.matches(".*[0-9].*")        //=isDigit()
                && password.matches(".*[!@#$%^&*].*")) {//=isSpecialCharactersCheck()
                return true;
        }
        else return false;
    }
    //cach2
    public static boolean passwordCheck2(String password){
        return isLengthCheck(password)
                && isUpperCaseCheck(password)
                && isLowerCaseCheck(password)
                && isDigitCheck(password)
                && isSpecialCharactersCheck(password);
    }
    public static boolean isLengthCheck(String password){
        return password.length()>=8;
    }
    public static boolean isUpperCaseCheck(String password){
        for (int i =0;i<password.length();i++){
            if(Character.isUpperCase(password.charAt(i))){
                return true;
            }
        }
        return false;
    }
    public static boolean isLowerCaseCheck(String password){
        for (int i =0;i<password.length();i++){
            if(Character.isLowerCase(password.charAt(i))){
                return true;
            }
        }
        return false;
    }
    public static boolean isDigitCheck(String password){
        for (int i =0;i<password.length();i++){
            if(Character.isDigit(password.charAt(i))){
                return true;
            }
        }
        return false;
    }
    public static boolean isSpecialCharactersCheck(String password){
        for (int i =0;i<password.length();i++){
            if("!@#$%^7*".contains(password.charAt(i)+"")){
                return true;
            }
        }
        return false;
    }

}

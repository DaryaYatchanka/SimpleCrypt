package Crypto.src;

import static java.lang.Character.isLowerCase;
import static java.lang.Character.isUpperCase;
import static java.lang.Character.toLowerCase;

public class ROT13  {

 private int key;

    ROT13(Character cs, Character cf) {

        this.key= cf-cs;

    }

    ROT13() {


    }


    public String crypt(String text) throws UnsupportedOperationException {

        return shift(text, key);
    }

    public String encrypt(String text) {


        return shift(text, key);
    }

    public String decrypt(String text) {

        return shift(text, 26-key);
    }

    public static String rotate(String s, Character c) {

        String rotated = "";
       rotated+= s.substring(s.indexOf(c))+s.substring(0, s.indexOf(c));



        return rotated;
    }

   public String shift(String str, int shift){
       StringBuilder sb = new StringBuilder();

       char c;
       for (int i = 0; i < str.length(); i++) {
           c = str.charAt(i);

           if (Character.isLetter(c)) {
               c = (char) (str.charAt(i) + shift);

               if((Character.isLowerCase(str.charAt(i))&& c >'z')||(Character.isUpperCase(str.charAt(i))&& c >'Z')){
                c = (char) (str.charAt(i)-(26-shift));
               }
           }
           sb.append(c);
       }

       return sb.toString();
   }

}

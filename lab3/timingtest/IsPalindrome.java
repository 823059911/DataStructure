package timingtest;

public class IsPalindrome {
    public boolean isPalindrome(int x) {
        String a=String.valueOf(x);
        Character[]elems=new Character[a.length()];
        int j=0;
        for(int i=a.length()-1;i>=0;i--){
            elems[j]=a.charAt(i);
            j++;
        }
        String temp="";
        for(Character elem:elems){
            temp+=elem;
        }
        return temp.equals(a)?true:false;
    }
    public static void main(String[] args) {
        IsPalindrome a=new IsPalindrome();
        boolean b=a.isPalindrome(3443);
        System.out.println(b);
    }
}

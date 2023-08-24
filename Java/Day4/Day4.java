import java.security.MessageDigest;

public class Day4 {
    public static void main(String[] args) {
        final String KEY_STARTS_WITH = "000000";
        final String INPUT = "yzbqklnj";
        MessageDigest md;

        try{
            md = MessageDigest.getInstance("MD5");
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            return;
        }

        for(int i = 0; i<Integer.MAX_VALUE; i++){
            if (getMD5(md, INPUT+i).startsWith(KEY_STARTS_WITH)){
                System.out.println(i);
                return;
            }
        }
    }

    public static String getMD5(MessageDigest md, String input){
        byte[] messageDigest = md.digest(input.getBytes());
        String output = "";
        for(byte b : messageDigest){
            output+=String.format("%02X", b);
        }
        return output;
    }
}
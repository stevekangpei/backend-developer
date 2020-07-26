import org.springframework.security.crypto.bcrypt.BCrypt;

/**
 * description: BCrypyt <br>
 * date: 2020/7/26 5:03 下午 <br>
 * author: kangpei <br>
 * version: 1.0 <br>
 */

public class BCrypyt1 {


    public  static void test() {
//        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
//
//        String encode = encoder.encode("123");
//        System.out.println(encode);
        String hashpw = BCrypt.hashpw("123", BCrypt.gensalt());
        System.out.println(hashpw);
    }


    public static void main(String[] args) {
        test();
    }
}

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/**
 * ASCII-->GBK-->Unicode-->UTF-8
 * 大小写英文字母、数字和一些符号-->增加中文-->所有类型文字，2个字节一个字符-->每种类型占用的字符个数自适应，减少了占用空间
 */
public class Encode {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String s = "你好";

// 编码
        byte[] utf = s.getBytes("utf-8");
        byte[] gbk = s.getBytes("gbk");

        System.out.println("utf-8编码：" + Arrays.toString(utf)); // [-28, -67, -96, -27, -91, -67]  6个字节
        System.out.println("gbk编码：" + Arrays.toString(gbk)); // [-60, -29, -70, -61]<span style="white-space:pre">  </span>4个字节

// 解码
        String s1 = new String(utf, "utf-8"); // 你好
        String s2 = new String(utf, "gbk");// gbk解码：浣犲ソ gbk用2个字节解码，所以会多一个字符
        String s3 = new String(gbk, "utf-8");// gbk用utf-8解码：??? <span style="white-space:pre">  </span>utf-8解码需要6个字节

        System.out.println("--------------------");
        System.out.println("utf-8解码：" + s1);
        System.out.println("gbk解码：" + s2);
        System.out.println("gbk用utf-8解码：" + s3);
        System.out.println("---------------------");

        System.out.println("用utf-8编码回去");

        s3 = new String(s3.getBytes("utf-8"), "gbk");  // 锟斤拷锟?   gbk用utf-8解码后无法编回去

        System.out.println(s3);
    }
}

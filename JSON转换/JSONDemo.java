import net.sf.json.JSONArray;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * 6个包一个不能少， 否则解析会报错
 */
public class JSONDemo {
    @Test
    public void test1(){
        ArrayList<Map<String,String>> list = new ArrayList<Map<String,String>>();
        HashMap<String, String> hashMap = null;
        hashMap = new HashMap<>();
        hashMap.put("name", "wangming");
        hashMap.put("sex", "man");
        list.add(hashMap);
        hashMap = new HashMap<>();
        hashMap.put("name", "wangming");
        hashMap.put("sex", "man");
        list.add(hashMap);

        JSONArray jsonObject = JSONArray.fromObject(list);
        System.out.println(jsonObject);


        //js将json格式数据，输出到页面上的表格。

        System.out.println(list.toString());
    }
}

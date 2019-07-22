package fastjson;

import com.alibaba.fastjson.JSON;
import org.junit.ClassRule;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

public class Demo2 {
    @Test
    public void test() {
        HashMap<String, String> stringStringHashMap = new HashMap<>();
        String s = "{\"czrkBeans\":[{\"bdyy\":null,\"byqk\":null,\"csd\":null,\"csdgj\":null,\"csdxz\":null,\"csrq\":null,\"cym\":null,\"fwcs\":null,\"hdqr\":null,\"hh\":null,\"hkszd\":null,\"hyzk\":null,\"jggj\":null,\"jgssx\":null,\"mz\":null,\"qtzzssxq\":null,\"qtzzxz\":null,\"rybh\":null,\"sfzh\":null,\"sg\":null,\"whcd\":null,\"xb\":null,\"xm\":\"林海萍\",\"xp\":null,\"yhzgx\":null,\"zy\":null,\"zzssxq\":null,\"zzxz\":null}],\"jsryBeans\":[{\"cclzrq\":null,\"csrq\":null,\"dabh\":null,\"djzzxz\":null,\"fzjg\":null,\"gj\":null,\"jszh\":null,\"jszyxqsrq\":null,\"jszyxzzrq\":null,\"jszzt\":null,\"lxdh\":null,\"sfzjzl\":null,\"xb\":null,\"xm\":\"林海萍\",\"xzzxz\":null,\"zjcx\":null}],\"lkzsBeans\":[{\"bz\":null,\"csrq\":null,\"cyzjdm\":null,\"czdw_gajgmc\":null,\"gmsfhm\":null,\"hjd_dzmc\":null,\"hjd_xzqhdm\":null,\"ld_mc\":null,\"ld_xz\":null,\"ld_xzqh\":null,\"lgbm\":null,\"mzdm\":null,\"rzfh\":null,\"rzsj\":null,\"sc_xxrksj\":null,\"xbdm\":null,\"xm\":\"林海萍\",\"xxrksj\":null,\"xxzjbh\":null,\"zjhm\":null}],\"xfdryBeans\":[{\"bmch\":null,\"ccchsj\":null,\"chdd\":null,\"chdw\":null,\"csrq\":null,\"hjszd\":null,\"hjszdxxdz\":null,\"sfzh\":null,\"sjjzd\":null,\"sjjzdxxdz\":null,\"wffzss\":null,\"xb\":null,\"xm\":\"林海萍\"}]}";
        PersonInfoBean personInfoBean = JSON.parseObject(s, PersonInfoBean.class);
        System.out.println(personInfoBean.getCzrkBeans()[0].getCsrq().toString());
        return;
}

    @Test
    public void test2(){
        String s = "<?xmlversion=\"1.0\"encoding=\"UTF-8\"?><RBSPMessage><Version/><ServiceID>S10-00000298</ServiceID><TimeStamp/><Validity/><Security><SignatureAlgorithm=\"\"/><CheckCodeAlgorithm=\"\"/><Encrypt/></Security><Method><Name>Query</Name><Items><Item><ValueType=\"arrayOfArrayOf_string\"><Row><Data>000</Data><Data/><Data/><Data/><Data/><Data/><Data/><Data/><Data/><Data/><Data/><Data/><Data/><Data/><Data/></Row><Row><Data>XM</Data><Data>XB</Data><Data>CYM</Data><Data>MZ</Data><Data>CSRQ</Data><Data>ZZSSXQ</Data><Data>ZZXZ</Data><Data>CSD</Data><Data>SFZH</Data><Data>SG</Data><Data>ZY</Data><Data>WHCD</Data><Data>FWCS</Data></Row><Row><Data>陈功</Data><Data>1</Data><Data>陈工</Data><Data>01</Data><Data>19851024</Data><Data>140105</Data><Data>山西省太原市小店区高新街１９号散户</Data><Data>140423</Data><Data>140423198510240017</Data><Data>180</Data><Data>职员</Data><Data>20</Data><Data>高新人才</Data></Row></Value></Item></Items></Method></RBSPMessage>";
        s=s.replaceAll("\n","");
        s=s.replaceAll("\r","");
        s=s.replaceAll("<Data/>","<Data></Data>");
        s=s.replaceAll(" ","");
        String[] sz1 = s.split("</Row>");
        String[] sz2 = null;
        int i = 2;
        sz2 = sz1[i].split("</Data>");
        for(String ss :sz2){
            System.out.println(ss);
        }
        String BIRTHDATE = sz2[4].substring(sz2[4].indexOf("<Data>")+6,sz2[4].length());// 出生日期
        String CZRKXB = sz2[1].substring(sz2[1].indexOf("<Data>")+6,sz2[1].length());// 性别
        String CZRKZZXZQH=sz2[5].substring(sz2[5].indexOf("<Data>")+6,sz2[5].length());// 常住人口行政区划，住址省市县(区)

        StringBuffer ret = new StringBuffer();
        ret.append("document.frminput.NAME.style.color = '#000000';").
                append("document.frminput.NAME.value='"+sz2[0].substring(sz2[0].indexOf("<Data>")+6,sz2[0].length())+"';").// 姓名
                append("document.frminput.nSEX.value='"+CZRKXB+"';"). //常住人口性别
                append("document.frminput.SEX.value='"+CZRKXB+"';");

    }

    @Test
    public void test3(){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
        String format = simpleDateFormat.format(new Date());
        System.out.println(format);
    }


}

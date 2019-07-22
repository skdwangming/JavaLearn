package fastjson;

import java.util.Arrays;

public class PersonInfoBean {
    private CzrkBean[] czrkBeans;
    private JsryBean[] jsryBeans;
    private LkzsBean[] lkzsBeans;
    private XfdryBean[] xfdryBeans;
    private ZtryBean[] ztryBeans;

    public CzrkBean[] getCzrkBeans() {
        return czrkBeans;
    }

    public void setCzrkBeans(CzrkBean[] czrkBeans) {
        this.czrkBeans = czrkBeans;
    }

    public JsryBean[] getJsryBeans() {
        return jsryBeans;
    }

    public void setJsryBeans(JsryBean[] jsryBeans) {
        this.jsryBeans = jsryBeans;
    }

    public LkzsBean[] getLkzsBeans() {
        return lkzsBeans;
    }

    public void setLkzsBeans(LkzsBean[] lkzsBeans) {
        this.lkzsBeans = lkzsBeans;
    }

    public XfdryBean[] getXfdryBeans() {
        return xfdryBeans;
    }

    public void setXfdryBeans(XfdryBean[] xfdryBeans) {
        this.xfdryBeans = xfdryBeans;
    }

    public ZtryBean[] getZtryBeans() {
        return ztryBeans;
    }

    public void setZtryBeans(ZtryBean[] ztryBeans) {
        this.ztryBeans = ztryBeans;
    }

    @Override
    public String toString() {
        return "PersonInfoBean{" +
                "czrkBeans=" + Arrays.toString(czrkBeans) +
                ", jsryBeans=" + Arrays.toString(jsryBeans) +
                ", lkzsBeans=" + Arrays.toString(lkzsBeans) +
                ", xfdryBeans=" + Arrays.toString(xfdryBeans) +
                ", ztryBeans=" + Arrays.toString(ztryBeans) +
                '}';
    }
}

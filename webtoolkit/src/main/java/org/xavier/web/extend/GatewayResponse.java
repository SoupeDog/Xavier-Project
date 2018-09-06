package org.xavier.web.extend;

/**
 * 描述信息：<br/>
 * 默认网关返回对象
 *
 * @author Xavier
 * @version 1.0
 * @date 2018.09.06
 * @since Jdk 1.8
 */
public class GatewayResponse<T> {
    /**
     * 返回值类型 1 成功 2 请求方引发的异常 3服务端异常
     */
    private Byte type;
    /**
     * 响应状态码
     */
    private Float code;
    /**
     * 补充信息，通常请求失败时才有实质性内容
     */
    private String msg;

    /**
     * 返回的实际内容
     */
    private T data;

    /**
     * 服务端响应时间戳(返回结果的瞬间)
     */
    private Long ts;

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }

    public Float getCode() {
        return code;
    }

    public void setCode(Float code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Long getTs() {
        return ts;
    }

    public void setTs(Long ts) {
        this.ts = ts;
    }
}

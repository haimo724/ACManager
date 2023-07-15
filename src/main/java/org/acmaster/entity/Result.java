package org.acmaster.entity;

/**
在实际开发中，后端开发人员一般会提前定义好响应数据的结构
状态码：code
描述信息：message
数据（Object）：data
 * @author whh
 */
public class  Result {

    private int code = 200;

    @Override
    public String toString() {
        return "Result{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Result(int code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    private String message = "success";
    private Object data;

    public Result(int code) {
        this.code = code;
    }

    public Result(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public Result(Object data) {
        this.data = data;
    }

    public Result() {
    }
}

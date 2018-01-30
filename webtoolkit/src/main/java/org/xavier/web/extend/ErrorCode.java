package org.xavier.web.extend;

/**
 * 描述信息：<br/>
 *
 * @author Xavier
 * @version 1.0
 * @date 2018/1/14
 * @since Jdk 1.8
 */
public enum ErrorCode {
    USER_NOTFOUND(404.1d),
    ARTICLE_NOTFOUND(404.2d),
    BOARD_NOTFOUND(404.3d),
    STATEMENT_NOTFOUND(404.4d),
    ARTICLECATEGORY_NOTFOUND(404.5d),




    USER_EXISTS(409.1d);
    private Double errorCod;

    ErrorCode(Double errorCod) {
        this.errorCod = errorCod;
    }

    public Double getErrorCod() {
        return errorCod;
    }

    public void setErrorCod(Double errorCod) {
        this.errorCod = errorCod;
    }
}

package exception;

import org.springframework.http.HttpStatus;

public class ProductExistException extends RuntimeException{

    public String getErrorMessage() {
        return "商品名称已存在，请输入新的商品名称";
    }
}

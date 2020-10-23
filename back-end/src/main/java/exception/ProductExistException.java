package exception;

import org.springframework.http.HttpStatus;

public class ProductExistException extends RuntimeException{

    public String getErrorMessage() {
        return "商品已存在，请检查您输入的商品名";
    }
}

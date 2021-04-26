package za.co.yoyowallet.kyc.utils.messages;

import java.util.List;

/**
 * Created  26/04/2021 - 10:04
 * Project  kyc
 * Author   Evans K F C
 **/
public class CustomerResponse<T> extends CommonResponse{

    private Long totalPages;

    public Long getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Long totalPages) {
        this.totalPages = totalPages;
    }

    private List<T> list;

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

}

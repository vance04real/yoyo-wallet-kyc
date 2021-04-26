package za.co.yoyowallet.kyc.utils;

import java.util.List;

/**
 * Created  25/04/2021 - 23:13
 * Project  kyc
 * Author   Evans K F C
 **/
public class CommonResponse <T> {
    private String narrative;
    private boolean success;
    private List<T> list;

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public String getNarrative() {

        return narrative;
    }

    public void setNarrative(String narrative) {
        this.narrative = narrative;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}

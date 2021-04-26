package za.co.yoyowallet.kyc.utils.messages;

import java.util.List;

/**
 * Created  25/04/2021 - 23:13
 * Project  kyc
 * Author   Evans K F C
 **/
public class CommonResponse {
    private String narrative;
    private boolean success;
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

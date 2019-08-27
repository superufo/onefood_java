package com.alamousse.modules.common.service;

import com.alamousse.modules.common.domain.VerificationCode;
import com.alamousse.modules.common.domain.vo.EmailVo;

/**
 * @author mike
 * @date 2018-12-26
 */
public interface VerificationCodeService {

    /**
     * 发送邮件验证码
     * @param code
     */
    EmailVo sendEmail(VerificationCode code);

    /**
     * 验证
     * @param code
     */
    void validated(VerificationCode code);
}

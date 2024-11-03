package com.victor.vbill.domain.login;

import com.victor.vbill.common.CommonEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class User extends CommonEntity {
    private String username;
}

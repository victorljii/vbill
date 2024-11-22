package com.victor.vbill.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class CommonEntity {
    private static final String DEFAULT_USER = "anonymous";

    private Long id;
    private Long createdDate;
    private String createdBy;
    private Long updatedDate;
    private String updatedBy;

    public void applyAuditInfoOnCreate(String createdBy) {
        long now = System.currentTimeMillis();
        this.createdBy = createdBy;
        this.createdDate = now;
        this.updatedBy = createdBy;
        this.updatedDate = now;
    }

    public void applyAuditInfoOnCreate() {
        applyAuditInfoOnCreate(DEFAULT_USER);
    }

    public void applyAuditInfoOnUpdate(String updatedBy) {
        this.updatedDate = System.currentTimeMillis();
        this.updatedBy = updatedBy;
    }

    public void applyAuditInfoOnUpdate() {
        applyAuditInfoOnUpdate(DEFAULT_USER);
    }
}

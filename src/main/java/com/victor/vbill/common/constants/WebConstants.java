package com.victor.vbill.common.constants;

/**
 * Web 请求相关的常量
 *
 * @date 2024/11/27
 */
public interface WebConstants {
    // Header 的字段
    enum Header {
        AUTHORIZATION("v-authorization"),
        USERNAME("v-username");

        private final String value;
        Header(String value) {
            this.value = value;
        }

        public String value() {
            return this.value;
        }
    }

}

package com.balcony.grande.apis.model.response;

import lombok.*;

import java.util.List;
import java.util.Map;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WebResponse<T> {
    
    private String status;
    private Integer code;
    private T data;
    
    @Singular
    private Map<String, List<String>> errors;
    
    private PagingResponse paging;
    
    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class PagingResponse {
        private Integer page;
        private Integer size;
        private Long totalItem;
        private Integer totalPage;
    }
    
    public static <T> WebResponse<T> success(T data) {
        return WebResponse.<T>builder()
                .status("success")
                .code(200)
                .data(data)
                .build();
    }
    
    
}

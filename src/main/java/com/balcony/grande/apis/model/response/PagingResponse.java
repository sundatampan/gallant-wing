package com.balcony.grande.apis.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PagingResponse<T> {
    
    private Integer page;
    
    private Integer size;
    
    private Long totalItem;
    
    private Integer totalPage;
    
    private T content;
}
package com.zrq.core.corerequest;

import lombok.Data;
import lombok.experimental.SuperBuilder;
import lombok.experimental.Tolerate;

/**
 * @Author:
 * @CreateDate: 2020/10/29
 * @Version: 类说明：
 */
@Data
@SuperBuilder
public class PageRequest<T> {

    private Long pageNo;

    private Long pageSize;

    private Boolean isAsc;

    private String orderBy;

    private T params;

    @Tolerate
    public PageRequest() {
        if(this.pageNo == null) this.pageNo = -1L;
        if(this.pageSize == null) this.pageSize = -1L;
        if(this.isAsc == null) this.isAsc = false;
        if (this.orderBy == null) this.orderBy = "id";
    }
    public void resetQueryUtil(PageRequest pageRequest){
        if (pageRequest.getOrderBy() != null && !pageRequest.getOrderBy().contains("_")) {
            pageRequest.setOrderBy(humpToLine(pageRequest.getOrderBy()));
        }
    }

    public String humpToLine(String str) {
        return str.replaceAll("[A-Z]", "_$0").toLowerCase();
    }


}

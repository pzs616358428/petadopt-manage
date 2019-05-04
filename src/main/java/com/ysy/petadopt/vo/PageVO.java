package com.ysy.petadopt.vo;

import lombok.Data;

@Data
public class PageVO {

    /* 当前页码 */
    private Integer number;

    /* 总页数 */
    private Integer totalPages;

    /* 数据总条数 */
    private Long totalElements;

    /* 是否是第一页 */
    private boolean isFirst;

    /* 是否是最后一页 */
    private boolean isLast;

    /* 是否还有下一页 */
    private boolean hasNext;

    /* 是否还有上一页 */
    private boolean hasPrevious;

    public static PageVO of (Integer number, Integer totalPages,Long totalElements, boolean isFirst, boolean isLast, boolean hasNext, boolean hasPrevious) {
        PageVO pageVO = new PageVO();
        pageVO.number = number;
        pageVO.totalPages = totalPages;
        pageVO.totalElements = totalElements;
        pageVO.isFirst = isFirst;
        pageVO.isLast = isLast;
        pageVO.hasNext = hasNext;
        pageVO.hasPrevious = hasPrevious;
        return pageVO;
    }

}

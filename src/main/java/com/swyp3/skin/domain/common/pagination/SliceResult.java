package com.swyp3.skin.domain.common.pagination;

import java.util.List;

public record SliceResult<T>(
        List<T> items,
        boolean hasNext
) {
}

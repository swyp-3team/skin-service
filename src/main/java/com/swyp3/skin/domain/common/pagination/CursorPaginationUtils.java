package com.swyp3.skin.domain.common.pagination;

import java.util.List;
import java.util.function.Function;

public final class CursorPaginationUtils {

    private CursorPaginationUtils(){}

    public static <T, ID> SliceResult<T> sliceWithCursor(
            List<T> list,
            ID cursor,
            int size,
            Function<T, ID> idExtractor
    ) {
        int startIndex = 0;

        if (cursor != null) {
            for (int i = 0; i < list.size(); i++) {
                if (idExtractor.apply(list.get(i)).equals(cursor)) {
                    startIndex = i + 1;
                    break;
                }
            }
        }

        List<T> sliced = list.stream()
                .skip(startIndex)
                .limit(size)
                .toList();

        boolean hasNext = list.size() > startIndex + size;

        return new SliceResult<>(sliced, hasNext);
    }
}

package org.openfact.models.db.jpa;

import org.openfact.models.ScrollableResultsModel;

import java.util.function.Function;

public class ScrollableResultsAdapter<T, R> /*implements ScrollableResultsModel<R>*/ {

//    private final ScrollableResults scroll;
//    private final Function<T, R> reader;
//
//    public ScrollableResultsAdapter(ScrollableResults scroll, Function<T, R> reader) {
//        this.scroll = scroll;
//        this.reader = reader;
//    }
//
//    @Override
//    public void close() {
//        scroll.close();
//    }
//
//    @Override
//    public boolean next() {
//        return scroll.next();
//    }
//
//    @Override
//    public boolean previous() {
//        return scroll.previous();
//    }
//
//    @Override
//    public boolean scroll(int positions) {
//        return scroll.scroll(positions);
//    }
//
//    @Override
//    public boolean last() {
//        return scroll.last();
//    }
//
//    @Override
//    public boolean first() {
//        return scroll.first();
//    }
//
//    @Override
//    public void beforeFirst() {
//        scroll.beforeFirst();
//    }
//
//    @Override
//    public void afterLast() {
//        scroll.afterLast();
//    }
//
//    @Override
//    public boolean isFirst() {
//        return scroll.isFirst();
//    }
//
//    @Override
//    public boolean isLast() {
//        return scroll.isLast();
//    }
//
//    @Override
//    public int getRowNumber() {
//        return scroll.getRowNumber();
//    }
//
//    @Override
//    public boolean setRowNumber(int rowNumber) {
//        return scroll.setRowNumber(rowNumber);
//    }
//
//    @Override
//    public R get() {
//        return reader.apply((T) scroll.get(0));
//    }

}

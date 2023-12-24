package pojos;

import java.util.List;

public class Item {

    private int pageNumber;
    private int pageSize;
    private int apiResultType;
    private Object message;
    private List<ItemData> data;


    public Item() {
    }

    public Item(int pageNumber, int pageSize, int apiResultType, Object message, List<ItemData> data) {
        this.pageNumber = pageNumber;
        this.pageSize = pageSize;
        this.apiResultType = apiResultType;
        this.message = message;
        this.data = data;
    }


    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getApiResultType() {
        return apiResultType;
    }

    public void setApiResultType(int apiResultType) {
        this.apiResultType = apiResultType;
    }

    public Object getMessage() {
        return message;
    }

    public void setMessage(Object message) {
        this.message = message;
    }

    public List<ItemData> getData() {
        return data;
    }

    public void setData(List<ItemData> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Item{" +
                "pageNumber=" + pageNumber +
                ", pageSize=" + pageSize +
                ", apiResultType=" + apiResultType +
                ", message=" + message +
                ", data=" + data +
                '}';
    }
}

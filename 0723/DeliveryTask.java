public class DeliveryTask {
    private String id;
    private String address;
    private String item;

    public DeliveryTask(String id, String address, String item) {
        this.id = id;
        this.address = address;
        this.item = item;
    }

    public String getId() {
        return id;
    }

    public String getAddress() {
        return address;
    }

    public String getItem() {
        return item;
    }

    @Override
    public String toString() {
        return "配送編號：" + id +
               " 地址：" + address +
               " 物品：" + item;
    }
}
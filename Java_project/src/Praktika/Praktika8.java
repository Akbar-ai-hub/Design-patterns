package Praktika;

interface IInternalDeliveryOrder{
    void DeliverOrder(String orderId);
    String GetdeliveryStatus(String orderId);
}

class InternalDeliveryOrder implements IInternalDeliveryOrder{
    @Override
    public void DeliverOrder(String orderId) {

    }

    @Override
    public String GetdeliveryStatus(String orderId) {
        return "";
    }
}

class ExternalGlovoService{
    public void ShipItem(int itemId){

    }
    public String TrackShipment(int itemId){
        return "";
    }
}

class LogisticGlovoAdapter implements IInternalDeliveryOrder{
    private ExternalGlovoService glovoService;

    public LogisticGlovoAdapter(ExternalGlovoService glovoService){
        this.glovoService = glovoService;
    }

    @Override
    public void DeliverOrder(String orderId) {
        int item = Integer.parseInt(orderId);
    }

    @Override
    public String GetdeliveryStatus(String orderId) {
        return "";
    }
}

public class Praktika8 {
    public static void main(String[] args){
        String orderType = "Nexia";
        IInternalDeliveryOrder service = null;

        if (orderType == "Nexia"){
            service = new InternalDeliveryOrder();
        } else if (orderType == "Glovo") {
            service = new LogisticGlovoAdapter(new ExternalGlovoService());
        }

        service.DeliverOrder("12345");
        String status = service.GetdeliveryStatus("123");
    }
}


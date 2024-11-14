package Praktika;

import java.util.Date;

class RoomBookingSystem{
    public void makeReservations(Date startTime, Date endTime, int peopleAmount){

    }
    public void Payment(double pay){

    }
}

class cleaningService{
    public void Notify(Date startTime, Date endTime, int roomNum){

    }
}

class RestaurantService{
    public void Notify(int roomNum, int peopleAmount){

    }
}

class HotelFacade{
    public void bookRoom(Date startTime, Date endTime, int peopleAmount, int roomNum){
        RoomBookingSystem roomBookingSystem = new RoomBookingSystem();
        roomBookingSystem.makeReservations(startTime, endTime, peopleAmount);
        roomBookingSystem.Payment(500);
        cleaningService service = new cleaningService();
        service.Notify(startTime, endTime, roomNum);
        RestaurantService restaurantService = new RestaurantService();
        restaurantService.Notify(roomNum, peopleAmount);
    }
}

public class Praktika9 {
    public static void main(String[] args){
        HotelFacade hotelFacade = new HotelFacade();
        //hotelFacade.bookRoom();
    }
}

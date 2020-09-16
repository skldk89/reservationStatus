package RestaurantReservation;

import RestaurantReservation.config.kafka.KafkaProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class ReservationStatusViewHandler {


    @Autowired
    private ReservationStatusRepository reservationStatusRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whenReservationRequested_then_CREATE_1 (@Payload ReservationRequested reservationRequested) {
        try {
            if (reservationRequested.isMe()) {
                // view 객체 생성
                ReservationStatus reservationStatus = new ReservationStatus();
                // view 객체에 이벤트의 Value 를 set 함
                reservationStatus.setId(reservationRequested.getId());
                reservationStatus.setReservationId(reservationRequested.getReservationId());
                reservationStatus.setOwnerId(reservationRequested.getOwnerId());
                // view 레파지 토리에 save
                reservationStatusRepository.save(reservationStatus);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    @StreamListener(KafkaProcessor.INPUT)
    public void whenReservationDeclined_then_UPDATE_1(@Payload ReservationDeclined reservationDeclined) {
        try {
            if (reservationDeclined.isMe()) {
                // view 객체 조회
                List<ReservationStatus> reservationStatusList = reservationStatusRepository.findByReservationId(reservationDeclined.getReservationId());
                for(ReservationStatus reservationStatus : reservationStatusList){
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    reservationStatus.setStatus(reservationDeclined.getStatus());
                    reservationStatus.setReservationId(reservationDeclined.getReservationId());
                    // view 레파지 토리에 save
                    reservationStatusRepository.save(reservationStatus);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenReservationApproved_then_UPDATE_2(@Payload ReservationApproved reservationApproved) {
        try {
            if (reservationApproved.isMe()) {
                // view 객체 조회
                List<ReservationStatus> reservationStatusList = reservationStatusRepository.findByReservationId(reservationApproved.getReservationId());
                for(ReservationStatus reservationStatus : reservationStatusList){
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    reservationStatus.setStatus(reservationApproved.getStatus());
                    reservationStatus.setReservationId(reservationApproved.getReservationId());
                    // view 레파지 토리에 save
                    reservationStatusRepository.save(reservationStatus);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
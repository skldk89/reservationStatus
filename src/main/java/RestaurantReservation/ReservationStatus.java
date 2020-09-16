package RestaurantReservation;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="ReservationStatus_table")
public class ReservationStatus {

        @Id
        @GeneratedValue(strategy=GenerationType.AUTO)
        private Long id;
        private Long reservationId;
        private Long trainerId;
        private String reservationDate;
        private String status;
        private String customerName;


        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }
        public Long getReservationId() {
            return reservationId;
        }

        public void setReservationId(Long reservationId) {
            this.reservationId = reservationId;
        }
        public Long getTrainerId() {
            return trainerId;
        }

        public void setTrainerId(Long trainerId) {
            this.trainerId = trainerId;
        }
        public String getReservationDate() {
            return reservationDate;
        }

        public void setReservationDate(String reservationDate) {
            this.reservationDate = reservationDate;
        }
        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }
        public String getCustomerName() {
            return customerName;
        }

        public void setCustomerName(String customerName) {
            this.customerName = customerName;
        }

}

package za.ac.cput.domain;

import jakarta.persistence.*;
import org.springframework.beans.factory.parsing.Location;

@Entity
public class Gym {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int gymId;

    @ManyToOne (cascade = CascadeType.ALL)
    @JoinColumn(name = "manager_id") // The name of the foreign key column in the Gym table
    private Manager managerId;

    @ManyToOne (cascade = CascadeType.ALL)
    @JoinColumn(name = "trainer_id") // The name of the foreign key column in the Gym table
    private Trainer trainerId;

   // @ManyToOne (cascade = CascadeType.ALL)
  //  @JoinColumn(name = "location_id") // The name of the foreign key column in the Gym table
   // private Location locationId;

    private String name;
    private int capacity;


    public Gym() {
    }
    private Gym(Builder builder){
        this.gymId = builder.gymId;
        this.managerId = builder.managerId;
       // this.locationId = builder.locationId;
        this.trainerId = builder.trainerId;
        this.name = builder.name;
        this.capacity = builder.capacity;
    }
    public int getGymId() {return gymId;}
    public Manager getManagerId() {return managerId;}
   // public String getLocationId() {return locationId;}
    public Trainer getTrainerId() {return trainerId;}
    public String getName(){return name;}
    public int getCapacity(){return capacity;}

    @Override
    public String toString() {
        return "Gym{" +
                "gymId='" + gymId + '\'' +
                ", managerId=" + managerId +
                ", trainerId=" + trainerId +
                ", name='" + name + '\'' +
                ", capacity=" + capacity +
                '}';
    }

    public static class Builder{
        private int gymId;
        private Manager managerId;
        private Trainer trainerId;
        private Location locationId;
        private String name;
        private int capacity;

        public Builder setGymId(int gymId) {
            this.gymId = gymId;
            return this;
        }
        public Builder setManagerId(Manager managerId) {
            this.managerId = managerId;
            return this;
        }
        //public Gym.Builder setLocationId(String locationId) {
          //  this.locationId = locationId;
       //     return this;
      //  }
        public Builder setTrainerId(Trainer trainerId) {
            this.trainerId = trainerId;
            return this;
        }
        public Builder setName(String name) {
            this.name = name;
            return this;
        }
        public Builder setCapacity(int capacity) {
            this.capacity = capacity;
            return this;
        }
        public Builder copy(Gym gym){
            this.gymId=gym.gymId;
            this.managerId=gym.managerId;
            //this.locationId=gym.locationId;
            this.trainerId=gym.trainerId;
            this.name=gym.name;
            this.capacity=gym.capacity;
            return this;
        }
        public Gym build(){
            return new Gym(this);
        }
    }
}

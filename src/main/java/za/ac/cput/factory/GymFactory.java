package za.ac.cput.factory;

import za.ac.cput.domain.Gym;
import za.ac.cput.domain.Manager;
import za.ac.cput.domain.Trainer;

public class GymFactory {

    public static Gym createGym(int gymId, Manager managerId, Trainer trainerId, String name, int capacity) {
        return new Gym.Builder()
                .setGymId(gymId)
                .setManagerId(managerId)
                .setTrainerId(trainerId)
                .setName(name)
                .setCapacity(capacity)
                .build();
    }
}
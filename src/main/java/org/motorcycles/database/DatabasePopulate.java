package org.motorcycles.database;

import io.quarkus.runtime.Startup;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.motorcycles.model.Motorcycle;
import org.motorcycles.repository.MotorcyclesRepository;

@ApplicationScoped
@Startup
public class DatabasePopulate {

    @Inject
    private MotorcyclesRepository motorcyclesRepository;

    public DatabasePopulate(MotorcyclesRepository motorcyclesRepository) {
        this.motorcyclesRepository = motorcyclesRepository;
    }

    @PostConstruct
    private void onStartup() {
        if (motorcyclesRepository.count() > 0L) {
            return;
        }
        motorcyclesRepository.save(new Motorcycle(null, "Harley-Davidson", "Sportster Iron 883",
                2023, 53, "68 Nm", "Cruiser-style motorcycle with a classic look."));
        motorcyclesRepository.save(new Motorcycle(null, "Honda", "CBR600RR",
                2023, 120, "66 Nm", "Sportbike known for its performance and agility."));
        motorcyclesRepository.save(new Motorcycle(null, "Ducati", "Panigale V4",
                2023, 214, "124 Nm", "High-performance sportbike with cutting-edge technology."));
        motorcyclesRepository.save(new Motorcycle(null, "Yamaha", "YZF-R3",
                2023, 42, "29.6 Nm", "Lightweight sportbike suitable for beginners."));
        motorcyclesRepository.save(new Motorcycle(null, "Kawasaki", "Ninja 400",
                2023, 49, "38 Nm", "Versatile and learner-friendly sportbike."));
        motorcyclesRepository.save(new Motorcycle(null, "BMW", "S1000RR",
                2023, 205, "113 Nm", "Superbike with advanced electronics and performance."));
        motorcyclesRepository.save(new Motorcycle(null, "Suzuki", "GSX-R1000",
                2023, 190, "86 Nm", "Powerful and agile sportbike."));
        motorcyclesRepository.save(new Motorcycle(null, "KTM", "Duke 390", 2023,
                44, "37 Nm", "Naked bike with a lightweight frame."));
        motorcyclesRepository.save(new Motorcycle(null, "Triumph", "Street Triple", 2023,
                111, "73 Nm", "Versatile naked bike with a strong engine."));
        motorcyclesRepository.save( new Motorcycle(null, "Moto Guzzi", "V85 TT", 2023,
                80, "77 Nm", "Adventure bike with a retro style."));
        motorcyclesRepository.save( new Motorcycle(null, "Aprilia", "RSV4", 2023,
                217, "123 Nm", "High-performance superbike."));
        motorcyclesRepository.save( new Motorcycle(null, "Kawasaki", "Versys 1000", 2023,
                104, "102 Nm", "Adventure touring bike."));
        motorcyclesRepository.save( new Motorcycle(null, "Harley-Davidson", "Road King", 2023,
                94, "162 Nm", "Classic cruiser with modern features."));
        motorcyclesRepository.save( new Motorcycle(null, "Honda", "Africa Twin", 2023,
                108, "105 Nm", "Adventure motorcycle built for off-road."));
        motorcyclesRepository.save( new Motorcycle(null, "Suzuki", "V-Strom 650", 2023,
                71, "62 Nm", "Versatile and affordable adventure bike."));
        motorcyclesRepository.save( new Motorcycle(null, "Yamaha", "MT-07", 2023,
                74, "68 Nm", "Naked bike with an excellent torque-to-weight ratio."));
        motorcyclesRepository.save( new Motorcycle(null, "Ducati", "Multistrada V4", 2023,
                170, "125 Nm", "Adventure bike with advanced technology."));
        motorcyclesRepository.save( new Motorcycle(null, "BMW", "R 1250 GS", 2023,
                136, "143 Nm", "Legendary adventure touring motorcycle."));
        motorcyclesRepository.save( new Motorcycle(null, "KTM", "Adventure 390", 2023,
                44, "37 Nm", "Compact and agile adventure bike."));
        motorcyclesRepository.save( new Motorcycle(null, "Triumph", "Bonneville T100", 2023,
                55, "78 Nm", "Classic and stylish retro motorcycle."));
    }

}

package com.pfa.covid19;

import com.pfa.covid19.entities.Patient;
import com.pfa.covid19.entities.Pays;
import com.pfa.covid19.entities.Region;
import com.pfa.covid19.repositories.AnalyseRepository;
import com.pfa.covid19.repositories.PatientRepository;
import com.pfa.covid19.repositories.PaysRepository;
import com.pfa.covid19.repositories.RegionRepository;
import com.pfa.covid19.services.PaysService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;

@SpringBootApplication
public class Covid19Application {

    public static void main(String[] args) {
        SpringApplication.run(Covid19Application.class, args);
    }

    //@Bean
    CommandLineRunner start(PaysRepository paysRepository ,
                            RegionRepository regionRepository,
                            PaysService paysService){
        return args -> {
            Stream.of("Maroc","Japan").forEach(name->{
                Pays pays = new Pays();
                pays.setNom(name);
                paysRepository.save(pays);
            });

            Pays pays = paysService.getPays(1);

            Stream.of("Casa-Settat","Marrakech-Safi").forEach(name->{
                Region region = new Region();
                region.setNom(name);
                region.setPays(pays);
                regionRepository.save(region);
            });
        };
    }

}

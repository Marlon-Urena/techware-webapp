package com.techware;

import com.techware.model.*;
import com.techware.repository.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.math.BigDecimal;


@Configuration
@Slf4j
class LoadDatabase {

/*
    @Bean
    CommandLineRunner initDatabase(UserAccountRepository userAccountRepository,UserAccountAddressRepository userAccountAddressRepository, AddressRepository addressRepository, InvoiceRepository invoiceRepository, InvoiceDetailsRepository invoiceDetailsRepository, ProductRepository productRepository) {
        String largeString1 = "The NFL Seattle Seahawks Dri-FIT Jersey delivers unparalleled fit and style at the stadium or on the street. Sweat-wicking technology offers up cool comfort, while the twill lettering adds an authentic touch.";

        return args -> {
            log.info("Preloading " + userAccountRepository.save(new UserAccount(1, "johndoe@gmail.com", "password1", "John", "Doe", LocalDate.parse("1995-01-01"), "111-111-1111")));
            log.info("Preloading " + userAccountRepository.save(new UserAccount(2, "JackDaniel@gmail.com", "password2", "Jack", "Daniel", LocalDate.parse("1995-02-02"), "222-222-2222")));
            log.info("Preloading " + userAccountRepository.save(new UserAccount(3, "BacardiRum@gmail.com", "password3", "Bacardi", "Rum", LocalDate.parse("1995-03-03"), "333-333-3333")));

            log.info("Preloading " + userAccountAddressRepository.save(new UserAccountAddress(new UserAccountAddressId(1,1))));
            log.info("Preloading " + userAccountAddressRepository.save(new UserAccountAddress(new UserAccountAddressId(2,2))));
            log.info("Preloading " + userAccountAddressRepository.save(new UserAccountAddress(new UserAccountAddressId(3,3))));

            log.info("Preloading " + addressRepository.save(new Address(1, "123 Johnny Street", "01010", "New York","Staten Island", "USA")));
            log.info("Preloading " + addressRepository.save(new Address(2, "123 Jack Street", "02020", "New York","Staten Island", "USA")));
            log.info("Preloading " + addressRepository.save(new Address(3, "123 Bacardi Street", "03030", "New York","Staten Island", "USA")));

            log.info("Preloading " + productRepository.save(new Product(1,1, new BigDecimal("20.00"),Size.XS, Color.GREEN, "ftp://71.105.7.77/uisn31tch7idksxmuyzm.webp", "NFL Seattle Seahawks Dri-FIT (Russell Wilson)", Files.readString(Path.of("src\\main\\resources\\static\\Seahawks.txt")),true,10,0)));
            log.info("Preloading " + productRepository.save(new Product(2,1, new BigDecimal("15.50"),Size.M, Color.GREY, "ftp://Admin@71.105.7.77/bsbljsy.jpeg", "BonaBaseball Jersey", Files.readString(Path.of("src\\main\\resources\\static\\BonaBaseBall_Jersey.txt")),true,5,0)));
            log.info("Preloading " + productRepository.save(new Product(3,2, new BigDecimal("30.00"),Size.M, Color.BLUE, "ftp://Admin@71.105.7.77/dgyqmfa88j5j6mzqc4dg.webp", "NFL Buffalo Bills Game (Josh Allen)", Files.readString(Path.of("src\\main\\resources\\static\\Buffalobills.txt")),true,7,0)));
            log.info("Preloading " + productRepository.save(new Product(4,3, new BigDecimal("10.00"),Size.L, Color.RED, "ftp://Admin@71.105.7.77/f59amidwq9kn8qwkfp1y.webp", "NFL Atlanta Falcons Game Jersey (Deion Sanders)", Files.readString(Path.of("src\\main\\resources\\static\\atlantafalcons.txt")),true,4,0)));

            log.info("Preloading " + invoiceDetailsRepository.save(new InvoiceDetails(new InvoiceDetailsId(2,1),2, new BigDecimal("31.00"))));
            log.info("Preloading " + invoiceDetailsRepository.save(new InvoiceDetails(new InvoiceDetailsId(4,2),3, new BigDecimal("30.00"))));
            log.info("Preloading " + invoiceDetailsRepository.save(new InvoiceDetails(new InvoiceDetailsId(2,2),1, new BigDecimal("15.50"))));

            //LocalDateTime.of(2019, Month.DECEMBER, 4,6,30).plusDays(3)
            log.info("Preloading " + invoiceRepository.save(new Invoice(1,1,2,1, LocalDate.now(),LocalDate.now().plusDays(3), LocalDate.now().plusDays(3).plusDays(7),new BigDecimal("31.00"))));
            log.info("Preloading " + invoiceRepository.save(new Invoice(2,2,1,2, LocalDate.now(),LocalDate.now().plusDays(3), LocalDate.now().plusDays(3).plusDays(7),new BigDecimal("45.50"))));

        };
    }

 */



}

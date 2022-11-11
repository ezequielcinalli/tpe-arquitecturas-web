package sales.utils;

import lombok.extern.slf4j.Slf4j;
import sales.models.Sale;
import sales.models.SaleProduct;
import sales.repositories.SaleProductRepository;
import sales.repositories.SaleRepository;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
class LoadDatabase {

	@Bean
    CommandLineRunner initDatabase(SaleRepository saleRepository, SaleProductRepository saleProductRepository) {
    	return args -> {
    		SimpleDateFormat obj = new SimpleDateFormat("yyyy-MM-dd");
  			var sale1 = new Sale(1, new Date(obj.parse("2022-11-10").getTime()));
  			var sale2 = new Sale(2, new Date(obj.parse("2022-11-11").getTime()));
  			var sale3 = new Sale(3, new Date(obj.parse("2022-11-11").getTime()));
  			var sale4 = new Sale(4, new Date(obj.parse("2022-11-10").getTime()));
  			var sale5 = new Sale(5, new Date(obj.parse("2022-11-9").getTime()));
  			var sale6 = new Sale(6, new Date(obj.parse("2022-11-8").getTime()));
  			var sale7 = new Sale(7, new Date(obj.parse("2022-11-11").getTime()));
  			var sale8 = new Sale(8, new Date(obj.parse("2022-11-10").getTime()));
  			var sale9 = new Sale(9, new Date(obj.parse("2022-11-12").getTime()));
  			var sale10 = new Sale(10, new Date(obj.parse("2022-11-13").getTime()));
			log.info("Preloading " + saleRepository.save(sale1));
			log.info("Preloading " + saleRepository.save(sale2));
			log.info("Preloading " + saleRepository.save(sale3));
			log.info("Preloading " + saleRepository.save(sale4));
			log.info("Preloading " + saleRepository.save(sale5));
			log.info("Preloading " + saleRepository.save(sale6));
			log.info("Preloading " + saleRepository.save(sale7));
			log.info("Preloading " + saleRepository.save(sale8));
			log.info("Preloading " + saleRepository.save(sale9));
			log.info("Preloading " + saleRepository.save(sale10));
			var saleProduct1 = new SaleProduct(sale1, 1, 2, 1000);
  			var saleProduct2 = new SaleProduct(sale2, 2, 3, 1500);
  			var saleProduct3 = new SaleProduct(sale3, 3, 2, 1230);
  			var saleProduct4 = new SaleProduct(sale4, 4, 3, 1400);
  			var saleProduct5 = new SaleProduct(sale5, 5, 4, 1600);
  			var saleProduct6 = new SaleProduct(sale6, 6, 1, 1800);
  			var saleProduct7 = new SaleProduct(sale7, 7, 2, 2000);
  			var saleProduct8 = new SaleProduct(sale8, 8, 3, 1100);
  			var saleProduct9 = new SaleProduct(sale9, 9, 4, 1300);
  			var saleProduct10 = new SaleProduct(sale10, 10, 2, 1450);
  			log.info("Preloading " + saleProductRepository.save(saleProduct1));
			log.info("Preloading " + saleProductRepository.save(saleProduct2));
			log.info("Preloading " + saleProductRepository.save(saleProduct3));
			log.info("Preloading " + saleProductRepository.save(saleProduct4));
			log.info("Preloading " + saleProductRepository.save(saleProduct5));
			log.info("Preloading " + saleProductRepository.save(saleProduct6));
			log.info("Preloading " + saleProductRepository.save(saleProduct7));
			log.info("Preloading " + saleProductRepository.save(saleProduct8));
			log.info("Preloading " + saleProductRepository.save(saleProduct9));
			log.info("Preloading " + saleProductRepository.save(saleProduct10));
        };
    }
}
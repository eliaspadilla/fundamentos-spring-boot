package com.fundamentosplatzi.springboot.fundamentos;

import com.fundamentosplatzi.springboot.fundamentos.bean.MyBeanEP;
import com.fundamentosplatzi.springboot.fundamentos.bean.MyBeanWithDependencyEP;
import com.fundamentosplatzi.springboot.fundamentos.bean.MyBeanWithProperties;
import com.fundamentosplatzi.springboot.fundamentos.component.ComponentDependencyEP;
import com.fundamentosplatzi.springboot.fundamentos.dto.UserDto;
import com.fundamentosplatzi.springboot.fundamentos.entity.User;
import com.fundamentosplatzi.springboot.fundamentos.pojo.UserPojo;
import com.fundamentosplatzi.springboot.fundamentos.repository.UserRepository;
import com.fundamentosplatzi.springboot.fundamentos.service.UserService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.tomcat.jni.Local;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class FundamentosApplication implements CommandLineRunner {

	private final Log logger = LogFactory.getLog(FundamentosApplication.class);

	private ComponentDependencyEP componentDependencyEP;
	private MyBeanEP myBean;
	private MyBeanWithDependencyEP myBeanWithDependencyEP;
	private MyBeanWithProperties myBeanWithProperties;
	private UserPojo userPojo;
	private UserRepository userRepository;
	private UserService userService;

	@Autowired
	public FundamentosApplication(@Qualifier("componentImplement2EP") ComponentDependencyEP componentDependencyEP,
									MyBeanEP myBean,
								  MyBeanWithDependencyEP myBeanWithDependencyEP,
								  MyBeanWithProperties myBeanWithProperties,
								  UserPojo userPojo,
								  UserRepository userRepository,
								  UserService userService){
		this.componentDependencyEP = componentDependencyEP;
		this.myBean = myBean;
		this.myBeanWithDependencyEP = myBeanWithDependencyEP;
		this.myBeanWithProperties = myBeanWithProperties;
		this.userPojo = userPojo;
		this.userRepository = userRepository;
		this.userService = userService;
	}

	public static void main(String[] args) {
		SpringApplication.run(FundamentosApplication.class, args);
	}

	@Override
	public void run(String... args) {
		//ejemplosAnteriores();
		saveUsersInDatabase();
		getInfoJPQLFromUser();
		saveWithErrorTransactional();
	}

	private void saveUsersInDatabase(){
		User user1 = new User("Pepito Derez","pepito.perez@gmail.com",
				LocalDate.of(2021,03,20));
		User user2 = new User("John Carlos","juan.carlos@gmail.com",
				LocalDate.of(2021,01,05));
		User user3 = new User("John Doe","john.doe@gmail.com",
				LocalDate.of(2021,05,14));

		List<User> list = Arrays.asList(user1,user2,user3);

		list.forEach(userRepository::save);
	}

	private void ejemplosAnteriores(){
		componentDependencyEP.procesarDato();
		myBean.procesarNuevoDato();
		myBeanWithDependencyEP.printWithDependency();
		logger.info(myBeanWithProperties.funcionTest());
		logger.info(userPojo.getEmail() + "-" + userPojo.getPassword());
		logger.error("error manual");
	}

	private void getInfoJPQLFromUser(){
		/*logger.info("Consulta objeto = "+
				userRepository.findByUserEmail("juan.carlos@gmail.com")
						.orElseThrow(()-> new RuntimeException("No se encontro el usuario")));

		userRepository.findAndSort("J", Sort.by("id").ascending())
				.forEach(user -> logger.info("metodo sort "+user));

		userRepository.findByName("John Doe").forEach(user -> logger.info("user querymethods = "+user));

		logger.info("usuario querymethods email an name ="+userRepository.
				findByEmailAndName("juan.carlos@gmail.com","John Carlos")
				.orElseThrow(() -> new RuntimeException("No se encontro el usuario buscado")));

		userRepository.findByNameLike("%J%").forEach(user -> logger.info("usuario like = "+user));

		userRepository.findByNameOrEmail("John Doe",null).
				forEach(user -> logger.info("user Or ="+user));*/

		userRepository.findByBirthDateBetween(LocalDate.of(2021,01,01),
				LocalDate.of(2021,04,29))
				.forEach(user -> logger.info("usuario por fecha = "+user));

		userRepository.findByNameLikeOrderByIdDesc("%John%").forEach(user -> logger.info("Usuario order 1= "+user));

		userRepository.findByNameContainingOrderByIdDesc("John").forEach(user -> logger.info("Usuario order 2= "+user));

		logger.info(userRepository.getAllByBirthDateAndEmail(LocalDate.of(2021,01,05),
				"juan.carlos@gmail.com").orElseThrow(() -> new RuntimeException("no se encontro el usuario getall")));
	}

	private void saveWithErrorTransactional(){
		User test1 = new User("nombre1","nombre1@gmail.com",
				LocalDate.of(2021,03,20));
		User test2 = new User("nombre2","nombre2@gmail.com",
				LocalDate.of(2021,01,05));
		User test3 = new User("nombre3","nombre3@gmail.com",
				LocalDate.of(2021,05,14));

		List<User> users = Arrays.asList(test1,test2,test3);

		try {
			userService.saveTransactional(users);
		} catch (Exception e) {
			logger.error("Error en metodo transaccional - "+e.getMessage());
		}

		userService.getAllUsers().forEach(user -> logger.info("usuario obtenido = "+user));
	}
}

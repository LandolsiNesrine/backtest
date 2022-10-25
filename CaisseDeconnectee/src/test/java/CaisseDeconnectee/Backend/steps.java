package CaisseDeconnectee.Backend;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.steps.Steps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.client.RestTemplate;

import CaisseDeconnectee.Controller.DisAdmUserProfileController;
import CaisseDeconnectee.Entities.JwtRequest;
import CaisseDeconnectee.Entities.JwtResponse;
import CaisseDeconnectee.Service.JwtService;
import CaisseDeconnectee.Entities.HrGenDebt;
import CaisseDeconnectee.Entities.HrPayCashDeskSession;
public class steps extends Steps {
	
	
@Given ("I am in authentification page")
public void authPage()
{
System.out.println("authentification page");
}
@Given ("I enter my username: $username and my password: $password" )
public void Givemdp(@Named("username") String username ,@Named("password")  String password)
{
System.out.println("I enter my username and my password"+ username + password);
}
@Autowired
private JwtService jwtService;
@Autowired
private AuthenticationManager authenticationManager;

private RestTemplate restTemplate = new RestTemplate();

@When ("The username: $username and the password: $password are correct" )
public void Correct_Login(@Named("username") String username ,@Named("password")  String password) throws Exception
{
	/*{System.out.println("uuuuuu" +username+password);}

	JwtRequest jr = JwtRequest.builder().userName(username).userPassword(password).build();
	JwtRequest j = new JwtRequest(username,password);
	
	{System.out.println("jr " + j+username+password);}*/
	//JwtResponse j = new JwtResponse ();
	JwtRequest jr = JwtRequest.builder().userName(username).userPassword(password).build();

	 String url = "http://localhost:8080/Auth/authenticate";
     DisAdmUserProfileController token = restTemplate.postForObject(url, jr,DisAdmUserProfileController.class);
     
     //System.out.println("jr " + j+username+password);
	//JwtResponse jwt = jwtService.createJwtToken(JwtRequest.builder().userName("popo").userPassword("poo").build());
	{System.out.println("The username and the password are " + username +"	"+ password );
		}
//assertEqual
}
@Then ("I am able to connect")
public void LoginSuccess()
{
System.out.println("Login success");
}




/////second scénario
@Given ("I am in authentification page!")
public void authPage2()
{
System.out.println("authentification page");
}
@Given ("I enter my username2: $username and my password2: $password" )
public void Givemdp2(@Named("username") String username ,@Named("password")  String password)
{
System.out.println("I enter my username and my password"+ username + password);
}
@When ("The username2: $username and the password2: $password are not correct" )
public void wrong_Login(@Named("username") String username ,@Named("password")  String password) throws Exception
{

	JwtRequest jr = JwtRequest.builder().userName(username).userPassword(password).build();
	try {
		 String url = "http://localhost:8080/Auth/authenticate";
     DisAdmUserProfileController token = restTemplate.postForObject(url, jr,DisAdmUserProfileController.class);
     
     //System.out.println("jr " + j+username+password);
	JwtResponse jwt = jwtService.createJwtToken(JwtRequest.builder().userName("popo").userPassword("poo").build());
	}
	catch(Exception e){
		
	}
	{System.out.println("The username and the password are " + username +"	"+ password );
		}
//assertEqual
}
@Then ("I am not able to connect")
public void LoginFailed()
{
System.out.println("Login failed");
}



/////third scénario

@Given ("give a bill reference $ref")
public void GiveRef(String ref)
{
System.out.println("Bill Refrence" +ref);
}

@Then ("show bill")
public void ShowBill()
{
	String url = "http://localhost:8080/Debt/getDebtByRef/string";
	ResponseEntity<HrGenDebt[]> response =restTemplate.getForEntity(url,HrGenDebt[].class);
	HrGenDebt[] Factures= response.getBody();

//System.out.println("facture"+"	"+Arrays.stream(Factures) 
//.collect(Collectors.toList()));
	
System.out.println("Process done");
}
}



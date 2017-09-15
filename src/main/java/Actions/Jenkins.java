package Actions;

import java.io.IOException;
import java.sql.SQLException;

import org.openqa.selenium.WebDriver;


import TestSkyBuy.SkyBuy.Constants;


public class Jenkins {

public static String type;
public static String url;
public static String urlCard;
public static String baseUrl;
public static String featureName;
public static String authLogin;
public static String authPassword;


	public static void getParamsFromJenkins() throws SQLException, IOException{	
		type = System.getenv("type");	
		if(type==null){
			type = Constants.type;	}
		featureName = System.getenv("featureName");	
		if(featureName==null){
			featureName = Constants.featureName;	}
		authLogin = System.getenv("authLogin");	
		if(authLogin==null){
			authLogin = Constants.authLogin;	}
		authPassword = System.getenv("authPassword");	
		if(authPassword==null){
			authPassword = Constants.authPassword;	}
		
		
		 if(type.equals("feature")) {
			 
			 Jenkins.url = "skyz-"+Jenkins.featureName+".stlaboratory.ru/";
			 Jenkins.baseUrl="http://" + Jenkins.authLogin + ":" + Jenkins.authPassword + "@" + Jenkins.url;	 
			 Jenkins.urlCard = "http://" + Jenkins.authLogin + ":" + Jenkins.authPassword + "@my." + Jenkins.url+"//cart";
		 }
			
		 	
		
		
	/*	
		OST = System.getenv("OST");
		
	//	System.out.println("34"+OST);
		if(OST==null){OST ="windows";} 
		LONGWAITING = System.getenv("LONGWAITING");
		if(LONGWAITING==null){LONGWAITING ="YES";}
		DOPEMAIL = System.getenv("DOPEMAIL");
		if(DOPEMAIL==null){DOPEMAIL ="NO";}
		INTER = System.getenv("INTER");
		
		
		//System.out.println("INTER:"+INTER);
		if(INTER==null){INTER ="RU";}
		Url = System.getenv("Url");	
		
		if(Url==null){
//	Url ="https://s3.4slovo.ru/";}
		Url ="om01.local";}	
		NameMashine = Url;
		UrlLending = System.getenv("UrlLending");	
		if(UrlLending==null){
			UrlLending ="https://n."+Url+"/?aprt159=2a06f3eedc49cfa3061e6a69fd288462&utm_source=i.ivanov@4slovo.ru";}
		CRM_Url = System.getenv("CRM_Url");	
		if(CRM_Url==null){
			CRM_Url ="https://crm."+Url;}
		Url="https://"+Url;
		
		
	//	Url = "https://beta.local";
	//	Url = "https://test04.local";
		//	Url = "https://s3.4slovo.ru";
	//	Url = "https://dd04.local/";
		String ssh_pass ="12345678";
		String ssh_crm_pass ="12345678";
		boolean inter = Url.contains("kz");
		if(inter==true){INTER ="KZ";
		ssh_pass ="87654321";
		ssh_crm_pass ="87654321";
		}
		 inter = Url.contains("kz04");
		if(inter==true){INTER ="KZ";
		ssh_pass ="12345678";
		ssh_crm_pass ="12345678";
		}
		
				
		inter = Url.contains("ge");
		if(inter==true){INTER ="GE";}
		
	//	bonus = promo.contains("NO");
	//	bonus= maxBonus.contains("YES");
		
		boolean isLocal = Url.contains("local");
			SSH = System.getenv("SSH_front");
			if(isLocal==true){
				name = NameMashine;
			//	System.out.println(name);
				
				SSH =name+" 22 root "+ssh_pass+" 3306 3370 127.0.0.1 4slovo 12345 4slovo";
				SSH_front = SSH.split(" ");
				SSH2 = "crm."+name+" 22 root "+ssh_crm_pass+" 3306 3367 127.0.0.1 84vcssv 12345 84vcssv";
				SSH_crm = SSH2.split(" ");
				//8uhbghjk
			}else{
				
					
			
			if(SSH==null){					
		//		SSH= "beta.local 22 root 12345678 3306 3369 127.0.0.1 4slovo 12345 4slovo";
						//	SSH = "test01.local 22 root 12345678 3306 3307 127.0.0.1 root n 4slovo";	
			//	SSH ="test03.local 22 root 12345678 3306 3369 127.0.0.1 4slovo 12345 4slovo";
		//	SSH ="test04.local 22 root 12345678 3306 3369 127.0.0.1 4slovo 12345 4slovo";
		//	SSH ="dd04.local 22 root 12345678 3306 3369 127.0.0.1 4slovo 12345 4slovo";
			SSH = "sb.4slovo.ru 22 s1 0A9zoBN5jrkt9JAhAOab 3306 3366 127.0.0.1 s3 ihcHFOIXKkSV4RLVSXlN s3";
			//		SSH ="ts01.local 22 root 12345678 3306 3369 127.0.0.1 4slovo 12345 4slovo";
					}
			SSH_front = SSH.split(" ");
			if(SSH_front[8] =="n"){SSH_front[8] ="";}
			
			SSH2 = System.getenv("SSH_crm");
					if(SSH2==null){					

 //SSH2= "crm.beta.local 22 root 12345678 3306 3367 127.0.0.1 84vcssv 12345 84vcssv";						
SSH2 = "sb.4slovo.ru 22 s1 0A9zoBN5jrkt9JAhAOab 3306 3367 127.0.0.1 s2 wMSUaNw4r7Yj2EbrLb5v s2";
			
		//		SSH2 = "crm.dd04.local 22 root 12345678 3306 3367 127.0.0.1 84vcssv 12345 84vcssv";
			//	SSH2 = "crm.ts01.local 22 root 12345678 3306 3367 127.0.0.1 84vcssv 12345 84vcssv";
				//		SSH2 = "crm.test03.local 22 root 12345678 3306 3367 127.0.0.1 84vcssv 12345 84vcssv";
			//		SSH2 = "crm.test04.local 22 root 12345678 3306 3367 127.0.0.1 84vcssv 12345 84vcssv";
	
					}
			}				
					SSH_crm = SSH2.split(" ");
				//	System.out.println(SSH_crm[6]);
				//	System.out.println(SSH_crm[8]);
	Stage1_Phone = System.getenv("Stage1_Phone");	
	if(Stage1_Phone==null){
		Stage1_Phone = Constants.Stage1_Phone;	
	}		
		
	LK_Phone = System.getenv("LK_Phone");	
		if(LK_Phone==null){
			LK_Phone = Constants.lk_Phone;		
	}
		LK_Pass = System.getenv("LK_Pass");	
		if(LK_Pass==null){
			LK_Pass = Constants.lk_Phone_pass;		
	}
		
		Stage5_way = System.getenv("way");
	//	System.out.println(Stage5_way);
		
		if(Stage5_way==null){
		//	System.out.println("2");
			Stage5_way = Constants.Stage5_CARD_WAY;
		}else {
			Stage5_way	= System.getProperty("user.dir")+Stage5_way; 
		}
		broker_login = System.getenv("broker_login");	
		if(broker_login==null){
			broker_login = Constants.broker_login;		
	}
		broker_pass = System.getenv("broker_pass");	
		if(broker_pass==null){
			broker_pass = Constants.broker_pass;		
	}
		promo = System.getenv("promo");	
		if(promo==null){
			promo = Constants.promo;}
			type = System.getenv("type");	
			if(type==null){
				type = Constants.type;	}
			browser = System.getenv("browser");	
			if(browser==null){
				browser = Constants.browser;	}
			crm_login = System.getenv("crm_login");	
			if(crm_login==null){
				crm_login = Constants.crm_login;	}
			crm_pass = System.getenv("crm_pass");	
			if(crm_pass==null){
				crm_pass = Constants.crm_pass;	}
			broker_cid = System.getenv("broker_cid");	
			if(broker_cid==null){
				broker_cid = Constants.broker_cid;	}	
			creditId = System.getenv("creditId");	
			if(creditId==null){
				creditId = Constants.creditId;	}
			days = System.getenv("days");	
			if(days==null){
				days = Constants.days;	}
			changeSumma = System.getenv("changeSumma");	
			if(changeSumma==null){
				changeSumma = Constants.changeSumma;	}
			changeDate = System.getenv("changeDate");	
			if(changeDate==null){
				changeDate = Constants.changeDate;	}
			changeSummaMobile = System.getenv("changeSummaMobile");	
			if(changeSummaMobile==null){
				changeSummaMobile = Constants.changeSummaMobile;	}
			changeDateMobile = System.getenv("changeDateMobile");	
			if(changeDateMobile==null){
				changeDateMobile = Constants.changeDateMobile;	}
			
			
			mailTo = System.getenv("mailTo");	
			if(mailTo==null){
				mailTo = Constants.mailTo;	}
			maxBonus = System.getenv("maxBonus");	
			if(maxBonus==null){
				maxBonus = Constants.maxBonus;	}
			bonusWithPromoUse = System.getenv("bonusWithPromoUse");	
			if(bonusWithPromoUse==null){
				bonusWithPromoUse = Constants.bonusWithPromoUse;	}
		
			GE_passCode = System.getenv("GEPassCode");	
			if(GE_passCode==null){
				GE_passCode = Constants.GE_passCode;	}
			GeAdditional = System.getenv("GeAdditional");	
			if(GeAdditional==null){
				GeAdditional = Constants.GeAdditional;	}
		
			
			bonusEnabled = System.getenv("bonusEnabled");	
			if(bonusEnabled==null){
				bonusEnabled = Constants.bonusEnabled;	}
			
	*/		
}}
	

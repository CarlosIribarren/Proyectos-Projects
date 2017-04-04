//**************************************************************************************
//**								     BEZEROA ABESTIK							  **
//**************************************************************************************
#define MAX_KAT 30
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <sys/types.h>
#include <sys/socket.h>
#include <netinet/in.h>
#include <netdb.h>
#include <sys/stat.h>
#include <unistd.h>
#include "Bezeroa.h"
//ALDAGAI GLOBALAK
static  int sock_BEZEROA;
struct hostent *hp;
//APLIKAZIORAN LOGOA
void Logoa()
{
	system("clear");                                                              
	printf("\n                                                         	");                                             
 	printf("\n                                         			    	");
	printf("\n                                          				");	
	printf("\n                                DMM       				");
	printf("\n                             M    M       				");
	printf("\n                         M     MM M       				");
	printf("\n                          MMMMMZM M       				");
	printf("\n                      MMMM  MMMZM ?       				");
	printf("\n                 MMMM  MMMMMMMMZM         				");
	printf("\n               MM MM     MMMMMM$M         				");
	printf("\n               MM       M      $M         				");
	printf("\n               MM      MMMMM7  7M         				");	
	printf("\n               MMMMMMM         IM         				");
	printf("\n               MM              IM         				");
	printf("\n       MMM     MM              ?M         				");
	printf("\n      M   MMM8MMM     ABESTIK  ?M         				");
	printf("\n     M  M8  MMMMM              +M         				");
	printf("\n       M  MMMMMM               =M         				");
	printf("\n       MMMMMMM                 =M         				");
	printf("\n                           MMMMZM         				");
	printf("\n                        MMM  MMMM         				");
	printf("\n                       MM  MMMMMM         				");
	printf("\n                      M= MMMMMMM          				");
	printf("\n                      DMOMMMMM  M:        				");
	printf("\n                              +M          				");
	printf("\n                                          				");
	printf("\n                                        				    ");
	int a;
	for(a=0;a<500000000;a++);
}
//PROGRAMA BUKATZEAN EGILEAK PANTAILARATU
void kredituak()
{
	printf("\n");
	printf("****************************************************************\n");
	printf("****************************************************************\n");
	printf("**                  ABESTIK 1.0  AMAITUTA                     **\n");
	printf("** 													     	  **\n");
	printf("**                EGILEAK : CARLOS ETA TELMO                  **\n");
	printf("****************************************************************\n");
	printf("****************************************************************\n\n");
}
/* HASIERAKO MENUA MARRAZTU EGITEN DU
   ERABILTZAILEAK EGINIKO AUKERA JASOTZEN DU */
int hasierakomenua()
{
	system("clear");
	char katea[MAX_BUF];
	int aukera;
	printf("\n");
	printf("****************************************************************\n");
	printf("****************************************************************\n");
	printf("**                       ABESTIK 1.0                          **\n");
	printf("****************************************************************\n");
	printf("****************************************************************\n\n");
	printf(" 		                MENUA			                	  ");
	printf("                              -------                           \n");
	printf("\t\t       1. FITXATEGIAREN BILAKETA            \n");
	printf("\t\t       2. FITXATEGIA JAITSI     			 \n");
	printf("\t\t       3. SAIOA AMAITU                   \n\n");
	printf("\t\t    EGIN ZURE AUKERA: ");
	//KONTROLATU EA MENUKO ZENBAKIAK SARTZEN DITUEN
	while(1)
	{
		fgets(katea,MAX_BUF,stdin);
		aukera = atoi(katea);
		if(aukera > 0 && aukera < 4)
		{
			break;
		}
		else 
		{
			printf("\t\t\t\tAUKERA OKERRA, SAIATU BERRIRO: ");
		}
	}
	printf("\n");
	return aukera;
}
//FITXATEGIAK BILATZEKO PROZEDURA
void BILAKETA()
{
	int auk;
	do
	{
		//HASIERAKO ALDAGAIAK
		char parametroa[MAX_BUF];
		int bidal=0,n;
		char katea[MAX_BUF];
		char BIDALKETA[MAX_BUF];
		char EMAITZA[MAX_BUF];
		//ALDAGAIAK GARBITU
		memset(parametroa,'\0',strlen(parametroa));
		memset(EMAITZA,'\0',strlen(EMAITZA));
		//MENUA
		system("clear");
		printf("\n");
		printf("****************************************************************\n");
		printf("****************************************************************\n");
		printf("**                       ABESTIK 2.0                          **\n");
		printf("****************************************************************\n");
		printf("****************************************************************\n\n");
		printf(" IDATZI BILATU NAHI DUZUN FITXATEGIA:");
		//DATUA TEKLATUTIK IRAKURRI
		fgets(katea, MAX_BUF, stdin);
		//FGETS LERRO JAUZIA ERASTEN DIO ETA GUK KENDU
		katea[strlen(katea)-1]='\0';
		//KOMANDO OSOA ERAIKI SEAR+KATEA
		sprintf(BIDALKETA, "SEAR%s\n", katea);	
		//BIDALKETA=SEAR+KATEA BIDALI ZERBITZARIRA 
		if ( bidal==write(sock_BEZEROA,BIDALKETA, strlen(BIDALKETA))==-1)
		{
			printf("ERROREA MEZUA BIDALTZEAN");
			exit(1);
		}
		if(n = read(sock_BEZEROA, EMAITZA, MAX_BUF)==-1)
		{
			("ERROREA MEZUA JASOTZEAN");
		}
		EMAITZA[n-1]='\0'; //BUF-EN INFORMAZIOAREN BUKAERA NON DAGOEN ADIERAZTEKO
		//ERROREAK TRATAU
		if (strncmp(EMAITZA, "ER4", 3) == 0)
		{
			printf("\n EZ DUGU EMAITZARIK LORTU!!!!!\n ");	
		}
		else
		{
			if (strncmp(EMAITZA, "ER5", 3) == 0)
			{
				printf("\n ZERBITZARIAK EZIN DU ESKARIA ZERBITZATU \n ");	
			}
			else
			{
				//DANA ONDO BALDIN BADIJOA
				//LORTU KOMANDOA
				char KOMA[3]={EMAITZA[0],EMAITZA[1],'\0'};
				//LORTU PARAMETRO
				strcpy(parametroa,EMAITZA+2);	
				//PARAMETROARI BUKAERA JARRI
				parametroa[n-2]='\0';
				//ORDEZKATU KOMA=> \n
				int cont=0;
				 while(parametroa[cont]!='\0')
				 {	
					if ( parametroa[cont]==',' )
					{
						parametroa[cont]='\n';
					}
					if ( parametroa[cont]=='#' )
					{
						parametroa[cont]='\t';
					}			
					cont++;
				 }	
				 //EMAITZA PANTALAIRATU
				 printf("\n\nZBK          FITXATEGIA           TAMAINA\n");
				 printf("-----            ---------         -------\n");
				 printf("%s ",parametroa);
			 }	 
		}
		printf("\n\n		MENUA   ");
		printf("\n		-----   ");
		printf("\n\t1.-BILAKETA BERRIA EGIN\n");
		printf("\n\t2.-ATZERA\n");
		printf("\n      EGIN EZAZU AUKERA BAT : ");
		//EGIAZTATU ZENBAKI ZUZENA SARTZEN DUELA
		while(1)
		{
			fgets(katea,MAX_BUF,stdin);
			auk = atoi(katea);
			if(auk > 0 && auk < 3)
			{
				break;
			}
			else 
			{
				printf("\t\t\t\tAUKERA OKERRA, SAIATU BERRIRO: ");
			}
		} 
	}while(auk!=2);
}
/* PROGRAMATIK ATERATZEKO PROZEDURA
   SOCKETA ITXI EGITEN DU           */
void EXIT()
{
	char buf[MAX_BUF];
	int n;
	//ZERBITZARIARI EXIT KOMANDOA BIDALI
	if(write(sock_BEZEROA,"EXIT\n",5)==-1)
	{
		printf("ERROREA EXIT MEZUA BIDALTZEAN");
		exit(1);		
	}
	//ZERBITZARITIK DATUAK JASO
	if((n = read(sock_BEZEROA, buf, MAX_BUF))==-1)
	{
		printf("ERROREA MEZUA JASOTZEAN");
		exit(1);
	}
	else
	{
		//OK ERANTZUNA JASOTZEN BADUGU
		if(strncmp(buf, "OK", 2)==0)
		{
			//TCP KONEXIOA ITXI
			close(sock_BEZEROA);
			kredituak();
		}
	}
}
//FITXATEGIAK JEISTEKO PROZEDURA
void JEITSI()
{
	//HASIERATU ALDAGAIAK
	int n,irakurrita,fitx_tamaina;
	char kanta[MAX_BUF],file_path[MAX_BUF],*kanta_izena;
	char BIDALKETA[MAX_BUF];
	char EMAITZA[MAX_BUF];	
	char ident[MAX_BUF],intro[1];
	FILE *fp;
	//MENUA MARRAZTU
	system("clear");
	printf("\n");
	printf("****************************************************************\n");
	printf("****************************************************************\n");
	printf("**                       ABESTIK 3.0                          **\n");
	printf("****************************************************************\n");
	printf("****************************************************************\n\n");
	printf(" 		   FITXATEGIAK JEISTEKO MENUA		          ");
	printf("                          ---------------------------          \n");
	printf("\n  IDATZI DESKARGATU NAHI DUZUN FITXATEGIAREN IDENTIFIKADOREA: ");
	//DATUA TEKLATUTIK IRAKURRI
	fgets(ident, MAX_BUF, stdin);
	//FGETS LERRO JAUZIA ERASTEN DIO ETA GUK KENDU
	ident[strlen(ident)-1]='\0';
	//KOMANDO OSOA ERAIKI DOWN+IDENT
	sprintf(BIDALKETA, "DOWN%s\n", ident);	
	//[BIDALKETA =DOWN+IDENT] BIDALI ZERBITZARIRA 
	if (write(sock_BEZEROA,BIDALKETA, strlen(BIDALKETA))==-1)
	{
		printf("ERROREA MEZUA BIDALTZEAN");
		exit(1);
	}
	//KANTA JASO OS+TAMAINA+KANTA EDO ERRORE KODEA	
	if ((n = read(sock_BEZEROA, kanta, MAX_BUF))==-1)
	{
		printf("ERROREA MEZUA JASOTZEAN");
		exit(1);	
	}
	//ERRORE KONTROLA 6 ETA 7
	if (strncmp(kanta, "ER6", 3) == 0)
	{
		printf("\n EZ DAGO SARTU DUZUN IDENTIFIKADORERIK \n ");
		printf("MESEDEZ TEKLA BAT SAKATU\n");
		fgets(intro,MAX_BUF,stdin);	
		
	}
	else
	{	
		if(strncmp(kanta, "ER7", 3) == 0)
		{
			printf("\n ZERBITZARIAK EZIN DU ZERBITZATU ESKARIA \n ");
		}
		else
		{
			//DANA ONDO BADOA
			//PARAMETROTIK KANTA IZENA ESKURATU
			kanta_izena=strchr(kanta,'#');
			//KANTAREN IZENARI # KENDU	
			kanta_izena[0]=' ';
			//LERRO SALTOA EZABATU
			kanta[n-1] = '\0'; //EOL EZABATU.
			//BUF-ETIK TAMAINA LORTU	
			fitx_tamaina = atoi(kanta+2);
			irakurrita = 0;
			//PATH ALDAGAIA EGOKITU
			sprintf(file_path,"%s/%s",FILES_PATH,kanta_izena);
			if((fp = fopen(file_path,"w")) == NULL)		// FITXATEGIA SORTU DISKOAN.
			{
				perror("EZIN DA FITXATEGIA DISKO LOKALEAN GORDE");
				exit(1);
			}
			while(irakurrita < fitx_tamaina)	// Fitxategia jaso eta diskoan gorde.
			{
				if ((n = read(sock_BEZEROA, kanta, MAX_BUF))==-1)
				{
					printf("ERROREA MEZUA JASOTZEAN");
					exit(1);		
				}
				if(fwrite(kanta, 1, n, fp) < 0)
				{
					perror("ARAZOA FITXATEGIA DISKO LOKALEAN GORDETZEAN");
					exit(1);
				}
				irakurrita =irakurrita+n;
			}
			//FITXATEGIA ITXI
			fclose(fp);
			//MEZU BAT PANTAILARATU ERABILTZAILEAK DANA ONDO JOAN DELA IKUSTEKO
			printf("FITXATEGIA JASO DA!!!\n");
			printf("MESEDEZ TEKLA BAT SAKATU\n");
			fgets(intro,MAX_BUF,stdin);	
		}
	}
}
/* ERABILTZAILEA EXISTITZEN DELA EGIAZTATZEKO PROZEDURA
   0=DENA ONDO  ||  1=ERABILTZAILEA EZ DA EXISTITZEN   */
int erabiltzailea()
{
	char erabil[MAX_KAT];
	char buf[MAX_BUF];
	int n, saiakerak=0;
	char KODEA[MAX_KAT];
	while(saiakerak<3)
	{
		//ALDAGAIAK HASIERATU 
		buf[0]='\0';
		KODEA[0]='\0';
		//ERABILTZAILE IZENA ESKURATU
		printf("\nERABILTZAILE IZENA: ");
		fgets(erabil,MAX_KAT,stdin);
		//FGETS LERRO JAUZIA ERASTEN DIO ETA GUK KENDU
		erabil[strlen(erabil)-1]='\0';
		//USER KOMANDO OSOA ERAIKI
		sprintf(KODEA, "USER%s\n", erabil);	
		//[KODEA = USER + ERABIL] BIDALI ZERBITZARIRA 
		if (write(sock_BEZEROA,KODEA, strlen(KODEA))==-1)
		{
			printf("ERROREA MEZUA BIDALTZEAN");
			exit(1);
		}
		//ZERBITZARITIK ERANTZUN KOAMANDOA JASO
		if((n = read(sock_BEZEROA, buf, MAX_BUF))==-1)
		{
			printf("ERROREA MEZUA JASOTZEAN");
			exit(1);
		}
		//BUF-EN BUKAERA JARRI
		buf[n]='\0';
		if(strncmp(buf, "OK", 2) == 0)
		{
			break; //WHILETIK ATERA, OK JASO DUGU = ERABILTZAILEA EXISTITZEN DA
		}
		else
		{
			//ERRORE KONTROLA 2
			if (strncmp(buf, "ER2", 3) == 0)
			{
				printf("\n ERABILTZAILE EZ DA EXISTITZEN!!!!! \n ");
				printf("\n SAIATU BERRIRO \n ");
				saiakerak++;
			}
		}
	}
	//KONTROLATU ZENBAT ALDITAN SARTZEN DUEN ERABILTZAILEA
	// 3 ALDIZ BAINO GEHIGO SARTZEN BADU, ORDUAN EXIT
	if ( saiakerak <3 )
	{
		return 0;
	}
	else
	{
		return 1;
	}
}
/* PASAHITZA EXISTITZEN DELA EGIAZTATU ETA ERABILTZAILEAREN BERDINA IZAN BEHAR DU
      0=DENA ONDO    ||     1=PASAHITZ OKERRA EDO EZ DA EXISTITZEN                  */
int pass()
{
	//ALDAGAIAK HASIERATU
	char pass[MAX_KAT];
	char buf[MAX_BUF];
	int n, saiakerak=0;
	char KODEA[MAX_KAT];
	while(saiakerak<3)
	{
		//ALDAGAIAK HASIERATU 
		buf[0]='\0';
		KODEA[0]='\0';
		//PASAHITZA ESKURATU
		printf("\nPASAHITZA IDATZ EZAZU: ");
		fgets(pass,MAX_KAT,stdin);
		//fgets lerro jauzia erasten dio eta guk kendu
		pass[strlen(pass)-1]=0;
		//PASS KOMANDO OSOA ERAIKI
		sprintf(KODEA, "PASS%s\n", pass);	
		//[KODEA = USER + ERABIL] BIDALI ZERBITZARIRA 
		if (write(sock_BEZEROA,KODEA, strlen(KODEA))==-1)
		{
			printf("ERROREA MEZUA BIDALTZEAN");
			exit(1);
		}
		//KOAMANDOA JASO
		if((n = read(sock_BEZEROA, buf, MAX_BUF))==-1)
		{
			printf("ERROREA MEZUA JASOTZEAN");
			exit(1);
		}
		//BUKAERA ADIERAZI
		buf[n]='\0';
		if(strncmp(buf, "OK", 2) == 0)
		{
			break; //WHILETIK ATERA, OK JASO DUGU = ERABILTZAILEA EXISTITZEN DA
		}
		else
		{
			//ERRORE KONTROLA 3
			if (strncmp(buf, "ER3", 3) == 0)
			{
				printf("\n PASAHITZA OKERA!!!! \n ");
				printf("\n SAIATU BERRIRO \n ");
				saiakerak++;
			}
		}
	}
	if ( saiakerak <3 )
	{
		return 0;
	}
	else
	{
		return 1;
	}		
}
//PROGRAMA NAGUSIA
int main(int argc, char *argv[])
{
	//DEFINIZIOAK
	char zerbitzaria[MAX_BUF];
	int portua = PORT,n;
	struct sockaddr_in zerb_helb;
	// PARAMETROAK PROZESATU
	switch(argc)
	{
		case 1:
			strcpy(zerbitzaria, SERVER);
			break;
		case 3:
			portua = atoi(argv[2]);
		case 2:
			strcpy(zerbitzaria, argv[1]);
			break;
		default:
			printf("ERABILERA: %s <ZERBITZARIA> <PORTUA>\n", argv[0]);
			exit(1);
	}
	// SOCKETA SORTU
	if((sock_BEZEROA = socket(AF_INET, SOCK_STREAM, 0)) < 0)
	{
		perror("ERROREA SOCKETA SORTZEAN");
		exit(1);
	}
	// ZERBITZARIKO SOCKETAREN HELBIDEA SORTU
	zerb_helb.sin_family = AF_INET;
	zerb_helb.sin_port = htons(portua);
	if((hp = gethostbyname(zerbitzaria)) == NULL)
	{
		herror("ERROREA ZERBITZARIAREN IZENA EBAZTEAN");
		exit(1);
	}
	memcpy(&zerb_helb.sin_addr, hp->h_addr, hp->h_length);
	// KONEKTATU ZERBITZARIAREKIN
	if(connect(sock_BEZEROA, (struct sockaddr *) &zerb_helb, sizeof(zerb_helb)) < 0)
	{
		perror("ERROREA ZERBITZARIAREKIN KONEKTATZEAN");
		exit(1);
	}
	//PASAHITZA ETA ERABILTZAILEA KAUTOTU
	if (erabiltzailea()==0 ) 
	{
		if ( pass()==0 ) 
		{
			//DANA ONGI => SISTEMAN SARTU
			int aukera=0;
			Logoa();
			while(aukera!=3)
			{
				//HASIERAKO MENUA PANTAILARATU
				//ETA AUKERAREN ARABERA DAGOKION PROZEDURARI DEITU
				aukera = hasierakomenua();
				if ( aukera ==1)
				{
					BILAKETA();
				}
				else
				{
					if ( aukera ==2) 
					{
						JEITSI();
					}
					else
					{	
						if ( aukera ==3) 	
						{
							EXIT();//SOCKET ITXI EGITEN DA
						}
					}
				}
			}
		}
		else
		{
			// EZ DA SISTEMAN SARTZEN, TCP KONEXIOA ITXI
			close(sock_BEZEROA);
			printf("\n\nPASAHITZA 3 ALDIZ GAIZKI SARTU DUZU !!!!\n\n");
			kredituak();
			exit(1);
		}
	}
	else
	{
		// EZ DA SISTEMAN SARTZEN, TCP KONEXIOA ITXI
		close(sock_BEZEROA);
		printf("\n\nERABILTZAILEA 3 ALDIZ GAIZKI SARTU DUZU !!!!\n\n");
		kredituak();
		exit(1);
	}
	//SOCKETA ITXI 
	exit(0);
}






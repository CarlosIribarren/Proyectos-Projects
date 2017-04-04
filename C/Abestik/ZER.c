//**************************************************************************
//**			            ZERBITZARIA ABESTIK							  **
//**************************************************************************
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <sys/types.h>
#include <sys/socket.h>
#include <netinet/in.h>
#include <unistd.h>
#include <sys/wait.h>
#include <signal.h>
#include <sys/stat.h>
#include <dirent.h>
#include <sys/statvfs.h>
#include "ZER.h"
/*EGOERA DESEGOKIEN KONTROLA
3 KOMANDO DESEGOKI JASOTZEN BADITU ORDUAN ZERBITZARIA BUKATU */
void Egoera_des(int s)
{
	//BEZERORA ERROREA 1 BIDALI
	if ((write(s,"ER1\n",4))==-1)
	{
		perror("ERROREA MEZUA BIDALTZEAN");
		exit(1);	
	}
	EGOERA_DESEGOKIAK++;
	//EGOERA DESEGOKIEN KONTAGAILUAREN KONTROLA
	//EGOERA ARRISKUTSUA ZERBITZARIARENTZAKO
	if (EGOERA_DESEGOKIAK==3)
	{
		exit(1);
	}
}

/* "STRING" BAT PASATA ZERRENDA BATEAN ADGOEN BILATZEN DU
-1= EZ BADA EXISTITZEN ||  BESTELA DAGOKION POSIZIOA ITZULTZEN DU */
int bilatu_string(char *string, char **string_zerr)
{
	int i=0;
	while(string_zerr[i] != NULL)
	{
		if(!strcmp(string,string_zerr[i]))
		{
			return i;
		}
		i++;
	}
	return -1;
}

//UNIXEKO FITXATEGI ARRAROAK EZ TRATATZEKO DIREKTORIOA IRAKURTZEN DUGUNEAN
int ez_ezkutua(const struct dirent *entry)
{
	if (entry->d_name[0]== '.')
	{
     return (0);
	}
	else
	{
     return (1);
	}
}

//GURE ARRAYAK(ABESTIEN_IZENAK ETA ABESTIEN_TAMAINAK) BETE DIREKTORIOAREN INFORMAZIOAREKIN
int Irakurri_direktorioa()
{
	//ALDAGAIAK HASIERATU
	struct dirent ** fitxategi_izenak;
	int i,fitxategi_kop;
	char fitxategi_path[MAX_BUF];
	struct stat file_info;
	float aldagaia;
	//ZERBITZARIAREN DIREKTORIOA IRAKURRI
	fitxategi_kop = scandir(FILES_PATH, &fitxategi_izenak, ez_ezkutua, alphasort);
	for(i=0;i<fitxategi_kop;i++)
	{
		//FITXATEGIAREN PATH GORDE
		sprintf(fitxategi_path,"%s/%s",FILES_PATH, fitxategi_izenak[i]->d_name);
		if(stat(fitxategi_path,&file_info) < 0)
		{
			printf("TAMAINA EZEZAGUNA");
		}
		else
		{
			//FITXATEGIEN IZENEN ARRAY BETE
			Abestien_izenak[i]=fitxategi_izenak[i]->d_name;
			//BYTETIK MBRA MOLDATU, ERABILTZAILEARENTZAKO EROSOAGOA
			aldagaia=(int)file_info.st_size;
			aldagaia=aldagaia/1024;	
			aldagaia=aldagaia/1024;
			//FITXATEGIEN TAMAINEN ARRAYA DATUZ
			//TAMAINA MB GORDETZEN DA	
			Abestien_tamaina[i]=aldagaia;
		}	
	}
	return fitxategi_kop;
}

/*KATE BAT EA BESTE KATEA BATEN ZATIA DEN BEGIRATZEN DU ( AZPIKATEA )
//   1= BADAGO AZPIKATEA   ||    0= EZ DAGO AZPIKATEA        */
int katea_dago(char *s1, char *s2 )
{
	 if ( strstr( s1, s2 )== NULL )
	 {
		return 0;
	 }
	 else
	 {
		return 1;
	 }
}

//PROGRAMA NAGUSIA
int main()
{
	//EGOERA DESEGOKIAK HASIERATU
	EGOERA_DESEGOKIAK=0;
	//EGOEREN AUTOMATA HASIERATU
	EGOERA=EGOERA_USER;
	int sock, elkarrizketa;
	struct sockaddr_in zerb_helb;
	socklen_t helb_tam;
	// SORTU SOCKETA.
	if((sock = socket(AF_INET, SOCK_STREAM, 0)) < 0)
	{
		perror("ERROREA SOCKETA SORTZEAN");
		exit(1);
	}
	//SOCKETAREN INFORMAZIOA
	memset(&zerb_helb, 0, sizeof(zerb_helb));
	zerb_helb.sin_family = AF_INET;
	zerb_helb.sin_addr.s_addr = htonl(INADDR_ANY);
	zerb_helb.sin_port = htons(PORT);
	// ESLEITU HELBIDEA SOCKETARI.	
	if(bind(sock, (struct sockaddr *) &zerb_helb, sizeof(zerb_helb)) < 0)
	{
		perror("ERROREA SOCKETARI HELBIDE BAT ESLEITZEAN");
		exit(1);
	}
	// EZARRI SOCKETA ENTZUTE SOCKET GISA.
	if(listen(sock,5) < 0)
	{
		perror("ERROREA SOCKETA ENTZUTE SOCKET BEZALA EZARTZEAN");
		exit(1);
	}
	// ADIERZI SIG_CHLD SEINALEA JASOTZEAN EZ DELA EZER EGINGO. MODU HONETAN AMAITUTAKO PROZESU UMEAK EZ DIRA ZONBI EGOERAN GERATUKO.
	signal(SIGCHLD, SIG_IGN);
	while(1)
	{
		// ONARTU KONEXIO ESKAERA ETA SORTU ELKARRIZKETA SOCKETA.
		if((elkarrizketa = accept(sock, NULL, NULL)) < 0)
		{
			perror("ERROREA KONEXIOA ONARTZEAN");
			exit(1);
		}
		// SORTU PROZESU UME BAT BEZEROAREKIN KOMUNIKATZEKO.
		switch(fork())
		{
			case 0:
				//UMEA
				close(sock);
				sesioa(elkarrizketa);
				close(elkarrizketa);
				exit(0);
			default:
				//GURASOA
				close(elkarrizketa);
		}
	}
}

/* FUNTZIO HONETAN KODETZEN DA BEZEROAREKIN KOMUNIKATU BEHAR DEN PROZESU UMEAK EGIN BEHARREKOA, APLIKAZIO PROTOKOLOAK ZEHAZTU BEZALA.
* PARAMETRO GISA ELKARRIZKETA SOCKETA PASA BEHAR ZAIO.
*/
void sesioa(int s)
{
	//ALDAGAIAK HASIERATU
	char buf[MAX_BUF];
	int n, erabiltzaile,posizioa;
	char parametroa[MAX_BUF];
	int fitx_kop;
	//ABESTI_IZENAK ARRAYKO AZKEN INDIZE BEHAR DUGU ONDOREN ER6 TRATAMENDUA EGITEKO, STRLEN-EN BIDEZ EZIN DUGUNEZ LORTU, HONEN BITARTEZ LORTUKO DUGU	
	fitx_kop=Irakurri_direktorioa()-1;
	while(1)
	{
		//BEZEROAREN KOMANDOA JASO
		if((n = read(s, buf, MAX_BUF))==-1)
		{
			printf("%s EROREAREN MEZUA",buf);
			printf("ERROREA MEZUA JASOTZEAN");
			exit(1);
		}
		buf[n-1]=0; //BUF-EN INFORMAZIOAREN BUKAERA NON DAGOEN ADIERAZTEN DA
		//LORTU KOMANDOA
		char etorritako_KOMANDOA[5]={buf[0],buf[1],buf[2],buf[3],'\0'};
		//LORTU PARAMETROA
		strcpy(parametroa,buf+4);
		//PARAMETROARI BUKAERA JARRI
		parametroa[n-4]=0;
		//BEGIRATU EA KOMANDOA EXISTITZEN DEN, HORRELA BADA EMAN KOMANDOAREN POSIZIOA
		if ((posizioa = bilatu_string(etorritako_KOMANDOA,KOMANDOAK))<0)
		{
			//KOMANDOA EZ DA EXISTITZEN
			Egoera_des(s);
		}
		//KOMANDO BAKOITZA TRATATU
		switch(posizioa)
		{
			//USER KOMANDOA
			case USER:
				if ( EGOERA==EGOERA_USER )
				{				
					//BEGIRATU EA ERABILTZAILEA EXISTITZEN DEN ETA BERE POSIZIOA GORDE
					if((erabiltzaile=bilatu_string(parametroa,erab_zer)) < 0)
					{	
						//ERRORE KONTROLA 2 ERABILTZAILEA EZ DA EXISTITZEN
						if ((write(s,"ER2\n",4))==-1)
						{
							printf("ERROREA MEZUA BIDALTZEAN");
							exit(1);
						}
						 EGOERA=EGOERA_USER; 
					}
					else
					{
						//DENA ONDO BADOA PASS EGOERARA PASA
						if ((write(s,"OK\n",3))==-1)
						{
							printf("ERROREA MEZUA BIDALTZEAN");
							exit(1);						
						}
						EGOERA= EGOERA_PASS	;
					}
				}
				else
				{
					//EGOERA DESEGOKIA TRATATU
					Egoera_des(s);	
				}
				break;
				
			//PASS KOMANDOA
			case PASS:
				if ( EGOERA==EGOERA_PASS )
				{				
					//BEGIRATU EA ERABILTZAILEA EXISTITZEN DEN ETA BERE POSIZIOA GORDE
					if( (erabiltzaile)==(bilatu_string(parametroa,pass_zer))  )
					{	
						//DENA ONDO BADOA EGOERA OROKORRERA PASA
						if ((write(s,"OK\n",3))==-1)
						{
							printf("ERROREA MEZUA BIDALTZEAN");
							exit(1);							
						}
						EGOERA=EGOERA_OROKORRA;
					}
					else
					{
						//ERRORE KONTROLA 3 ERABILTZAILEA EZ DA EXISTITZEN
						if ((write(s,"ER3\n",4))==-1)
						{
							printf("ERROREA MEZUA BIDALTZEAN");
							exit(1);						
						}
						EGOERA=EGOERA_PASS; 
					}
				}
				else
				{
					//EGOERA DESEGOKIA
					Egoera_des(s);
				}
				break;
				
			//SEAR KOMANDOA
			case SEAR:
				if ( EGOERA==EGOERA_OROKORRA )
				{	
					//ALDAGAIAK HASIERATU
					int i=0;
					char kat[MAX_BUF];
					char emaitza[MAX_BUF];
					int kont=0;
					//ARRAYAK HUSTU
					memset(kat,'\0',strlen(kat));
					memset(emaitza,'\0',strlen(emaitza));
					//KOMANDOA ERAIKITZEN JOAN
					strcat(emaitza,"OS");
					//DITUGUN ABESTI BAKOITZEAN BEGIRATU EA AZPIKATEA EXISTITZEN DEN, HAU DA, EMAITZA DEN
					while(Abestien_izenak[i] != '\0')
					{
						if(katea_dago(Abestien_izenak[i],parametroa)==1)
						{
							//OS KOMANDO OSOA ERAIKI || OHARRA: AZKENEKO PARAM KOMA BAT GEHIAGOREKIN DATOR
							sprintf(kat,"%d#%s#%f,",i,Abestien_izenak[i],Abestien_tamaina[i]);
							// EMAITZA = SOPARAM1#PARAM2#PARAM3,
							strcat(emaitza,kat);
							kont ++;
						}
						i++;
					}
					if(kont==0)
					{
						//ERRORE KONTROLA 4 EZ DU EMAITZARIK LORTU
						if ((write(s,"ER4\n",4))==-1)
						{
							printf("ERROREA MEZUA BIDALTZEAN");
							exit(1);							
						}
					}
					else
					{
						//BUKAERA JARRI ETA 	
						emaitza[strlen(emaitza)-1]='\n';
						int n;
						//AZKENEKO KOMA KENDU	
						if (n=write(s, emaitza, strlen(emaitza))<0 )
						{
							printf("ERROREA MEZUA BIDALTZEAN");
							if ((write(s,"ER5\n",4))==-1)
							{
								printf("ERROREA MEZUA BIDALTZEAN");
								exit(1);							
							}
							exit(1);
						}
					}
				}
				else
				{
					//EGOERA DESEGOKIA TRATATU
					 Egoera_des(s);
				}
				break;

			//DOWN KOMANDOA
			case DOWN:
				if ( EGOERA==EGOERA_OROKORRA )
				{	
					char *abestia;
					//ABESTIEN ZERRENDAN NAHI DUGUN ABESTIAREN INDIZEA IZANGO DENA(IDENTIFIKADOREA)			
					struct stat file_info;
					FILE *fp,*fichero;			
					int ident;
					char file_path[MAX_BUF];
					//JASOTAKO IDENTIFIKADOREA(CHAR) INTEGER BIHURTU 
					ident =atoi(parametroa);
					if(ident < 0 || ident >fitx_kop )
					{			
						if ((write(s,"ER6\n",4))==-1)
						{
							printf("ERROREA MEZUA BIDALTZEAN");
							exit(1);							
						}
					}
					else
					{
						//ABESTIA IZANGO DA JEITSIKO DUGUN ABESTIA
						abestia=Abestien_izenak[ident];
						//FILE_PATHEN FITXATEGIEN KARPETA ETA ABESTI IZENA KATEATU
						sprintf(file_path,"%s/%s",FILES_PATH,abestia);
						// LORTU FITXATEGIARI BURUZKO INFORMAZIOA.			
						if(stat(file_path, &file_info) <0)					
						{
							if ((write(s,"ER7\n",4))==-1)
							{
								printf("ERROREA MEZUA BIDALTZEAN");
								exit(1);								
							}
						}
						else
						{	//ABESTIAREN TAMAINA  ETA IZENA BIDALTZEN ZAIO
							sprintf(buf,"OD%ld#%s\n", file_info.st_size,abestia);
							if(write(s, buf, strlen(buf))==-1)
							{
								printf("ERROREA MEZUA BIDALTZEAN");
								exit(1);							
							}
						}
						//FITXATEGIA IREKI
						if((fp=fopen(file_path,"r")) == NULL)
						{
								if((write(s,"ER7\n",4))==-1)
								{
									printf("ERROREA MEZUA BIDALTZEAN");
									exit(1);							
								}
						}
						else
						{
							// FITXATEGIAREN LEHENENGO ZATIA IRAKURRI ETA ERRORE BAT GERTATU BADA BIDALI ERRORE KODEA.
							if((n=fread(buf,1,MAX_BUF,fp))<MAX_BUF && ferror(fp) != 0)
							{				
								if ((write(s,"ER7\n",4))==-1)
								{
									printf("ERROREA MEZUA BIDALTZEAN");
									exit(1);					
								}
							}
							else
							{	
								do
								{
									if ((write(s,buf,n))==-1)
									{
										printf("ERROREA MEZUA BIDALTZEAN");
										exit(1);					
									}
									
								} while((n=fread(buf,1,MAX_BUF,fp)) == MAX_BUF);
								if(ferror(fp) != 0)
								{
									close(s);
									return;
								}
								else if(n>0)
								{	// BIDALI AZKENEKO ZATIA.
									if((write(s,buf,n))==-1)
									{
										printf("ERROREA MEZUA BIDALTZEAN");
										exit(1);					
									}
									
								}
							}
						}
						fclose(fp);
						}
					}
					else
					{
						//EGOERA DESEGOKIA
						 Egoera_des(s);
					}
			
				break;
			//EXIT KOMANDOA
			case EXIT:
				if ( EGOERA==EGOERA_OROKORRA )
				{	
					if ((write(s,"OK\n",3))==-1)
					{
						printf("ERROREA MEZUA BIDALTZEAN");
						exit(1);			
					}
				}
				else
				{
					//EGOERA DESEGOKIA
					 Egoera_des(s);
				}
				break;
		}
		//BUF ALDAGAIA EZABATU HURRENGO BUELTARAKO
		buf[0]=0;
	}
}












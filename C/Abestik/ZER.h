#define MAX_BUF 4096
#define PORT 6012
#define FILES_PATH	"/home/telmo/Escritorio/KANTAK"

#define EGOERA_USER		0
#define EGOERA_PASS		1
#define EGOERA_OROKORRA	2
#define EGOERA_BILATU	3
#define EGOERA_JAITSI	4

#define USER	0
#define PASS	1
#define SEAR	2
#define DOWN	3
#define EXIT	4

char * KOMANDOAK[] = {"USER","PASS","SEAR","DOWN","EXIT",NULL};
char * erab_zer[] = {"anonimous","sar","sza",NULL};
char * pass_zer[] = {"","sar","sza",NULL};
char * Abestien_izenak[MAX_BUF];
//tamaina MB gordetzen da
float  Abestien_tamaina[MAX_BUF];

//HASIERAKO EGOERA
int EGOERA;
int EGOERA_DESEGOKIAK;

void sesioa(int s);
int readline(int stream, char *buf, int tam);
int bilatu_string(char *string, char **string_zerr);
int bilatu_substring(char *string, char **string_zerr);



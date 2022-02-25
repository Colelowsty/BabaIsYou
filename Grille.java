import java.util.*;

public class Grille{

	private static int nblig;
	private static int nbcol;
	private static char[][] grille;
	public static boolean win = false;

	// constructeur
	public Grille(int n, int p){
		nblig = n;
		nbcol = p;
		grille = new char[nblig][nbcol];
		for (int i=0; i<nblig;i++){
			for (int j=0; j<nbcol;j++){
				grille[i][j] = '.';
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int d;
		Grille g = new Grille(13,11);
		g.placer(5,3,'m');g.placer(5,4,'m');g.placer(5,5,'m');g.placer(5,6,'m');g.placer(5,7,'m');g.placer(5,8,'m');g.placer(5,9,'m');//premier mur
		g.placer(7,4,'b');//baba
		g.placer(7,8,'f');//flag
		g.placer(6,6,'r');g.placer(7,6,'r');g.placer(8,6,'r');//placer les rochers
		g.placer(9,3,'m');g.placer(9,4,'m');g.placer(9,5,'m');g.placer(9,6,'m');g.placer(9,7,'m');g.placer(9,8,'m');g.placer(9,9,'m');//deuxieme mur
		g.afficher();
		int p=0;
		while (win == false){
		System.out.print("m = mur....b=baba....f=flag....r=rock....\n");
		System.out.println("vers ou voulez-vous vous deplacer?\n8->haut....2->bas....4....gauche....6->droite....\n)");
		d = sc.nextInt();

		switch(d){
			case 8:g.deplacerH();
			break;
			case 2:g.deplacerB();
			break;
			case 4:g.deplacerG();
			break;
			case 6:g.deplacerD();
			break;

		}
		for (int i=0;i<100;i++){
			System.out.println();
		}
		g.afficher();

	}
		if (win == true){
			System.out.println("vous avez gagne");
		}
		//g.deplacerD();
		//g.afficher();
	}

	public static void afficher(){
		for (int i=0; i<nblig;i++){
			for (int j=0; j<nbcol;j++){
				System.out.print("|"+ grille[i][j]);
			}
		System.out.println("|");
		}
		System.out.println();
		//positioner
		//deplacer
	}

	public char getcase(int l, int c){
		return grille[l-1][c-1];
	}

	public void placer(int l, int c,char t){
		l = l-1;
		c = c-1;
		// on test si on se trouve sur la grille
		if (l<0 || c<0 || l>nbcol || c>nblig){
			System.out.print("erreur de placement");
		}
		if (grille[l][c] == '.'){
			grille[l][c] = t;
		}
		else{
			System.out.print("erreur de placement");
		}
	}

	public static void deplacerH(){
		char tmp;
		for (int i=0; i<nblig;i++){
			for (int j=0; j<nbcol;j++){
				if (grille[i][j] == 'b'){//on cherche baba
					if (i-2>=0 && grille[i-1][j] == '.'){//on teste s'il ya plus de ligne en dessous
						tmp = grille[i][j];//on copi le joueur
						grille[i][j] = '.';//on vide sa case
						grille[i-1][j] =tmp;//on perseau le perseau
					}
					else if(i-2>=0 && grille[i-1][j] == 'f'){
						win = true;
						
					}

				}
			}
		}
	}

	public static void deplacerB(){
		char tmp;
		for (int i=0; i<nblig;i++){
			for (int j=0; j<nbcol;j++){
				if (grille[i][j] == 'b'){//on cherche baba
					if (i+2>=0 && grille[i+1][j] == '.'){//on teste s'il ya plus de ligne en dessous
						tmp = grille[i][j];//on copi le joueur
						grille[i][j] = '.';//on vide sa case
						grille[i+1][j] =tmp;//on perseau le perseau
						j++;
						i++;
					}
					if (i+2>=0 && grille[i+1][j] == 'f'){
						win = true;
					}

				}
			}
		}
	}



	public static void deplacerG(){
	char tmp;
	for (int i=0; i<nblig;i++){
		for (int j=0; j<nbcol;j++){
			if (grille[i][j] == 'b'){//on cherche baba
				if (j-2>=0 && grille[i][j-1] == '.'){//on teste s'il ya plus de ligne en dessous
					tmp = grille[i][j];//on copi le joueur
					grille[i][j] = '.';//on vide sa case
					grille[i][j-1] =tmp;//on perseau le perseau
				}
				if (j-2>=0 && grille[i][j-1] == 'f'){
						win = true; 
					}


			}
		}
	}
	}
	public static void deplacerD(){
	char tmp;
	for (int i=0; i<nblig;i++){
		for (int j=0; j<nbcol;j++){
			if (grille[i][j] == 'b'){//on cherche baba
				if (j+2<nbcol && grille[i][j+1] == '.'){//on teste s'il ya plus de ligne en dessous
					tmp = grille[i][j];//on copi le joueur
					grille[i][j] = '.';//on vide sa case
					grille[i][j+1] =tmp;//on perseau le perseau
					break;
				}
				if (j+2>=0 && grille[i][j+1] == 'f'){
						win = true;
					}


			}
		}
	}
	}

}



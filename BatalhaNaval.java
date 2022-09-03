package jogo;
import java.util.Scanner;
/*
INICIALIZAÇÃO DOS 5 BARCOS: OK
-CRUZADOR(4)-OK, SUBMARINO(1)-OK, COURAÇADO(5)-OK, DESTROYER(2)-OK, HIDRO-AVIAO(3)-OK;
INCIALIZAÇÃO DAS MATRIZ:
-PEDIR VALORES
-LER VALORES
INICIALIZAÇÃO TABULEIRO(14x14): OK
-UM PARA O JOGADOR COLOCAR AS PEÇAS E MOSTRAR AS POSIÇÕES OK
-PARA O JOGADOR ADIVINHAR
-COMPARAÇÃO DAS MATRIZES
VERIFICAÇÃO DA POSIÇÃO E TAMANHO DOS NAVIOS
 */

public class BatalhaNaval{
    public static void main(String[]args){

        Scanner sc = new Scanner(System.in);

        int tabuleiro_user[][] = new int[14][14];
        int tabuleiro[][] = new int[14][14];
        int tabuleiro_aux[][] = new int[1000][1000];
        int acertos = 0, tentativas = 20;
        int l, c, l_aux , c_aux;

        System.out.println("BATALHA NAVAL");
        inicializaTabuleiro(tabuleiro);
        mostrarTabuleiroComPecas(tabuleiro);
        

        //SUBMARINO(1) - "1"
        System.out.println("Insira a posição do submarino: ");
        System.out.print("Insira a linha do submarino: ");l_aux = sc.nextInt();
        System.out.print("Insira a coluna do submarino: ");c_aux = sc.nextInt();
        if(l_aux > 0 && c_aux > 0 && l_aux < 15 && c_aux < 15){
            l = l_aux;
            c = c_aux;
            tabuleiro[l-1][c-1]=1;
        }else{    
            while(l_aux <= 0 || c_aux <= 0 || l_aux > 14 || c_aux > 14){
                if(l_aux <= 0 || l_aux > 14){
                    System.out.print("Posição inválida para linha! Digite uma posição válida (1 a 14): ");
                    l_aux = sc.nextInt();
                }
                if(c_aux <= 0 || c_aux > 14){
                System.out.print("Posição inválida para coluna! Digite uma posição válida (1 a 14): ");
                c_aux = sc.nextInt();
                }
                if(l_aux > 0 && c_aux > 0 && l_aux < 15 && c_aux < 15){
                    l = l_aux;
                    c = c_aux;
                    tabuleiro[l-1][c-1]=2;
                }
            }
        }mostrarTabuleiroComPecas(tabuleiro);

        //DESTROYER(2) - "2"
        l = l_aux;
        c = c_aux;
        tabuleiro[l-1][c-1]=2;
        for(int i = 0; i<2;i++) {
			System.out.println("Insira a posição do destroyer: ");
            System.out.print("Insira a linha do destroyer: ");l_aux = sc.nextInt();
            System.out.print("Insira a coluna do destroyer: ");c_aux = sc.nextInt();
            tabuleiro_aux[l_aux-1][c_aux-1] = 3;
            if(l_aux > 0 && c_aux > 0 && l_aux < 15 && c_aux < 15 && tabuleiro[l-1][c-1] != 1){//CERTO
                l = l_aux;
                c = c_aux;
                tabuleiro[l-1][c-1]=3;
                mostrarTabuleiroComPecas(tabuleiro);
            }else{    //ERRADO
                while(l_aux < 0 && c_aux < 0 && l_aux > 14 && c_aux > 14 && tabuleiro_aux[l_aux-1][c_aux-1] == l && tabuleiro_aux[l_aux-1][c_aux-1] == c){
                    if(l_aux < 0 && c_aux < 0 && l_aux > 14 && c_aux > 14 && tabuleiro_aux[l_aux-1][c_aux-1] == l && tabuleiro_aux[l_aux-1][c_aux-1] == c){
                        System.out.print("Posição inválida para linha! Digite uma posição válida (1 a 14): ");
                        l_aux = sc.nextInt();
                        System.out.print("Posição inválida para coluna! Digite uma posição válida (1 a 14): ");
                        c_aux = sc.nextInt();
                    }
                    if(l_aux > 0 && c_aux > 0 && l_aux < 15 && c_aux < 15 && tabuleiro_aux[l_aux-1][c_aux-1] > -1 && tabuleiro_aux[l_aux-1][c_aux-1] != 2){
                        l = l_aux;
                        c = c_aux;
                        tabuleiro[l-1][c-1]=3;
                        mostrarTabuleiroComPecas(tabuleiro);
                    }
                }
            }mostrarTabuleiroComPecas(tabuleiro);
		}
        //HIDRO-AVIAO(3) - "3"   
        for(int i = 0; i<1;i++) {
            String pos;
            System.out.println("Insira a posição do hidro-aviao: ");
            System.out.print("Insira a linha do hidro-avião: ");l_aux = sc.nextInt();
            System.out.print("Insira a coluna do hidro-aviao: ");c_aux = sc.nextInt();
            System.out.print("Posição para 'CIMA' ou para 'BAIXO': ");pos = sc.next();
                tabuleiro_aux[l_aux-1][c_aux-1] = 3;
                if(pos.equals("CIMA") || pos.equals("cima")){
                    l = l_aux;
                    c = c_aux;
                    tabuleiro[l-1-1][c-1-1] = 3;//esquerda-cima
                    tabuleiro[l-1-1][c-1+1] = 3;//direita-cima
                    tabuleiro[l-1][c-1] = 3;//meio
                    mostrarTabuleiroComPecas(tabuleiro);
                }
                if(pos.equals("BAIXO") || pos.equals("baixo")){
                    l = l_aux;
                    c = c_aux;
                    tabuleiro[l-1+1][c-1-1] = 3;//esquerda-baixo
                    tabuleiro[l-1+1][c-1+1] = 3;//direita-baixo
                    tabuleiro[l-1][c-1] = 3;//meio
                    mostrarTabuleiroComPecas(tabuleiro);
                }
        }
        //CRUZADOR(4) - "4"
        for(int i = 0; i<4;i++) {
            System.out.println("Insira a posição do cruzador: ");
            System.out.print("Insira a linha do cruzador: ");l_aux = sc.nextInt();
            System.out.print("Insira a coluna do cruzador: ");c_aux = sc.nextInt();
            l = l_aux;
            c = c_aux;
            tabuleiro[l-1][c-1]=4;
            mostrarTabuleiroComPecas(tabuleiro);
        }
        //COURAÇADO(5) - "5"
        for(int i = 0; i<5;i++) {
            
            System.out.println("Insira a posição do couraçado: ");
            System.out.print("Insira a linha do couraçado: ");l_aux = sc.nextInt();
            System.out.print("Insira a coluna do couraçado: ");c_aux = sc.nextInt();
            l = l_aux;
            c = c_aux;
            tabuleiro[l-1][c-1]=5;
            mostrarTabuleiroComPecas(tabuleiro);
        }
        
        for(l=0 ; l < 14 ; l++ )
                    for(c=0 ; c < 14 ; c++ )
                        tabuleiro_user[l][c]=-2;
        
        //LAÇO DE REPETIÇÃO DO-WHILE PARA MOSTRAR AO USÚARIO O TABULEIRO, TIROS, ACERTOS E FINALIZAÇÃO DO JOGO
        do {
			System.out.println("ATIRE!");
			System.out.println("Digite a coordenada do tiro: ");
			System.out.print("Linha: "); l = sc.nextInt(); 
            System.out.print("Coluna: "); c = sc.nextInt();
			
			if(tabuleiro[l-1][c-1] != -2 && tabuleiro[l-1][c-1] != -1 && tabuleiro[l-1][c-1] != 0) {
				System.out.println("ACERTOU");
				tabuleiro_user[l-1][c-1] = 0;
				acertos++;
                tentativas++;
			}
			else {
				System.out.println("ERROU!");
				tabuleiro_user[l-1][c-1] = -1;
			}
            if(tabuleiro[l-1][c-1] == 1){
                System.out.println("Submarino");
            }
            if(tabuleiro[l-1][c-1] == 2){
                System.out.println("Destroyer");
            }
            if(tabuleiro[l-1][c-1] == 3){
                System.out.println("Hidro-aviao");
            }
			if(tabuleiro[l-1][c-1] == 4){
                System.out.println("Cruzador");
            }
            if(tabuleiro[l-1][c-1] == 5){
                System.out.println("Couraçado");
            }

			System.out.println("\t1 \t2 \t3 \t4 \t5 \t6 \t7 \t8 \t9 \t10 \t11 \t12 \t13 \t14");
                System.out.println();

                    for(l=0;l<14;l++){
                        System.out.print((l+1)+"");
                        for(c=0;c<14;c++){
                            if(tabuleiro_user[l][c]== -2){//água
                                System.out.print("\t"+"~");
                            }else if(tabuleiro_user[l][c]==-1){//tiro errado
                                System.out.print("\t"+"*");
                            }else if(tabuleiro_user[l][c]==0){//tiro certo
                                System.out.print("\t"+"X");
                            }
                        }
                        System.out.println();
                    }
			tentativas--;
		}while(tentativas != 0 || acertos != 12);
		System.out.print("A quantidade total de acertos foi de: " + acertos);
        
        if(acertos == 12 || tentativas == 0){
            System.out.println("\n\n\nJogo finalizado. Você acertou os 5 navios em "+tentativas+" tentativas");
            mostrarTabuleiroComPecas(tabuleiro);
        }

    }   
            public static void inicializaTabuleiro(int[][] tabuleiro){
                //MÉTODO PARA INICIALIZAR O TABULEIRO, DANDO VALOR -2 PARA TODA A MATRIZ 14x14
                for(int l=0 ; l < 14 ; l++ )
                    for(int c=0 ; c < 14 ; c++ )
                        tabuleiro[l][c]=-2;
            }
            

            public static void mostrarTabuleiroComPecas(int[][] tabuleiro){
                //MÉTODO PARA MOSTRAR AO USÚARIO O TABULEIRO
                System.out.println("\t1 \t2 \t3 \t4 \t5 \t6 \t7 \t8 \t9 \t10 \t11 \t12 \t13 \t14");
                System.out.println();

                    for(int l=0;l<14;l++){
                        System.out.print((l+1)+"");
                        for(int c=0;c<14;c++){
                            if(tabuleiro[l][c]==-2){//água
                                System.out.print("\t"+"~");
                            }else if(tabuleiro[l][c]==-1){//tiro errado
                                System.out.print("\t"+"*");
                            }else if(tabuleiro[l][c]==0){//tiro certo
                                System.out.print("\t"+"X");
                            }else if(tabuleiro[l][c]==1){//submarino
                                System.out.print("\t"+1);
                            }else if(tabuleiro[l][c]==2){//destroyer
                                System.out.print("\t"+2);
                            }else if(tabuleiro[l][c]==3){//hidro-aviao
                                System.out.print("\t"+3);
                            }else if(tabuleiro[l][c]==4){//cruzador
                                System.out.print("\t"+4);
                            }else if(tabuleiro[l][c]==5){//couraçado
                                System.out.print("\t"+5);
                            }
                        }
                        System.out.println();
                    }
            }

        
}
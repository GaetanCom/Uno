
package uno;

import java.util.List;

public class nbalbalUnoPlayer implements UnoPlayer {


    public int play(List<Card> hand, Card upCard, Color calledColor, GameState state) {

        // Card numMain = hand.get(); // Retourne la carte dans position 1 (numéro + couleur).

        int nSize = hand.size();

    	Color init = upCard.getColor(); // Retourne la couleur de upCard.

		Color coulTer = coulUpCard(init, calledColor); // Appelle la fonction coulupCard

		int posCart = posCarteMain(hand, coulTer);

		int posWild = posWildMain(hand, upCard);

		int posNum = posNumMain(hand, upCard);

		int posSpe = posSpeMain(hand, upCard);

    	if((posCart==-1) && (posWild==-1)){
    		System.out.println("1");
    		return -1;
    	} else if(posWild != -1){
    		System.out.println("2");
    		return posWild;
    	} else if( posSpe != -1){
    		System.out.println("5");
    		return posSpe;
    	} else if (posNum != -1 ){
    		System.out.println("3");
    		return posNum;
    	}else if(posCart != -1){
    		System.out.println("4");
    		return posCart;
    	}

		// System.out.println(posCart);

		return -1;
    }

    public Color callColor(List<Card> hand) {
        int green = 0;
        int blue = 0;
        int red = 0;
        int yellow = 0;
        int tailleMain = hand.size();

        // System.out.println(tailleMain);

        for (int i = 0 ; i<tailleMain ; i++){
            // EN Faire une fonction
            Card numMain = hand.get(i); // Retourne la carte dans position 1 (numéro + couleur).
            Color couleurMain = numMain.getColor(); // Retourne la couleur de la Card num.

            if(couleurMain == Color.RED){
                red++;
            } else if(couleurMain == Color.BLUE){
                blue++;
            } else if(couleurMain == Color.YELLOW){
                yellow++;
            } else if(couleurMain == Color.GREEN){
                green++;
            }
        }

        int max = 0;
        Color couleur = Color.GREEN;

        
        if(red>max) {
            max = red;
            couleur = Color.RED;
        } else if (blue>max){
            max = blue;
            couleur = Color.BLUE;
        }
        else if (yellow>max){
            max = yellow;
            couleur = Color.YELLOW;
        }
        else if(green>max) {
            max = green;
            couleur = Color.GREEN;
        }

        return couleur;

        // return null;
    }

    public Color coulUpCard(Color carteCouleur, Color couleurApp){
    	if(carteCouleur == Color.NONE){
    		carteCouleur = couleurApp;
    	}

    	return carteCouleur;
    }

    public int posCarteMain(List<Card> hand, Color couleur){

    	Card numMain = hand.get(0); // Retourne la carte dans position 1 (numéro + couleur).
      	Color couleurMain = numMain.getColor(); // Retourne la couleur de la Card num.

    	Card numero;
    	int position = -1;


    	for(int i=0 ; i<hand.size(); i++){
        	numMain = hand.get(i);
        	couleurMain = numMain.getColor();
        	if(couleur == couleurMain){
        		position = i;
    		}
    	}
        return position;
    }

    public int posWildMain(List<Card> hand, Card upCard){
    	int position = -1;
     	Rank typeRank = Rank.NUMBER;

      	for(int i=0;i<hand.size();i++){
        	if(hand.get(i).getRank() == Rank.WILD || hand.get(i).getRank() == Rank.WILD_D4){
          		position = i;
          		return position;
        	}
      	}
      	return position;
    }

     public int posNumMain(List<Card> hand, Card upCard){
     	int position = -1;

     	for(int i=0 ; i<hand.size() ; i++){
        	if(hand.get(i).getNumber() == upCard.getNumber()){
          		position = i;
          		return position;
        	}
      	}
      	return position;
     }

     public int posSpeMain(List<Card> hand, Card upCard){
     	int position = -1;

     	for(int i=0 ; i<hand.size() ; i++){
     		if(hand.get(i).getRank() == upCard.getRank() || hand.get(i).getColor() == upCard.getColor()){
     			position = i;
     			return position;
     		} 
     	}
     	return position;
     }


}

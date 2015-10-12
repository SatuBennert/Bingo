/**
 * PaaOhjelma -luokka kutsuu Valikkoa, josta varsinainen ohjelma alkaa LogIn -ja
 * BingonYlläpito -napeilla.
 * 
 */
package com.satu.bingo;

import com.satu.bingo.Kayttoliittymat.*;

/**
 *
 * @author bensatu
 */
public class PaaOhjelma {

    public static void main(String[] args) {

//seuraava koodi rinnakkaisuuden takia:
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Valikko valikko = new Valikko();
                valikko.gui();
                
            }

        }
        );
    }

}

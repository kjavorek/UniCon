# UniCon
Aplikacija sadrži četiri activity-a. U MainActivity-u definirani su gumbi za pretvaranja, a zbog ljepšeg izgleda 
za svaki gumb je definiran selektor u kojem su postavljene boje, gradient, oblik. Nakon što korisnik klikne na 
gumb provjerava se koji je gumb pritisnut te se eksplicitnim intentom prelazi u odgovarajući activity. U activity-u 
za pretvorbu i activity-u u kojem se prikazuje rezultat u manifestu je promijenjen izgled, odnosno stil. U activity-u 
za pretvorbe dohvaća se odgovarajuće polje stringova (ovisno o kojoj pretvorbi je riječ) i prikazuje pomoću spinner-a. 
Defaultni izgled spinner-a je promijenjen pomoću spinner_dropdown_item.xml i spinner_item.xml datoteka (promjena veličine 
i boje izabranog teksta i teksta u dropdown listi). Nakon provjere o kojoj pretvorbi se radi prikazuje se odgovarajući 
tekst pretvorbe te se koristi adapter zbog postavljanja mogućnosti odabira pretvorbe. Nakon klika na gumb "CONVERT" ako 
je korisnik unio podatke prikupljaju se vrijednosti i izračunava se rezultat. Poslije toga dobiveni rezultat i jedinice 
koje se preračunavaju šalju se eksplicitnim intentom u activity za prikaz rezultata uz  pomoć extra podataka. U activity-u 
za prikaz podataka prikazuju se mjerne jedinice, početna veličina i rezultat. Pomoću ScrollView-a omogućen je vertikalni 
scroll ekrana prilikom okretanja mobitela horizontalno.
  
Literatura i izvori:  
Predlošci s laboratorijskih vježbi  
http://stackoverflow.com/questions/26070827/how-to-set-style-for-a-button-in-android (Button style)  
https://www.mkyong.com/android/android-spinner-drop-down-list-example/ (Spinner)  
http://stackoverflow.com/questions/30160784/how-to-compare-two-spinner-items (Compare spinners)  
http://www.broculos.net/2013/09/how-to-change-spinner-text-size-color.html#.WN5Xd_nyjIU (Spinner style)  
import Ember from 'ember';
import user from '../models/user';
 
export default Ember.Controller.extend({
    userService: Ember.inject.service('userService'),
    session: Ember.inject.service(),
    msgedit: ' ',
 
 
    actions: {
         spasiPromjeneKorisnika() {
         let editKorisnika = this.getProperties('email','firstName','lastName', 'omeni', 'interesovanja', 'zanimanje', 'location');
         var ime = /^[a-z ,.'-]+$/i;
         var waserror = false;
         
 
          if(this.get('session.data.authenticated.korisnik.firstName') === '' || this.get('session.data.authenticated.korisnik.firstName') === null)
                  {
                     editKorisnika.firstName = ' ';
                  }
                  else
         editKorisnika.firstName= this.get('session.data.authenticated.korisnik.firstName');

          
          console.log('prezime' + this.get('session.data.authenticated.korisnik.lastName'));

         if(this.get('session.data.authenticated.korisnik.lastName') === '' || this.get('session.data.authenticated.korisnik.lastName') === null)
                 {
                    editKorisnika.lastName = ' ';
                 }
                 else
         editKorisnika.lastName =this.get('session.data.authenticated.korisnik.lastName');

     if(!this.get('session.data.authenticated.korisnik.firstName').match(ime))
     {
        waserror = true;
        this.set('errorFirstName','Name can contain only letters!');
     }
     else
     {
        this.set('errorFirstName','');

     }

     if(!this.get('session.data.authenticated.korisnik.lastName').match(ime))
     {
         waserror = true;
        this.set('errorLastName','Last name can contain only letters!');
     }
     else
     {
         this.set('errorLastName','');

     }
 
         if(this.get('session.data.authenticated.korisnik.zanimanje') === '' || this.get('session.data.authenticated.korisnik.zanimanje') === null)
                 {
                    editKorisnika.zanimanje = ' ';
                 }
                 else
 
         editKorisnika.zanimanje = this.get('session.data.authenticated.korisnik.zanimanje');
 
         if(this.get('session.data.authenticated.korisnik.location') === '' || this.get('session.data.authenticated.korisnik.location') === null)
                 {
                    editKorisnika.location = ' ';
                 }
                 else
         editKorisnika.location = this.get('session.data.authenticated.korisnik.location');
         if(this.get('session.data.authenticated.korisnik.email') === '' || this.get('session.data.authenticated.korisnik.email') === null)
                 {
                    editKorisnika.email = ' ';
                 }
                 else
 
         editKorisnika.email = this.get('session.data.authenticated.korisnik.email');
 
         if(this.get('session.data.authenticated.korisnik.interesovanja') === '' || this.get('session.data.authenticated.korisnik.interesovanja') === null)
                 {
                    editKorisnika.interesovanja = ' ';
                 }
                 else
         editKorisnika.interesovanja = this.get('session.data.authenticated.korisnik.interesovanja');
         if(this.get('session.data.authenticated.korisnik.omeni') === '' || this.get('session.data.authenticated.korisnik.omeni') === null)
                 {
                    editKorisnika.omeni= ' ';
                 }
                 else
         editKorisnika.omeni = this.get('session.data.authenticated.korisnik.omeni');
 
      if(waserror === false){
         this.get('userService').editKorisnik(editKorisnika, this.get('session.data.authenticated.korisnik.username'));
         this.set('msgedit','Promjene su uspjesno sacuvane!');
      }
    
    
 
  },
 
    azurirajPromjene()
    {
              let korisnik = this.getProperties('username','password');
              korisnik.username = this.get('session.data.authenticated.korisnik.username');
               korisnik.password = this.get('session.data.authenticated.korisnik.password');
 
                     this.get('session').authenticate('authenticator:application', korisnik, (data) => {
                             console.log(data);
                     })
                     .catch(reason => {
                             //Ember.set(this, 'errorMessage', JSON.parse(reason.responseText).errorMessage);
                             this.set('authenticationError', this.errorMessage || reason);
                     });

                      this.set('msgedit','');
    }
  }
});
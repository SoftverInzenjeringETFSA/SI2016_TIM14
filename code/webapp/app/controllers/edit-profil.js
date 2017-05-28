import Ember from 'ember';
import user from '../models/user';
 
export default Ember.Controller.extend({
    userService: Ember.inject.service('userService'),
    session: Ember.inject.service(),
 
 
 
    actions: {
         spasiPromjeneKorisnika() {
         let editKorisnika = this.getProperties('email','firstName','lastName', 'omeni', 'interesovanja', 'zanimanje', 'location');
 
          console.log(this.get('session.data.authenticated.korisnik.firstName'));
 
          if(this.get('session.data.authenticated.korisnik.firstName') === '')
                  {
                     editKorisnika.firstName = ' ';
                  }
                  else
         editKorisnika.firstName= this.get('session.data.authenticated.korisnik.firstName');
 
         if(this.get('session.data.authenticated.korisnik.lastName') === '')
                 {
                    editKorisnika.lastName = ' ';
                 }
                 else
         editKorisnika.lastName =this.get('session.data.authenticated.korisnik.lastName');
 
         if(this.get('session.data.authenticated.korisnik.zanimanje') === '')
                 {
                    editKorisnika.zanimanje = ' ';
                 }
                 else
 
         editKorisnika.zanimanje = this.get('session.data.authenticated.korisnik.zanimanje');
 
         if(this.get('session.data.authenticated.korisnik.location') === '')
                 {
                    editKorisnika.location = ' ';
                 }
                 else
         editKorisnika.location = this.get('session.data.authenticated.korisnik.location');
         if(this.get('session.data.authenticated.korisnik.email') === '')
                 {
                    editKorisnika.email = ' ';
                 }
                 else
 
         editKorisnika.email = this.get('session.data.authenticated.korisnik.email');
 
         if(this.get('session.data.authenticated.korisnik.interesovanja') === '')
                 {
                    editKorisnika.interesovanja = ' ';
                 }
                 else
         editKorisnika.interesovanja = this.get('session.data.authenticated.korisnik.interesovanja');
         if(this.get('session.data.authenticated.korisnik.omeni') === '')
                 {
                    editKorisnika.omeni= ' ';
                 }
                 else
 
         editKorisnika.omeni = this.get('session.data.authenticated.korisnik.omeni');
 
 
         this.get('userService').editKorisnik(editKorisnika, this.get('session.data.authenticated.korisnik.username'));
 
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
    }
  }
});
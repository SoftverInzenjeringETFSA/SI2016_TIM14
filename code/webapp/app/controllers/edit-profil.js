import Ember from 'ember';
import user from '../models/user';

export default Ember.Controller.extend({
    userService: Ember.inject.service('userService'),
    session: Ember.inject.service(),



    actions: {
         spasiPromjeneKorisnika() {
         let editKorisnika = this.getProperties('email','firstName','lastName', 'omeni', 'interesovanja', 'zanimanje', 'location');
         editKorisnika.firstName= '';
         editKorisnika.lastName = '';
         editKorisnika.zanimanje = '';
         editKorisnika.location = '';
         editKorisnika.email = '';
         editKorisnika.interesovanja = '';
         editKorisnika.omeni = '';

          console.log(this.get('name'));
         if(this.get('name') === undefined)
         {
            editKorisnika.firstName = ' ';
         }
         else
         editKorisnika.firstName= this.get('name');

         if(this.get('prezime') === undefined)
         {
            editKorisnika.lastName = ' ';
         }
         else
         editKorisnika.lastName = this.get('prezime');


          if(this.get('zanimanje') === undefined)
         {
            editKorisnika.zanimanje = ' ';
         }
         else
         editKorisnika.zanimanje = this.get('zanimanje');

         if(this.get('grad') === undefined)
         {
            editKorisnika.location = ' ';
         }
         else
         editKorisnika.location = this.get('grad');

         if(this.get('email') === undefined)
         {
            editKorisnika.email = ' ';
         }
         else
         editKorisnika.email = this.get('email');

         if(this.get('interesi') === undefined)
         {
            editKorisnika.interesovanja = ' ';
         }
         else
         editKorisnika.interesovanja = this.get('interesi');

         if(this.get('omeni') === undefined)
         {
            editKorisnika.omeni = ' ';
         }
         else
         editKorisnika.omeni = this.get('omeni');


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

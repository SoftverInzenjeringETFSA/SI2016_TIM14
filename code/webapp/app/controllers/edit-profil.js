import Ember from 'ember';
import user from '../models/user';

 export default Ember.Controller.extend({
   userService: Ember.inject.service('userService'),
    session: Ember.inject.service(),



    actions: {
         spasiPromjeneKorisnika() {
         let editKorisnika = this.getProperties('email','firstName','lastName', 'omeni', 'interesovanja', 'zanimanje', 'location');
         var name = /^[a-zA-Z0-9]+$/;

          console.log('ime' + this.get('session.data.authenticated.korisnik.firstName'));

          if(this.get('session.data.authenticated.korisnik.firstName') === '' || this.get('session.data.authenticated.korisnik.firstName') === null || !this.get('session.data.authenticated.korisnik.firstName').match(name))
                  {
                     editKorisnika.firstName = ' ';
                  }
                  else
         editKorisnika.firstName= this.get('session.data.authenticated.korisnik.firstName');

          console.log('prezime' + this.get('session.data.authenticated.korisnik.lastName'));

         if(this.get('session.data.authenticated.korisnik.lastName') === '' || this.get('session.data.authenticated.korisnik.lastName') === null || !this.get('session.data.authenticated.korisnik.firstName').match(name))
                 {
                    editKorisnika.lastName = ' ';
                 }
                 else
         editKorisnika.lastName =this.get('session.data.authenticated.korisnik.lastName');

         if(this.get('session.data.authenticated.korisnik.zanimanje') === '' || this.get('session.data.authenticated.korisnik.zanimanje') === null || !this.get('session.data.authenticated.korisnik.firstName').match(name))
                 {
                    editKorisnika.zanimanje = ' ';
                 }
                 else

         editKorisnika.zanimanje = this.get('session.data.authenticated.korisnik.zanimanje');

         if(this.get('session.data.authenticated.korisnik.location') === '' || this.get('session.data.authenticated.korisnik.location') === null || !this.get('session.data.authenticated.korisnik.firstName').match(name))
                 {
                    editKorisnika.location = ' ';
                 }
                 else
         editKorisnika.location = this.get('session.data.authenticated.korisnik.location');
           var email = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
         if(this.get('session.data.authenticated.korisnik.email') === '' || this.get('session.data.authenticated.korisnik.email') === null || !this.get('session.data.authenticated.korisnik.firstName').match(email))
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

 console.log('nesto' + this.get('session.data.authenticated.korisnik.omeni'));
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

import Ember from 'ember';

export default Ember.Component.extend({
    store: Ember.inject.service(),
    session: Ember.inject.service(),
    isToSAccepted: false,

    model: {},
    errorMessage: '',
   /* check: function()
    {  
       if(this.get('model.username') == '' || this.get('model.password') == '')
       {
         Ember.set(this, 'errorMessage', 'Polja za unos ne smiju biti prazna!');
         isToSAccepted: true;
       }
       else
         isToSAccepted: false;
    },*/

    actions: {
     
       login() {
          //this.check();
            this.get('session').authenticate('authenticator:application', this.model, (data) => {
                    console.log(data);
                   Ember.set(this, 'errorMessage', '');
                     this.set('model.username', '');
                     this.set('model.password', '');
                   // console.log(data.korisnik.id);
                    //this.transitionToRoute('home');
                     this.get('router').transitionTo('profil');
                })
                .catch(reason => {
                    Ember.set(this, 'errorMessage', JSON.parse(reason.responseText).errorMessage);
                    this.set('authenticationError', this.errorMessage || reason);
                });
        },

        logout()
        {

              this.get('session').invalidate();
              this.get('router').transitionTo('login');

        }
    }
});

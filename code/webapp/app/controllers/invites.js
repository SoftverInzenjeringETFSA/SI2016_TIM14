import Ember from 'ember';

export default Ember.Controller.extend({
    inviteUserService: Ember.inject.service('inviteuser-service'),
        ajax: Ember.inject.service(),
        self : this,
        session: Ember.inject.service(),

    model: function() {
    },
    refreshInvite: function(params){
        var idOfUser = this.get('session.data.authenticated.korisnik.id');
        this.get('inviteUserService').declineInvite(params, idOfUser);
        let myInvites = this.get('inviteUserService').findInvites(idOfUser);
        this.set("model.myInvites", myInvites);
    },
    actions: {
        declineInvite(params) {          
            this.refreshInvite(params);
        },
        prihvatiZahtjev(iduser) {
           var idPrihvatioZahtjev = this.get('session.data.authenticated.korisnik.id');
           this.get('userService').prihvatiZahtjevPM(iduser, idPrihvatioZahtjev);
          // Ember.set(this, 'Message', 'Uspješno obrisan korisnik!');
          window.location.reload(true); 
       }
    }
});
